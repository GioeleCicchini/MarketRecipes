package marres.client.Events.EventDown;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DisplayIngredienteEvent extends GwtEvent<DisplayIngredienteEventHandler>{

	private DivElement divElement;
	
	public static Type<DisplayIngredienteEventHandler> TYPE = new Type<DisplayIngredienteEventHandler>();
	
	public DisplayIngredienteEvent(DivElement divElement){
		this.divElement = divElement;
	}
	
	@Override
	protected void dispatch(DisplayIngredienteEventHandler handler) {
		handler.OnDisplayIngrediente(this);
		
	}

	@Override
	public Type<DisplayIngredienteEventHandler> getAssociatedType() {
		return TYPE;
	}

	public DivElement getElement(){
		return this.divElement;
	}

}
