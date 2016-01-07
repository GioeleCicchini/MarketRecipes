package marres.client.Events.EventMiddle;

import com.google.gwt.event.shared.GwtEvent;

import marres.shared.dto.DCategoriaDTO;



public class CambiaCategoriaEvent extends GwtEvent<CambiaCategoriaEventHandler>{

	public static Type<CambiaCategoriaEventHandler> TYPE = new Type<CambiaCategoriaEventHandler>();
	
	private DCategoriaDTO categoria;		
	
	public CambiaCategoriaEvent(DCategoriaDTO categoria) {
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
	
	public DCategoriaDTO getCategoria(){
		return this.categoria;
	}

}
