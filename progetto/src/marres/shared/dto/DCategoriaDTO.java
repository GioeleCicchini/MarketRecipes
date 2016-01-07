package marres.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class DCategoriaDTO implements Serializable {
	
	private long id;
	private String nome;
	
	
	public DCategoriaDTO (){
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





}
