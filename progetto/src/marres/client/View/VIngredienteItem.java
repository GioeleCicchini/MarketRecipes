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
import com.vaadin.polymer.paper.element.PaperDialogElement;
import com.vaadin.polymer.paper.element.PaperItemElement;
import com.vaadin.polymer.paper.element.PaperMenuElement;
import com.vaadin.polymer.paper.widget.PaperItem;

public class VIngredienteItem extends Composite implements IngredienteItemPresenter.Display {

	IngredienteItemPresenter presenter;
	List<DProdottoDTO> ProdottiList = new ArrayList<DProdottoDTO>();
	
	
	private static VIngredienteItemUiBinder uiBinder = GWT.create(VIngredienteItemUiBinder.class);

	private final DivElement element;
	
	@UiField Element nomeIngrediente;
	@UiField IronSelectorElement prodotti;
	
	@UiField PaperDialogElement apriProdotti;
	@UiField Element apriProdottibutton;
	@UiField Element prezzo;
	
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
		this.ProdottiList=prodotti;	
		int i=0;
		int index = -1;
		if(prodottoselezionato != null){
			for(DProdottoDTO prodotto : ProdottiList){
				if(prodotto.getId() == prodottoselezionato.getId()){
					index = i;
				}
				i=i+1;
			}
		}
		else{
			index= 0;
		}
		for(DProdottoDTO prodotto :prodotti){
				String item = "<div>"+prodotto.getNome()+"<p>"+"<b>Prezzo:</b>"+prodotto.getPrezzo()+"<div>";
				this.prodotti.setInnerHTML(this.prodotti.getInnerHTML()+item);
		}
		if(prodotti.size() != 0){
		setProdottoSelezionato(index);
		}
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
	public void setProdottoSelezionato(int index) {
		int indice = index;
		
		this.apriProdottibutton.setInnerHTML(this.ProdottiList.get(indice).getNome());
		this.prezzo.setInnerHTML(this.ProdottiList.get(indice).getPrezzo()+"€");
		
		AppUtils.EVENT_BUS.fireEvent(new AggiungiATotaleEvent(ProdottiList.get(indice)));
	}

	




}
