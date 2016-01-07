package marres.client.Presenter;

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
import marres.client.Events.EventUp.AggiungiCategoriaEvent;
import marres.client.Events.EventUp.AggiungiIngredienteEvent;
import marres.client.RPC.MainService;
import marres.client.RPC.MainServiceAsync;
import marres.shared.domain.DRicetta;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DRicettaDTO;

public class RicettaPresenter implements Presenter {

	private MainServiceAsync RicettaSvc = GWT.create(MainService.class);
	Display view;
	DRicettaDTO Ricetta ;
	
	public interface Display {
		public DivElement getDivElement();
		public void setPresenter(RicettaPresenter RicettaPresenter);
		public Element getApriRicetta();
		public void ApriRicetta();
		public Widget asWidget(); 
		public void AggiungiIngredienti(DivElement ingrediente);
		public void setRicetta(String titolo, String difficolta, String preparazione,String cottura,String dosi ,String costo, String immagine);
	}
	
	public RicettaPresenter(Display view){
		this.view = view;
		InizializzaEventiView();
		bind();
	}
	
	@Override
	public void InizializzaEventiView() {
		
		AppUtils.EVENT_BUS.addHandler(DisplayIngredienteEvent.TYPE, new DisplayIngredienteEventHandler(){
			@Override
			public void OnDisplayIngrediente(DisplayIngredienteEvent event) {
				view.AggiungiIngredienti(event.getElement());
			}
		});
		
		this.view.getApriRicetta().addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				view.ApriRicetta();
				PrelevaIngredienti();
				FaiChiamata();
			}
		});
		
		
	}
	
	@Override
	public void bind() {
		view.setPresenter(this);

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
		        	AggiungiIngrediente(ingrediente);
		        }
			}
		  
		    };
		    RicettaSvc.getIngredienti(Ricetta, callback);
		
		
		
	}
	
	
	public void setRicetta(DRicettaDTO ricetta){
		this.Ricetta = ricetta;
	
		view.setRicetta(ricetta.getNome(), ricetta.getDifficolta(),ricetta.getPreparazione(),ricetta.getCottura(),ricetta.getDosi(),ricetta.getCosto(), ricetta.getImage());
		
	}

	public void AggiungiIngrediente (DIngredienteDTO ingrediente){
		AppUtils.EVENT_BUS.fireEvent(new AggiungiIngredienteEvent(ingrediente));
	}
	
	
	@Override
	public DivElement getDivElement() {
		return view.getDivElement();
	}

	
	


	
	public void FaiChiamata(){
		
		
		String url="http://localhost/MyShopWeb/call.php?func=RicercaPerNome&nome=carta";
		 url = URL.encode(url);
		JsonpRequestBuilder builder = new JsonpRequestBuilder();
		
	    builder.requestObject(url, new AsyncCallback<JsArray<DProdottoOverlay>>() {
	      public void onFailure(Throwable caught) {
	    	  Window.alert("Failure:" + caught.getMessage());
	      }
	      public void onSuccess(JsArray<DProdottoOverlay> data) {
	   
	    	    // Yay! Now I have a JS object that appears to be a Customer
	    	   Window.alert(data.get(0).getDescrizione());
	    	  
	      }
	    });

        
	}
	

}
