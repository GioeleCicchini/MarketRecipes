package marres.client.Events.EventMiddle;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;

public class AggiungiACarrelloEvent extends GwtEvent<AggiungiACarrelloEventHandler> {

	
	public static Type<AggiungiACarrelloEventHandler> TYPE = new Type<AggiungiACarrelloEventHandler>();
	
	private DRicettaDTO ricetta;
	private List<DProdottoDTO> prodotti;
	

	public AggiungiACarrelloEvent(DRicettaDTO ricetta,List<DProdottoDTO> prodotti){
		this.ricetta=ricetta;
		this.prodotti=prodotti;
	}
	
	@Override
	protected void dispatch(AggiungiACarrelloEventHandler handler) {
		handler.OnAggiungiACarrello(this);
		
	}

	@Override
	public Type<AggiungiACarrelloEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	public DRicettaDTO getRicetta() {
		return ricetta;
	}

	public List<DProdottoDTO> getProdotti() {
		return prodotti;
	}




}
