package marres.client.Events.EventDown;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.shared.GwtEvent;


public class DisplayCategoriaEvent extends GwtEvent<DisplayCategoriaEventHandler> {
	
	private DivElement divElement;
	
	public DisplayCategoriaEvent(DivElement divElement){
		this.divElement = divElement;
	}
	
	public static Type<DisplayCategoriaEventHandler> TYPE = new Type<DisplayCategoriaEventHandler>();
	@Override
	public Type<DisplayCategoriaEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(DisplayCategoriaEventHandler handler) {
		handler.OnDisplayCategoria(this);
	}
	
	public DivElement getElement(){
		return this.divElement;
	}


}
