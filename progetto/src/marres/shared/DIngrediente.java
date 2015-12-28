package marres.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DIngrediente implements Serializable{
	
	private long id;
	private String nome;
	
	private List<DRicetta> ricette = new ArrayList<DRicetta>();
	
	public DIngrediente(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<DRicetta> getRicette() {
		return ricette;
	}

	public void setRicette(List<DRicetta> ricette) {
		this.ricette = ricette;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
