package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

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

public class VentanaAddArticulo extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNumeroDeSerie;
	private JTextField txtMarca;
	private JTextField txtFechaDeLlegada;
	private JTextField txtStock;

	public VentanaAddArticulo() {
		setTitle("A\u00F1adir Articulo");
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
        setIconImage(icon);
		setBounds(100, 100, 634, 382);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		JButton btnArticulo = new JButton("A\u00F1adir Art\u00EDculo");
		btnArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {}
		});
		btnArticulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnArticulo.setBounds(224, 292, 121, 30);
		desktopPane.add(btnArticulo);
		
		JLabel lblNumeroDeSerie = new JLabel("Numero de Serie:");
		lblNumeroDeSerie.setForeground(new Color(255, 255, 255));
		lblNumeroDeSerie.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumeroDeSerie.setBounds(115, 71, 137, 19);
		desktopPane.add(lblNumeroDeSerie);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipo.setBounds(115, 101, 137, 19);
		desktopPane.add(lblTipo);
		
		JLabel lblSubtipo = new JLabel("Subtipo:");
		lblSubtipo.setForeground(new Color(255, 255, 255));
		lblSubtipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubtipo.setBounds(115, 131, 137, 19);
		desktopPane.add(lblSubtipo);
		
		JLabel lblMarca = new JLabel("Marca: ");
		lblMarca.setForeground(new Color(255, 255, 255));
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarca.setBounds(115, 161, 137, 19);
		desktopPane.add(lblMarca);
		
		JLabel lblFechaDeLlegada = new JLabel("Fecha de Llegada:");
		lblFechaDeLlegada.setForeground(new Color(255, 255, 255));
		lblFechaDeLlegada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaDeLlegada.setBounds(115, 190, 137, 19);
		desktopPane.add(lblFechaDeLlegada);
		
		JLabel lblStock = new JLabel("Stock: ");
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStock.setBounds(115, 220, 137, 19);
		desktopPane.add(lblStock);
		
		txtNumeroDeSerie = new JTextField();
		txtNumeroDeSerie.setBounds(262, 72, 208, 20);
		desktopPane.add(txtNumeroDeSerie);
		txtNumeroDeSerie.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(262, 162, 208, 20);
		desktopPane.add(txtMarca);
		
		txtFechaDeLlegada = new JTextField();
		txtFechaDeLlegada.setText("aaaa/mm/dd");
		txtFechaDeLlegada.setColumns(10);
		txtFechaDeLlegada.setBounds(262, 191, 208, 20);
		desktopPane.add(txtFechaDeLlegada);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(262, 221, 208, 20);
		desktopPane.add(txtStock);
		
		JComboBox BoxTipo = new JComboBox();
		BoxTipo.setToolTipText("Procesador\r\nPlaca Base\r\nRAM\r\nROM HDD\r\nROM SSD\r\n");
		BoxTipo.setBounds(262, 102, 208, 20);
		desktopPane.add(BoxTipo);
		
		JLabel lblAadirArticulo = new JLabel("A\u00D1ADIR ARTICULO");
		lblAadirArticulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirArticulo.setForeground(new Color(255, 255, 255));
		lblAadirArticulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAadirArticulo.setBounds(115, 30, 355, 30);
		desktopPane.add(lblAadirArticulo);
	}
}
