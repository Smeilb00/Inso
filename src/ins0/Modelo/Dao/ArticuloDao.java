package ins0.Modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ins0.Controlador.DataConnection;
import ins0.Modelo.Vo.ArticuloVo;

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
			if(campo.equals("ID") || campo.equals("Stock")) {
				stmt.setInt(2, Integer.parseInt(campo));
			}else {
				stmt.setString(2, campo);
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
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
	
	
}
