package marres.client.Events.EventUp;

import com.google.gwt.event.shared.GwtEvent;

import marres.client.Events.EventUp.AggiungiRicettaEventHandler;
import marres.shared.DRicetta;

public class AggiungiRicettaEvent extends GwtEvent<AggiungiRicettaEventHandler>{
	public static Type<AggiungiRicettaEventHandler> TYPE = new Type<AggiungiRicettaEventHandler>();
	
	private DRicetta ricetta;
	
	

	public AggiungiRicettaEvent(DRicetta ricetta) {
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
	
	public DRicetta getRicetta() {
		return this.ricetta;
	}




}
