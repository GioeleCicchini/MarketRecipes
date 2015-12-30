package marres.client.Presenter;


import java.util.ArrayList;
import java.util.List;
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
import marres.client.RPC.MainService;
import marres.client.RPC.MainServiceAsync;
import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;



public class MainPresenter implements Presenter {
	
	private DCategoriaDTO Categoria ;
	private MainServiceAsync MainSvc = GWT.create(MainService.class);
	private ArrayList<DCategoriaDTO> categorie = new ArrayList<DCategoriaDTO>();
	
	
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
		Categoria = new DCategoriaDTO();
		Categoria.setNome("Primi");
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
		if (MainSvc == null) {
		      MainSvc = GWT.create(MainService.class);
		    }
		    AsyncCallback<List<DRicettaDTO>> callback = new AsyncCallback<List<DRicettaDTO>>() {
		      public void onFailure(Throwable caught) {
		    	  Window.alert("ERRORE");
		      }
		      public void onSuccess(List<DRicettaDTO> result) {
		        for(DRicettaDTO ricetta : result){

		        	AggiungiRicetta(ricetta);
		        }
		      }
		    };
		    MainSvc.getRicette(Categoria, callback);
	}
	
	private void PrelevaCategorie(){
		if (MainSvc == null) {
		      MainSvc = GWT.create(MainService.class);
		    }
		    AsyncCallback<List<DCategoriaDTO>> callback = new AsyncCallback<List<DCategoriaDTO>>() {
		      public void onFailure(Throwable caught) {
		    	  Window.alert("ERRORE");
		      }
		      public void onSuccess(List<DCategoriaDTO> result) {
		        for(DCategoriaDTO categoria : result){
		        	AggiungiCategoria(categoria);
		        }
		      }
		    };
		    MainSvc.getCategorie(callback);
	}
	
	
	@Override
	public DivElement getDivElement() {
		return null;
	}

	public void AggiungiRicetta (DRicettaDTO ricetta) {
		AppUtils.EVENT_BUS.fireEvent(new AggiungiRicettaEvent(ricetta));
	}

	public void AggiungiCategoria (DCategoriaDTO categoria){
		AppUtils.EVENT_BUS.fireEvent(new AggiungiCategoriaEvent(categoria));
	}

	
}
