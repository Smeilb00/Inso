package ins0.Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import com.mysql.jdbc.PreparedStatement;

import ins0.Controlador.DataConnection;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;

public class VentanaBotones extends JFrame {


	private JPanel Principal;
	public VentanaBotones() {
		setTitle("Principal");
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
        setIconImage(icon);
		setBounds(100, 100, 600, 400);
		Principal = new JPanel();
		Principal.setBackground(new Color(70, 130, 180));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		
		JButton btnRegistro = new JButton("Registrar Usuarios");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VentanaLogin.getConectado().equals("Cliente")) {
					JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta acción.");
				}else {
					VentanaRegistro v1 = new VentanaRegistro();
					v1.setVisible(true);
				}
				
			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistro.setBounds(70, 80, 180, 30);
		desktopPane.add(btnRegistro);
		
		JButton btnCrearPedido = new JButton("Crear Pedido");
		btnCrearPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPedido v2 = new VentanaPedido();
				v2.setVisible(true);
			}
		});
		btnCrearPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearPedido.setBounds(70, 222, 180, 30);
		desktopPane.add(btnCrearPedido);
		
		JButton btnModificarDatos = new JButton("Modificar Datos");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VentanaLogin.getConectado().equals("Cliente")) {
					JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta acción.");
				}else {
					VentanaModificar v3 = new VentanaModificar();
					v3.setVisible(true);
				}
			}
		});
		btnModificarDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarDatos.setBounds(70, 154, 180, 30);
		desktopPane.add(btnModificarDatos);
		
		JButton btnSolicitarReposicion = new JButton("Solicitar Reposicion");
		btnSolicitarReposicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VentanaLogin.getConectado().equals("Almacen") || VentanaLogin.getConectado().equals("Administrador")){
					VentanaReposicion v4 = new VentanaReposicion();
					v4.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta acción.");
				}
				
			}
		});
		btnSolicitarReposicion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSolicitarReposicion.setBounds(330, 80, 180, 30);
		desktopPane.add(btnSolicitarReposicion);
		
		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					VentanaCancelar v5 = new VentanaCancelar();
					v5.setVisible(true);
			}
		});
		btnCancelarPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarPedido.setBounds(330, 222, 180, 30);
		desktopPane.add(btnCancelarPedido);
		
		JButton btnAceptarPedidos = new JButton("Aceptar Pedidos");
		btnAceptarPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VentanaLogin.getConectado().equals("Cliente")) {
					JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta acción.");
				}else {
					DataConnection conectar = new DataConnection();
                    Connection conn = conectar.DataConn();
                    conectar.aceptarPedidos(conn);
                    JOptionPane.showMessageDialog(null, "Se han aceptado todos los pedidos para los que había stock suficiente.");
				}
				
			}
		});
		btnAceptarPedidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAceptarPedidos.setBounds(330, 154, 180, 30);
		desktopPane.add(btnAceptarPedidos);
		
		JButton btnConsultarEstadoPedido = new JButton("Consultar Pedidos");
		btnConsultarEstadoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEstadoPedidos v7 = new VentanaEstadoPedidos();
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				
				conectar.getEstadoPedido(conn, VentanaLogin.getID(), v7);
				
				v7.setVisible(true);
			}
		});
		btnConsultarEstadoPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultarEstadoPedido.setBounds(70, 287, 180, 30);
		desktopPane.add(btnConsultarEstadoPedido);
		
		JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VentanaLogin.getConectado().equals("Cliente")) {
					JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta acción.");
				}else {
				VentanaRemoveUser v8 = new VentanaRemoveUser();
				v8.setVisible(true);
				}
			}
		});
		btnEliminarUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarUsuario.setBounds(330, 287, 180, 30);
		desktopPane.add(btnEliminarUsuario);
		
	}
}
