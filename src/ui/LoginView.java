package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.UsersDAO;
import models.Usuario;

public class LoginView {

	@SuppressWarnings("unused")
	private JFrame frame;
	private JFrame frmPokedexMen;
	private JLabel lblNomUsuario;
	private JTextField textNomUsuario;
	private JLabel lblPassword;
	private JPasswordField pfilePassword;
	private JButton btnEntrar;
	private JButton btnRegistrarse;
	private JLabel lblPokedex;
	private UsersDAO usuarioDAO;
	private JPanel panelRojoDeco1;
	private JPanel panelRojoDeco2;
	private JPanel panelRojoDeco3;
	private JPanel panelRojoDeco4;
	private JPanel panelGrisDeco1;
	private JPanel panelGrisDeco2;
	private JPanel panelGrisDeco3;
	private JPanel panelGrisDeco4;
	private JLabel imgfondo;

	/**
	 * Create the application.
	 */
	public LoginView() {
		
		this.usuarioDAO = new UsersDAO();
		initialize();
		frmPokedexMen.setVisible(true);	

		}


	/**
	 * Inicializa el contenido del frame.
	 */
	private void initialize() {
		frame = new JFrame();
		setUIComponents();
		setListeners();
	}

	//M�todos
	/**
	 * Configura la interfaz gr�fica de la ventana
	 */
	private void setUIComponents() {
		frmPokedexMen = new JFrame();
		frmPokedexMen.setTitle("Pokedex - Inicio");
		frmPokedexMen.setBounds(100, 100, 665, 495);
		frmPokedexMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedexMen.getContentPane().setLayout(null);

		lblNomUsuario = new JLabel("Usuario:");
		lblNomUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNomUsuario.setBounds(185, 204, 110, 28);
		frmPokedexMen.getContentPane().add(lblNomUsuario);

		textNomUsuario = new JTextField();
		textNomUsuario.setFont(new Font("Verdana", Font.PLAIN, 16));
		textNomUsuario.setBounds(305, 197, 144, 35);
		frmPokedexMen.getContentPane().add(textNomUsuario);
		textNomUsuario.setColumns(10);

		lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblPassword.setBounds(147, 243, 151, 35);
		frmPokedexMen.getContentPane().add(lblPassword);

		pfilePassword = new JPasswordField();
		pfilePassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		pfilePassword.setBounds(305, 243, 144, 35);
		frmPokedexMen.getContentPane().add(pfilePassword);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Verdana", Font.BOLD, 18));
		btnEntrar.setBackground(new Color(0, 51, 204));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBounds(251, 289, 127, 39);
		frmPokedexMen.getContentPane().add(btnEntrar);

		btnRegistrarse = new JButton("Registrate");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setFont(new Font("Verdana", Font.BOLD, 18));
		btnRegistrarse.setBackground(new Color(0, 51, 204));
		btnRegistrarse.setBounds(225, 339, 176, 44);
		frmPokedexMen.getContentPane().add(btnRegistrarse);
		
		panelGrisDeco1 = new JPanel();
		panelGrisDeco1.setBackground(Color.DARK_GRAY);
		panelGrisDeco1.setBounds(0, 28, 27, 420);
		frmPokedexMen.getContentPane().add(panelGrisDeco1);
		
		panelGrisDeco2 = new JPanel();
		panelGrisDeco2.setBackground(Color.DARK_GRAY);
		panelGrisDeco2.setBounds(621, 27, 28, 420);
		frmPokedexMen.getContentPane().add(panelGrisDeco2);
		
		panelGrisDeco3 = new JPanel();
		panelGrisDeco3.setBackground(Color.DARK_GRAY);
		panelGrisDeco3.setBounds(0, 0, 649, 31);
		frmPokedexMen.getContentPane().add(panelGrisDeco3);
		
		panelGrisDeco4 = new JPanel();
		panelGrisDeco4.setBackground(Color.DARK_GRAY);
		panelGrisDeco4.setBounds(0, 425, 649, 31);
		frmPokedexMen.getContentPane().add(panelGrisDeco4);
		
		panelRojoDeco1 = new JPanel();
		panelRojoDeco1.setBackground(Color.RED);
		panelRojoDeco1.setBounds(0, 0, 649, 62);
		frmPokedexMen.getContentPane().add(panelRojoDeco1);

		panelRojoDeco2 = new JPanel();
		panelRojoDeco2.setBackground(Color.RED);
		panelRojoDeco2.setBounds(0, 51, 55, 347);
		frmPokedexMen.getContentPane().add(panelRojoDeco2);

		panelRojoDeco3 = new JPanel();
		panelRojoDeco3.setBackground(Color.RED);
		panelRojoDeco3.setBounds(594, 51, 55, 347);
		frmPokedexMen.getContentPane().add(panelRojoDeco3);

		panelRojoDeco4 = new JPanel();
		panelRojoDeco4.setBackground(Color.RED);
		panelRojoDeco4.setBounds(0, 394, 649, 62);
		frmPokedexMen.getContentPane().add(panelRojoDeco4);

		lblPokedex = new JLabel("");
		lblPokedex.setBounds(176, 89, 256, 104);
		lblPokedex.setIcon(new ImageIcon(LoginView.class.getResource("/img/pokemon.png")));
		frmPokedexMen.getContentPane().add(lblPokedex);
		
		imgfondo = new JLabel("");
		imgfondo.setBounds(53, 51, 541, 347);
		frmPokedexMen.getContentPane().add(imgfondo);
		imgfondo.setIcon(new ImageIcon(LoginView.class.getResource("/img/fondo.jpg")));
		
	}

	/**
	 * Configura las acciones al presionar un bot�n
	 */
	private void setListeners() {
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				analizarDatosAcceso();			
			}
		});

		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedexMen.setVisible(false);
				new RegistroView(frmPokedexMen);
			}
		});

		pfilePassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 analizarDatosAcceso();
				}
		});
	}

	/**
	 * Verifica los datos introducidos para acceder a la pokedex
	 */
	private void analizarDatosAcceso() {
		String username = textNomUsuario.getText();
		String password = new String (pfilePassword.getPassword());
		Usuario usuario = new Usuario(0, username, password);
		boolean loginCorrecto = usuarioDAO.login(usuario);
		if (loginCorrecto) {
			JOptionPane.showMessageDialog(btnEntrar, "Login Correcto. Bienvenid@ "+username);
			new PokedexView(username, frmPokedexMen, 0, password);
			frmPokedexMen.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(btnEntrar, "                                ERR0R 203 - Login Incorrecto.\nAsegurate de haber introducido correctamente el usuario y contrase�a");
		}
	}
} 
