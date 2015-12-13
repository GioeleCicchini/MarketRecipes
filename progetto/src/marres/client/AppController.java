package marres.client;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Panel;

import marres.client.Events.EventDown.DisplayCategoriaEvent;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventUp.AggiungiCategoriaEvent;
import marres.client.Events.EventUp.AggiungiCategoriaEventHandler;
import marres.client.Events.EventUp.AggiungiRicettaEvent;
import marres.client.Events.EventUp.AggiungiRicettaEventHandler;
import marres.client.Presenter.CategoriaItemPresenter;
import marres.client.Presenter.MainPresenter;
import marres.client.Presenter.RicettaPresenter;
import marres.client.View.CategoriaItem;
import marres.client.View.Main;
import marres.client.View.VRicetta;
import marres.shared.DCategoria;
import marres.shared.DRicetta;

public class AppController {
	


	
	 private EventBus eventbus;
	
	 
	public AppController(EventBus eventbus){
		this.eventbus = eventbus;
	}
	public void go(Panel panel){
	// inizializzazione Applicazione	
		 Main main = new Main();
		 MainPresenter mainpresenter = new MainPresenter(main,this.eventbus);
		 RegistraEventi();
		 mainpresenter.go(panel);
	}
	
	
	public void RegistraEventi(){
		this.eventbus.addHandler(AggiungiRicettaEvent.TYPE, new AggiungiRicettaEventHandler(){
			@Override
			public void OnAggiungiRicetta(AggiungiRicettaEvent event) {
				DRicetta Dricetta = event.getRicetta();
				VRicetta Vricetta = new VRicetta();
				RicettaPresenter ricettapresenter = new RicettaPresenter(Vricetta);
				ricettapresenter.setRicetta(Dricetta.getTitolo(), Dricetta.getDescrizione());
				DivElement ricettaDiv= Vricetta.getDivElement();		
				eventbus.fireEvent(new DisplayRicettaEvent(ricettaDiv));
				
			}
		});
		
		this.eventbus.addHandler(AggiungiCategoriaEvent.TYPE, new AggiungiCategoriaEventHandler(){
			
			@Override
			public void OnAggiungiCategoria(AggiungiCategoriaEvent event) {
				DCategoria Dcategoria = event.getCategoria();
				CategoriaItem Vcategoria = new CategoriaItem();
				CategoriaItemPresenter categoriapresenter = new CategoriaItemPresenter(Vcategoria);
				categoriapresenter.setCategoria(Dcategoria.getNome());
				DivElement categoriaDiv = Vcategoria.getDivElement();
				eventbus.fireEvent(new DisplayCategoriaEvent(categoriaDiv));
			}
		});
		
	}


	

}
