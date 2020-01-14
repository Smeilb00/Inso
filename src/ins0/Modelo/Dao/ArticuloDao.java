package ins0.Modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ins0.Controlador.DataConnection;
import ins0.Modelo.Vo.ArticuloVo;
import ins0.Vista.VentanaEstadoPedidos;
import ins0.Vista.VentanaLogin;
import ins0.Vista.VentanaReposicion;

public class ArticuloDao {
	public ArticuloDao() {

	}

	public ArticuloVo getArticulo(String busqueda, String campo) {
		DataConnection conectar = new DataConnection();
		Connection conn = conectar.DataConn();
		ArticuloVo retorno = new ArticuloVo();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM articulos WHERE ?=?");
			stmt.setString(1, campo);
			if (campo.equals("ID") || campo.equals("Stock")) {
				stmt.setInt(2, Integer.parseInt(campo));
			} else {
				stmt.setString(2, campo);
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				retorno.setiD(rs.getInt(1));
				retorno.setNumeroSerie(rs.getString(2));
				retorno.setTipo(rs.getString(3));
				retorno.setSubTipo(rs.getString(4));
				retorno.setMarca(rs.getString(5));
				retorno.setFechaLLegada(rs.getDate(6));
				retorno.setStock(rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}

	public void getStock(Connection conn, VentanaReposicion v4) {
		try {

			PreparedStatement stmt = conn.prepareStatement("SELECT ID,Stock FROM articulos WHERE Stock < 5");
			ResultSet rs = stmt.executeQuery();

			String[] titulos = new String[2];

			titulos[0] = "Numero de articulo";
			titulos[1] = "Stock";

			while (rs.next()) {
				String iD = rs.getString(1);
				String stock = rs.getString(2);

				String[] filas = new String[2];
				filas[0] = iD;
				filas[1] = stock;

				v4.getModelo().addRow(filas);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizarStock(Connection conn,VentanaReposicion v4) {
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("UPDATE articulos SET Stock=15 WHERE Stock < 5");
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}