package ins0.Modelo.Dao;

import java.sql.*;
import java.time.Instant;
import java.util.Calendar;

import ins0.Modelo.Vo.ClienteVo;
import ins0.Vista.VentanaLogin;

public class ClienteDao {
	public ClienteVo getCliente(int iD) {
		ClienteVo retorno = new ClienteVo();
		return retorno;
	}

	public void iniciarPedido(Connection conn, String direccionEntrega, String articulos, String nombreCliente,
			String tipoPedido) {
		try {

			if (VentanaLogin.getConectado() == "Cliente") {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `pedidos` (`IDTrabajador`, `IDCliente`, `NumPedido`, `Fecha`, `DireccionEntrega`, `Articulos`, `Nombre Cliente`, `TipoPedido`, `Estado`) VALUES (NULL, ?, NULL, ?, ?, ?, ?, ?, 'Pendiente')");
				stmt.setInt(1, VentanaLogin.getID());

				Calendar hoy = Calendar.getInstance();
				java.sql.Date fecha = new java.sql.Date(hoy.get(Calendar.YEAR) - 1900, hoy.get(Calendar.MONTH),
						hoy.get(Calendar.DAY_OF_MONTH));

				stmt.setDate(2, fecha);
				stmt.setString(3, direccionEntrega);
				stmt.setString(4, articulos);
				stmt.setString(5, nombreCliente);
				stmt.setString(6, tipoPedido);

				stmt.executeUpdate();
			} else {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `pedidos` (`IDTrabajador`, `IDCliente`, `NumPedido`, `Fecha`, `DireccionEntrega`, `Articulos`, `Nombre Cliente`, `TipoPedido`, `Estado`) VALUES (?, NULL, NULL, ?, ?, ?, ?, ?, 'Pendiente')");
				stmt.setInt(1, VentanaLogin.getID());

				Calendar hoy = Calendar.getInstance();
				java.sql.Date fecha = new java.sql.Date(hoy.get(Calendar.YEAR) - 1900, hoy.get(Calendar.MONTH),
						hoy.get(Calendar.DAY_OF_MONTH));

				stmt.setDate(2, fecha);
				stmt.setString(3, direccionEntrega);
				stmt.setString(4, articulos);
				stmt.setString(5, nombreCliente);
				stmt.setString(6, tipoPedido);

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
