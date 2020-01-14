package ins0.Modelo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import ins0.Modelo.Vo.TrabajadorVo;
import ins0.Vista.VentanaLogin;

public class TrabajadorDao {

	public TrabajadorVo getTrabajadorVo() {
		TrabajadorVo retorno = new TrabajadorVo();
		return retorno;
	}
	
	public void addPedido() {
		
	}
	public void addCliente(Connection conn, String txtNombre, String txtApellido, String txtTelefono, String txtDireccion, String txtDNI, Date calendar, String txtContrasenha) {
		try {
			if (VentanaLogin.getConectado().equals("Trabajador")) {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `clientes` (`Nombre`, `Apellido`, `ID`, `Telefono`, `Direccion`, `DNI`, `FechaNacimiento`, `Contrasenha`) VALUES (?, ?, NULL, ?, ?, ?, ?, ?)");

				stmt.setString(1, txtNombre);
				stmt.setString(2, txtApellido);
				stmt.setInt(3, Integer.parseInt(txtTelefono));
				stmt.setString(4, txtDireccion);
				stmt.setString(5, txtDNI);
				java.sql.Date fecha = new java.sql.Date(calendar.getTime());
				stmt.setDate(6, fecha);
				stmt.setString(7, txtContrasenha);

				stmt.executeUpdate();
				
				stmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void addTrabajador(Connection conn, String txtPosicion, String txtNombre, String txtApellido, String txtDNI, String txtDireccion, String txtTelefono, String txtContrasenha) {

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO `trabajador` (`Posicion`, `Nombre`, `Apellido`, `DNI`, `Direccion`, `Telefono`, `ID`, `Contrasenha`) VALUES (?, ?, ?, ?, ?, ?, NULL, ?)");

			stmt.setString(1, txtPosicion);
			stmt.setString(2, txtNombre);
			stmt.setString(3, txtApellido);
			stmt.setString(4, txtDNI);
			stmt.setString(5, txtDireccion);
			stmt.setInt(6, Integer.parseInt(txtTelefono));
			stmt.setString(7, txtContrasenha);

			stmt.executeUpdate();

			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void removeTrabajador(Connection conn, String DNI) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM `Trabajador` WHERE `trabajador`.`DNI` = ?");
			stmt.setString(1, DNI);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyTrabajador(Connection conn, String Tipo, String Valor, String DNI) {
		if (Tipo.equals("Telefono")) {
			int telefono = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setInt(2,  telefono);
				stmt.setString(3, DNI);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setString(2,  Valor);
				stmt.setString(3, DNI);
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeCliente(Connection conn, String DNI) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM `Tlientes` WHERE `clientes`.`DNI` = ?");
			stmt.setString(1, DNI);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyCliente(Connection conn, String Tipo, String Valor, String DNI) {
		if (Tipo.equals("Telefono")) {
			int telefono = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Clientes` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setInt(2,  telefono);
				stmt.setString(3, DNI);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(Tipo.equals("FechaNacimiento")) {
			/*
			 java.sql.Date fecha = new java.sql.Date(calendar.getDate().getTime());
		*/
			
		}else if(Tipo.equals("ID") || Tipo.equals("DNI")) {
			JOptionPane.showMessageDialog(null, "Este campo no se puede modificar.");
		}else {
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Clientes` SET ?=[?] WHERE DNI=?");
				stmt.setString(1, Tipo);
				stmt.setString(2,  Valor);
				stmt.setString(3, DNI);
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	public void addArticulo(Connection conn, String numeroSerie, String tipo, String subtipo, String marca, String date,
			int stock) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO `articulos` (`ID`, `NumeroSerie`, `Tipo`, `Subtipo`, `Marca`, `FechaLlegada`, `Stock`) VALUES (NULL, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, numeroSerie);
			stmt.setString(2, tipo);
			stmt.setString(3, subtipo);
			stmt.setString(4, marca);
			stmt.setString(5, date);
			stmt.setInt(6, stock);

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeArticulo(Connection conn, int iD) {
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM `articulos` WHERE `articulos`.`ID` = ?");
			stmt.setInt(1, iD);
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyArticulo(Connection conn, String Tipo, String Valor, String ID) {
		if (Tipo.equals("Stock")) {
			int stock = Integer.parseInt(Valor);
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE ID=?");
				stmt.setString(1, Tipo);
				stmt.setInt(2,  stock);
				stmt.setString(3, ID);
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				PreparedStatement stmt = conn.prepareStatement("UPDATE `Trabajador` SET ?=[?] WHERE ID=?");
				stmt.setString(1, Tipo);
				stmt.setString(2,  Valor);
				stmt.setString(3, ID);
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void gestionarAlmacen() {

	}

	public void solicitarReparacion(String DNI) {

	}
}
