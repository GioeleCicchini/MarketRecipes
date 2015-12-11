package marres.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.elemental.Function;
import com.vaadin.polymer.iron.element.IronIconElement;
import com.vaadin.polymer.iron.element.IronImageElement;
import com.vaadin.polymer.paper.element.*;
import java.util.Arrays;
import marres.client.Presenter.Presenter;
import marres.client.Presenter.MainPresenter;
import marres.client.Presenter.MainPresenter.Display;

import marres.client.View.*;

public class Entry implements EntryPoint {
	public void onModuleLoad() {
		
		 Polymer.importHref(Arrays.asList(
	                "iron-icons/iron-icons.html",
	                PaperIconItemElement.SRC,
	                PaperRippleElement.SRC,
	                IronIconElement.SRC,
	                PaperDrawerPanelElement.SRC,
	                PaperHeaderPanelElement.SRC,
	                PaperToolbarElement.SRC,
	                PaperFabElement.SRC,
	                PaperDialogElement.SRC,
	                PaperTextareaElement.SRC,
	                PaperInputElement.SRC,
	                PaperButtonElement.SRC,
	                PaperCheckboxElement.SRC
	                    
               
                
        ), new Function() {
            public Object call(Object arg) {
                startApplication();
                return null;
            }
        });

	  }

	  private void startApplication() {
	    
		AppController controller = new AppController();
		//  RootPanel.get().add(new Main());
		  
		  
	
		
		
		

		
		
		/*
		Presenter presenterRicSpace = new RicettaSpacePresenter(view2);
		presenterRicSpace.go(RootPanel.get());
		*/
	  }
}














