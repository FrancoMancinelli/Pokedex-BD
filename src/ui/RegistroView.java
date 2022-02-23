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
		lblUsuarioReg.setBounds(218, 192, 100, 30);
		frmRegistro.getContentPane().add(lblUsuarioReg);

		textUsuarioReg = new JTextField();
		textUsuarioReg.setFont(new Font("Verdana", Font.PLAIN, 16));
		textUsuarioReg.setBounds(328, 196, 160, 30);
		frmRegistro.getContentPane().add(textUsuarioReg);
		textUsuarioReg.setColumns(10);

		lblContrase�a1 = new JLabel("Contrase\u00F1a:");
		lblContrase�a1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContrase�a1.setBounds(182, 229, 136, 30);
		frmRegistro.getContentPane().add(lblContrase�a1);

		lblContrase�a2 = new JLabel("Repite Contrase\u00F1a:");
		lblContrase�a2.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblContrase�a2.setBounds(107, 270, 210, 30);
		frmRegistro.getContentPane().add(lblContrase�a2);

		btnRegistrarseReg = new JButton("Registrarse");
		btnRegistrarseReg.setForeground(new Color(255, 255, 255));
		btnRegistrarseReg.setBackground(new Color(0, 51, 204));
		btnRegistrarseReg.setFont(new Font("Verdana", Font.BOLD, 18));
		btnRegistrarseReg.setBounds(224, 331, 180, 44);
		frmRegistro.getContentPane().add(btnRegistrarseReg);

		pFldContrase�a1 = new JPasswordField();
		pFldContrase�a1.setFont(new Font("Verdana", Font.PLAIN, 16));
		pFldContrase�a1.setBounds(328, 233, 160, 30);
		frmRegistro.getContentPane().add(pFldContrase�a1);

		pFldContrase�a2 = new JPasswordField();
		pFldContrase�a2.setFont(new Font("Verdana", Font.PLAIN, 16));
		pFldContrase�a2.setBounds(328, 271, 160, 30);
		frmRegistro.getContentPane().add(pFldContrase�a2);

		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(RegistroView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(171, 89, 256, 104);
		frmRegistro.getContentPane().add(lblPokedex);
		
				btnVolver = new JButton("Volver");
				btnVolver.setBounds(75, 76, 89, 30);
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
		String passwd1 = new String (pFldContrase�a1.getPassword());
		String passwd2 = new String (pFldContrase�a2.getPassword());

		if (!textUsuarioReg.getText().isEmpty() && !passwd1.isEmpty() && !passwd2.isEmpty()) {
			if(!uDAO.usuariosExistente(textUsuarioReg.getText())) {
				if(textUsuarioReg.getText().length() > 3 && textUsuarioReg.getText().length() < 11) {
					if(!checkSpaces(textUsuarioReg.getText())) {
						if(passwd1.equals(passwd2)) { //Comprueba que la clave introducida sea la misma
							if(!checkSpaces(passwd1)) {
								if(passwd1.length() > 3 && passwd1.length() <= 15) {
									Usuario u = new Usuario(0, textUsuarioReg.getText(), passwd1);
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