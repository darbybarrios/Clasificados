package general;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import general.EncriptarClave;

import modelos.Root;


public class Credenciales implements Serializable{
	private Integer id_usuario;
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	private String usuario;
	private String nombre;
	private String apellido;
	private String clave;
	private String indentificador;
	private String tipo;
	private String estatus;
	private String destino;
	private String correo;
	private Integer id_destino;

	public Credenciales() {
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void jbInit() throws Exception {
		
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getIndentificador() {
		return indentificador;
	}
	public void setIndentificador(String indentificador) {
		this.indentificador = indentificador;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getId_destino() {
		return id_destino;
	}
	public void setId_destino(Integer id_destino) {
		this.id_destino = id_destino;
	}
	
	public Credenciales ValidarLogin(String login, String clave,HttpServletRequest servletRequest)throws Exception{
		try{
			List<Object[]> listaUsuario = null;
			int conecto = 0;
			int valido = 0;
			Credenciales Credenciales = new Credenciales();
			Root objUsuario = new Root();
			if(login.equals("root")){
				listaUsuario = objUsuario.ConsultarRoot(login);
			}else{
				listaUsuario = null;
			}
			
			if (!(listaUsuario == null)) {				
					
					if (!((String)listaUsuario.get(0)[2]).equals(clave)) {
							throw new Exception("Contraseña inválida");
					}
					
					Credenciales.setId_usuario((Integer) listaUsuario.get(0)[0]);
					Credenciales.setUsuario(login);
					
				
			}else{
				throw new Exception("Usuario no registrado");
			}
			return Credenciales;
		}catch(Exception ex){
			throw ex;
		}
	
		
	}
}
