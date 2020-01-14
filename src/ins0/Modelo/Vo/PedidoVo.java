package ins0.Modelo.Vo;

import java.sql.Date;

public class PedidoVo {
	
	private int iDTrabajador;
	private int iDCliente;
	private int numPedido;
	private Date fecha;
	private String direccionEntrega;
	private String articulos;
	private String nombreCliente;
	private String tipoPedido;
	private String estado;
	
	public PedidoVo() {}
	
	public PedidoVo(int iDTrabajador,  int iDCliente, int numPedido, Date fecha, String direccionEntrega, String articulos, String nombreCliente, String tipoPedido, String estado) {
		this.iDTrabajador = iDTrabajador;
		this.iDCliente = iDCliente;
		this.numPedido = numPedido;
		this.fecha = fecha;
		this.direccionEntrega= direccionEntrega;
		this.articulos = articulos; 
		this.nombreCliente = nombreCliente;
		this.tipoPedido = tipoPedido;
		this.estado = estado;
	}

	public int getiDTrabajador() {
		return iDTrabajador;
	}
	public void setiDTrabajador(int iDTrabajador) {
		this.iDTrabajador = iDTrabajador;
	}
	public int getiDCliente() {
		return iDCliente;
	}
	public void setiDCliente(int iDCliente) {
		this.iDCliente = iDCliente;
	}
	public int getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public String getArticulos() {
		return articulos;
	}
	public void setArticulos(String articulos) {
		this.articulos = articulos;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	public String toString() {
		return "";
	}
}
