package marres.client.View;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;

import marres.client.Presenter.RicettaCarrelloPresenter;
import marres.client.Presenter.RicettaPresenter;
import marres.shared.dto.DProdottoDTO;

public class VRicettaCarrelloElement extends Composite implements RicettaCarrelloPresenter.Display  {

	RicettaCarrelloPresenter presenter;
	
	private static VRicettaCarrelloElementUiBinder uiBinder = GWT.create(VRicettaCarrelloElementUiBinder.class);
	 private final DivElement element;
	
	 
	 @UiField Element nome;
	 @UiField Element costo;
	 @UiField Element ProdottoItem;
	 @UiField Element RimuoviRicetta;
	 @UiField Element ElementoNelCarrello;
	 @UiField Element quantita;
	 @UiField Element incrementapiu;
	 @UiField Element incrementameno;
	 
	interface VRicettaCarrelloElementUiBinder extends UiBinder<DivElement, VRicettaCarrelloElement> {
	}
	

	public VRicettaCarrelloElement() {
		element = uiBinder.createAndBindUi(this);
	}

	@Override
	public void setPresenter(RicettaCarrelloPresenter presenter) {
	 this.presenter = presenter;
	}

	@Override
	public DivElement getDivElement() {
		return this.element;
	}

	@Override
	public void setRicetta(String nome,String costo,List<DProdottoDTO> prodotti) {
		this.nome.setInnerHTML(nome);
		this.costo.setInnerHTML(costo+"€");
		for(DProdottoDTO prodotto : prodotti ){
			String item= "<paper-item>"+prodotto.getNome()+"<paper-item>";
			this.ProdottoItem.setInnerHTML(this.ProdottoItem.getInnerHTML()+item);
		}
		
		
	}

	@Override
	public Element getEliminaRicettaButton() {
		return RimuoviRicetta;
	}

	@Override
	public void clear() {
		this.ElementoNelCarrello.setInnerHTML("");
		
	}

	public void incrementa(){
		int quantita = Integer.valueOf(this.quantita.getInnerHTML());
		quantita = quantita +1 ;
		this.quantita.setInnerHTML(String.valueOf(quantita));
	}
	public int decrementa(){
		int quantita = Integer.valueOf(this.quantita.getInnerHTML());
		quantita = quantita -1;
		this.quantita.setInnerHTML(String.valueOf(quantita));
		return quantita;
	}
	
	public Element getIncrementaPiu(){
		return incrementapiu;
	}
	public Element getIncrementaMeno(){
		return incrementameno;
	}

}
