package marres.client.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;

import marres.client.Presenter.IngredienteItemPresenter;
import marres.client.Presenter.RicettaPresenter;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;

public class VIngredienteItem extends Composite implements IngredienteItemPresenter.Display {

	IngredienteItemPresenter presenter;
	
	private static VIngredienteItemUiBinder uiBinder = GWT.create(VIngredienteItemUiBinder.class);

	private final DivElement element;
	
	@UiField Element nomeIngrediente;
	
	
	
	interface VIngredienteItemUiBinder extends UiBinder<DivElement, VIngredienteItem> {
	}

	public VIngredienteItem() {
		element = uiBinder.createAndBindUi(this);
	}

	@Override
	public DivElement getDivElement() {
		return element;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(IngredienteItemPresenter presenter) {
		this.presenter= presenter;
	}

	@Override
	public void setIngrediente(String Nomeingrediente) {
		this.nomeIngrediente.setInnerHTML(Nomeingrediente);
		
	}





}
