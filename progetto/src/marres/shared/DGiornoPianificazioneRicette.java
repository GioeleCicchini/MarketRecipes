package marres.shared;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DGiornoPianificazioneRicette {

	private long id;
	private Date dataConsegna;
	private List<DRicetta> ricette = new ArrayList<DRicetta>();
	private DCliente cliente;
	
	public DGiornoPianificazioneRicette(){
		
	}


	public List<DRicetta> getRicette() {
		return ricette;
	}

	public void setRicette(List<DRicetta> ricette) {
		this.ricette = ricette;
	}

	public DCliente getCliente() {
		return cliente;
	}

	public void setCliente(DCliente cliente) {
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Date getDataConsegna() {
		return dataConsegna;
	}


	public void setDataConsegna(Date dataConsegna) {
		this.dataConsegna = dataConsegna;
	}
	
	
	
	
	
}
