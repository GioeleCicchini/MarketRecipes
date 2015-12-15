package marres.client.Presenter;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import marres.shared.DRicetta;

public class RicettaPresenter implements Presenter {

	Display view;
	DRicetta Ricetta ;
	
	public interface Display {
		public DivElement getDivElement();
		public void setPresenter(RicettaPresenter RicettaPresenter);
		public Widget asWidget(); 
		public void setRicetta(String titolo, String descrizione);
	}
	
	public RicettaPresenter(Display view){
		this.view = view;
		bind();
	}
	
	@Override
	public void InizializzaEventiView() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void bind() {
		view.setPresenter(this);

	}
	
	public void setRicetta(DRicetta ricetta){
		this.Ricetta = ricetta;
	
		view.setRicetta(ricetta.getTitolo(), ricetta.getDescrizione());
		
	}

	@Override
	public DivElement getDivElement() {
		return view.getDivElement();
	}

	
	
	

}
