package marres.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class DCategoria implements Serializable {
	
	private long id;
	private String nome;
	private List<DRicetta> ricetta = new ArrayList<DRicetta>();
	
	
	public DCategoria (){
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}




	public List<DRicetta> getRicetta() {
		return ricetta;
	}


	public void setRicetta(List<DRicetta> ricetta) {
		this.ricetta = ricetta;
	}




}
