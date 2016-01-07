package marres.client.Presenter;


import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.Widget;

import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayIngredienteEvent;
import marres.client.Events.EventDown.DisplayIngredienteEventHandler;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventDown.DisplayRicettaEventHandler;
import marres.client.Presenter.RicettaPresenter.Display;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;

public class IngredienteItemPresenter implements Presenter {

	private Display view;
	private DIngredienteDTO Ingrediente;
	
	public interface Display {
		public DivElement getDivElement();
		public void clear();
		public Widget asWidget();
		public void setPresenter(IngredienteItemPresenter presenter);
		public void setIngrediente(String Nomeingrediente);
	}
	
	
	public IngredienteItemPresenter(Display view){
		this.view = view;
		InizializzaEventiView();
		bind();
	}
	
	@Override
	public DivElement getDivElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bind() {
		view.setPresenter(this);
	}

	@Override
	public void InizializzaEventiView() {
		
		
		
		

	}
	
	public void setIngredienteItem(DIngredienteDTO ingrediente){
		this.Ingrediente = ingrediente;
		
		view.setIngrediente(ingrediente.getNome());
		
	}
	


}
