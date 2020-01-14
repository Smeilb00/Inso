package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import ins0.Controlador.DataConnection;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.awt.event.ActionEvent;

public class VentanaEstadoPedidos extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable pedido;
	private DefaultTableModel modelo;
	
	public DefaultTableModel getModelo() {
		return this.modelo;
	}
	public VentanaEstadoPedidos() {
		setTitle("EstadoPedidos");
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
		pedido.setBounds(25, 21, 311, 454);
		desktopPane.add(pedido);
	}
}
