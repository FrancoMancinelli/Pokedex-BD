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
	private JLabel lblContrase�a1;
	private JLabel lblContrase�a2;
	private JButton btnRegistrarseReg;
	private JPasswordField pFldContrase�a1;
	private JPasswordField pFldContrase�a2;
	private JButton btnVolver;
	private JFrame loginView;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_1_1;
	private JLabel lblPokedex;
	private UsersDAO usuarioDAO;


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
	 * Configura la interfaz gr�fica de la ventana
	 */
	private void setUIComponents() {
		frmRegistro.setTitle("Pokedex - Registro");
		frmRegistro.setBounds(100, 100, 655, 495);
		frmRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		frmRegistro.setVisible(true);

		lblUsuarioReg = new JLabel("Usuario:");
		lblUsuarioReg.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblUsuarioReg.setBounds(260, 200, 100, 30);
		frmRegistro.getContentPane().add(lblUsuarioReg);

		textUsuarioReg = new JTextField();
		textUsuarioReg.setBounds(370, 204, 120, 30);
		frmRegistro.getContentPane().add(textUsuarioReg);
		textUsuarioReg.setColumns(10);

		lblContrase�a1 = new JLabel("Contrase\u00F1a:");
		lblContrase�a1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContrase�a1.setBounds(224, 237, 136, 30);
		frmRegistro.getContentPane().add(lblContrase�a1);

		lblContrase�a2 = new JLabel("Repite Contrase\u00F1a:");
		lblContrase�a2.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContrase�a2.setBounds(150, 278, 210, 30);
		frmRegistro.getContentPane().add(lblContrase�a2);

		btnRegistrarseReg = new JButton("Registrarse");
		btnRegistrarseReg.setForeground(new Color(255, 255, 255));
		btnRegistrarseReg.setBackground(new Color(0, 51, 204));
		btnRegistrarseReg.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnRegistrarseReg.setBounds(245, 319, 144, 36);
		frmRegistro.getContentPane().add(btnRegistrarseReg);

		pFldContrase�a1 = new JPasswordField();
		pFldContrase�a1.setBounds(370, 241, 120, 30);
		frmRegistro.getContentPane().add(pFldContrase�a1);

		pFldContrase�a2 = new JPasswordField();
		pFldContrase�a2.setBounds(370, 278, 120, 30);
		frmRegistro.getContentPane().add(pFldContrase�a2);

		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 649, 78);
		frmRegistro.getContentPane().add(panel);
		panel.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(255, 255, 255));
		btnVolver.setFont(new Font("Verdana", Font.BOLD, 14));
		btnVolver.setBounds(10, 17, 89, 23);
		panel.add(btnVolver);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 73, 55, 325);
		frmRegistro.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(0, 378, 649, 78);
		frmRegistro.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.RED);
		panel_1_1.setBounds(594, 73, 55, 325);
		frmRegistro.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);

		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(RegistroView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(171, 89, 256, 104);
		frmRegistro.getContentPane().add(lblPokedex);
	}

	/**
	 * Configura las acciones al presionar un bot�n
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
		
		pFldContrase�a1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 realizarRegistro();
				}
		});
		
		pFldContrase�a2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 realizarRegistro();
				}
		});
		
	}
	
	public boolean checkSpaces(String s) {
		int index = s.indexOf(' ');
		if(index != -1)
			return true;
		return false;
	}
	
	public void realizarRegistro() {
		UsersDAO uDAO = new UsersDAO();
		String usuario = textUsuarioReg.getText();
		String passwd1 = new String (pFldContrase�a1.getPassword());
		String passwd2 = new String (pFldContrase�a2.getPassword());

		if (!usuario.isEmpty() && !passwd1.isEmpty() && !passwd2.isEmpty()) {
			if(!uDAO.usuariosExistente(usuario)) {
				if(usuario.length() > 3 && usuario.length() < 11) {
					if(!checkSpaces(usuario)) {
						if(passwd1.equals(passwd2)) { //Comprueba que la clave introducida sea la misma
							if(!checkSpaces(passwd1)) {
								if(passwd1.length() > 3 && passwd1.length() <= 15) {
									Usuario u = new Usuario(0, usuario, passwd1);
									try {
										usuarioDAO.registro(u);
										JOptionPane.showMessageDialog(btnRegistrarseReg, "Te has registrado con �xito");
										frmRegistro.dispose();
										new LoginView();
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  Algo no salio bien D:");
									}
								} else {
									JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  La contrase�a debe tener al menos 4 caracteres y m�ximo 16");
								}
							} else {
								JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  La constrase�a no puede estar compuesto por espacios");
							}
						} else {
							JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  Las contrase�as no coinciden");
						}
					} else {
						JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  El nombre no puede estar compuesto por espacios");
					}
				} else {
					JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! -  El nombre debe tener al menos 4 caracteres y m�ximo 12");
				}
			} else {
				JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! - El nombre de usuario ya existe");
			}
		} else {
			JOptionPane.showMessageDialog(btnRegistrarseReg, "ERR0R! - Rellena todos los campos");

		}
	}
} //CIERRE CLASE