package marres.server;


import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.hibernate.Session;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import marres.client.RPC.MainService;
import marres.client.util.HibernateUtil;
import marres.server.service.CategoriaService;
import marres.server.service.IngredienteService;
import marres.server.service.RicettaService;
import marres.shared.dto.DCategoriaDTO;
import marres.shared.dto.DIngredienteDTO;
import marres.shared.dto.DRicettaDTO;
import marres.shared.domain.*;

public class MainServiceFacade extends RemoteServiceServlet implements MainService {

	@Override
	public List<DRicettaDTO> getRicette(DCategoriaDTO categoria) {
			
		
		
		RicettaService ricetta = new RicettaService();
		
		return ricetta.PrelevaRicette(categoria);
		
	}

	@Override
	public List<DCategoriaDTO> getCategorie() {
		
		//Riempidatabase();
	
		CategoriaService categoria = new CategoriaService();
		
		return categoria.PrelevaCategorie();

	}
	
	@Override
	public List<DIngredienteDTO> getIngredienti(DRicettaDTO ricetta) {
		IngredienteService ingrediente = new IngredienteService();
		return ingrediente.PrelevaIngredienti(ricetta);
	}

	
	private void Riempidatabase(){
	
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		DCategoria categoria = new DCategoria();
		categoria.setNome("Primo");
		session.save(categoria);
		
		DRicetta ricetta = new DRicetta();
		categoria.getRicetta().add(ricetta);
		ricetta.setCategoria(categoria);
		ricetta.setNome("Prima Ricetta");
		ricetta.setCottura("50 Minuti");
		
		
		categoria.getRicetta().add(ricetta);
		ricetta.setImage("/Image/luca.jpg");
		session.save(ricetta);
		
		DCarrello carrello = new DCarrello();
		carrello.getRicette().add(ricetta);
		
		DIndirizzo indirizzo = new DIndirizzo();
		indirizzo.setIndirizzo("via bella");
		indirizzo.setNumCiv("5");
		session.save(indirizzo);
		
		DNegozio negozio = new DNegozio();
		negozio.setIndirizzo(indirizzo);
		negozio.setMarchio("conad");
		session.save(negozio);
		
		DOrdine ordine = new DOrdine();
		ordine.setCarrello(carrello);
		ordine.setNegozio(negozio);
		
		DStatoOrdine stato = new DStatoOrdine();
		
		ordine.setStato(stato);
		
		DCliente cliente = new DCliente();
		ordine.setCliente(cliente);
		cliente.getOrdiniEffettuati().add(ordine);
		
		DGiornoPianificazioneRicette pianificazione = new DGiornoPianificazioneRicette();
		pianificazione.setCliente(cliente);
		pianificazione.getRicette().add(ricetta);
		cliente.getPianificazione().add(pianificazione);
		
		session.save(cliente);
		
		session.getTransaction().commit();
		
		
		
	}



}
