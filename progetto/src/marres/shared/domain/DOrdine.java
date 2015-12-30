package marres.shared.domain;

public class DOrdine {
	
	private long id;
	private DCarrello carrello;
	private DStatoOrdine stato;
	private DCliente cliente;
	private DNegozio negozio;
	
	public DOrdine(){
		
	}
	
	public void setCarrello(DCarrello carrello){
		this.carrello = carrello;
	}

	public DCarrello getCarrello() {
		return carrello;
	}

	public DStatoOrdine getStato() {
		return stato;
	}

	public void setStato(DStatoOrdine stato) {
		this.stato = stato;
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

	public DNegozio getNegozio() {
		return negozio;
	}

	public void setNegozio(DNegozio negozio) {
		this.negozio = negozio;
	}
	
	

}
