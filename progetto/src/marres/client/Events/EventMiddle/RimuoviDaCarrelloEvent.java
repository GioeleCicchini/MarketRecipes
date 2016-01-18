package marres.client.Events.EventMiddle;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;

public class RimuoviDaCarrelloEvent extends GwtEvent<RimuoviDaCarrelloEventHandler>{

public static Type<RimuoviDaCarrelloEventHandler> TYPE = new Type<RimuoviDaCarrelloEventHandler>();
	
	private List<DProdottoDTO> prodotti;
	private DRicettaDTO ricetta;
	
	
	public RimuoviDaCarrelloEvent(DRicettaDTO ricetta,List<DProdottoDTO> prodotti) {
		this.prodotti = prodotti;
		this.ricetta= ricetta;
	}

	@Override
	public Type<RimuoviDaCarrelloEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RimuoviDaCarrelloEventHandler handler) {
		handler.OnRimuoviDaCarrello(this);
		
	}
	
	public List<DProdottoDTO> getProdotti(){
		return this.prodotti;
	}

	public DRicettaDTO getRicetta(){
		return this.ricetta;
	}
	
}
