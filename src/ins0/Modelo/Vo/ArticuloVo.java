package ins0.Modelo.Vo;

import java.util.Date;

public class ArticuloVo {
	
	private int iD;
	private String numeroSerie;
	private String tipo;
	private String subTipo;
	private String marca;
	private int stock;
	private Date fechaLLegada;
	
	public ArticuloVo() {}	
	
	public ArticuloVo(int iD, String numeroSerie, String tipo, String subTipo, String marca, int stock, Date fechaLLegada) {
		this.iD = iD;
		this.numeroSerie = numeroSerie;
		this.tipo = tipo;
		this.subTipo = subTipo;
		this.marca = marca;
		this.stock = stock;
		this.fechaLLegada = fechaLLegada;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSubTipo() {
		return subTipo;
	}
	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getFechaLLegada() {
		return fechaLLegada;
	}
	public void setFechaLLegada(Date fechaLLegada) {
		this.fechaLLegada = fechaLLegada;
	}
	public String toString() {
		return "";
	}
}
