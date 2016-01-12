package marres.client.Presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.user.client.ui.Widget;

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
	}
	

	public RicettaCarrelloPresenter(Display view){
		this.view = view;
		InizializzaEventiView();	
		bind();
		
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
		this.prodotti = prodotti;
	
		float somma=0;
		
		for(DProdottoDTO prodotto : prodotti){
			somma=somma+Float.parseFloat(prodotto.getPrezzo());
			
		}
		
		view.setRicetta(ricetta.getNome(),String.valueOf((float) (Math.floor(somma * 100) / 100)),prodotti);
		
	}
	


	@Override
	public void InizializzaEventiView() {
		// TODO Auto-generated method stub
		
	}

}
