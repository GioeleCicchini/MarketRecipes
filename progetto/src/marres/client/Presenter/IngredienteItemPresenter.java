package marres.client.Presenter;


import java.util.List;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.iron.element.IronSelectorElement;

import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayIngredienteEvent;
import marres.client.Events.EventDown.DisplayIngredienteEventHandler;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventDown.DisplayRicettaEventHandler;
import marres.client.Presenter.RicettaPresenter.Display;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DProdottoDTO;

public class IngredienteItemPresenter implements Presenter {

	private Display view;
	private DIngredienteDTO Ingrediente;
	
	public interface Display {
		public DivElement getDivElement();
		public void clear();
		public Widget asWidget();
		public void setPresenter(IngredienteItemPresenter presenter);
		public void setIngrediente(String Nomeingrediente);
		public void setProdotti(List<DProdottoDTO> prodotti);
		public Element getprodotto();
		public Element getApriProdotti();
		public void ApriProdotti();
		public void setProdottoSelezionato(String prodotto);
	}
	
	
	public IngredienteItemPresenter(Display view){
		this.view = view;
		InizializzaEventiView();
		bind();
	}
	
	@Override
	public DivElement getDivElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bind() {
		view.setPresenter(this);
	}

	@Override
	public void InizializzaEventiView() {
		
		this.view.getprodotto().addEventListener("click",  new EventListener(){

			@Override
			public void handleEvent(Event event) {
				IronSelectorElement elemento =(IronSelectorElement) view.getprodotto();
				view.setProdottoSelezionato(elemento.getSelected());
			}
			
		});
		
		this.view.getApriProdotti().addEventListener("click",  new EventListener(){

			@Override
			public void handleEvent(Event event) {
				view.ApriProdotti();
				
			}
			
		});
		

	}
	
	public void setIngredienteItem(DIngredienteDTO ingrediente){
		this.Ingrediente = ingrediente;
		
		view.setIngrediente(ingrediente.getNome());
		
	}
	
	public void setProdotti(List<DProdottoDTO> prodotti){
		
			view.setProdotti(prodotti);
	}


}
