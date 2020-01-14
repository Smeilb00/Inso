package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import ins0.Controlador.DataConnection;
import ins0.Modelo.Dao.TrabajadorDao;
import ins0.Modelo.Vo.ClienteVo;
import ins0.Modelo.Vo.TrabajadorVo;

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

public class VentanaRemoveUser extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField textField_1;

	public VentanaRemoveUser() {
		setTitle("Eliminar usuario");
		setBounds(100, 100, 480, 179);
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
        setIconImage(icon);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		JButton btnPedido = new JButton("Eliminar usuario");
		
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedido.setBounds(162, 87, 137, 30);
		desktopPane.add(btnPedido);
		
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
				
				if(rdbtnTrabajador.isSelected()) {
					trabajador.removeTrabajador(conn, dNI);
				}else if(rdbtnCliente.isSelected()){
					trabajador.removeCliente(conn, dNI);
				}
			}
		});
	}
}
