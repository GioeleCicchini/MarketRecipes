package marres.client.Events.EventMiddle;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DProdottoDTO;
import marres.shared.dto.DRicettaDTO;

public class CambiaStatoEscludiEvent  extends GwtEvent<CambiaStatoEscludiEventHandler>{

	public static Type<CambiaStatoEscludiEventHandler> TYPE = new Type<CambiaStatoEscludiEventHandler>();
	
	private DRicettaDTO ricetta;
	private Boolean stato;
	private DProdottoDTO prodotto;
	
	
	public CambiaStatoEscludiEvent(DRicettaDTO ricetta,DProdottoDTO prodotto,Boolean stato) {
	this.ricetta=ricetta;
	this.prodotto = prodotto;
	this.stato=stato;
		
	}

	@Override
	public Type<CambiaStatoEscludiEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CambiaStatoEscludiEventHandler handler) {
		handler.OnCambiaStatoEscludi(this);
		
	}
	
	public DRicettaDTO getRicetta(){
		return this.ricetta;
	}
	
	public DProdottoDTO getProdotto(){
		return this.prodotto;
	}
	
	public Boolean getStato(){
		return this.stato;
	}
	
	


}
