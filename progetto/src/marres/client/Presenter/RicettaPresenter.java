package marres.client.Presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.paper.element.PaperFabElement;

import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayIngredienteEvent;
import marres.client.Events.EventDown.DisplayIngredienteEventHandler;
import marres.client.Events.EventMiddle.AggiungiATotaleEvent;
import marres.client.Events.EventMiddle.AggiungiATotaleEventHandler;
import marres.client.Events.EventUp.AggiungiCategoriaEvent;
import marres.client.Events.EventUp.AggiungiIngredienteEvent;
import marres.client.RPC.MainService;
import marres.client.RPC.MainServiceAsync;
import marres.client.service.MagazzinoSupermercatoAdapter;
import marres.client.service.MyShopWebRemoteService;
import marres.shared.domain.DRicetta;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;

public class RicettaPresenter implements Presenter {

	private MainServiceAsync RicettaSvc = GWT.create(MainService.class);
	Display view;
	DRicettaDTO Ricetta ;
	List<DIngredienteDTO> Ingredienti = new ArrayList<DIngredienteDTO>();
	List<DProdottoDTO> ProdottiSelezionati = new ArrayList<DProdottoDTO>();
	
	public interface Display {
		public DivElement getDivElement();
		public void setPresenter(RicettaPresenter RicettaPresenter);
		public Element getApriRicetta();
		public void ApriRicetta();
		public Widget asWidget(); 
		public void AggiungiIngredienti(DivElement ingrediente);
		public void setRicetta(String titolo, String difficolta, String preparazione,String cottura,String dosi ,String costo, String immagine);
		public void Clear();
		public void DisplaySomma(float somma);
	}
	
	public RicettaPresenter(Display view){
		this.view = view;
		InizializzaEventiView();
		bind();
	}
	
	@Override
	public void InizializzaEventiView() {
		
		AppUtils.EVENT_BUS.addHandler(AggiungiATotaleEvent.TYPE, new AggiungiATotaleEventHandler(){

			@Override
			public void OnAggiungiATotale(AggiungiATotaleEvent event) {
				DProdottoDTO prodotto = event.getProdotto();
				int i=0;
				int index=0;
				Boolean flag= false;
				for(DProdottoDTO ProdottoSelezionato:ProdottiSelezionati){
					if(ProdottoSelezionato.getIngrediente().getId() == prodotto.getIngrediente().getId()){
						index=i;
						flag= true;
					}
					i=i+1;
				}
				if(flag==false){
					ProdottiSelezionati.add(prodotto);
				}
				else{
					ProdottiSelezionati.remove(index);
					ProdottiSelezionati.add(prodotto);
				}
				
				AggiornaTotale();
				
				
			}
			
		});
		
		AppUtils.EVENT_BUS.addHandler(DisplayIngredienteEvent.TYPE, new DisplayIngredienteEventHandler(){
			@Override
			public void OnDisplayIngrediente(DisplayIngredienteEvent event) {
			
				view.AggiungiIngredienti(event.getElement());
			}
		});
		
		this.view.getApriRicetta().addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				view.Clear();
				view.ApriRicetta();
				
				PrelevaIngredienti();
				
			}
		});
		
		
		
		
	}
	
	@Override
	public void bind() {
		view.setPresenter(this);

	}
	
	public void AggiornaTotale(){
	float somma = 0;
		for(DProdottoDTO prodotto: ProdottiSelezionati){
			float prezzo =Float.parseFloat(prodotto.getPrezzo());
			somma=somma+prezzo;
		}
		view.DisplaySomma(somma);
	}
	
	public void PrelevaIngredienti(){
		
		if (RicettaSvc == null) {
		      RicettaSvc = GWT.create(MainService.class);
		    }
		    AsyncCallback<List<DIngredienteDTO>> callback = new AsyncCallback<List<DIngredienteDTO>>() {
		      public void onFailure(Throwable caught) {
		    	  Window.alert("ERRORE");
		      }

			@Override
			public void onSuccess(List<DIngredienteDTO> ingredienti) {
			
				for(DIngredienteDTO ingrediente : ingredienti){
					Ingredienti.add(ingrediente);
		        }
				int i=0;
				for(DIngredienteDTO ingrediente : ingredienti){
					PrelevaProdotti(ingrediente,i);
					i=i+1;
		        }
			}
		  
		    };
		 
		    RicettaSvc.getIngredienti(Ricetta, callback);
		
		
		
	}
	
	
	public void setRicetta(DRicettaDTO ricetta){
		this.Ricetta = ricetta;
	
		view.setRicetta(ricetta.getNome(), ricetta.getDifficolta(),ricetta.getPreparazione(),ricetta.getCottura(),ricetta.getDosi(),ricetta.getCosto(), ricetta.getImage());
		
	}

	public void AggiungiIngrediente (DIngredienteDTO ingrediente ,List<DProdottoDTO> prodotti){
		AppUtils.EVENT_BUS.fireEvent(new AggiungiIngredienteEvent(ingrediente,prodotti));
	}
	
	
	@Override
	public DivElement getDivElement() {
		return view.getDivElement();
	}

	
	


	
	public void PrelevaProdotti(final DIngredienteDTO ingrediente,final int ingredienteIndice){
		
		String url="http://localhost/MyShopWeb/call.php?func=RicercaPerNome&nome="+ingrediente.getNome();
		 url = URL.encode(url);
		JsonpRequestBuilder builder = new JsonpRequestBuilder();
		
		
	    builder.requestObject(url, new AsyncCallback<JsArray<MyShopWebRemoteService>>() {
	      public void onFailure(Throwable caught) {
	    	  Window.alert("Failure:" + caught.getMessage());
	      }
	      public void onSuccess(JsArray<MyShopWebRemoteService> data) {
	    	  List<DProdottoDTO> prodotti = new ArrayList<DProdottoDTO>();
	    	 
	    		
	    	if(data.length() != 0){		
	    	  	for(int i=0; i<data.length();i=i+1 ){
	    	  		DProdottoDTO prodotto = new DProdottoDTO(data.get(i).getCategorie(),data.get(i).getDescrizione(),data.get(i).getId(),data.get(i).getNome(),data.get(i).getPrezzo(),ingrediente);
	    	  		prodotti.add(prodotto);
	    	  	}
	    	}
	    	
	    		AggiungiIngrediente(Ingredienti.get(ingredienteIndice),prodotti);
	    	  
	      }
	    });

        
	}
	

}
