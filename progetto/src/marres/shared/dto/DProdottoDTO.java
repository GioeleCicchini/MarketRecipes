package marres.shared.dto;

public class DProdottoDTO {
	
	
	private DIngredienteDTO Ingrediente;
	private  String Categorie;
	private String Descrizione;
	private String Id;
	private String Nome;
	private String Prezzo;
	
	public DProdottoDTO(){}
	
	public DProdottoDTO(String categorie,String descrizione, String id,String nome,String prezzo,DIngredienteDTO ingrediente){
		this.Categorie = categorie;
		this.Descrizione=descrizione;
		this.Id=id;
		this.Nome=nome;
		this.Prezzo= prezzo;
		this.setIngrediente(ingrediente);
	}
	
	public String getCategorie() {
		return Categorie;
	}
	public void setCategorie(String categorie) {
		Categorie = categorie;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(String prezzo) {
		Prezzo = prezzo;
	}

	public DIngredienteDTO getIngrediente() {
		return Ingrediente;
	}

	public void setIngrediente(DIngredienteDTO ingrediente) {
		Ingrediente = ingrediente;
	}
	  
	
	
}
