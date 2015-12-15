package marres.client.Presenter;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.paper.element.PaperFabElement;
import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayCategoriaEvent;
import marres.client.Events.EventDown.DisplayCategoriaEventHandler;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventDown.DisplayRicettaEventHandler;
import marres.client.Events.EventMiddle.CambiaCategoriaEvent;
import marres.client.Events.EventMiddle.CambiaCategoriaEventHandler;
import marres.client.Events.EventUp.AggiungiCategoriaEvent;
import marres.client.Events.EventUp.AggiungiRicettaEvent;
import marres.client.RPC.CategorieService;
import marres.client.RPC.CategorieServiceAsync;
import marres.client.RPC.RicetteService;
import marres.client.RPC.RicetteServiceAsync;
import marres.shared.DCategoria;
import marres.shared.DRicetta;


public class MainPresenter implements Presenter {
	
	private DCategoria Categoria ;
	private RicetteServiceAsync ricetteSvc = GWT.create(RicetteService.class);
	private ArrayList<DCategoria> categorie = new ArrayList<DCategoria>();
	private CategorieServiceAsync categorieSvc = GWT.create(CategorieService.class);
	
	private Display view;

	
	public interface Display {
		public void AggiungiContenutiPrincipali(DivElement ricetta);
		public void AggiungiContenutiMenu(DivElement categoria);
		public void EliminaContenutiPrincipali();
		public void EliminaContenutiMenu();
		public void setPresenter(MainPresenter presenter);
		public PaperFabElement getApriCarrello();
		public void ApriCarrello();
		public Widget asWidget();
	}
	
	public MainPresenter(Display view){
		this.view = view;
		Categoria = new DCategoria("Primi");
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
	
		AppUtils.EVENT_BUS.addHandler(DisplayRicettaEvent.TYPE, new DisplayRicettaEventHandler(){
			@Override
			public void OnDisplayRicetta(DisplayRicettaEvent event) {
				view.AggiungiContenutiPrincipali(event.getElement());
			}
		});
		
		AppUtils.EVENT_BUS.addHandler(DisplayCategoriaEvent.TYPE, new DisplayCategoriaEventHandler(){
			@Override
			public void OnDisplayCategoria(DisplayCategoriaEvent event) {
				view.AggiungiContenutiMenu(event.getElement());	
			}
		});
		AppUtils.EVENT_BUS.addHandler(CambiaCategoriaEvent.TYPE, new CambiaCategoriaEventHandler(){

			@Override
			public void OnCambiaCategoria(CambiaCategoriaEvent event) {
				Categoria.setNome(event.getCategoria().getNome());	
				view.EliminaContenutiPrincipali();
				PrelevaRicette();
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
		    ricetteSvc.getRicette(Categoria, callback);
	}
	
	private void PrelevaCategorie(){
		if (categorieSvc == null) {
		      categorieSvc = GWT.create(CategorieService.class);
		    }
		    AsyncCallback<DCategoria[]> callback = new AsyncCallback<DCategoria[]>() {
		      public void onFailure(Throwable caught) {
		    	  Window.alert("ERRORE");
		      }
		      public void onSuccess(DCategoria[] result) {
		        for(DCategoria categoria : result){
		        	AggiungiCategoria(categoria);
		        }
		      }
		    };
		    categorieSvc.getCategorie(categorie, callback);
	}
	
	
	@Override
	public DivElement getDivElement() {
		return null;
	}

	public void AggiungiRicetta (DRicetta ricetta) {
		AppUtils.EVENT_BUS.fireEvent(new AggiungiRicettaEvent(ricetta));
	}

	public void AggiungiCategoria (DCategoria categoria){
		AppUtils.EVENT_BUS.fireEvent(new AggiungiCategoriaEvent(categoria));
	}

	
}
