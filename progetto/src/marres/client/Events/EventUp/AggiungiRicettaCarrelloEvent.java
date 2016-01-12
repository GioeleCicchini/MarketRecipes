package marres.client.Events.EventUp;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;

public class AggiungiRicettaCarrelloEvent extends GwtEvent<AggiungiRicettaCarrelloEventHandler> {

public static Type<AggiungiRicettaCarrelloEventHandler> TYPE = new Type<AggiungiRicettaCarrelloEventHandler>();
	
	private DRicettaDTO ricetta;
	private List<DProdottoDTO> prodotti;
	
	public AggiungiRicettaCarrelloEvent(DRicettaDTO ricetta,List<DProdottoDTO> prodotti) {
		this.ricetta = ricetta;
		this.prodotti = prodotti;
	}

	@Override
	public Type<AggiungiRicettaCarrelloEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AggiungiRicettaCarrelloEventHandler handler) {
		handler.OnAggiungiRicettaCarrello(this);
		
	}
	
	public DRicettaDTO getRicetta() {
		return this.ricetta;
	}

	public List<DProdottoDTO> getProdotti(){
		return this.prodotti;
	}

	
}
