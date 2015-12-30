package marres.client.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DGiornoPianificazioneRicetteDTO {

	private long id;
	private Date dataConsegna;
	private List<DRicettaDTO> ricette = new ArrayList<DRicettaDTO>();
	private DClienteDTO cliente;
	
	public DGiornoPianificazioneRicetteDTO(){
		
	}


	public List<DRicettaDTO> getRicette() {
		return ricette;
	}

	public void setRicette(List<DRicettaDTO> ricette) {
		this.ricette = ricette;
	}

	public DClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(DClienteDTO cliente) {
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
