package marres.client.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.vaadin.polymer.paper.element.PaperCheckboxElement;

import marres.client.Presenter.RicettaPresenter;


public class VRicetta extends Composite implements RicettaPresenter.Display{

	RicettaPresenter presenter;
	  @UiField Element titolo;
	  @UiField Element descrizione;
	  @UiField PaperCheckboxElement done;
	
	

	 private final DivElement element;
	 
	private static VRicettaUiBinder uiBinder = GWT.create(VRicettaUiBinder.class);

	interface VRicettaUiBinder extends UiBinder<DivElement, VRicetta> {
	}

	public DivElement getDivElement() {
		return element;
	}





	public VRicetta() {
		element = uiBinder.createAndBindUi(this);
	}





	@Override
	public void setPresenter(RicettaPresenter RicettaPresenter) {
		this.presenter= RicettaPresenter;
		
	}
	public String getTitolo() {
		return titolo.getInnerText();
	}



	public void setTitolo(String titolo) {
		this.titolo.setInnerText(titolo);
	}



	public String getDescrizione() {
		return descrizione.getInnerText();
	}



	public void setDescrizione(String descrizione) {
		this.descrizione.setInnerText(descrizione);
	}





	@Override
	public void setRicetta(String titolo, String descrizione) {
		this.titolo.setInnerText(titolo);
		this.descrizione.setInnerText(descrizione);
		
	}
	
	
	






}
