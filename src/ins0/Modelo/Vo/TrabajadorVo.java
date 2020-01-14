package ins0.Modelo.Vo;

import java.util.Date;

public class TrabajadorVo {

	private int iD;
	private String apellido;
	private String contrasenha;
	private String direccion;
	private String dNI;
	private String posicion;
	private String nombre;
	private int telefono;
	
	public TrabajadorVo() {}
	
	public TrabajadorVo(int iD,  String apellido, String contrasenha, String direccion, String dNI, String posicion, String nombre, int telefono) {
		this.iD = iD;
		this.apellido = apellido;
		this.contrasenha = contrasenha;
		this.direccion = direccion;
		this.dNI = dNI;
		this.posicion = posicion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasenha() {
		return contrasenha;
	}
	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getdNI() {
		return dNI;
	}
	public void setdNI(String dNI) {
		this.dNI = dNI;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String toString() {
		return "";
	}
}
