package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;


import ins0.Controlador.DataConnection;
import ins0.Modelo.Dao.ArticuloDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class VentanaReposicion extends JFrame {
	private JPanel Principal;

	private JTable pedido;
	private DefaultTableModel modelo;
	
	public DefaultTableModel getModelo() {
		return this.modelo;
	}
	public VentanaReposicion() {
		setTitle("Gestionar Stock");
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
        setIconImage(icon);
		setBounds(100, 100, 375, 536);
		Principal = new JPanel();
		Principal.setBorder(null);
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		
		DataConnection conectar = new DataConnection();
		Connection conn = conectar.DataConn();
		
		pedido = new JTable();
		pedido.setRowSelectionAllowed(false);
		pedido.setForeground(Color.WHITE);
		pedido.setGridColor(Color.BLACK);
		pedido.setFont(new Font("Tahoma", Font.BOLD, 14));
		modelo = (DefaultTableModel)pedido.getModel();
		
		modelo.addColumn("");
		modelo.addColumn("");
		Border borde = BorderFactory.createLineBorder(Color.black);
		pedido.setBorder(borde);
		pedido.setBackground(new Color(70, 130, 180));
		pedido.setBounds(25, 21, 311, 406);
		desktopPane.add(pedido);
		
		JButton btnNewButton = new JButton("Actualizar Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaReposicion v4 = new VentanaReposicion();
				ArticuloDao articuloDao = new ArticuloDao();
				articuloDao.actualizarStock(conn, v4);
				JOptionPane.showMessageDialog(null, "Se ha actualizado el Stock a 15");
			}
		});
		btnNewButton.setBounds(114, 451, 123, 35);
		desktopPane.add(btnNewButton);
	}
}
