package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;

import ins0.Controlador.DataConnection;
import ins0.Modelo.Dao.TrabajadorDao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
		BoxCampo.setModel(new DefaultComboBoxModel(new String[] {"Direccion", "Telefono", "Contrasenha"}));
		BoxCampo.setBounds(207, 87, 194, 20);
		desktopPane.add(BoxCampo);
		
		JRadioButton rdbtnTrabajador = new JRadioButton("Trabajador");
		rdbtnTrabajador.setForeground(new Color(255, 255, 255));
		rdbtnTrabajador.setBackground(new Color(70, 130, 180));
		
		buttonGroup_2.add(rdbtnTrabajador);
		rdbtnTrabajador.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnTrabajador.setBounds(117, 24, 109, 23);
		desktopPane.add(rdbtnTrabajador);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setForeground(new Color(255, 255, 255));
		
		rdbtnCliente.setBackground(new Color(70, 130, 180));
		buttonGroup_2.add(rdbtnCliente);
		rdbtnCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCliente.setBounds(256, 24, 86, 23);
		desktopPane.add(rdbtnCliente);
		
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
		
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				TrabajadorDao trabajador = new TrabajadorDao();
				String dNI = textField_1.getText();
				String tipo = BoxCampo.getSelectedItem().toString();
				String valor = textField.getText();
				
				if(rdbtnTrabajador.isSelected()) {
					trabajador.modifyTrabajador(conn, tipo, valor, dNI);
				}else if(rdbtnCliente.isSelected()){
					trabajador.modifyCliente(conn, tipo, valor, dNI);
				}
			}
		});
	}
}
