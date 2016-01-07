package marres.client.View;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.iron.element.IronImageElement;
import com.vaadin.polymer.paper.element.PaperDialogElement;

import marres.client.Presenter.RicettaPresenter;


public class VRicetta extends Composite implements RicettaPresenter.Display{

	RicettaPresenter presenter;
	
	
	  @UiField Element titolo;
	  @UiField Element difficolta;
	  @UiField Element preparazione;
	  @UiField Element cottura;
	  @UiField Element dosi;
	  @UiField Element costo;
	  @UiField IronImageElement immagine;
	  @UiField IronImageElement immagineDettagli;
	  @UiField Element RicettaCard;
	  @UiField PaperDialogElement RicettaDettagli;
	  @UiField Element IngredientiTable;
	  
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
		return titolo.getInnerHTML();
	}

	public void setTitolo(String titolo) {
		this.titolo.setInnerHTML(titolo);
		
	}

	@Override
	public void setRicetta(String titolo, String difficolta, String preparazione,String cottura,String dosi , String costo, String immagine) {
		this.titolo.setInnerHTML(titolo);
		this.difficolta.setInnerHTML(difficolta);
		this.preparazione.setInnerHTML(preparazione);
		this.cottura.setInnerHTML(cottura);
		this.dosi.setInnerHTML(dosi);
		this.costo.setInnerHTML(costo+"€");
		
		this.immagine.setSrc(immagine);
		this.immagineDettagli.setSrc(immagine);
		
	}



	@Override
	public void ApriRicetta() {
		
		// chiamata per ricevere ingredienti
		// per ogni ingrediente inserisci!
		RicettaDettagli.open();
		
	}

	@Override
	public Element getApriRicetta() {
		return RicettaCard;
	}

	@Override
	public void AggiungiIngredienti(DivElement ingrediente) {
		this.IngredientiTable.appendChild(ingrediente);
		
	}
	
	
	






}
