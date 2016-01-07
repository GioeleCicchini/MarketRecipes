package marres.client.Events.EventUp;

import com.google.gwt.event.shared.GwtEvent;

import marres.client.Events.EventUp.AggiungiRicettaEventHandler;
import marres.shared.domain.DRicetta;
import marres.shared.dto.DRicettaDTO;

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
