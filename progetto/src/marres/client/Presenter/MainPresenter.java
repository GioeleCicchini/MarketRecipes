package marres.client.Presenter;


import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import marres.client.Events.AggiungiRicettaEvent;
import marres.client.Events.RegisterEvent;
import marres.client.RPC.RicetteService;
import marres.client.RPC.RicetteServiceAsync;
import marres.shared.DRicetta;


public class MainPresenter implements Presenter {
	
	private ArrayList<DRicetta> ricette = new ArrayList<DRicetta>();
	private RicetteServiceAsync ricetteSvc = GWT.create(RicetteService.class);
	
	private Display view;
	
	
	public interface Display {
		public void OpenItemDialog();
		public void AggiungiRicetta(DivElement ricetta);
		public void clear();
		public void setPresenter(MainPresenter presenter);
		public Widget asWidget();
	}
	
	public MainPresenter(Display view){
		this.view = view;
		bind();
		
		
		if (ricetteSvc == null) {
		      ricetteSvc = GWT.create(RicetteService.class);
		    }

		     // Set up the callback object.
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
	
	@Override
	public void bind() {
		view.setPresenter(this);
		
	}

	@Override
	public void go(Panel panel) {
		panel.add(view.asWidget());

	}
	
	private void PrelevaRicette(){
		
		
	}
	
	public void OpenItemDialog(){
		view.OpenItemDialog();
	}
	
	
	public void DisplayRicetta(DivElement ricetta){
	view.AggiungiRicetta(ricetta);
	}


	@Override
	public DivElement getDivElement() {
		// TODO Auto-generated method stub
		return null;
	}


	public void AggiungiRicetta (DRicetta ricetta) {
		RegisterEvent.eventBus.fireEvent(new AggiungiRicettaEvent(ricetta));
	}

}
