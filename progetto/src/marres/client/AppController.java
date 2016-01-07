package marres.client;



import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.DivElement;

import com.google.gwt.user.client.ui.Panel;
import marres.client.Events.EventDown.DisplayCategoriaEvent;
import marres.client.Events.EventDown.DisplayIngredienteEvent;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventUp.AggiungiCategoriaEvent;
import marres.client.Events.EventUp.AggiungiCategoriaEventHandler;
import marres.client.Events.EventUp.AggiungiIngredienteEvent;
import marres.client.Events.EventUp.AggiungiIngredienteEventHandler;
import marres.client.Events.EventUp.AggiungiRicettaEvent;
import marres.client.Events.EventUp.AggiungiRicettaEventHandler;
import marres.client.Presenter.CategoriaItemPresenter;
import marres.client.Presenter.IngredienteItemPresenter;
import marres.client.Presenter.MainPresenter;
import marres.client.Presenter.RicettaPresenter;
import marres.client.View.CategoriaItem;
import marres.client.View.Main;
import marres.client.View.VIngredienteItem;
import marres.client.View.VRicetta;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DRicetta;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DRicettaDTO;

public class AppController {
	


	
	 
	public AppController(){
		


	//	Session session = HibernateUtil.getSessionFactory().openSession();
		
	}
	public void go(Panel panel){
	
	// inizializzazione Applicazione	
		 Main main = new Main();
		 MainPresenter mainpresenter = new MainPresenter(main);
		 RegistraEventi();
		 mainpresenter.go(panel);
		 
	}
	
	
	public void RegistraEventi(){
		
		AppUtils.EVENT_BUS.addHandler(AggiungiRicettaEvent.TYPE, new AggiungiRicettaEventHandler(){
			@Override
			public void OnAggiungiRicetta(AggiungiRicettaEvent event) {
				
				DRicettaDTO Ricetta = event.getRicetta();
				VRicetta Vricetta = new VRicetta();
				RicettaPresenter ricettapresenter = new RicettaPresenter(Vricetta);
				
				ricettapresenter.setRicetta(Ricetta);
				DivElement ricettaDiv= Vricetta.getDivElement();		
				AppUtils.EVENT_BUS.fireEvent(new DisplayRicettaEvent(ricettaDiv));
				
			}
		});
		
		AppUtils.EVENT_BUS.addHandler(AggiungiCategoriaEvent.TYPE, new AggiungiCategoriaEventHandler(){
			
			@Override
			public void OnAggiungiCategoria(AggiungiCategoriaEvent event) {
				DCategoriaDTO Categoria = event.getCategoria();
				CategoriaItem Vcategoria = new CategoriaItem();
				CategoriaItemPresenter categoriapresenter = new CategoriaItemPresenter(Vcategoria);
				categoriapresenter.setCategoria(Categoria);
				DivElement categoriaDiv = Vcategoria.getDivElement();
				AppUtils.EVENT_BUS.fireEvent(new DisplayCategoriaEvent(categoriaDiv));
			}
		});
		
		
		AppUtils.EVENT_BUS.addHandler(AggiungiIngredienteEvent.TYPE, new AggiungiIngredienteEventHandler(){

			@Override
			public void OnAggiungiIngrediente(AggiungiIngredienteEvent event) {
				
				DIngredienteDTO Ingrediente = event.getIngrediente();
				VIngredienteItem Vingrediente = new VIngredienteItem();
				IngredienteItemPresenter ingredientepresenter = new IngredienteItemPresenter(Vingrediente);
				ingredientepresenter.setIngredienteItem(Ingrediente);
				DivElement ingredienteDiv = Vingrediente.getDivElement();
				AppUtils.EVENT_BUS.fireEvent(new DisplayIngredienteEvent(ingredienteDiv));
				
			}
			
			
		});
		
		
	}


	

}
