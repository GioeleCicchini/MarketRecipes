package marres.client.View;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.DivElement;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.vaadin.polymer.elemental.Element;

import marres.client.Presenter.CategoriaItemPresenter;

import marres.client.Presenter.Presenter;

public class CategoriaItem extends Composite implements CategoriaItemPresenter.Display {

	Presenter presenter;
	
  private final DivElement element;

  
  interface CategoriaItemUiBinder extends UiBinder<DivElement, CategoriaItem>  {
  }

  @UiField DivElement Categoria;
  @UiField Element CategoriaButton;
  
  private static CategoriaItemUiBinder ourUiBinder = GWT.create(CategoriaItemUiBinder.class);


  public CategoriaItem() {
    element = ourUiBinder.createAndBindUi(this);
  }

  
  @Override
  public void setCategoria(String categoria) {
  Categoria.setInnerText(categoria);
  CategoriaButton.setAttribute("tipo", categoria);
  }


@Override
public void AggiungiCategoria(DivElement categoria) {
	// TODO Auto-generated method stub
	
}



@Override
public void clear() {
	// TODO Auto-generated method stub
	
}


@Override
public void setPresenter(CategoriaItemPresenter presenter) {
	this.presenter= presenter;
	
}


@Override
public DivElement getDivElement() {
	return this.element;
}


@Override
public Element getCategoriaButton() {
	return this.CategoriaButton;
}













}