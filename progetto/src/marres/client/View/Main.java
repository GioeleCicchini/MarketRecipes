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


  @UiField HTMLElement content;
  @UiField HTMLElement categorie;
  @UiField PaperFabElement addButton;

  @UiField PaperDialogElement addItemDialog;
  @UiField PaperInputElement titleInput;
  @UiField PaperTextareaElement descriptionInput;
  @UiField PaperButtonElement confirmAddButton;

 

  // costruttore con inizializzazione eventi 
  public Main() {
    initWidget(ourUiBinder.createAndBindUi(this));

    addButton.addEventListener("click", new EventListener() {
      public void handleEvent(Event event) {
    	  if(presenter != null){
    	  presenter.OpenItemDialog();
    	  }
      }
    });

   
    confirmAddButton.addEventListener("click", new EventListener() {
      public void handleEvent(Event event) {
        if (!titleInput.getValue().isEmpty()) {
        	//presenter.OnAddButtonClick(titleInput.getValue(),descriptionInput.getValue());
        }
      }
    });

  }
  
  @Override
 public void OpenItemDialog(){
	  addItemDialog.open();
  }
  


@Override
public void clear() {
    titleInput.setValue("");
    descriptionInput.setValue("");
}

@Override
public void setPresenter(MainPresenter presenter) {
 this.presenter = presenter;
	
}

@Override
public void AggiungiRicetta(DivElement ricetta) {
	    content.appendChild(ricetta);
}



}
