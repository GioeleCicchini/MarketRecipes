package marres.client.Presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.http.client.URL;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;

import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayIngredienteEvent;
import marres.client.Events.EventDown.DisplayIngredienteEventHandler;
import marres.client.Events.EventMiddle.AggiungiACarrelloEvent;
import marres.client.Events.EventMiddle.AggiungiATotaleEvent;
import marres.client.Events.EventMiddle.AggiungiATotaleEventHandler;
import marres.client.Events.EventMiddle.CambiaStatoEscludiEvent;
import marres.client.Events.EventMiddle.CambiaStatoEscludiEventHandler;
import marres.client.Events.EventUp.AggiungiIngredienteEvent;
import marres.client.RPC.MainService;
import marres.client.RPC.MainServiceAsync;
import marres.client.service.MyShopWebRemoteService;
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
		public Element getAggiungiACarrelloButton();
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
		
		AppUtils.EVENT_BUS.addHandler(CambiaStatoEscludiEvent.TYPE, new CambiaStatoEscludiEventHandler(){

			@Override
			public void OnCambiaStatoEscludi(CambiaStatoEscludiEvent event) {
				if(Ricetta == event.getRicetta()){
				if(event.getStato() == true){
					ProdottiSelezionati.remove(event.getProdotto());
				}
				if(event.getStato() == false){
					ProdottiSelezionati.add(event.getProdotto());
				}
			}
				AggiornaTotale();
			}
		});
		
		
		
		
		
		AppUtils.EVENT_BUS.addHandler(AggiungiATotaleEvent.TYPE, new AggiungiATotaleEventHandler(){

			@Override
			public void OnAggiungiATotale(AggiungiATotaleEvent event) {
				
				DProdottoDTO prodotto = event.getProdotto();
				
				if(prodotto.getRicetta() == Ricetta){
					ProdottiSelezionati.remove(event.getProdottoPrecedente());
					ProdottiSelezionati.add(prodotto);
					
				}
				
				AggiornaTotale();
			}
			
		});
		
		this.view.getApriRicetta().addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				view.ApriRicetta();
				}
		});
		
		this.view.getAggiungiACarrelloButton().addEventListener("click", new EventListener(){

			@Override
			public void handleEvent(Event event) {
				AppUtils.EVENT_BUS.fireEvent(new AggiungiACarrelloEvent(Ricetta,ProdottiSelezionati,0));
				
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
					AggiungiIngrediente(ingrediente);
		        }
				
			}
		    };
		 
		    RicettaSvc.getIngredienti(Ricetta, callback);
		
		
		
	}
	
	
	public void setRicetta(DRicettaDTO ricetta){
		this.Ricetta = ricetta;	
		view.setRicetta(ricetta.getNome(), ricetta.getDifficolta(),ricetta.getPreparazione(),ricetta.getCottura(),ricetta.getDosi(),ricetta.getCosto(), ricetta.getImage());
		PrelevaIngredienti();
	}

	public void AggiungiIngrediente (DIngredienteDTO ingrediente){
		AppUtils.EVENT_BUS.fireEvent(new AggiungiIngredienteEvent(ingrediente,this));
	}
	public void DisplayIngrediente(DivElement elemento){
		view.AggiungiIngredienti(elemento);
	}

	
	@Override
	public DivElement getDivElement() {
		return view.getDivElement();
	}

	
	
	
	public  List<DProdottoDTO> getProdottiSelezionati(){
		return this.ProdottiSelezionati;
	
	}
	public void setProdottiSelezionati(List<DProdottoDTO> prodotti){
		this.ProdottiSelezionati = prodotti;
		
	}

	
	public DRicettaDTO getRicetta(){
		return this.Ricetta;
		
	}

}
