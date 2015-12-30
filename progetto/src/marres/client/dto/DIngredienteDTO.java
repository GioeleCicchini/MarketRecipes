package marres.client.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DIngredienteDTO implements Serializable{
	
	private long id;
	private String nome;
	
	private List<DRicettaDTO> ricette = new ArrayList<DRicettaDTO>();
	
	public DIngredienteDTO(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public List<DRicettaDTO> getRicette() {
		return ricette;
	}

	public void setRicette(List<DRicettaDTO> ricette) {
		this.ricette = ricette;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
