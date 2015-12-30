package marres.server;



import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import marres.client.RPC.RicetteService;
import marres.client.dto.DCategoriaDTO;
import marres.client.dto.DRicettaDTO;
import marres.client.util.HibernateUtil;
import marres.shared.domain.DCarrello;
import marres.shared.domain.DCategoria;
import marres.shared.domain.DCliente;
import marres.shared.domain.DGiornoPianificazioneRicette;
import marres.shared.domain.DIndirizzo;
import marres.shared.domain.DNegozio;
import marres.shared.domain.DOrdine;
import marres.shared.domain.DRicetta;
import marres.shared.domain.DStatoOrdine;


public class RicetteServiceImpl extends RemoteServiceServlet implements RicetteService {

	
	@Override
	public List<DRicettaDTO> getRicette(DCategoriaDTO categoria) {

		//AggiungiRicetta();
		
	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		List<DRicetta> RicetteQuary = new ArrayList<DRicetta>();

		Criteria cr = session.createCriteria(DRicetta.class);
		
		RicetteQuary = (List<DRicetta>) cr.list();
		
		List<DRicettaDTO> ricetteDTO = new ArrayList<DRicettaDTO>(
		       RicetteQuary != null ? RicetteQuary.size() : 0);
		    if (RicetteQuary != null) {
		    	List<String> myMappingFiles = new ArrayList<String>();
		    	myMappingFiles.add("marres/dozerBeanMapping.xml");
		    	DozerBeanMapper mapper = new DozerBeanMapper();
		    	mapper.setMappingFiles(myMappingFiles);
		    	
		      for (DRicetta ricetta : RicetteQuary) {
		        ricetteDTO.add(mapper.map(
		            ricetta, DRicettaDTO.class));
		      }
		    }
	/*	
		if (RicetteQuary != null) {
		      for (DRicetta ricetta : RicetteQuary) {
		    	 
		        accountDTOs.add(DozerBeanMapperSingletonWrapper.getInstance().map(
		            account, AccountDTO.class));
		      }
		    }
		*/
		
		return ricetteDTO;
			
	}

	
	private void AggiungiRicetta(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
		DCategoria categoria = new DCategoria();
		categoria.setNome("Primo");
		session.save(categoria);
		
		DRicetta ricetta = new DRicetta();
		categoria.getRicetta().add(ricetta);
		ricetta.setCategoria(categoria);
		
		ricetta.setNome("Prima Ricetta");
		ricetta.setCottura("prima");
		inserisciImagine(ricetta);
		
		session.save(ricetta);
		
		DRicetta ricetta2 = new DRicetta();
		
		categoria.getRicetta().add(ricetta2);
		ricetta2.setCategoria(categoria);
		
		ricetta2.setNome("Seconda Ricetta");
		ricetta2.setCottura("seconda");
		inserisciImagine(ricetta2);
		
		session.save(ricetta2);
		
		session.getTransaction().commit();
	} 
	
	
	private void prova(){
		
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		DCategoria categoria = new DCategoria();
		categoria.setNome("Primo");
		session.save(categoria);
		
		DRicetta ricetta = new DRicetta();
		categoria.getRicetta().add(ricetta);
		ricetta.setCategoria(categoria);
		ricetta.setNome("pollo polletto");
		ricetta.setCottura("POLLO FRITTO");
		
		categoria.getRicetta().add(ricetta);
		inserisciImagine(ricetta);
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
	
	public void inserisciImagine(DRicetta ricetta ){
		
        //save image into database
    	File file = new File("../Image/luca.jpg");
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        
        ricetta.setImage(bFile);
       
    }
		
		
	

}
