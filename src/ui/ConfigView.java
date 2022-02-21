package ui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfigView {

	private JFrame frame;
	private JLabel lblPokedex;
	private JButton btnCambiarContrasea;
	private JButton btnBorrarCuenta;
	private JButton btnVolver;
	private JLabel lblBienvenida;
	private JButton btnCambiarNombre;
	private JPanel panelDeCambios;


	/**
	 * Create the application.
	 */
	public ConfigView() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.RED);
		frame.setTitle("Pokedex - Configuración");
		frame.setBounds(100, 100, 665, 495);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(ConfigView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(190, 32, 256, 104);
		frame.getContentPane().add(lblPokedex);
		
		btnCambiarNombre = new JButton("Cambiar Nombre");
		btnCambiarNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCambiarNombre.setForeground(new Color(255, 255, 255));
		btnCambiarNombre.setBackground(new Color(51, 102, 204));
		btnCambiarNombre.setBounds(36, 205, 190, 54);
		frame.getContentPane().add(btnCambiarNombre);
		
		btnCambiarContrasea = new JButton("Cambiar Password");
		btnCambiarContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnCambiarContrasea.setForeground(new Color(255, 255, 255));
		btnCambiarContrasea.setBackground(new Color(51, 102, 204));
		btnCambiarContrasea.setBounds(36, 270, 190, 54);
		frame.getContentPane().add(btnCambiarContrasea);
		
		btnBorrarCuenta = new JButton("Borrar Cuenta");
		btnBorrarCuenta.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		btnBorrarCuenta.setBackground(new Color(255, 215, 0));
		btnBorrarCuenta.setBounds(36, 370, 190, 54);
		btnBorrarCuenta.setBorder(null);
		frame.getContentPane().add(btnBorrarCuenta);
		
		panelDeCambios = new JPanel();
		panelDeCambios.setBounds(268, 205, 347, 219);
		frame.getContentPane().add(panelDeCambios);
		
		lblBienvenida = new JLabel("Bienvenido a la configuraci\u00F3n de usuario");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(110, 125, 440, 40);
		frame.getContentPane().add(lblBienvenida);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnVolver.setBorder(null);
		btnVolver.setBounds(30, 37, 89, 33);
		frame.getContentPane().add(btnVolver);
		
		
	}
}
