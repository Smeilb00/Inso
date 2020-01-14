package ins0.Modelo.Dao;

import java.sql.*;

import ins0.Modelo.Vo.ClienteVo;
import ins0.Modelo.Vo.PedidoVo;

public class ClienteDao {
	public ClienteVo getCliente(int iD) {
		ClienteVo retorno = new ClienteVo();
		return retorno;
	}
	
	public void addPedido(Connection conn,PedidoVo pedido) {
		PedidoDao pedidoDao = new PedidoDao();
		pedidoDao.iniciarPedido(conn, pedido);
	}

}
