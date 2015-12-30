package marres.client.dto;

import java.util.ArrayList;
import java.util.List;



public class DCarrelloDTO {

	private long id;
	private long nome;
	private List<DRicettaDTO> ricette = new ArrayList<DRicettaDTO>();
	
	public DCarrelloDTO(){
		
	}
	
	public long getNome() {
		return nome;
	}

	public void setNome(long nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public List<DRicettaDTO> getRicette() {
		return ricette;
	}


	public void setRicette(List<DRicettaDTO> ricette) {
		this.ricette = ricette;
	}

}
