package marres.client.Presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.elemental.Element;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.elemental.Event;
import marres.client.AppUtils;
import marres.client.Events.EventDown.DisplayRicettaEvent;
import marres.client.Events.EventMiddle.AggiungiACarrelloEvent;
import marres.client.Events.EventMiddle.RimuoviDaCarrelloEvent;
import marres.client.Events.EventUp.AggiungiRicettaCarrelloEvent;
import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;


public class RicettaCarrelloPresenter implements Presenter {

	
	
	private Display view;
	private DRicettaDTO ricetta;
	private List<DProdottoDTO> prodotti = new ArrayList<DProdottoDTO>();
	
	public interface Display {
		public DivElement getDivElement();
		public void setPresenter(RicettaCarrelloPresenter presenter);
		public Widget asWidget();
		public void setRicetta(String nome,String costo,List<DProdottoDTO> Prodottoitem);
		public Element getEliminaRicettaButton();
		public void clear();
		public Element getIncrementaPiu();
		public Element getIncrementaMeno();
		public void incrementa();
		public int decrementa();
	}
	

	public RicettaCarrelloPresenter(Display view){
		this.view = view;	
		bind();
		InizializzaEventiView();
		
	}
	
	@Override
	public DivElement getDivElement() {
		return this.view.getDivElement();
	}

	@Override
	public void bind() {
		view.setPresenter(this);
		
	}
	
	public void setRicetta(DRicettaDTO ricetta,List<DProdottoDTO> prodotti){
		this.ricetta = ricetta;
		float somma=0;
		
		for(DProdottoDTO prodotto : prodotti){			
			this.prodotti.add(prodotto);
		}
	
		for(DProdottoDTO prodotto : prodotti){
			somma=somma+Float.parseFloat(prodotto.getPrezzo());
			
		}
		
		view.setRicetta(ricetta.getNome(),String.valueOf((float) (Math.floor(somma * 100) / 100)),prodotti);
		
	}
	


	@Override
	public void InizializzaEventiView() {
		
		this.view.getEliminaRicettaButton().addEventListener("click", new EventListener(){

			@Override
			public void handleEvent(Event event) {
				view.clear();	
				AppUtils.EVENT_BUS.fireEvent(new RimuoviDaCarrelloEvent(ricetta,prodotti));
			}

			
		});
		
		this.view.getIncrementaPiu().addEventListener("click", new EventListener(){

			@Override
			public void handleEvent(Event event) {
				view.incrementa();
				AppUtils.EVENT_BUS.fireEvent(new AggiungiACarrelloEvent(ricetta,prodotti,1));
			}
		});
		
		this.view.getIncrementaMeno().addEventListener("click", new EventListener(){

			@Override
			public void handleEvent(Event event) {
				int quantita = view.decrementa();
				if(quantita >= 1){
				AppUtils.EVENT_BUS.fireEvent(new RimuoviDaCarrelloEvent(ricetta,prodotti));
				}
				if(quantita == 0){
					view.clear();	
					AppUtils.EVENT_BUS.fireEvent(new RimuoviDaCarrelloEvent(ricetta,prodotti));
				}
				
			}
		});
		
		
	}

}
