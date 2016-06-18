package controladores;

import java.util.List;

import modelos.Contactos;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

public class contactos extends GenericForwardComposer {
	private Button btnNuevo;
	private Listbox listaContactos;
	
	public void onCreate$windContactos() throws Exception{
		CargarLista();
	}
	
	public void onClick$btnNuevo() throws InterruptedException{
		try {
		final Window ventana = (Window) Executions.createComponents("registrar_contacto.zul", null, null);
		ventana.setMaximizable(false);
		ventana.setClosable(true);
		ventana.doModal();
		LimpiarList(listaContactos);
		CargarLista();
		} catch (Exception ex) {
			System.out.println("onClick$btnNuevo "+ex);
		
		}
	}
	
	public void CargarLista() throws Exception{
		List<Object[]> lista = null;
		Contactos contactos = new Contactos();
		lista = contactos.CargarLista();
		if(lista.size()>0){
			for(int i=0;i<lista.size();i++){
				final Listitem item = new Listitem();
				item.appendChild(new Listcell(lista.get(i)[0].toString()));
				item.appendChild(new Listcell(lista.get(i)[1].toString()+" "+lista.get(i)[2].toString()));
				item.appendChild(new Listcell(lista.get(i)[3].toString()));
				item.appendChild(new Listcell(lista.get(i)[4].toString()));
				item.appendChild(new Listcell(lista.get(i)[5].toString()));
				listaContactos.appendChild(item);
			}
			
		}
	}
	
	public void onSelect$listaContactos(){
		if(listaContactos.getSelectedItem() != null){
			Integer id = null;
			List hijo = listaContactos.getSelectedItem().getChildren();
			id = Integer.valueOf(((Listcell) hijo.get(0)).getLabel());
			final Window ventana = (Window) Executions.createComponents("editar_contacto.zul", null, null);
			ventana.setMaximizable(false);
			ventana.setClosable(true);
			ventana.setAttribute("id",id);
			ventana.doModal();
			
			try {
				LimpiarList(listaContactos);
				CargarLista();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
