package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigView {

	private JFrame frame;
	private JFrame pokedex;
	private JLabel lblPokedex;
	private JButton btnCambiarContrasea;
	private JButton btnBorrarCuenta;
	private JButton btnVolver;
	private JLabel lblBienvenida;
	private JButton btnCambiarNombre;
	private JPanel panelCambios;
	private JTextField tfNombreActual;
	private JPasswordField pwNewPass;
	private JPasswordField pwActualPassCont;
	private JTextField tfNombreNuevo;
	private JPanel panelNombre;
	private JPanel panelContraseña;
	private JPasswordField pwRepitePass;
	private JLabel lblTextActualPass_1;
	private JPasswordField pwActualPassName;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lblTextNombreActual;
	private JLabel lblTextNombreNuevo;
	private JLabel lblTextNewPass;
	private JLabel lblTextActualPass;
	private JLabel lblRepiteContraseña;
	private JPanel panelRojoSuperior;
	private JLabel lblConfiguracion;
	private String username;
	private String password;
	private JPanel panelBaseText;
	private JLabel lblPanelDe;
	private JLabel lblConfiguraciones;
	private int modo;
	
	/**
	 * Create the application.
	 */
	public ConfigView(JFrame pokedex, String username, String password) {
		this.pokedex = pokedex;
		this.username = username;
		this.password = password;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
		
	}
	
	public void setUIComponents() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setTitle("Pokedex - Configuración");
		frame.setBounds(100, 100, 665, 495);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(ConfigView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(188, 61, 256, 104);
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
		frame.getContentPane().add(btnBorrarCuenta);
		
		panelCambios = new JPanel();
		panelCambios.setBounds(268, 205, 347, 219);
		frame.getContentPane().add(panelCambios);
		panelCambios.setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(212, 178, 100, 30);
		btnConfirmar.setBackground(new Color(255, 215, 0));
		panelCambios.add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(38, 178, 100, 30);
		btnCancelar.setBackground(new Color(255, 215, 0));
		panelCambios.add(btnCancelar);
		
		panelNombre = new JPanel();
		panelNombre.setBounds(10, 10, 327, 162);
		panelNombre.setBackground(new Color(51, 102, 204));
		panelCambios.add(panelNombre);
		panelNombre.setLayout(null);
		
		lblTextNombreActual = new JLabel("Nombre Actual:");
		lblTextNombreActual.setBounds(0, 0, 327, 30);
		panelNombre.add(lblTextNombreActual);
		lblTextNombreActual.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblTextNombreActual.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfNombreActual = new JTextField();
		tfNombreActual.setBounds(95, 32, 140, 25);
		panelNombre.add(tfNombreActual);
		tfNombreActual.setColumns(10);
		
		lblTextNombreNuevo = new JLabel("Nombre Nuevo:");
		lblTextNombreNuevo.setBounds(10, 65, 307, 25);
		panelNombre.add(lblTextNombreNuevo);
		lblTextNombreNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextNombreNuevo.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		
		tfNombreNuevo = new JTextField();
		tfNombreNuevo.setBounds(95, 90, 140, 25);
		tfNombreNuevo.setBorder(null);
		panelNombre.add(tfNombreNuevo);
		tfNombreNuevo.setColumns(10);
		
		lblTextActualPass_1 = new JLabel("Contrase\u00F1a Actual:");
		lblTextActualPass_1.setBounds(10, 132, 156, 19);
		panelNombre.add(lblTextActualPass_1);
		lblTextActualPass_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextActualPass_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		pwActualPassName = new JPasswordField();
		pwActualPassName.setBounds(177, 132, 140, 20);
		panelNombre.add(pwActualPassName);
		
		panelContraseña = new JPanel();
		panelContraseña.setBackground(Color.RED);
		panelContraseña.setBounds(10, 10, 327, 162);
		panelCambios.add(panelContraseña);
		panelContraseña.setLayout(null);
		
		lblTextNewPass = new JLabel("Nueva Contrase\u00F1a:");
		lblTextNewPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextNewPass.setBounds(10, 8, 307, 19);
		panelContraseña.add(lblTextNewPass);
		lblTextNewPass.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		
		pwNewPass = new JPasswordField();
		pwNewPass.setBounds(95, 32, 140, 25);
		panelContraseña.add(pwNewPass);
		
		lblTextActualPass = new JLabel("Contrase\u00F1a Actual:");
		lblTextActualPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextActualPass.setBounds(10, 132, 156, 19);
		panelContraseña.add(lblTextActualPass);
		lblTextActualPass.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		pwActualPassCont = new JPasswordField();
		pwActualPassCont.setBounds(177, 132, 140, 20);
		panelContraseña.add(pwActualPassCont);
		
		lblRepiteContraseña = new JLabel("Repite Contrase\u00F1a:");
		lblRepiteContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepiteContraseña.setBounds(10, 65, 307, 25);
		panelContraseña.add(lblRepiteContraseña);
		lblRepiteContraseña.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		
		pwRepitePass = new JPasswordField();
		pwRepitePass.setBounds(95, 90, 140, 25);
		panelContraseña.add(pwRepitePass);
		
		panelBaseText = new JPanel();
		panelBaseText.setBackground(new Color(240, 240, 240));
		panelBaseText.setBounds(10, 10, 327, 162);
		panelCambios.add(panelBaseText);
		panelBaseText.setLayout(null);
		
		lblPanelDe = new JLabel("PANEL DE");
		lblPanelDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPanelDe.setFont(new Font("Lucida Console", Font.BOLD, 36));
		lblPanelDe.setBounds(0, 55, 327, 51);
		panelBaseText.add(lblPanelDe);
		
		lblConfiguraciones = new JLabel("CONFIGURACIONES");
		lblConfiguraciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguraciones.setFont(new Font("Lucida Console", Font.BOLD, 34));
		lblConfiguraciones.setBounds(0, 110, 327, 51);
		panelBaseText.add(lblConfiguraciones);
		
		lblBienvenida = new JLabel("Bienvenido a la configuraci\u00F3n de usuario");
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setBounds(109, 143, 440, 40);
		frame.getContentPane().add(lblBienvenida);
		
		panelRojoSuperior = new JPanel();
		panelRojoSuperior.setLayout(null);
		panelRojoSuperior.setBackground(Color.RED);
		panelRojoSuperior.setBounds(0, 0, 652, 56);
		frame.getContentPane().add(panelRojoSuperior);
		
		lblConfiguracion = new JLabel("Configuraci\u00F3n");
		lblConfiguracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracion.setForeground(Color.WHITE);
		lblConfiguracion.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblConfiguracion.setBounds(185, 10, 256, 34);
		panelRojoSuperior.add(lblConfiguracion);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 17, 89, 23);
		panelRojoSuperior.add(btnVolver);
		btnVolver.setFont(new Font("Verdana", Font.BOLD, 14));
		btnVolver.setBorder(null);
		
		setBasePanel();
	}
	
	public void setListeners() {
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				pokedex.setVisible(true);
			}
		});
		
		btnCambiarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNombrePanel();
			}
		});
		
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPassPanel();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBasePanel();
			}
		});
	}
	
	public void setBasePanel() {
		btnCancelar.setVisible(false);
		btnConfirmar.setVisible(false);
		panelNombre.setVisible(false);
		panelContraseña.setVisible(false);
		panelBaseText.setVisible(true);
		tfNombreActual.setText(null);
		tfNombreNuevo.setText(null);
		pwActualPassName.setText(null);
		pwActualPassCont.setText(null);
		pwNewPass.setText(null);
		pwRepitePass.setText(null);
		modo = 0;
	}
	
	public void setNombrePanel() {
		btnCancelar.setVisible(true);
		btnConfirmar.setVisible(true);
		panelNombre.setVisible(true);
		panelContraseña.setVisible(false);
		panelBaseText.setVisible(false);
		pwActualPassCont.setText(null);
		pwNewPass.setText(null);
		pwRepitePass.setText(null);
		modo = 1;
	}
	
	public void setPassPanel() {
		btnCancelar.setVisible(true);
		btnConfirmar.setVisible(true);
		panelNombre.setVisible(false);
		panelContraseña.setVisible(true);
		panelBaseText.setVisible(false);
		tfNombreActual.setText(null);
		tfNombreNuevo.setText(null);
		pwActualPassName.setText(null);
		modo = 2;
	}
}
