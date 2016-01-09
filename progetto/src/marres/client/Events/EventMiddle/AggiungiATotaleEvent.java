package marres.client.Events.EventMiddle;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DProdottoDTO;

public class AggiungiATotaleEvent extends GwtEvent<AggiungiATotaleEventHandler> {
	
public static Type<AggiungiATotaleEventHandler> TYPE = new Type<AggiungiATotaleEventHandler>();
	
	private DProdottoDTO prodotto;		
	
	public AggiungiATotaleEvent(DProdottoDTO prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public Type<AggiungiATotaleEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AggiungiATotaleEventHandler handler) {
		handler.OnAggiungiATotale(this);
		
	}
	
	public DProdottoDTO getProdotto(){
		return this.prodotto;
	}

}
