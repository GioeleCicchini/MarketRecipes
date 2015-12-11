package marres.shared;

import java.io.Serializable;

public class DCategoria implements Serializable {
	
	String Nome;
	
	
	public DCategoria (){
			
	}
	
	public DCategoria(String Nome){
		
		this.Nome = Nome;
	}


	public String getNome() {
		return Nome;
	}


	public void setNome(String nome) {
		Nome = nome;
	}
	

}
