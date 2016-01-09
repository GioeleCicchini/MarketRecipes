package marres.client.service;

import com.google.gwt.core.client.JavaScriptObject;

public class MyShopWebRemoteService extends JavaScriptObject implements MagazzinoSupermercatoAdapter {

	  // Overlay types always have protected, zero-arg ctors
	  protected MyShopWebRemoteService() { }

	  // Typically, methods on overlay types are JSNI
	  public final native String getCategorie() /*-{ return this.Categorie; }-*/;
	  public final native String getDescrizione()  /*-{ return this.Descrizione;  }-*/;
	  public final native String getId()  /*-{ return this.Id;  }-*/;
	  public final native String getNome()  /*-{ return this.Nome;  }-*/;
	  public final native String getPrezzo()  /*-{ return this.Prezzo;  }-*/;


	}