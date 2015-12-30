package marres.client.dto;

public class DStatoOrdineDTO {

	private long id;
	private DOrdineDTO ordine;
	
	public DStatoOrdineDTO(){
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public DOrdineDTO getOrdine() {
		return ordine;
	}


	public void setOrdine(DOrdineDTO ordine) {
		this.ordine = ordine;
	}
	
}
