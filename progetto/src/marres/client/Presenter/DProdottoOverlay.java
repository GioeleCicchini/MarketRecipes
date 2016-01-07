package marres.client.Presenter;

import com.google.gwt.core.client.JavaScriptObject;

class DProdottoOverlay extends JavaScriptObject {

	  // Overlay types always have protected, zero-arg ctors
	  protected DProdottoOverlay() { }

	  // Typically, methods on overlay types are JSNI
	  public final native String getCategorie() /*-{ return this.Categorie; }-*/;
	  public final native String getDescrizione()  /*-{ return this.Descrizione;  }-*/;
	  public final native String getId()  /*-{ return this.Id;  }-*/;
	  public final native String getNome()  /*-{ return this.Nome;  }-*/;
	  public final native String getPrezzo()  /*-{ return this.Prezzo;  }-*/;
	  public final native String getSupermercatoId()  /*-{ return this.SupermercatoId;  }-*/;


	  
	  // Note, though, that methods aren't required to be JSNI
	  public final String getFullName() {
	    return null;
	  }
	}