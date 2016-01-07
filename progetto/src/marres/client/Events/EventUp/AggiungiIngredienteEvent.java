package marres.client.Events.EventUp;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;

public class AggiungiIngredienteEvent extends GwtEvent<AggiungiIngredienteEventHandler> {

	public static Type<AggiungiIngredienteEventHandler> TYPE = new Type<AggiungiIngredienteEventHandler>();
	
	
	private DIngredienteDTO ingrediente;		
	
	public AggiungiIngredienteEvent(DIngredienteDTO Ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	@Override
	protected void dispatch(AggiungiIngredienteEventHandler handler) {
		handler.OnAggiungiIngrediente(this);
		
	}

	@Override
	public Type<AggiungiIngredienteEventHandler> getAssociatedType() {
		return TYPE;
	}

	public DIngredienteDTO getIngrediente(){
		return this.ingrediente;
	}

	
}
