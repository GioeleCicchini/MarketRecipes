package marres.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DRicetta implements Serializable{

	private long id;
	private String nome;
	private String difficolta;
	private String preparazione;
	private String cottura;
	private String dosi;
	private String costo;
	private String image;
	private DCategoria categoria;
	private List<DIngrediente> ingredienti = new ArrayList<DIngrediente>();

	
	public DRicetta(){
		
	}
	


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getDifficolta() {
		return difficolta;
	}



	public void setDifficolta(String difficolta) {
		this.difficolta = difficolta;
	}



	public String getPreparazione() {
		return preparazione;
	}



	public void setPreparazione(String preparazione) {
		this.preparazione = preparazione;
	}



	public String getCottura() {
		return cottura;
	}



	public void setCottura(String cottura) {
		this.cottura = cottura;
	}



	public String getDosi() {
		return dosi;
	}



	public void setDosi(String dosi) {
		this.dosi = dosi;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public void setCategoria(DCategoria categoria){
		this.categoria = categoria;
	}
	public DCategoria getCategoria(){
		return this.categoria;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public List<DIngrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<DIngrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}



	public String getCosto() {
		return costo;
	}



	public void setCosto(String costo) {
		this.costo = costo;
	}



}
