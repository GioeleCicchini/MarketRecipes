package marres.client.Events.EventDown;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DisplayRicettaCarrelloEvent extends GwtEvent<DisplayRicettaCarrelloEventHandler> {

	public static Type<DisplayRicettaCarrelloEventHandler> TYPE = new Type<DisplayRicettaCarrelloEventHandler>();
	
	private DivElement divElement;
	
	public DisplayRicettaCarrelloEvent(DivElement divElement){
		this.divElement = divElement;
	}
	
	@Override
	public Type<DisplayRicettaCarrelloEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DisplayRicettaCarrelloEventHandler handler) {
		handler.OnDisplayRicettaCarrello(this);
	}
	
	public DivElement getElement(){
		return this.divElement;
	}

}