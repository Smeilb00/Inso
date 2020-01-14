package ins0.Modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import ins0.Modelo.Vo.ClienteVo;
import ins0.Modelo.Vo.PedidoVo;
import ins0.Modelo.Vo.TrabajadorVo;
import ins0.Vista.VentanaLogin;

public class TrabajadorDao {

	public TrabajadorVo getTrabajadorVo() {
		TrabajadorVo retorno = new TrabajadorVo();
		return retorno;
	}
	
	public void addPedido(Connection conn,PedidoVo pedido) {
		PedidoDao pedidoDao = new PedidoDao();
		pedidoDao.iniciarPedido(conn, pedido);
	}
 
	public void addCliente(Connection conn, ClienteVo cliente) {
		try {
			if (!VentanaLogin.getConectado().equals("Cliente") ) {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `clientes` (`Nombre`, `Apellido`, `ID`, `Telefono`, `Direccion`, `DNI`, `FechaNacimiento`, `Contrasenha`) VALUES (?, ?, NULL, ?, ?, ?, ?, ?)");

				stmt.setString(1, cliente.getNombre());
				stmt.setString(2, cliente.getApellido());
				stmt.setInt(3, cliente.getTelefono());
				stmt.setString(4, cliente.getDireccion());
				stmt.setString(5, cliente.getdNI());
				stmt.setDate(6, cliente.getFechaNacimiento());
				stmt.setString(7, cliente.getContrasenha());

				stmt.executeUpdate();
				
				stmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void addTrabajador(Connection conn, TrabajadorVo trabajador) {

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO `trabajador` (`Posicion`, `Nombre`, `Apellido`, `DNI`, `Direccion`, `Telefono`, `ID`, `Contrasenha`) VALUES (?, ?, ?, ?, ?, ?, NULL, ?)");

			stmt.setString(1, trabajador.getPosicion());
			stmt.setString(2, trabajador.getNombre());
			stmt.setString(3, trabajador.getApellido());
			stmt.setString(4, trabajador.getdNI());
			stmt.setString(5, trabajador.getDireccion());
			stmt.setInt(6, trabajador.getTelefono());
			stmt.setString(7, trabajador.getContrasenha());

			stmt.executeUpdate();

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void removeTrabajador(Connection conn, String DNI) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM trabajador WHERE DNI = ?");
			stmt.setString(1, DNI);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyTrabajador(Connection conn, String Tipo, String Valor, String DNI) {
		if (Tipo.equals("Telefono")) {
			int telefono = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE trabajador SET Telefono=? WHERE DNI=?");
				stmt.setInt(1, telefono);
				stmt.setString(2, DNI);
				stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(Tipo.equals("Direccion")){
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE trabajador SET Direccion=? WHERE DNI=?");
				stmt.setString(1,  Valor);
				stmt.setString(2, DNI);
				stmt.executeUpdate();
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(Tipo.equals("Contrasenha")){
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE trabajador SET Contrasenha=? WHERE DNI=?");
				stmt.setString(1,  Valor);
				stmt.setString(2, DNI);
				stmt.executeUpdate();
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeCliente(Connection conn, String DNI) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM clientes WHERE DNI = ?");
			stmt.setString(1, DNI);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyCliente(Connection conn, String Tipo, String Valor, String DNI) {
		if (Tipo.equals("Telefono")) {
			int telefono = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET Telefono=? WHERE DNI=?");
				stmt.setInt(1, telefono);
				stmt.setString(2, DNI);
				stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(Tipo.equals("Direccion")){
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET Direccion=? WHERE DNI=?");
				stmt.setString(1,  Valor);
				stmt.setString(2, DNI);
				stmt.executeUpdate();
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(Tipo.equals("Contrasenha")){
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET Contrasenha=? WHERE DNI=?");
				stmt.setString(1,  Valor);
				stmt.setString(2, DNI);
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void aceptarPedidos(Connection conn) {
        PreparedStatement stmt;
        PreparedStatement stmt2;
        PreparedStatement stmt3;
        PreparedStatement stmt4;
        PreparedStatement stmt5;
        ResultSet rs2;
        ResultSet rs4;
        try {
            stmt = conn.prepareStatement("SELECT NumPedido, Articulos FROM pedidos WHERE Estado = ? ");
            stmt.setString(1, "Pendiente");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                String[] articulos;
                articulos = (rs.getString(2).split(","));
                boolean aceptar = true;
                for(int i = 0; i<articulos.length;i++) {
                    stmt2 = conn.prepareStatement("SELECT Stock FROM articulos WHERE ID = ?");
                    stmt2.setInt(1, Integer.parseInt(articulos[i]));
                    rs2 = stmt2.executeQuery();

                    if(rs2.next() && rs2.getInt(1)<=0) {
                        aceptar=false;
                    }

                }
                if(aceptar) {
                    stmt3 = conn.prepareStatement("UPDATE pedidos SET estado=?, IDTrabajador=? WHERE Estado='Pendiente'");
                    stmt3.setString(1, "Aceptado");
                    stmt3.setInt(2,VentanaLogin.getID());
                    stmt3.executeUpdate();
                    stmt3.close();
                    
                    for(int i = 0; i<articulos.length;i++) {
                    	 stmt4 = conn.prepareStatement("SELECT Stock FROM articulos WHERE ID = ?");
                         stmt4.setInt(1, Integer.parseInt(articulos[i]));
                         rs4 = stmt4.executeQuery();
                         while(rs4.next()) {
                        	 stmt5 = conn.prepareStatement("UPDATE articulos SET Stock=? WHERE ID=?");
                        	 stmt5.setInt(1,rs4.getInt(1)-1);
                        	 stmt5.setInt(2, Integer.parseInt(articulos[i]));
                        	 stmt5.executeUpdate();
                         }


                    }
                }
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
