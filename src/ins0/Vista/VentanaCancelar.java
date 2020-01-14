package ins0.Vista;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import ins0.Controlador.DataConnection;
import ins0.Modelo.Dao.ClienteDao;
import ins0.Modelo.Dao.PedidoDao;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaCancelar extends JFrame {
	private JPanel Principal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNumeroPedido;
	public int idpedido = 0;
	public VentanaCancelar() {
		setTitle("Gestionar Stock");
		Image icon = new ImageIcon(getClass().getResource("../o2.png")).getImage();
        setIconImage(icon);
		setBounds(100, 100, 851, 336);
		Principal = new JPanel();
		Principal.setBackground(Color.LIGHT_GRAY);
		Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Principal.setLayout(new BorderLayout(0, 0));
		setContentPane(Principal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(70, 130, 180));
		Principal.add(desktopPane, BorderLayout.CENTER);
		JButton btnPedido = new JButton("Cancelar Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataConnection conectar = new DataConnection();
				Connection conn = conectar.DataConn();
				PedidoDao pedido = new PedidoDao();
				pedido.eliminarPedido(conn, Integer.parseInt(txtNumeroPedido.getText()));
			}
		});
		
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedido.setBounds(544, 233, 216, 30);
		desktopPane.add(btnPedido);
		
		txtNumeroPedido = new JTextField();
		txtNumeroPedido.setBounds(198, 80, 264, 20);
		desktopPane.add(txtNumeroPedido);
		txtNumeroPedido.setColumns(10);
		
		JLabel lblNumeroDePedido = new JLabel("Numero de pedido");
		lblNumeroDePedido.setForeground(new Color(255, 255, 255));
		lblNumeroDePedido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumeroDePedido.setBounds(27, 81, 145, 14);
		desktopPane.add(lblNumeroDePedido);
		
		JLabel lblPedidos = new JLabel("DATOS PEDIDO");
		lblPedidos.setBounds(493, 24, 293, 185);
		desktopPane.add(lblPedidos);
		
		
		
		JButton btnBuscarPedido = new JButton("Buscar Pedido");
		btnBuscarPedido.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					int ID = Integer.parseInt(txtNumeroPedido.getText());
					DataConnection conectar = new DataConnection();
					Connection conn = conectar.DataConn();
					ArrayList<Object> array = buscarPedido(conn, ID);
					StringBuffer label = new StringBuffer();
					label.append("<html>DATOS PEDIDO: <br>");
					for(int i=0;i<array.size();i++) {
						label.append("- ");
						label.append(array.get(i).toString());
						label.append("<br>");
					}
					label.append("</html>");
					lblPedidos.setText(label.toString());
				}
			
		});
		btnBuscarPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarPedido.setBounds(122, 131, 216, 30);
		desktopPane.add(btnBuscarPedido);
	}
	
	public ArrayList<Object> buscarPedido(Connection conn, int ID) {
		ArrayList<Object> array = new ArrayList<Object>();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pedidos where numPedido = ?");
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next()) {
				array.add(rs.getInt(1));
				array.add(rs.getInt(2));
				array.add(rs.getInt(3));
				array.add(rs.getDate(4));
				array.add(rs.getString(5));
				array.add(rs.getString(6));
				array.add(rs.getString(7));
				array.add(rs.getString(8));
				array.add(rs.getString(9));
				
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return array;
		
		
	}
}
