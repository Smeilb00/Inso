package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;

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

public class VentanaModificar extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField textField_1;

	public VentanaModificar() {
		setTitle("Modificar Usuarios");
		setBounds(100, 100, 493, 264);
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
        setIconImage(icon);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		JButton btnPedido = new JButton("Modificar Datos");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				
				
				
				
				
			}
		});
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedido.setBounds(168, 157, 137, 30);
		desktopPane.add(btnPedido);
		
		JLabel lblCampo = new JLabel("Campo a modificar:");
		lblCampo.setForeground(new Color(255, 255, 255));
		lblCampo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCampo.setBounds(60, 86, 137, 19);
		desktopPane.add(lblCampo);
		
		JLabel lblValor = new JLabel("Modificacion:");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setBounds(60, 117, 137, 19);
		desktopPane.add(lblValor);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(207, 116, 194, 20);
		desktopPane.add(textField);
		
		JComboBox BoxCampo = new JComboBox();
		BoxCampo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BoxCampo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione arriba primero"}));
		BoxCampo.setBounds(207, 87, 194, 20);
		desktopPane.add(BoxCampo);
		
		JRadioButton rdbtnTrabajador = new JRadioButton("Trabajador");
		rdbtnTrabajador.setForeground(new Color(255, 255, 255));
		rdbtnTrabajador.setBackground(new Color(70, 130, 180));
		rdbtnTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BoxCampo.removeAllItems();
				BoxCampo.setModel(new DefaultComboBoxModel(new String[] {"Posicion", "Nombre", "Apellido", "Direccion", "Telefono", "Contrasenha"}));
			}
		});
		
		buttonGroup_2.add(rdbtnTrabajador);
		rdbtnTrabajador.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnTrabajador.setBounds(88, 24, 109, 23);
		desktopPane.add(rdbtnTrabajador);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setForeground(new Color(255, 255, 255));
		rdbtnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BoxCampo.removeAllItems();
				BoxCampo.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Apellido", "Direccion", "Telefono", "Contrasenha", "Fecha Nacimiento"}));
			}
		});
		rdbtnCliente.setBackground(new Color(70, 130, 180));
		buttonGroup_2.add(rdbtnCliente);
		rdbtnCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCliente.setBounds(197, 24, 86, 23);
		desktopPane.add(rdbtnCliente);
		
		JRadioButton rdbtnArticulo = new JRadioButton("Articulo");
		rdbtnArticulo.setForeground(new Color(255, 255, 255));
		rdbtnArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BoxCampo.removeAllItems();
				BoxCampo.setModel(new DefaultComboBoxModel(new String[] {"Numero De Serie","Tipo", "Subtipo", "Marca", "Fecha de Llegada", "Stock"}));
			}
		});
		rdbtnArticulo.setBackground(new Color(70, 130, 180));
		buttonGroup_2.add(rdbtnArticulo);
		rdbtnArticulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnArticulo.setBounds(288, 24, 97, 23);
		desktopPane.add(rdbtnArticulo);
		
		JLabel lblIdentificador = new JLabel("Identificador: ");
		lblIdentificador.setForeground(new Color(255, 255, 255));
		lblIdentificador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdentificador.setBounds(60, 56, 137, 19);
		desktopPane.add(lblIdentificador);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(207, 55, 194, 20);
		desktopPane.add(textField_1);
		
		

		
		
	}
}
