package marres.client.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.paper.widget.PaperButton;
import com.vaadin.polymer.paper.widget.PaperDialog;
import com.vaadin.polymer.paper.widget.PaperInput;
import com.vaadin.polymer.paper.widget.PaperTextarea;


public class View extends Composite implements HasText {

	private static ViewUiBinder uiBinder = GWT.create(ViewUiBinder.class);

	@UiField PaperButton Primo;
	 @UiField PaperButton Secondo;
	 @UiField PaperDialog add;
	 @UiField PaperInput titleInput;
	 @UiField PaperTextarea descriptionInput;
	 
	interface ViewUiBinder extends UiBinder<Widget, View> {
	}

	public View() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("Primo")
    protected void premuto(ClickEvent e) {
        add.open();
    }
	
	@UiHandler("confirmAddButton")
    protected void confirm(ClickEvent e) {
        titleInput.setValue("");
        descriptionInput.setValue("");
        add.close();
    }

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}
	

}
