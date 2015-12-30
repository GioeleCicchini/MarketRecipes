package marres.client.Presenter;


import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;

import marres.client.AppUtils;
import marres.client.Events.EventMiddle.CambiaCategoriaEvent;
import marres.client.dto.DCategoriaDTO;



public class CategoriaItemPresenter implements Presenter {

	
	
	private Display view;
	private DCategoriaDTO Categoria;
	
	public interface Display {
		public DivElement getDivElement();
		public void AggiungiCategoria(DivElement categoria);
		public void clear();
		public Widget asWidget();
		public void setPresenter(CategoriaItemPresenter presenter);
		public void setCategoria(String categoria);
		public Element getCategoriaButton();
	}
	
	public CategoriaItemPresenter(Display view){
		this.view = view;
		bind();
		InizializzaEventiView();
	}
	
	@Override
	public void InizializzaEventiView() {
		
		final Element CategoriaButton = this.view.getCategoriaButton();
		CategoriaButton.addEventListener("click", new EventListener(){
			@Override
			public void handleEvent(Event event) {
				
				AppUtils.EVENT_BUS.fireEvent(new CambiaCategoriaEvent(Categoria));
				
			}
		});
		
	}
	
	
	public void setCategoria(DCategoriaDTO categoria){
		view.setCategoria(categoria.getNome());
		this.Categoria= categoria;
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

	
	
	
	
	

}
