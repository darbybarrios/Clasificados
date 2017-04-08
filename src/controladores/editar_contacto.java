package controladores;

import java.util.List;

import modelos.Contactos;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class editar_contacto extends GenericForwardComposer{
	Integer id;
	Window windEditarContacto;
	Textbox txtNombre;
	Textbox txtApellido;
	Textbox txtEmpresa;
	Textbox txtCorreo;
	Textbox txtCelular;
	Textbox txtTwitter;
	Textbox txtCiudad;
	Textbox txtEstado;
	Textbox txtPais;
	Checkbox ckboxLara;
	Checkbox ckboxCaracas;
	Checkbox ckboxMiranda;
	Checkbox ckboxMerida;
	Checkbox ckboxCarabobo;
	Checkbox ckboxZulia;
	Checkbox ckboxPanama;
	Checkbox ckboxChile;
	String estatus;
	Button btnActivar;
	Button btnInactivar;
	
	public void onCreate$windEditarContacto(){
		id = (Integer) windEditarContacto.getAttribute("id");
		CargarContacto();
		if(estatus.equals("IN")){
			btnActivar.setVisible(true);
		}else{
			btnInactivar.setVisible(true);
		}
	}
	
	public void CargarContacto(){
		List<Object[]> lista = null;
		Contactos contacto = new Contactos();
		try {
			lista = contacto.SelecionarContacto(id);
			txtNombre.setText(lista.get(0)[1].toString());
			txtApellido.setText(lista.get(0)[2].toString());
			txtEmpresa.setText(lista.get(0)[3].toString());
			txtCorreo.setText(lista.get(0)[4].toString());
			txtCelular.setText(lista.get(0)[5].toString());
			txtTwitter.setText(lista.get(0)[6].toString());
			txtCiudad.setText(lista.get(0)[7].toString());
			txtEstado.setText(lista.get(0)[8].toString());
			txtPais.setText(lista.get(0)[9].toString());
			estatus = lista.get(0)[10].toString();
			ckboxLara.setChecked(Boolean.valueOf(lista.get(0)[11].toString()));			
			ckboxCaracas.setChecked(Boolean.valueOf(lista.get(0)[12].toString()));			
			ckboxMiranda.setChecked(Boolean.valueOf(lista.get(0)[13].toString()));			
			ckboxMerida.setChecked(Boolean.valueOf(lista.get(0)[14].toString()));			
			ckboxCarabobo.setChecked(Boolean.valueOf(lista.get(0)[15].toString()));			
			ckboxZulia.setChecked(Boolean.valueOf(lista.get(0)[16].toString()));			
			ckboxPanama.setChecked(Boolean.valueOf(lista.get(0)[17].toString()));
			ckboxChile.setChecked(Boolean.valueOf(lista.get(0)[18].toString()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onClick$btnGuardar(){
		try {
		Contactos contacto = new Contactos();
		contacto.setId(id);
		contacto.setNombre(txtNombre.getValue());
		contacto.setApellido(txtApellido.getValue());
		contacto.setEmpresa(txtEmpresa.getValue());
		contacto.setFijo(txtCorreo.getValue());
		contacto.setCelular(txtCelular.getValue());
		contacto.setDireccion(txtTwitter.getValue());
		contacto.setCiudad(txtCiudad.getValue());
		contacto.setEstado(txtEstado.getValue());
		contacto.setPais(txtPais.getValue());
		contacto.setEstatus(estatus);
		contacto.setLara(ckboxLara.isChecked());
		contacto.setCaracas(ckboxCaracas.isChecked());
		contacto.setMiranda(ckboxMiranda.isChecked());
		contacto.setMerida(ckboxMerida.isChecked());
		contacto.setCarabobo(ckboxCarabobo.isChecked());
		contacto.setZulia(ckboxZulia.isChecked());
		contacto.setPanama(ckboxPanama.isChecked());
		contacto.setChile(ckboxChile.isChecked());
		contacto.Modificar(contacto);
		Messagebox.show("Contacto Modificado Exitosamente", "Mensaje", Messagebox.OK,Messagebox.INFORMATION);
		if(estatus.equals("IN")){
			btnActivar.setVisible(true);
			btnInactivar.setVisible(false);
		}else{
			btnInactivar.setVisible(true);
			btnActivar.setVisible(false);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onClick$btnActivar(){
		estatus ="AC";
		onClick$btnGuardar();
	}
	
	public void onClick$btnInactivar(){
		estatus = "IN";
		onClick$btnGuardar();
	}
	
	public void onClick$btnCancelar(){
		windEditarContacto.detach();
	}

}
