package marres.client.Events.EventMiddle;

import com.google.gwt.event.shared.GwtEvent;

import marres.client.Events.EventUp.AggiungiCategoriaEventHandler;
import marres.shared.DCategoria;


public class CambiaCategoriaEvent extends GwtEvent<CambiaCategoriaEventHandler>{

	public static Type<CambiaCategoriaEventHandler> TYPE = new Type<CambiaCategoriaEventHandler>();
	
	private DCategoria categoria;		
	
	public CambiaCategoriaEvent(DCategoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public Type<CambiaCategoriaEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CambiaCategoriaEventHandler handler) {
		handler.OnCambiaCategoria(this);
		
	}
	
	public DCategoria getCategoria(){
		return this.categoria;
	}

}
