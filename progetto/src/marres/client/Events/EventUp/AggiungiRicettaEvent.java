package marres.client.Events.EventUp;

import com.google.gwt.event.shared.GwtEvent;

import marres.client.Events.EventUp.AggiungiRicettaEventHandler;
import marres.client.dto.DRicettaDTO;
import marres.shared.domain.DRicetta;

public class AggiungiRicettaEvent extends GwtEvent<AggiungiRicettaEventHandler>{
	public static Type<AggiungiRicettaEventHandler> TYPE = new Type<AggiungiRicettaEventHandler>();
	
	private DRicettaDTO ricetta;
	
	

	public AggiungiRicettaEvent(DRicettaDTO ricetta) {
		this.ricetta = ricetta;
	}

	@Override
	public Type<AggiungiRicettaEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AggiungiRicettaEventHandler handler) {
		handler.OnAggiungiRicetta(this);
		
	}
	
	public DRicettaDTO getRicetta() {
		return this.ricetta;
	}




}
