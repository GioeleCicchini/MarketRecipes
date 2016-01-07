package marres.shared.dto;

import java.util.ArrayList;
import java.util.List;

public class DNegozioDTO {
	
	
	private long id;
	private String marchio;
	private String partitaIva;
	private DIndirizzoDTO indirizzo;
	private List<DOrdineDTO> ordini = new ArrayList<DOrdineDTO>();
	
	public DNegozioDTO(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<DOrdineDTO> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<DOrdineDTO> ordini) {
		this.ordini = ordini;
	}

	public String getMarchio() {
		return marchio;
	}

	public void setMarchio(String marchio) {
		this.marchio = marchio;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public DIndirizzoDTO getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(DIndirizzoDTO indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	
}
