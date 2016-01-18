package marres.client.Events.EventUp;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.client.Presenter.Presenter;
import marres.client.Presenter.RicettaPresenter;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;

public class AggiungiIngredienteEvent extends GwtEvent<AggiungiIngredienteEventHandler> {

	public static Type<AggiungiIngredienteEventHandler> TYPE = new Type<AggiungiIngredienteEventHandler>();
	
	
	private DIngredienteDTO ingrediente;		
	private RicettaPresenter presenter;
	
	public AggiungiIngredienteEvent(DIngredienteDTO Ingrediente,RicettaPresenter presenter) {
		this.ingrediente = Ingrediente;
		this.presenter = presenter;
		
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

	public RicettaPresenter getPresenter(){
		return this.presenter;
	}

	
	

	
}
