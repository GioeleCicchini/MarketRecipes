package marres.client.Events.EventMiddle;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DProdottoDTO;

public class AggiungiATotaleEvent extends GwtEvent<AggiungiATotaleEventHandler> {
	
public static Type<AggiungiATotaleEventHandler> TYPE = new Type<AggiungiATotaleEventHandler>();
	
	private DProdottoDTO prodotto;		
	private DProdottoDTO prodottoprecedente;		
	public AggiungiATotaleEvent(DProdottoDTO prodotto,DProdottoDTO prodottoprecedente) {
		this.prodotto = prodotto;
		this.prodottoprecedente=prodottoprecedente;
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

	public DProdottoDTO getProdottoPrecedente(){
		return this.prodottoprecedente;
	}
}
