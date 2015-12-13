package marres.client.Events.EventDown;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.shared.GwtEvent;


public class DisplayRicettaEvent extends GwtEvent<DisplayRicettaEventHandler> {

	public static Type<DisplayRicettaEventHandler> TYPE = new Type<DisplayRicettaEventHandler>();
	
	private DivElement divElement;
	
	public DisplayRicettaEvent(DivElement divElement){
		this.divElement = divElement;
	}
	
	@Override
	public Type<DisplayRicettaEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DisplayRicettaEventHandler handler) {
		handler.OnDisplayRicetta(this);
	}
	
	public DivElement getElement(){
		return this.divElement;
	}

}
