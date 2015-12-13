package marres.client.Presenter;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.paper.element.PaperFabElement;

import marres.client.Events.EventDown.DisplayCategoriaEvent;
import marres.client.Events.EventDown.DisplayCategoriaEventHandler;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventDown.DisplayRicettaEventHandler;
import marres.client.Events.EventUp.AggiungiCategoriaEvent;
import marres.client.Events.EventUp.AggiungiRicettaEvent;
import marres.client.RPC.RicetteService;
import marres.client.RPC.RicetteServiceAsync;
import marres.shared.DCategoria;
import marres.shared.DRicetta;


public class MainPresenter implements Presenter {
	
	private ArrayList<DRicetta> ricette = new ArrayList<DRicetta>();
	private RicetteServiceAsync ricetteSvc = GWT.create(RicetteService.class);
	
	private Display view;
	private EventBus eventbus;
	
	public interface Display {
		public void AggiungiRicetta(DivElement ricetta);
		public void setPresenter(MainPresenter presenter);
		public void AggiungiCategoria(DivElement ricetta);
		public PaperFabElement getApriCarrello();
		public void ApriCarrello();
		public Widget asWidget();
	}
	
	public MainPresenter(Display view,EventBus eventbus){
		this.view = view;
		this.eventbus = eventbus;
		
		bind();
		InizializzaEventiView();
		
	}

	public void go(Panel panel) {
		panel.add(view.asWidget());
		PrelevaRicette();
		PrelevaCategorie();	
	}
	@Override
	public void InizializzaEventiView(){
		
		this.view.getApriCarrello().addEventListener("click", new EventListener() {
			@Override
			public void handleEvent(Event event) {
				view.ApriCarrello();
			}
		});
	
		this.eventbus.addHandler(DisplayRicettaEvent.TYPE, new DisplayRicettaEventHandler(){
			@Override
			public void OnDisplayRicetta(DisplayRicettaEvent event) {
				view.AggiungiRicetta(event.getElement());
			}
		});
		
		this.eventbus.addHandler(DisplayCategoriaEvent.TYPE, new DisplayCategoriaEventHandler(){
			@Override
			public void OnDisplayCategoria(DisplayCategoriaEvent event) {
				view.AggiungiCategoria(event.getElement());	
			}
			
		});
	}
	
	@Override
	public void bind() {
		view.setPresenter(this);
	}

	
	private void PrelevaRicette(){
		if (ricetteSvc == null) {
		      ricetteSvc = GWT.create(RicetteService.class);
		    }
		    AsyncCallback<DRicetta[]> callback = new AsyncCallback<DRicetta[]>() {
		      public void onFailure(Throwable caught) {
		    	  Window.alert("ERRORE");
		      }
		      public void onSuccess(DRicetta[] result) {
		        for(DRicetta ricetta : result){
		        	AggiungiRicetta(ricetta);
		        }
		      }
		    };
		    ricetteSvc.getRicette(ricette, callback);
	}
	
	private void PrelevaCategorie(){
		DCategoria categoria = new DCategoria("Primi Piatti");
		AggiungiCategoria(categoria);	
	}
	
	
	public void DisplayCategoria(DivElement ricetta){
		view.AggiungiCategoria(ricetta);
	}
	
	@Override
	public DivElement getDivElement() {
		return null;
	}

	public void AggiungiRicetta (DRicetta ricetta) {
		this.eventbus.fireEvent(new AggiungiRicettaEvent(ricetta));
	}

	public void AggiungiCategoria (DCategoria categoria){
		this.eventbus.fireEvent(new AggiungiCategoriaEvent(categoria));
	}

	
}
