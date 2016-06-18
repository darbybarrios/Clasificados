package controladores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import modelos.Anuncios;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;


public class anuncios extends GenericForwardComposer {
private Button btnNuevo;
private Combobox cmbAnuncios;
private Listbox listaAnuncios;
private Listheader listAnuncio;
private List<Anuncios> listaaux = new ArrayList();


	public void onCreate$windAnuncios(){
		CargarComboAnuncios();
	}
	
	public void onClick$btnNuevo() throws InterruptedException{
		try {
		final Window ventana = (Window) Executions.createComponents("registrar_anuncios.zul", null, null);
		ventana.setMaximizable(false);
		ventana.setClosable(true);
		ventana.doModal();
		LimpiarList(listaAnuncios);
		listaaux.clear();
		CargarLista();
		} catch (Exception ex) {
			System.out.println("onClick$btnNuevo "+ex);
		
		}
	}
	
	public void CargarComboAnuncios(){
		/*Comboitem combo1 = new Comboitem();
		combo1.setValue("1");
		combo1.setLabel("Todos");					
		cmbAnuncios.appendChild(combo1);*/
		Comboitem combo2 = new Comboitem();
		combo2.setValue("2");
		combo2.setLabel("Lara");					
		cmbAnuncios.appendChild(combo2);
		Comboitem combo3 = new Comboitem();
		combo3.setValue("3");
		combo3.setLabel("Caracas");					
		cmbAnuncios.appendChild(combo3);
		Comboitem combo4 = new Comboitem();
		combo4.setValue("4");
		combo4.setLabel("Miranda");					
		cmbAnuncios.appendChild(combo4);
		Comboitem combo5 = new Comboitem();
		combo5.setValue("5");
		combo5.setLabel("Carabobo");					
		cmbAnuncios.appendChild(combo5);
		Comboitem combo6 = new Comboitem();
		combo6.setValue("6");
		combo6.setLabel("Merida");					
		cmbAnuncios.appendChild(combo6);
		Comboitem combo7 = new Comboitem();
		combo7.setValue("7");
		combo7.setLabel("Zulia");					
		cmbAnuncios.appendChild(combo7);
		Comboitem combo8 = new Comboitem();
		combo8.setValue("8");
		combo8.setLabel("Panama");					
		cmbAnuncios.appendChild(combo8);
	}
	public void onChange$cmbAnuncios() throws Exception{
		LimpiarList(listaAnuncios);
		listaaux.clear();
		CargarLista();
	}
	
	public void CargarLista() throws Exception{
		String where = "";
		if(cmbAnuncios.getSelectedItem().getValue().equals("1")){
			where = "a.contactos.todos = true";
		}else if(cmbAnuncios.getSelectedItem().getValue().equals("2")){
			where = "a.contactos.lara = true";
		}else if(cmbAnuncios.getSelectedItem().getValue().equals("3")){
			where = "a.contactos.caracas = true";
		}else if(cmbAnuncios.getSelectedItem().getValue().equals("4")){
			where = "a.contactos.miranda = true";
		}else if(cmbAnuncios.getSelectedItem().getValue().equals("5")){
			where = "a.contactos.carabobo = true";
		}else if(cmbAnuncios.getSelectedItem().getValue().equals("6")){
			where = "a.contactos.merida = true";
		}else if(cmbAnuncios.getSelectedItem().getValue().equals("7")){
			where = "a.contactos.zulia = true";
		}else if(cmbAnuncios.getSelectedItem().getValue().equals("8")){
			where = "a.contactos.panama = true";
		} 
		
		Anuncios anuncios = new Anuncios();
		List<Object[]> lista = null;
		lista = anuncios.CargarListaTipo(where);
		if(lista.size()>0){
			for(int i=0;i<lista.size();i++){
				final Listitem item = new Listitem();
				Anuncios anuncioaux = new Anuncios();
				item.appendChild(new Listcell(lista.get(i)[0].toString()));
				item.appendChild(new Listcell(lista.get(i)[1].toString()));
				item.appendChild(new Listcell(lista.get(i)[2].toString()));
				listaAnuncios.appendChild(item);
				anuncioaux.setAnuncio(lista.get(i)[2].toString());
				listaaux.add(anuncioaux);
			}
		}	
		
	
	}	
	
	public void onClick$btnGenerar() throws IOException{
		Messagebox.show("Generando Archivo. Por favor espere...", "Mensaje", Messagebox.OK,Messagebox.INFORMATION);
		int i = 0;
		if(!listaaux.isEmpty()){
			File archivo=new File("C:\\AutoTwitter\\"+cmbAnuncios.getSelectedItem().getLabel()+".txt");
			FileWriter escribir=new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(escribir); 
			PrintWriter salArch = new PrintWriter(bw);
			while(i < listaaux.size()){
				Anuncios anuncio = new Anuncios();
				anuncio = (Anuncios)listaaux.get(i);
				salArch.println(anuncio.getAnuncio());				
				i++;				
			}
			salArch.close();
		Messagebox.show("Archivo "+cmbAnuncios.getSelectedItem().getLabel()+".txt generado", "Mensaje", Messagebox.OK,Messagebox.INFORMATION);
	}
	
		
	}
	 void LimpiarList(Listbox lista) {
			int n = 0;			
			while (lista.getItems().size() > n) {
				lista.removeItemAt(n);
			}
			lista.setRows(0);
	 }
	 
	 
	
	
}
