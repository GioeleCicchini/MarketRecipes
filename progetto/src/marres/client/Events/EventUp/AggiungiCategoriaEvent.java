package marres.client.Events.EventUp;

import com.google.gwt.event.shared.GwtEvent;

import marres.client.Events.EventUp.AggiungiCategoriaEventHandler;
import marres.shared.dto.DCategoriaDTO;


public class AggiungiCategoriaEvent extends GwtEvent<AggiungiCategoriaEventHandler>{

	public static Type<AggiungiCategoriaEventHandler> TYPE = new Type<AggiungiCategoriaEventHandler>();
	
	private DCategoriaDTO categoria;		
	
	public AggiungiCategoriaEvent(DCategoriaDTO categoria) {
		this.categoria = categoria;
	}

	@Override
	public Type<AggiungiCategoriaEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AggiungiCategoriaEventHandler handler) {
		handler.OnAggiungiCategoria(this);
		
	}
	
	public DCategoriaDTO getCategoria(){
		return this.categoria;
	}

}
