package marres.client.Presenter;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import marres.client.dto.DRicettaDTO;
import marres.shared.domain.DRicetta;

public class RicettaPresenter implements Presenter {

	Display view;
	DRicettaDTO Ricetta ;
	
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
	
	public void setRicetta(DRicettaDTO ricetta){
		this.Ricetta = ricetta;
	
		view.setRicetta(ricetta.getNome(), ricetta.getCottura());
		
	}

	@Override
	public DivElement getDivElement() {
		return view.getDivElement();
	}

	
	
	

}
