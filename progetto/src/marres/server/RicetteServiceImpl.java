package marres.server;



import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import marres.client.RPC.RicetteService;
import marres.client.util.HibernateUtil;
import marres.shared.DCarrello;
import marres.shared.DCategoria;
import marres.shared.DCliente;
import marres.shared.DGiornoPianificazioneRicette;
import marres.shared.DIndirizzo;
import marres.shared.DNegozio;
import marres.shared.DOrdine;
import marres.shared.DRicetta;
import marres.shared.DStatoOrdine;


public class RicetteServiceImpl extends RemoteServiceServlet implements RicetteService {

	
	@Override
	public DRicetta[] getRicette(DCategoria categoria) {

		//AggiungiRicetta();
		
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		session.beginTransaction();
		
	
		categoria.setId(4);

		Criteria cr = session.createCriteria(DRicetta.class);
		
		List ricette = cr.list();
		DRicetta[] ricetteRitorno = new DRicetta[ricette.size()];
		
		for(int i=0; i<ricette.size(); i=i+1) {
				ricetteRitorno[i] = (DRicetta) ricette.get(i);
		}
	
		return ricetteRitorno;
	

/*	
		this.prova();

		// DRicetta[] lista = new DRicetta[3];
		if(categoria.getNome().equals("Primi")){
		DRicetta ricetta1 = new DRicetta();
		DRicetta ricetta2 = new DRicetta();
		DRicetta ricetta3 = new DRicetta();
		lista[0]= ricetta1;
		lista[1]= ricetta2;
		lista[2]= ricetta3;
		}		
		if(categoria.getNome().equals("Secondi")){
			DRicetta ricetta1 = new DRicetta();
			DRicetta ricetta2 = new DRicetta();
			DRicetta ricetta3 = new DRicetta();
			lista[0]= ricetta1;
			lista[1]= ricetta2;
			lista[2]= ricetta3;
			}		
	*/	

		

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
