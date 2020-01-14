package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import ins0.Controlador.DataConnection;
import ins0.Modelo.Dao.TrabajadorDao;
import ins0.Modelo.Vo.ClienteVo;
import ins0.Modelo.Vo.TrabajadorVo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {
	private JPanel Principal;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JPasswordField txtContrasenha;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public VentanaRegistro() {
		setTitle("Registro de Usuarios");
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
        setIconImage(icon);
		setBounds(100, 100, 851, 536);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);

		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		rdbtnCliente.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setBackground(new Color(70, 130, 180));
		rdbtnCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnCliente.setBounds(224, 101, 109, 23);
		desktopPane.add(rdbtnCliente);

		JRadioButton rdbtnTrabajador = new JRadioButton("Trabajador");
		rdbtnTrabajador.setForeground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnTrabajador);
		rdbtnTrabajador.setBackground(new Color(70, 130, 180));
		rdbtnTrabajador.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnTrabajador.setBounds(335, 101, 109, 23);
		desktopPane.add(rdbtnTrabajador);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(126, 103, 84, 19);
		desktopPane.add(lblTipo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(126, 163, 84, 19);
		desktopPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(414, 163, 88, 19);
		desktopPane.add(lblApellido);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setForeground(new Color(255, 255, 255));
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDni.setBounds(126, 231, 84, 14);
		desktopPane.add(lblDni);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(414, 229, 88, 19);
		desktopPane.add(lblContrasea);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(126, 303, 80, 14);
		desktopPane.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(414, 293, 88, 23);
		desktopPane.add(lblTelefono);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(224, 163, 180, 21);
		desktopPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDNI.setColumns(10);
		txtDNI.setBounds(224, 228, 180, 21);
		desktopPane.add(txtDNI);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(224, 300, 180, 21);
		desktopPane.add(txtDireccion);

		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBounds(512, 164, 180, 21);
		desktopPane.add(txtApellido);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(512, 296, 180, 21);
		desktopPane.add(txtTelefono);

		txtContrasenha = new JPasswordField();
		txtContrasenha.setBounds(512, 230, 180, 20);
		desktopPane.add(txtContrasenha);

		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaNacimiento.setForeground(new Color(255, 255, 255));
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaNacimiento.setBounds(126, 358, 164, 14);
		desktopPane.add(lblFechaNacimiento);

		JDateChooser calendar = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		calendar.setBounds(300, 354, 180, 29);
		desktopPane.add(calendar);

		JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setForeground(new Color(255, 255, 255));
		lblPosicion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPosicion.setBounds(500, 354, 74, 23);
		desktopPane.add(lblPosicion);

		JComboBox<String> txtPosicion = new JComboBox<String>();
		txtPosicion.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Cliente", "Almacen", "Administrador", "Atencion al Cliente" }));
		txtPosicion.setBounds(572, 357, 120, 20);
		desktopPane.add(txtPosicion);
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				TrabajadorDao t1 = new TrabajadorDao();
				
				Calendar fecha = Calendar.getInstance();
				boolean mayor = false;

				if ((fecha.get(Calendar.YEAR) - calendar.getCalendar().get(Calendar.YEAR)) == 18) {
					if (fecha.get(Calendar.MONTH) == calendar.getCalendar().get(Calendar.MONTH)) {
						if (fecha.get(Calendar.DAY_OF_MONTH) >= calendar.getCalendar().get(Calendar.DAY_OF_MONTH)) {
							mayor = true;
						}
					} else if (fecha.get(Calendar.MONTH) > calendar.getCalendar().get(Calendar.MONTH)) {
						mayor = true;
					}
				} else if ((fecha.get(Calendar.YEAR) - calendar.getCalendar().get(Calendar.YEAR)) > 18) {
					mayor = true;
				}
				if (mayor) {

					if (rdbtnCliente.isSelected()) {
						
						java.sql.Date fechaNacimiento = new java.sql.Date(calendar.getDate().getTime());
						ClienteVo cliente = new ClienteVo(0,txtNombre.getText(),txtApellido.getText(),Integer.parseInt(txtTelefono.getText()),txtDireccion.getText(),txtDNI.getText(),fechaNacimiento,txtContrasenha.getText());
						t1.addCliente(conn, cliente);
					} else if (rdbtnTrabajador.isSelected()) {
						if (VentanaLogin.getConectado().equals("Administrador")) {
							TrabajadorVo trabajador = new TrabajadorVo(txtPosicion.getSelectedItem().toString(), txtNombre.getText(),
									txtApellido.getText(), txtDNI.getText(), txtDireccion.getText(),
									Integer.parseInt(txtTelefono.getText()), 0 , txtContrasenha.getText());
							t1.addTrabajador(conn,trabajador);
						} else {
							JOptionPane.showMessageDialog(null,
									"Solo el Administrador puede añadir nuevos trabajadores.");
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Debe ser mayor de 18 años.");
				}

			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistro.setBounds(381, 433, 121, 30);
		desktopPane.add(btnRegistro);

		JLabel lblRegistroDeUsuarios = new JLabel("REGISTRO DE USUARIOS");
		lblRegistroDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRegistroDeUsuarios.setForeground(new Color(255, 255, 255));
		lblRegistroDeUsuarios.setBounds(126, 38, 566, 40);
		desktopPane.add(lblRegistroDeUsuarios);
	}
}
