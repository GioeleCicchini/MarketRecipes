package marres.shared.dto;

public class DOrdineDTO {
	
	private long id;
	private DCarrelloDTO carrello;
	private DStatoOrdineDTO stato;
	private DClienteDTO cliente;
	private DNegozioDTO negozio;
	
	public DOrdineDTO(){
		
	}
	
	public void setCarrello(DCarrelloDTO carrello){
		this.carrello = carrello;
	}

	public DCarrelloDTO getCarrello() {
		return carrello;
	}

	public DStatoOrdineDTO getStato() {
		return stato;
	}

	public void setStato(DStatoOrdineDTO stato) {
		this.stato = stato;
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

	public DNegozioDTO getNegozio() {
		return negozio;
	}

	public void setNegozio(DNegozioDTO negozio) {
		this.negozio = negozio;
	}
	
	

}
