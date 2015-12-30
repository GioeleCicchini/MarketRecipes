package marres.shared.domain;

import java.util.ArrayList;
import java.util.List;

public class DNegozio {
	
	
	private long id;
	private String marchio;
	private String partitaIva;
	private DIndirizzo indirizzo;
	private List<DOrdine> ordini = new ArrayList<DOrdine>();
	
	public DNegozio(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<DOrdine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<DOrdine> ordini) {
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

	public DIndirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(DIndirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	
	
}
