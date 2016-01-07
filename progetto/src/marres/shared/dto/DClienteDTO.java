package marres.shared.dto;

import java.util.ArrayList;
import java.util.List;

public class DClienteDTO {
	
	private List<DGiornoPianificazioneRicetteDTO> pianificazione = new ArrayList<DGiornoPianificazioneRicetteDTO>();
	private List<DOrdineDTO> OrdiniEffettuati = new ArrayList<DOrdineDTO>();
	private long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	
	public DClienteDTO(){
		
	}

	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}




	public List<DOrdineDTO> getOrdiniEffettuati() {
		return OrdiniEffettuati;
	}

	public void setOrdiniEffettuati(List<DOrdineDTO> ordiniEffettuati) {
		OrdiniEffettuati = ordiniEffettuati;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public List<DGiornoPianificazioneRicetteDTO> getPianificazione() {
		return pianificazione;
	}


	public void setPianificazione(List<DGiornoPianificazioneRicetteDTO> pianificazione) {
		this.pianificazione = pianificazione;
	}

}
