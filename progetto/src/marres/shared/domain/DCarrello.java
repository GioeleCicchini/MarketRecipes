package marres.shared.domain;

import java.util.ArrayList;
import java.util.List;



public class DCarrello {

	private long id;
	private long nome;
	private List<DRicetta> ricette = new ArrayList<DRicetta>();
	
	public DCarrello(){
		
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


	public List<DRicetta> getRicette() {
		return ricette;
	}


	public void setRicette(List<DRicetta> ricette) {
		this.ricette = ricette;
	}

}
