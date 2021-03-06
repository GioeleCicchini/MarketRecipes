package marres.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import marres.shared.domain.DCategoria;
import marres.shared.domain.DIngrediente;


public class DRicettaDTO implements Serializable{

	private long id;
	private String nome;
	private String difficolta;
	private String preparazione;
	private String cottura;
	private String costo;
	private String dosi;
	private String image;
	private DCategoriaDTO categoria;
	private List<DIngredienteDTO> ingredienti = new ArrayList<DIngredienteDTO>();

	
	public DRicettaDTO(){
		
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


	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public List<DIngredienteDTO> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<DIngredienteDTO> ingredienti) {
		this.ingredienti = ingredienti;
	}



	public DCategoriaDTO getCategoria() {
		return categoria;
	}



	public void setCategoria(DCategoriaDTO categoria) {
		this.categoria = categoria;
	}



	public String getCosto() {
		return costo;
	}



	public void setCosto(String costo) {
		this.costo = costo;
	}



}
