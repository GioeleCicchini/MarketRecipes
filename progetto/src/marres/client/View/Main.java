package marres.client.View;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.vaadin.polymer.elemental.*;
import com.vaadin.polymer.paper.element.*;
import marres.client.Presenter.MainPresenter;
import marres.client.Presenter.MainPresenter.Display;


public class Main extends Composite implements Display {
	
	MainPresenter presenter;
  interface MainUiBinder extends UiBinder<HTMLPanel, Main> {
  }

  private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);

  @UiField PaperDrawerPanelElement drawerPanel;
  @UiField HTMLElement ContenutiPrincipali;
  @UiField HTMLElement categorie;
  @UiField PaperFabElement ApriCarrello;
  @UiField PaperDialogElement Carrello;


  public Main() {
    initWidget(ourUiBinder.createAndBindUi(this));
  }
  
@Override
public void setPresenter(MainPresenter presenter) {
 this.presenter = presenter;
	
}

@Override
public void AggiungiContenutiPrincipali(DivElement ricetta) {
	ContenutiPrincipali.appendChild(ricetta);
}

@Override
public void AggiungiContenutiMenu(DivElement categoria) {
	categorie.appendChild(categoria);
	
}

@Override
public void EliminaContenutiPrincipali() {
	ContenutiPrincipali.setInnerHTML("");
	
}

@Override
public void EliminaContenutiMenu() {
	categorie.setInnerHTML("");
}

@Override
public PaperFabElement getApriCarrello() {
	return ApriCarrello;
}
@Override
public void ApriCarrello(){
	Carrello.open();
}







}
