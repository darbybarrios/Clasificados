package controladores;

import java.util.List;

import modelos.Anuncios;
import modelos.Contactos;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class registrar_anuncios extends GenericForwardComposer {
	Combobox cmbContactos;
	Intbox txtNumero;
	Textbox txtAnuncio;
	
	
	
	Listbox listaAnuncios;
	Anuncios anunciomodif = null;	
	
	Button btnAñadir;
	Button btnModificar;
	Button btnActivar;
	Button btnInactivar;
	Window windRegistrarAnuncios;
	
	public void onCreate$windRegistrarAnuncios() throws Exception{
		CargarComboContactos();
		
	}
	
	public void CargarComboContactos() throws Exception{
		List <Object[]> lista = null;
		Contactos contactos = new Contactos();
		lista = contactos.CargarLista();
		if (lista.size() > 0) {
			int i = 0;
			while (i < lista.size()) {
				Comboitem combo = new Comboitem();
				combo.setValue(Integer.valueOf(lista.get(i)[0].toString()));
				combo.setLabel(lista.get(i)[4].toString());
				cmbContactos.appendChild(combo);
				++i;
			}				
		} else {
			Comboitem combo = new Comboitem();
			combo.setValue(0);
			combo.setLabel("- No existen contactos -");
			cmbContactos.appendChild(combo);
		}
	}
	
	
	
	public void onClick$btnAñadir() throws Exception{
		Anuncios anuncio = new Anuncios();
		Contactos contacto = new Contactos();
		contacto.setId((Integer)cmbContactos.getSelectedItem().getValue());
		anuncio.setNumero(txtNumero.getValue());
		anuncio.setAnuncio(txtAnuncio.getValue().trim());
		anuncio.setContactos(contacto);		
		anuncio.setEstatus("AC");
		anuncio.incluir(anuncio);
		LimpiarList(listaAnuncios);
		CargarLista(Integer.valueOf(cmbContactos.getSelectedItem().getValue().toString()));
		limpiar();
		
		
	}
	
	public void onClick$btnModificar() throws Exception{
		anunciomodif.setNumero(txtNumero.getValue());
		anunciomodif.setAnuncio(txtAnuncio.getValue());			
		anunciomodif.Modificar(anunciomodif);
		LimpiarList(listaAnuncios);
		CargarLista(Integer.valueOf(cmbContactos.getSelectedItem().getValue().toString()));
		limpiar();
	}
	public void onClick$btnActivar() throws Exception{
		anunciomodif.setNumero(txtNumero.getValue());
		anunciomodif.setAnuncio(txtAnuncio.getValue());
		anunciomodif.setEstatus("AC");
		anunciomodif.Modificar(anunciomodif);
		LimpiarList(listaAnuncios);
		CargarLista(Integer.valueOf(cmbContactos.getSelectedItem().getValue().toString()));
		limpiar();
	}
	public void onClick$btnInactivar() throws Exception{
		anunciomodif.setNumero(txtNumero.getValue());
		anunciomodif.setAnuncio(txtAnuncio.getValue());
		anunciomodif.setEstatus("IN");
		anunciomodif.Modificar(anunciomodif);
		LimpiarList(listaAnuncios);
		CargarLista(Integer.valueOf(cmbContactos.getSelectedItem().getValue().toString()));
		limpiar();
	}
	public void onSelect$listaAnuncios(){
		if(listaAnuncios.getSelectedItem() != null){			
			Integer id = null;
			anunciomodif = new Anuncios();
			Contactos contacto = new Contactos();
			contacto.setId(Integer.valueOf(cmbContactos.getSelectedItem().getValue().toString()));
			List hijo = listaAnuncios.getSelectedItem().getChildren();
			id = Integer.valueOf(((Listcell) hijo.get(0)).getLabel());
			List<Object[]> lista = null;
			lista = anunciomodif.ConsultarAnuncio(id); 
			anunciomodif.setId(id);
			anunciomodif.setContactos(contacto);						
			anunciomodif.setEstatus(lista.get(0)[3].toString());
			
			txtNumero.setText(lista.get(0)[1].toString());						
			txtAnuncio.setText(lista.get(0)[2].toString());		
			
					
			
			
			if(lista.get(0)[3].equals("AC")){
				btnInactivar.setVisible(true);
				btnActivar.setVisible(false);
			}else{
				btnActivar.setVisible(true);
				btnInactivar.setVisible(false);
			}
			
			btnModificar.setVisible(true);
			btnAñadir.setVisible(false);
			
		}
	}
	public void CargarLista(Integer id) throws Exception{
		Anuncios anuncios = new Anuncios();
		List<Object[]> lista = null;
		lista = anuncios.CargarLista(id);
		if(lista.size()>0){
			for(int i=0;i<lista.size();i++){
				final Listitem item = new Listitem();
				item.appendChild(new Listcell(lista.get(i)[0].toString()));
				item.appendChild(new Listcell(lista.get(i)[1].toString()));
				item.appendChild(new Listcell(lista.get(i)[2].toString()));
				item.appendChild(new Listcell(lista.get(i)[3].toString()));
				listaAnuncios.appendChild(item);
			}
		}	
	
	}
	
	public void onChange$cmbContactos() throws NumberFormatException, Exception{
		limpiar();		
		LimpiarList(listaAnuncios);
		CargarLista(Integer.valueOf(cmbContactos.getSelectedItem().getValue().toString()));
	}
	 void LimpiarList(Listbox lista) {
			int n = 0;
			
			while (lista.getItems().size() > n) {
				lista.removeItemAt(n);
			}
			lista.setRows(0);
	 }
	 
	 void limpiar(){
		txtNumero.setText("");
		txtAnuncio.setText("");
		btnAñadir.setVisible(true);
		btnModificar.setVisible(false);
		btnActivar.setVisible(false);
		btnInactivar.setVisible(false);
	 }
	 
	 public void onClick$btnAceptar(){
		 windRegistrarAnuncios.detach();
	 }
	 
	 public void onClick$btnCancelar(){
		 limpiar();
	 }
}
