package controladores;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Include;

public class principal extends GenericForwardComposer {
public Include pagina;
	
	
	
	public void onClick$menuContactos(){
		
		pagina.setSrc("contactos.zul");  
	}
	
	public void onClick$menuAnuncios(){
		
		pagina.setSrc("anuncios.zul");  
	}
	
	
	
}
