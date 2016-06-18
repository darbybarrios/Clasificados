package controladores;

import modelos.Contactos;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class registrar_contactos extends GenericForwardComposer {
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
	Window windNuevoContacto;
	
	public void onClick$btnGuardar() throws Exception{
		
		Contactos contacto = new Contactos();
		contacto.setNombre(txtNombre.getValue());
		contacto.setApellido(txtApellido.getValue());
		contacto.setEmpresa(txtEmpresa.getValue());
		contacto.setFijo(txtCorreo.getValue());
		contacto.setCelular(txtCelular.getValue());
		contacto.setDireccion(txtTwitter.getValue());
		contacto.setCiudad(txtCiudad.getValue());
		contacto.setEstado(txtEstado.getValue());
		contacto.setPais(txtPais.getValue());
		contacto.setEstatus("AC");
		contacto.setLara(ckboxLara.isChecked());
		contacto.setCaracas(ckboxCaracas.isChecked());
		contacto.setMiranda(ckboxMiranda.isChecked());
		contacto.setMerida(ckboxMerida.isChecked());
		contacto.setCarabobo(ckboxCarabobo.isChecked());
		contacto.setZulia(ckboxZulia.isChecked());
		contacto.setPanama(ckboxPanama.isChecked());	
		contacto.incluir(contacto);
		limpiar();
		onClick$btnCancelar();
	}
	
	public void limpiar(){
		txtNombre.setConstraint("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEmpresa.setText("");
		txtCorreo.setText("");
		txtCelular.setText("");
		txtTwitter.setText("");
		txtCiudad.setText("");
		txtEstado.setText("");
		txtPais.setText("");
	}
	
	public void onClick$btnCancelar(){
		windNuevoContacto.detach();
	}
	
}
