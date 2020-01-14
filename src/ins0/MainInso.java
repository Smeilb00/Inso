package ins0;

import java.awt.EventQueue;

import ins0.Vista.VentanaLogin;
  
public class MainInso {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ins0.Vista.VentanaLogin frame = new ins0.Vista.VentanaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
