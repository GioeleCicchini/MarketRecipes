package marres.client.Presenter;


import java.util.ArrayList;
import java.util.List;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.paper.element.PaperFabElement;
import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayCategoriaEvent;
import marres.client.Events.EventDown.DisplayCategoriaEventHandler;
import marres.client.Events.EventDown.DisplayRicettaCarrelloEvent;
import marres.client.Events.EventDown.DisplayRicettaCarrelloEventHandler;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventDown.DisplayRicettaEventHandler;
import marres.client.Events.EventMiddle.AggiungiACarrelloEvent;
import marres.client.Events.EventMiddle.AggiungiACarrelloEventHandler;
import marres.client.Events.EventMiddle.CambiaCategoriaEvent;
import marres.client.Events.EventMiddle.CambiaCategoriaEventHandler;
import marres.client.Events.EventUp.AggiungiCategoriaEvent;
import marres.client.Events.EventUp.AggiungiRicettaCarrelloEvent;
import marres.client.Events.EventUp.AggiungiRicettaEvent;
import marres.client.RPC.MainService;
import marres.client.RPC.MainServiceAsync;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;



public class MainPresenter implements Presenter {
	
	private MainServiceAsync MainSvc = GWT.create(MainService.class);
	private DCategoriaDTO categoria;
	
	private List<DProdottoDTO> ProdottiCarrello = new ArrayList<DProdottoDTO>();
	
	private Display view;

	
	public interface Display {
		public void AggiungiContenutiPrincipali(DivElement ricetta);
		public void AggiungiContenutiMenu(DivElement categoria);
		public void AggiungiACarrello(DivElement ricetta);
		public void EliminaContenutiPrincipali();
		public void EliminaContenutiMenu();
		public void setPresenter(MainPresenter presenter);
		public PaperFabElement getApriCarrello();
		public Element getChiudiCarrello();
		public void ApriCarrello();
		public void ChiudiCarrello();
		public Widget asWidget();
		public void AggiornaTotaleCarrello(float totale);
	}
	
	public MainPresenter(Display view){
		this.view = view;
		bind();
		InizializzaEventiView();
		
	}

	public void go(Panel panel) {
		panel.add(view.asWidget());
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
	
		this.view.getChiudiCarrello().addEventListener("click", new EventListener(){

			@Override
			public void handleEvent(Event event) {
				view.ChiudiCarrello();	
			}
			
		});
		
		AppUtils.EVENT_BUS.addHandler(DisplayRicettaEvent.TYPE, new DisplayRicettaEventHandler(){
			@Override
			public void OnDisplayRicetta(DisplayRicettaEvent event) {
				view.AggiungiContenutiPrincipali(event.getElement());
			}
		});
		
		AppUtils.EVENT_BUS.addHandler(DisplayRicettaCarrelloEvent.TYPE, new DisplayRicettaCarrelloEventHandler(){
			@Override
			public void OnDisplayRicettaCarrello(DisplayRicettaCarrelloEvent event) {
				view.AggiungiACarrello(event.getElement());
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
				view.EliminaContenutiPrincipali();
				PrelevaRicette(event.getCategoria());
			}
		});
		
		AppUtils.EVENT_BUS.addHandler(AggiungiACarrelloEvent.TYPE, new AggiungiACarrelloEventHandler(){

			@Override
			public void OnAggiungiACarrello(AggiungiACarrelloEvent event) {
				
				for(DProdottoDTO prodotto :event.getProdotti() ){
					ProdottiCarrello.add(prodotto);
				}
				
				float somma=0;
				for(DProdottoDTO prodotto : ProdottiCarrello){
					somma=somma+Float.parseFloat(prodotto.getPrezzo());
				}
				view.AggiornaTotaleCarrello(somma);
				
				AppUtils.EVENT_BUS.fireEvent(new AggiungiRicettaCarrelloEvent(event.getRicetta(),event.getProdotti()));
				
				
			}
			
		
		});
		
	}
	
	@Override
	public void bind() {
		view.setPresenter(this);
	}

	
	private void PrelevaRicette(DCategoriaDTO Categoria){
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
		    	  categoria = result.get(0);
		    	  PrelevaRicette(categoria);
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
