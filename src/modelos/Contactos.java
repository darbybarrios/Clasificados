package modelos;

// Generated 23/05/2016 01:08:15 PM by Hibernate Tools 3.4.0.CR1

import general.ManejarEntidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Contactos generated by hbm2java
 */
public class Contactos extends ManejarEntidades implements java.io.Serializable {

	private int id;
	private String nombre;
	private String apellido;
	private String empresa;
	private String fijo;
	private String celular;
	private String direccion;
	private String ciudad;
	private String estado;
	private String pais;
	private String estatus;
	private Boolean lara;
	private Boolean caracas;
	private Boolean miranda;
	private Boolean merida;
	private Boolean carabobo;
	private Boolean zulia;
	private Boolean panama;
	private Boolean chile;
	private Set anuncioses = new HashSet(0);

	public Contactos() {
	}

	public Contactos(int id) {
		this.id = id;
	}

	public Contactos(int id, String nombre, String apellido, String empresa,
			String fijo, String celular, String direccion, String ciudad,
			String estado, String pais, String estatus,Boolean lara, Boolean caracas, Boolean miranda,
			Boolean merida, Boolean carabobo, Boolean zulia, Boolean panama,
			Boolean chile, Set anuncioses) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.empresa = empresa;
		this.fijo = fijo;
		this.celular = celular;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.estado = estado;
		this.pais = pais;
		this.estatus = estatus;
		this.lara = lara;
		this.caracas = caracas;
		this.miranda = miranda;
		this.merida = merida;
		this.carabobo = carabobo;
		this.zulia = zulia;
		this.panama = panama;
		this.chile = chile;
		this.anuncioses = anuncioses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getFijo() {
		return this.fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Set getAnuncioses() {
		return this.anuncioses;
	}
	
	public Boolean getLara() {
		return this.lara;
	}

	public void setLara(Boolean lara) {
		this.lara = lara;
	}

	public Boolean getCaracas() {
		return this.caracas;
	}

	public void setCaracas(Boolean caracas) {
		this.caracas = caracas;
	}

	public Boolean getMiranda() {
		return this.miranda;
	}

	public void setMiranda(Boolean miranda) {
		this.miranda = miranda;
	}

	public Boolean getMerida() {
		return this.merida;
	}

	public void setMerida(Boolean merida) {
		this.merida = merida;
	}

	public Boolean getCarabobo() {
		return this.carabobo;
	}

	public void setCarabobo(Boolean carabobo) {
		this.carabobo = carabobo;
	}

	public Boolean getZulia() {
		return this.zulia;
	}

	public void setZulia(Boolean zulia) {
		this.zulia = zulia;
	}

	public Boolean getPanama() {
		return this.panama;
	}

	public void setPanama(Boolean panama) {
		this.panama = panama;
	}

	public Boolean getChile() {
		return this.chile;
	}

	public void setChile(Boolean chile) {
		this.chile = chile;
	}

	public void setAnuncioses(Set anuncioses) {
		this.anuncioses = anuncioses;
	}
	
	public List <Object[]> CargarLista() throws Exception{
		List <Object[]> lista = null;
		try{		
		String sql = "select a.id, a.nombre, a.apellido, a.fijo, a.direccion, a.estatus from Contactos a order by 1";
		lista = (List<Object[]>) ConsultarLista(sql);
		}catch (Exception ex) {
			System.out.println("Cargar Lista Contactos: "+ex.getMessage());			
		}
		
		return lista;
	}
	
	public List <Object[]> SelecionarContacto(Integer id) throws Exception{
		List <Object[]> lista = null;
		try{		
		String sql = "select a.id, a.nombre, a.apellido, a.empresa, a.fijo, a.celular, a.direccion, a.ciudad, a.estado, a.pais, a.estatus, " +
				"a.lara, a.caracas, a.miranda, a.merida, a.carabobo, a.zulia, a.panama, a.chile " +
				"from Contactos a where " +
				"a.id = "+id+"";
		lista = (List<Object[]>) Consultar(sql);
		}catch (Exception ex) {
			System.out.println("Cargar Lista Contactos: "+ex.getMessage());			
		}
		
		return lista;
	}
	
	public List <Object[]> SelecionarTwiter(Integer id) throws Exception{
		List <Object[]> lista = null;
		try{		
		String sql = "select a.lara, a.caracas, a.miranda, a.merida, a.carabobo, a.zulia, a.panama, a.chile " +
				"from Contactos a where " +
				"a.id = "+id+"";
		lista = (List<Object[]>) Consultar(sql);
		}catch (Exception ex) {
			System.out.println("Cargar Lista Contactos: "+ex.getMessage());			
		}
		
		return lista;
	}

}
