package marres.client.dto;

public class DIndirizzoDTO {
	
	private long id;
	private String indirizzo, numCiv, cap;
	
	public DIndirizzoDTO(){
		
		
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNumCiv() {
		return numCiv;
	}

	public void setNumCiv(String numCiv) {
		this.numCiv = numCiv;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
