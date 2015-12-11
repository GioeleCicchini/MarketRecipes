package marres.client.Presenter;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class RicettaPresenter implements Presenter {

	Display view;
	
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
	public void bind() {
		view.setPresenter(this);

	}
	
	public void setRicetta(String titolo, String descrizione){
		view.setRicetta(titolo, descrizione);
		
	}

	@Override
	public void go(Panel panel) {
		panel.add(view.asWidget());
	}

	@Override
	public DivElement getDivElement() {
		return view.getDivElement();
	}
	
	

}
