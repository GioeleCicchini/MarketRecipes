package marres.client.View;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Node;

import marres.client.AppUtils;
import marres.client.Events.EventMiddle.AggiungiATotaleEvent;
import marres.client.Events.EventUp.AggiungiIngredienteEvent;
import marres.client.Presenter.IngredienteItemPresenter;
import marres.client.Presenter.RicettaPresenter;
import marres.shared.dto.DProdottoDTO;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.iron.element.IronSelectorElement;
import com.vaadin.polymer.paper.element.PaperCheckboxElement;
import com.vaadin.polymer.paper.element.PaperDialogElement;
import com.vaadin.polymer.paper.element.PaperItemElement;
import com.vaadin.polymer.paper.element.PaperMenuElement;
import com.vaadin.polymer.paper.widget.PaperItem;

public class VIngredienteItem extends Composite implements IngredienteItemPresenter.Display {

	IngredienteItemPresenter presenter;
	
	
	
	private static VIngredienteItemUiBinder uiBinder = GWT.create(VIngredienteItemUiBinder.class);

	private final DivElement element;
	
	@UiField Element nomeIngrediente;
	@UiField IronSelectorElement prodotti;
	
	@UiField PaperDialogElement apriProdotti;
	@UiField Element apriProdottibutton;
	@UiField Element prezzo;
	@UiField PaperCheckboxElement escludi;
	
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

	@Override
	public void setProdotti(List<DProdottoDTO> prodotti,DProdottoDTO prodottoselezionato) {
		for(DProdottoDTO prodotto :prodotti){
				String item = "<div>"+prodotto.getNome()+"<p>"+"<b>Prezzo:</b>"+prodotto.getPrezzo()+"<div>";
				this.prodotti.setInnerHTML(this.prodotti.getInnerHTML()+item);
		}
		setProdottoSelezionato(prodottoselezionato);
	}
	
	public  Element getprodotto(){
		return this.prodotti;
		
	}

	
	@Override
	public Element getApriProdotti() {
		return this.apriProdottibutton;
	}
	
	@Override
	public void ApriProdotti() {
		 this.apriProdotti.open();
	}

	@Override
	public void setProdottoSelezionato(DProdottoDTO prodotto) {
		
		this.apriProdottibutton.setInnerHTML(prodotto.getNome());
		this.prezzo.setInnerHTML(prodotto.getPrezzo()+"€");
		
	}

	@Override
	public PaperCheckboxElement getEscludi(){
		return this.escludi;
	}




}
