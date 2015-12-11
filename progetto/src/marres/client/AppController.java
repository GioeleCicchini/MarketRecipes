package marres.client;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.RootPanel;
import marres.client.Events.AggiungiRicettaEvent;
import marres.client.Events.AggiungiRicettaEventHandler;
import marres.client.Events.RegisterEvent;
import marres.client.Presenter.MainPresenter;
import marres.client.Presenter.RicettaPresenter;
import marres.client.View.Main;
import marres.client.View.VRicetta;
import marres.shared.DRicetta;

public class AppController {
	

	
	public AppController(){
		
		
		final Main main = new Main();
		final MainPresenter mainpresenter = new MainPresenter(main);
		
		mainpresenter.go(RootPanel.get());
		
		RegisterEvent.eventBus.addHandler(AggiungiRicettaEvent.TYPE, new AggiungiRicettaEventHandler(){

			@Override
			public void OnAggiungiRicetta(AggiungiRicettaEvent event) {
				DRicetta Dricetta = event.getRicetta();
				VRicetta Vricetta = new VRicetta();
				RicettaPresenter ricettapresenter = new RicettaPresenter(Vricetta);
				ricettapresenter.setRicetta(Dricetta.getTitolo(), Dricetta.getDescrizione());
				DivElement ricettaDiv= Vricetta.getDivElement();		
				mainpresenter.DisplayRicetta(ricettaDiv);
				
			}
		});
		
	}
	

}
