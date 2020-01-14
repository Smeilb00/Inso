package ins0.Modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import ins0.Modelo.Vo.PedidoVo;
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
}
