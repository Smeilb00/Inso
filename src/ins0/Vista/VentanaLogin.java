package ins0.Vista;

import javax.swing.*;
import ins0.Controlador.DataConnection;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {
	
	private JPanel Principal;
	private JPasswordField txtPassword;
	private JTextField txtUser;
	private JLabel lblLogin;
	private static String conectado = "";
	private static int iD = 0;
	
	public static String getConectado() {
		return VentanaLogin.conectado;
	}

	public static void setConectado(String conectado) {
		VentanaLogin.conectado = conectado;
	}
	public static int getID() {
		return VentanaLogin.iD;
	}
	public static void setID(int iD) {
		VentanaLogin.iD = iD;
	}
	
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGIN");
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
		setIconImage(icon);
		setBounds(400,200,629,309);
		Principal = new JPanel();	
		Principal.setBackground(new Color(70, 130, 180));
		setContentPane(Principal);
		Principal.setLayout(null);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUser.setBounds(102, 114, 100, 14);
		Principal.add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(102, 151, 100, 14);
		Principal.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(224, 147, 277, 27);
		Principal.add(txtPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(224, 110, 277, 26);
		Principal.add(txtUser);
		txtUser.setColumns(10);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(93, 51, 427, 27);
		Principal.add(lblLogin);
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				conectar.comprobarUsuario(conn, txtUser.getText(), txtPassword.getText());
				
				if(getConectado().equals("")) {
					JOptionPane.showMessageDialog(null, "Login incorrecto.");
				}else {
					VentanaBotones v1 = new ins0.Vista.VentanaBotones();
					v1.setVisible(true);
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(70, 130, 180));
		btnLogin.setBounds(262, 202, 89, 23);
		Principal.add(btnLogin);
		

	}
}

