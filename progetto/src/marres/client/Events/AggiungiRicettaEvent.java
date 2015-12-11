package marres.client.Events;

import com.google.gwt.event.shared.GwtEvent;
import marres.client.Events.AggiungiRicettaEventHandler;
import marres.shared.DRicetta;

public class AggiungiRicettaEvent extends GwtEvent<AggiungiRicettaEventHandler>{
	public static Type<AggiungiRicettaEventHandler> TYPE = new Type<AggiungiRicettaEventHandler>();
	
	private DRicetta ricetta;
	
	

	public AggiungiRicettaEvent(DRicetta ricetta) {
		this.ricetta = ricetta;
	}

	@Override
	public Type<AggiungiRicettaEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(AggiungiRicettaEventHandler handler) {
		handler.OnAggiungiRicetta(this);
		
	}
	
	public DRicetta getRicetta() {
		return ricetta;
	}




}
