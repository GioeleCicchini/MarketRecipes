package marres.shared.domain;

import java.util.ArrayList;
import java.util.List;

public class DCliente {
	
	private List<DGiornoPianificazioneRicette> pianificazione = new ArrayList<DGiornoPianificazioneRicette>();
	private List<DOrdine> OrdiniEffettuati = new ArrayList<DOrdine>();
	private long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	
	public DCliente(){
		
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




	public List<DOrdine> getOrdiniEffettuati() {
		return OrdiniEffettuati;
	}

	public void setOrdiniEffettuati(List<DOrdine> ordiniEffettuati) {
		OrdiniEffettuati = ordiniEffettuati;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public List<DGiornoPianificazioneRicette> getPianificazione() {
		return pianificazione;
	}


	public void setPianificazione(List<DGiornoPianificazioneRicette> pianificazione) {
		this.pianificazione = pianificazione;
	}

}
