package marres.client.Events.EventUp;

import java.util.List;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DProdottoDTO;

public class AggiungiIngredienteEvent extends GwtEvent<AggiungiIngredienteEventHandler> {

	public static Type<AggiungiIngredienteEventHandler> TYPE = new Type<AggiungiIngredienteEventHandler>();
	
	
	private DIngredienteDTO ingrediente;		
	private List<DProdottoDTO> prodotti;	
	private DProdottoDTO prodottoselezionato;	
	
	public AggiungiIngredienteEvent(DIngredienteDTO Ingrediente,List<DProdottoDTO> prodotti,DProdottoDTO prodottoselezionato) {
		this.ingrediente = Ingrediente;
		this.prodotti = prodotti;
		this.prodottoselezionato = prodottoselezionato;
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

	public List<DProdottoDTO> getProdotti() {
		return prodotti;
	}
	public DProdottoDTO getProdottoSelezionato(){
		return this.prodottoselezionato;
	}

	
	

	
}
