package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.UsersDAO;
import models.Usuario;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class RegistroView {

	private JFrame frmRegistro;
	private JTextField textUsuarioReg;
	private JLabel lblUsuarioReg;
	private JLabel lblContraseña1;
	private JLabel lblContraseña2;
	private JButton btnRegistrarseReg;
	private JPasswordField pFldContraseña1;
	private JPasswordField pFldContraseña2;
	private JButton btnVolver;
	private JFrame loginView;
	private JLabel lblPokedex;
	private UsersDAO usuarioDAO;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel imgfondo;




	/**
	 * Create the application.
	 */
	public RegistroView(JFrame loginView) {
		initialize();
		this.loginView = loginView;
		this.usuarioDAO = new UsersDAO();
		frmRegistro.setVisible(true);
	}

	/**
	 * Inicializa el contenido del frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		setUIComponents();
		setListeners();
	}

	/**
	 * Configura la interfaz gráfica de la ventana
	 */
	private void setUIComponents() {
		frmRegistro.setTitle("Pokedex - Registro");
		frmRegistro.setBounds(100, 100, 655, 495);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		frmRegistro.setVisible(true);

		lblUsuarioReg = new JLabel("Usuario:");
		lblUsuarioReg.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblUsuarioReg.setBounds(218, 192, 100, 30);
		frmRegistro.getContentPane().add(lblUsuarioReg);

		textUsuarioReg = new JTextField();
		textUsuarioReg.setFont(new Font("Verdana", Font.PLAIN, 16));
		textUsuarioReg.setBounds(328, 196, 160, 30);
		frmRegistro.getContentPane().add(textUsuarioReg);
		textUsuarioReg.setColumns(10);

		lblContraseña1 = new JLabel("Contrase\u00F1a:");
		lblContraseña1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContraseña1.setBounds(182, 229, 136, 30);
		frmRegistro.getContentPane().add(lblContraseña1);

		lblContraseña2 = new JLabel("Repite Contrase\u00F1a:");
		lblContraseña2.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContraseña2.setBounds(107, 270, 210, 30);
		frmRegistro.getContentPane().add(lblContraseña2);

		btnRegistrarseReg = new JButton("Registrarse");
		btnRegistrarseReg.setForeground(new Color(255, 255, 255));
		btnRegistrarseReg.setBackground(new Color(0, 51, 204));
		btnRegistrarseReg.setFont(new Font("Verdana", Font.BOLD, 18));
		btnRegistrarseReg.setBounds(224, 331, 180, 44);
		frmRegistro.getContentPane().add(btnRegistrarseReg);

		pFldContraseña1 = new JPasswordField();
		pFldContraseña1.setFont(new Font("Verdana", Font.PLAIN, 16));
		pFldContraseña1.setBounds(328, 233, 160, 30);
		frmRegistro.getContentPane().add(pFldContraseña1);

		pFldContraseña2 = new JPasswordField();
		pFldContraseña2.setFont(new Font("Verdana", Font.PLAIN, 16));
		pFldContraseña2.setBounds(328, 271, 160, 30);
		frmRegistro.getContentPane().add(pFldContraseña2);

		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(RegistroView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(198, 91, 256, 104);
		frmRegistro.getContentPane().add(lblPokedex);
		
			btnVolver = new JButton("Volver");
			btnVolver.setBounds(65, 65, 85, 25);
			frmRegistro.getContentPane().add(btnVolver);
			btnVolver.setBackground(new Color(255, 255, 255));
			btnVolver.setFont(new Font("Verdana", Font.BOLD, 14));
				
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 639, 27);
			frmRegistro.getContentPane().add(panel);
			
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setBounds(0, 429, 639, 27);
			frmRegistro.getContentPane().add(panel_1);
			
			panel_2 = new JPanel();
			panel_2.setBackground(Color.DARK_GRAY);
			panel_2.setBounds(0, 0, 27, 455);
			frmRegistro.getContentPane().add(panel_2);
			
			panel_3 = new JPanel();
			panel_3.setBackground(Color.DARK_GRAY);
			panel_3.setBounds(612, 0, 27, 455);
			frmRegistro.getContentPane().add(panel_3);
			
			panel_4 = new JPanel();
			panel_4.setBackground(Color.RED);
			panel_4.setBounds(26, 25, 27, 405);
			frmRegistro.getContentPane().add(panel_4);
			
			panel_5 = new JPanel();
			panel_5.setBackground(Color.RED);
			panel_5.setBounds(585, 27, 27, 405);
			frmRegistro.getContentPane().add(panel_5);
			
			panel_6 = new JPanel();
			panel_6.setBackground(Color.RED);
			panel_6.setBounds(53, 25, 535, 27);
			frmRegistro.getContentPane().add(panel_6);
			
			panel_7 = new JPanel();
			panel_7.setBackground(Color.RED);
			panel_7.setBounds(53, 403, 535, 27);
			frmRegistro.getContentPane().add(panel_7);
			
			imgfondo = new JLabel("");
			imgfondo.setBounds(53, 49, 535, 358);
			imgfondo.setIcon(new ImageIcon(LoginView.class.getResource("/img/fondo.jpg")));
			frmRegistro.getContentPane().add(imgfondo);
	}

	/**
	 * Configura las acciones al presionar un botón o teclas
	 */
	private void setListeners() {
		btnRegistrarseReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarRegistro();
			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginView.setVisible(true);
				frmRegistro.dispose();
			}
		});
		
		textUsuarioReg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 realizarRegistro();
				}
		});
		
		pFldContraseña1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 realizarRegistro();
				}
		});
		
		pFldContraseña2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 realizarRegistro();
				}
		});
		
	}
	
	/**
	 * Comprueba si existen espacios en un String
	 * @return True en caso de encontrar algun espacio, False en caso de no encontrarlo
	 */
	public boolean checkSpaces(String s) {
		int index = s.indexOf(' ');
		if(index != -1)
			return true;
		return false;
	}
	
	/**
	 * Registra un nuevo Usuario en la base de datos según los datos introducidos
	 * en los TextFields
	 */
	public void realizarRegistro() {
		UsersDAO uDAO = new UsersDAO();
		String passwd1 = new String (pFldContraseña1.getPassword());
		String passwd2 = new String (pFldContraseña2.getPassword());

		if (!textUsuarioReg.getText().isEmpty() && !passwd1.isEmpty() && !passwd2.isEmpty()) { //Si los campos a rellenar NO estan vacios...
			if(!uDAO.usuariosExistente(textUsuarioReg.getText())) { //Si NO existe un Usuario con ese nombre...
				if(textUsuarioReg.getText().length() >= 4 && textUsuarioReg.getText().length() <= 12) { //Si el nombre cumple los requisitos de longitud...
					if(!checkSpaces(textUsuarioReg.getText())) { //Si el nombre NO lleva espacios...
						if(passwd1.equals(passwd2)) { //Si las claves introducidas sean las mismas...
							if(!checkSpaces(passwd1)) { //Si la clave NO lleva espacios...
								if(passwd1.length() >= 4 && passwd1.length() <= 16) { //Si la contraseña cumple los requisitos de longitud...
									Usuario u = new Usuario(0, textUsuarioReg.getText(), passwd1);
									try {
										usuarioDAO.registro(u);
										JOptionPane.showMessageDialog(btnRegistrarseReg, "Te has registrado con éxito");
										frmRegistro.dispose();
										new LoginView();
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  Algo no salio bien D:");
									}
								} else {
									JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  La contraseña debe tener al menos 4 caracteres y máximo 16");
								}
							} else {
								JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  La constraseña no puede estar compuesto por espacios");
							}
						} else {
							JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  Las contraseñas no coinciden");
						}
					} else {
						JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  El nombre no puede estar compuesto por espacios");
					}
				} else {
					JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  El nombre debe tener al menos 4 caracteres y máximo 12");
				}
			} else {
				JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! - El nombre de usuario ya existe");
			}
		} else {
			JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! - Rellena todos los campos");

		}
	}
} //CIERRE CLASE