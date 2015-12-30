package marres.shared.domain;

public class DStatoOrdine {

	private long id;
	private DOrdine ordine;
	
	public DStatoOrdine(){
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public DOrdine getOrdine() {
		return ordine;
	}


	public void setOrdine(DOrdine ordine) {
		this.ordine = ordine;
	}
	
}
