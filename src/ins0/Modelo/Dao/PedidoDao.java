package ins0.Modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import ins0.Modelo.Vo.PedidoVo;
import ins0.Vista.VentanaEstadoPedidos;
import ins0.Vista.VentanaLogin;

public class PedidoDao {
	public PedidoVo getPedido(int numPedido) {
		PedidoVo retorno = new PedidoVo();
		return retorno;
	}
	 
	public void iniciarPedido(Connection conn,PedidoVo pedido) {
		try {

			if (VentanaLogin.getConectado() == "Cliente") {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `pedidos` (`IDTrabajador`, `IDCliente`, `NumPedido`, `Fecha`, `DireccionEntrega`, `Articulos`, `Nombre Cliente`, `TipoPedido`, `Estado`) VALUES (NULL, ?, NULL, ?, ?, ?, ?, ?, 'Pendiente')");
				
				stmt.setInt(1, pedido.getiDCliente());
				stmt.setDate(2, pedido.getFecha());
				stmt.setString(3, pedido.getDireccionEntrega());
				stmt.setString(4, pedido.getArticulos());
				stmt.setString(5, pedido.getNombreCliente());
				stmt.setString(6, pedido.getTipoPedido());

				stmt.executeUpdate();
			} else {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `pedidos` (`IDTrabajador`, `IDCliente`, `NumPedido`, `Fecha`, `DireccionEntrega`, `Articulos`, `Nombre Cliente`, `TipoPedido`, `Estado`) VALUES (?, NULL, NULL, ?, ?, ?, ?, ?, 'Pendiente')");
				stmt.setInt(1, pedido.getiDTrabajador());
				stmt.setDate(2, pedido.getFecha());
				stmt.setString(3, pedido.getDireccionEntrega());
				stmt.setString(4, pedido.getArticulos());
				stmt.setString(5, pedido.getNombreCliente());
				stmt.setString(6, pedido.getTipoPedido());

				stmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarPedido(Connection conn, int numPedido) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM pedidos WHERE numpedido = ?");
			stmt.setInt(1, numPedido);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void getEstadoPedido(Connection conn, int iD, VentanaEstadoPedidos v7) {
		try {
			ResultSet rs;

			if (VentanaLogin.getConectado().equals("Cliente")) {
				PreparedStatement stmt = conn
						.prepareStatement("SELECT NumPedido,Estado FROM pedidos WHERE IDCliente=?");
				stmt.setInt(1, VentanaLogin.getID());
				rs = stmt.executeQuery();

			} else {
				PreparedStatement stmt = conn
						.prepareStatement("SELECT NumPedido,Estado FROM pedidos WHERE IDTrabajador=?");
				stmt.setInt(1, VentanaLogin.getID());
				rs = stmt.executeQuery();
			}
			String[] titulos = new String[2];

			titulos[0] = "Numero de pedido";
			titulos[1] = "Estado del pedido";
			v7.getModelo().addRow(titulos);
			
			while (rs.next()) {
				String numPedido = rs.getString(1);
				String estado = rs.getString(2);

				String[] filas = new String[2];
				filas[0] = numPedido;
				filas[1] = estado;

				v7.getModelo().addRow(filas);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
