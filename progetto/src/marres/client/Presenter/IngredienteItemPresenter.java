package marres.client.Presenter;


import java.util.ArrayList;
import java.util.List;

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
import com.vaadin.polymer.iron.element.IronSelectorElement;
import com.vaadin.polymer.paper.element.PaperCheckboxElement;

import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayIngredienteEvent;
import marres.client.Events.EventDown.DisplayIngredienteEventHandler;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventDown.DisplayRicettaEventHandler;
import marres.client.Events.EventMiddle.AggiungiATotaleEvent;
import marres.client.Events.EventMiddle.CambiaStatoEscludiEvent;
import marres.client.Presenter.RicettaPresenter.Display;
import marres.client.service.MyShopWebRemoteService;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;

public class IngredienteItemPresenter implements Presenter {

	private Display view;
	private DIngredienteDTO Ingrediente;
	private DRicettaDTO Ricetta;
	private List<DProdottoDTO> Prodotti = new ArrayList<DProdottoDTO>();
	private DProdottoDTO ProdottoSelezionato;
	
	public interface Display {
		public DivElement getDivElement();
		public void clear();
		public Widget asWidget();
		public void setPresenter(IngredienteItemPresenter presenter);
		public void setIngrediente(String Nomeingrediente);
		public void setProdotti(List<DProdottoDTO> prodotti,DProdottoDTO prodottoselezionato);
		public Element getprodotto();
		public Element getApriProdotti();
		public void ApriProdotti();
		public void setProdottoSelezionato(DProdottoDTO prodotto);
		public PaperCheckboxElement getEscludi();
	}
	
	
	public IngredienteItemPresenter(Display view){
		this.view = view;
		InizializzaEventiView();
		bind();
	}
	
	public void setRicetta(DRicettaDTO Ricetta){
		this.Ricetta = Ricetta;
	}
	
	@Override
	public DivElement getDivElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bind() {
		view.setPresenter(this);
	}

	@Override
	public void InizializzaEventiView() {
		
		this.view.getprodotto().addEventListener("click",  new EventListener(){

			@Override
			public void handleEvent(Event event) {
				IronSelectorElement elemento =(IronSelectorElement) view.getprodotto();
				view.setProdottoSelezionato(Prodotti.get(Integer.parseInt(elemento.getSelected())));
				DProdottoDTO prodottoprecedente = ProdottoSelezionato;
				ProdottoSelezionato= Prodotti.get(Integer.parseInt(elemento.getSelected()));
				AppUtils.EVENT_BUS.fireEvent(new AggiungiATotaleEvent(ProdottoSelezionato,prodottoprecedente));
			}
			
		});
		
		this.view.getApriProdotti().addEventListener("click",  new EventListener(){

			@Override
			public void handleEvent(Event event) {
				view.ApriProdotti();
				
			}
			
		});
		
		this.view.getEscludi().addEventListener("click",new EventListener(){

			@Override
			public void handleEvent(Event event) {
				Boolean flag = view.getEscludi().getActive();
				AppUtils.EVENT_BUS.fireEvent(new CambiaStatoEscludiEvent(Ricetta,ProdottoSelezionato,flag));
			}
			
		});
		

	}
	
	public void setIngredienteItem(DIngredienteDTO ingrediente){
		this.Ingrediente = ingrediente;
		view.setIngrediente(ingrediente.getNome());
		
	}
	
	public DProdottoDTO getProdottoSelezionato(){
		return this.ProdottoSelezionato;
	}

	public void getProdotti(){
		
	
		String url="http://localhost/MyShopWeb/call.php?func=RicercaPerNome&nome="+Ingrediente.getNome();
		
		 url = URL.encode(url);
		JsonpRequestBuilder builder = new JsonpRequestBuilder();
		
		
	    builder.requestObject(url, new AsyncCallback<JsArray<MyShopWebRemoteService>>() {
	      public void onFailure(Throwable caught) {
	    	  Window.alert("Failure:" + caught.getMessage());
	      }
	      public void onSuccess(JsArray<MyShopWebRemoteService> data) {
	    	
	    	 
	    	if(data.length() != 0){		
	    	  	for(int i=0; i<data.length();i=i+1 ){
	    	  		DProdottoDTO prodotto = new DProdottoDTO(data.get(i).getCategorie(),data.get(i).getDescrizione(),data.get(i).getId(),data.get(i).getNome(),data.get(i).getPrezzo(),Ricetta);
	    	  		Prodotti.add(prodotto);
	    	  	}
	    	}
	    	InizializzaIngrediente();
	    	
	      }
	    });

		
		
		
	}

	public void InizializzaIngrediente(){
		// imposto prodotto di default
		
		if(Prodotti.size() > 0){
		ProdottoSelezionato = Prodotti.get(0);
		}
		view.setProdotti(Prodotti, ProdottoSelezionato);
		DProdottoDTO prodottoprecedente = ProdottoSelezionato;
		AppUtils.EVENT_BUS.fireEvent(new AggiungiATotaleEvent(ProdottoSelezionato,prodottoprecedente));
		
		
		
	}
}
