package ins0.Controlador;

import java.sql.*;

import ins0.Vista.VentanaEstadoPedidos;
import ins0.Vista.VentanaLogin;

public class DataConnection {

	public Connection DataConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://83.32.59.1:50001/ins0?useSSL=false", "ins0", "");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void comprobarUsuario(Connection conn, String usuario, String password) {
		try {
			PreparedStatement stmt = conn
					.prepareStatement("SELECT DNI,Contrasenha,ID FROM `clientes` where DNI=? and Contrasenha=?");
			stmt.setString(1, usuario);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					VentanaLogin.setConectado("Cliente");
					VentanaLogin.setID(rs.getInt(3));
				}
			} else {
				PreparedStatement stmt2 = conn.prepareStatement(
						"SELECT DNI,Contrasenha,Posicion,ID FROM trabajador WHERE DNI = ? and Contrasenha = ?");
				stmt2.setString(1, usuario);
				stmt2.setString(2, password);

				rs = stmt2.executeQuery();
				if (rs.next()) {
					if (usuario.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
						VentanaLogin.setConectado(rs.getString(3));
						VentanaLogin.setID(rs.getInt(4));
					}
				}
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
