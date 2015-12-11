package marres.client.View;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;


public class CategoriaItem {

  private final DivElement element;

  interface CategoriaItemUiBinder extends UiBinder<DivElement, CategoriaItem> {
  }

  @UiField Element ciao;
  private static CategoriaItemUiBinder ourUiBinder = GWT.create(CategoriaItemUiBinder.class);


  public CategoriaItem() {
    element = ourUiBinder.createAndBindUi(this);
  }


	  
  public Element getCiao() {
	return ciao;
}



public void setCiao(Element ciao) {
	this.ciao = ciao;
}



public DivElement getElement() {
    return element;
  }
}