package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dao.UsersDAO;
import models.Usuario;

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
	private JPanel panelSuperior;
	private UsersDAO userDAO;
	@SuppressWarnings("unused")
	private Usuario usuario;
	private int pagina;
	private JFrame frmLoginView;
	private JPanel panelBotones;
	private JLabel imgPikaSad;
	private JLabel imgfondo1;
	private JLabel imgfondo2;
	private JLabel imgfondo3;
	
	/**
	 * Create the application.
	 */
	public ConfigView(JFrame pokedex, String username, String password, int pagina, JFrame loginview) {
		this.pokedex = pokedex;
		this.username = username;
		this.password = password;
		this.pagina = pagina;
		this.frmLoginView = loginview;
		this.userDAO = new UsersDAO();
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
	
	/**
	 * Configure los componentes gráficos de la view
	 */
	public void setUIComponents() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setTitle("Pokedex - Configuración");
		frame.setBounds(100, 100, 665, 495);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelCambios = new JPanel();
		panelCambios.setBounds(268, 205, 347, 219);
		frame.getContentPane().add(panelCambios);
		panelCambios.setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnConfirmar.setBounds(212, 178, 100, 30);
		btnConfirmar.setBackground(new Color(177, 228, 107));
		panelCambios.add(btnConfirmar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCancelar.setBounds(38, 178, 100, 30);
		btnCancelar.setBackground(new Color(177, 228, 107));
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
		tfNombreActual.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		tfNombreActual.setHorizontalAlignment(SwingConstants.CENTER);
		tfNombreActual.setEditable(false);
		tfNombreActual.setBounds(95, 32, 140, 25);
		tfNombreActual.setBorder(null);
		panelNombre.add(tfNombreActual);
		tfNombreActual.setColumns(10);
		
		lblTextNombreNuevo = new JLabel("Nombre Nuevo:");
		lblTextNombreNuevo.setBounds(10, 65, 307, 25);
		panelNombre.add(lblTextNombreNuevo);
		lblTextNombreNuevo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextNombreNuevo.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		
		tfNombreNuevo = new JTextField();
		tfNombreNuevo.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		tfNombreNuevo.setHorizontalAlignment(SwingConstants.CENTER);
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
		pwActualPassName.setBorder(null);
		panelNombre.add(pwActualPassName);
		
		panelContraseña = new JPanel();
		panelContraseña.setBackground(new Color(51, 102, 204));
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
		pwNewPass.setBorder(null);
		panelContraseña.add(pwNewPass);
		
		lblTextActualPass = new JLabel("Contrase\u00F1a Actual:");
		lblTextActualPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextActualPass.setBounds(10, 132, 156, 19);
		panelContraseña.add(lblTextActualPass);
		lblTextActualPass.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		
		pwActualPassCont = new JPasswordField();
		pwActualPassCont.setBounds(177, 132, 140, 20);
		pwActualPassCont.setBorder(null);
		panelContraseña.add(pwActualPassCont);
		
		lblRepiteContraseña = new JLabel("Repite Contrase\u00F1a:");
		lblRepiteContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepiteContraseña.setBounds(10, 65, 307, 25);
		panelContraseña.add(lblRepiteContraseña);
		lblRepiteContraseña.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		
		pwRepitePass = new JPasswordField();
		pwRepitePass.setBounds(95, 90, 140, 25);
		pwRepitePass.setBorder(null);
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
		
		imgPikaSad = new JLabel("");
		imgPikaSad.setBounds(43, 0, 256, 219);
		imgPikaSad.setIcon(new ImageIcon(PokedexView.class.getResource("/img/pikasad.jpg")));
		panelCambios.add(imgPikaSad);
		
		panelRojoSuperior = new JPanel();
		panelRojoSuperior.setLayout(null);
		panelRojoSuperior.setBackground(Color.RED);
		panelRojoSuperior.setBounds(0, 0, 652, 56);
		frame.getContentPane().add(panelRojoSuperior);
		
		lblConfiguracion = new JLabel("Configuraci\u00F3n");
		lblConfiguracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracion.setForeground(Color.WHITE);
		lblConfiguracion.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblConfiguracion.setBounds(182, 11, 278, 34);
		panelRojoSuperior.add(lblConfiguracion);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(10, 17, 89, 23);
		panelRojoSuperior.add(btnVolver);
		btnVolver.setFont(new Font("Verdana", Font.BOLD, 14));
		btnVolver.setBorder(null);
		
		panelSuperior = new JPanel();
		panelSuperior.setBounds(36, 67, 579, 120);
		frame.getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		lblPokedex = new JLabel("");
		lblPokedex.setBounds(152, 2, 256, 104);
		panelSuperior.add(lblPokedex);
		lblPokedex.setIcon(new ImageIcon(ConfigView.class.getResource("/img/pokemon.png")));
		
		lblBienvenida = new JLabel("Bienvenido a la configuraci\u00F3n de usuario");
		lblBienvenida.setBounds(0, 84, 579, 36);
		panelSuperior.add(lblBienvenida);
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblBienvenida.setForeground(Color.BLACK);
		
		imgfondo1 = new JLabel("");
		imgfondo1.setBounds(0, -84, 579, 206);
		panelSuperior.add(imgfondo1);
		imgfondo1.setIcon(new ImageIcon(ConfigView.class.getResource("/img/fondo.jpg")));
		
		panelBotones = new JPanel();
		panelBotones.setBounds(36, 205, 222, 219);
		panelBotones.setBackground(new Color(127, 172, 113));
		frame.getContentPane().add(panelBotones);
		panelBotones.setLayout(null);
		
		btnCambiarNombre = new JButton("Cambiar Nombre");
		btnCambiarNombre.setBounds(16, 11, 190, 54);
		panelBotones.add(btnCambiarNombre);
		btnCambiarNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnCambiarNombre.setForeground(new Color(255, 255, 255));
		btnCambiarNombre.setBackground(new Color(51, 102, 204));
		btnCambiarNombre.setBorder(null);
		
		btnCambiarContrasea = new JButton("Cambiar Password");
		btnCambiarContrasea.setBounds(16, 76, 190, 54);
		panelBotones.add(btnCambiarContrasea);
		btnCambiarContrasea.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnCambiarContrasea.setForeground(new Color(255, 255, 255));
		btnCambiarContrasea.setBackground(new Color(51, 102, 204));
		btnCambiarContrasea.setBorder(null);
		
		btnBorrarCuenta = new JButton("Borrar Cuenta");
		btnBorrarCuenta.setForeground(Color.BLACK);
		btnBorrarCuenta.setBounds(16, 163, 190, 50);
		panelBotones.add(btnBorrarCuenta);
		btnBorrarCuenta.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnBorrarCuenta.setBackground(new Color(177, 228, 107));
		btnBorrarCuenta.setBorder(null);
		
		imgfondo2 = new JLabel("");
		imgfondo2.setBounds(0, -231, 222, 450);
		panelBotones.add(imgfondo2);
		imgfondo2.setIcon(new ImageIcon(ConfigView.class.getResource("/img/fondo.jpg")));
		
		imgfondo3 = new JLabel("");
		imgfondo3.setBounds(-231, -231, 590, 450);
		imgfondo3.setIcon(new ImageIcon(ConfigView.class.getResource("/img/fondo.jpg")));
		panelCambios.add(imgfondo3);

		setBasePanel();
	}
	
	/**
	 * Configura las acciones de los botones
	 */
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
		
		btnBorrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgPikaSad.setVisible(true);
				panelBaseText.setVisible(false);
				panelNombre.setVisible(false);
				panelContraseña.setVisible(false);
				btnConfirmar.setVisible(false);
				btnCancelar.setVisible(false);
				panelCambios.setBackground(Color.DARK_GRAY);
				imgfondo3.setVisible(false);
				int confirmar = JOptionPane.showConfirmDialog(btnBorrarCuenta,
						"¿Estás seguro de que deseas borrar tu cuenta?");
				if (confirmar == 0) { // Confirma borrar
					JOptionPane.showMessageDialog(btnBorrarCuenta, "Bueno adiós, usted se lo pierde");
					userDAO.deleteUsuario(username);
					frame.dispose();
					new LoginView();
				} else {
					if(modo == 0) { //Si el modo es 0 se entiende como modo Base
						imgPikaSad.setVisible(false);
						panelBaseText.setVisible(true);
						imgfondo3.setVisible(false);
						panelCambios.setBackground(new Color(240, 240, 240));
					} else if(modo == 1) { //Si el modo es 1 se entiende como modo CambioNombre
						imgPikaSad.setVisible(false);
						panelNombre.setVisible(true);
						btnConfirmar.setVisible(true);
						btnCancelar.setVisible(true);
						imgfondo3.setVisible(true);
						panelCambios.setBackground(new Color(127, 172, 113));
					} else if (modo == 2) { //Si el modo es 2 se entiende como modo CambioContraseña
						imgPikaSad.setVisible(false);
						panelContraseña.setVisible(true);
						btnConfirmar.setVisible(true);
						btnCancelar.setVisible(true);
						imgfondo3.setVisible(true);
						panelCambios.setBackground(new Color(127, 172, 113));
					} 
				}
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modo == 1) {
					confirmarCambioNombre();
				} else if (modo == 2) {
					confirmarCambioPass();
				}
			}
		});
	}
	
	/**
	 * Configura la vista para que se vea en estado base
	 */
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
		imgPikaSad.setVisible(false);
		imgfondo3.setVisible(false);
		panelCambios.setBackground(new Color(240, 240, 240));
		modo = 0;
	}
	
	/**
	 * Configura la vista para que se vea en estado cambio de nombre
	 */
	public void setNombrePanel() {
		btnCancelar.setVisible(true);
		btnConfirmar.setVisible(true);
		panelNombre.setVisible(true);
		panelContraseña.setVisible(false);
		panelBaseText.setVisible(false);
		pwActualPassCont.setText(null);
		pwNewPass.setText(null);
		pwRepitePass.setText(null);
		tfNombreActual.setText(username);
		imgPikaSad.setVisible(false);
		imgfondo3.setVisible(true);
		panelCambios.setBackground(new Color(127, 172, 113));
		modo = 1;
	}
	
	/**
	 * Configura la vista para que se vea en estado cambio de contraseña
	 */
	public void setPassPanel() {
		btnCancelar.setVisible(true);
		btnConfirmar.setVisible(true);
		panelNombre.setVisible(false);
		panelContraseña.setVisible(true);
		panelBaseText.setVisible(false);
		tfNombreActual.setText(null);
		tfNombreNuevo.setText(null);
		pwActualPassName.setText(null);
		imgPikaSad.setVisible(false);
		imgfondo3.setVisible(true);
		panelCambios.setBackground(new Color(127, 172, 113));
		modo = 2;
	}
	
	/**
	 * Método que comprueba los datos introducidos para el cambio de nombre
	 * Si los datos son correctos según las condiciones se ejecutara la
	 * actualización, de lo contrario señalizará donde esta el fallo
	 */
	public void confirmarCambioNombre() {
		String passwd = new String (pwActualPassName.getPassword());
		if(!tfNombreNuevo.getText().isEmpty() && !passwd.isEmpty()) { //Si los campos a rellenar NO estan vacios...
			if(!tfNombreNuevo.getText().equals(tfNombreActual.getText())) { //Si el nombre nuevo NO es igual al anterior...
				if(!userDAO.usuariosExistente(tfNombreNuevo.getText())) { //Si el nuevo nombre de usuario NO está utilizado...
					if(tfNombreNuevo.getText().length() >= 4 && tfNombreNuevo.getText().length() <= 12) { //Si el nombre cumple con la longitud requerida...
						if(!checkSpaces(tfNombreNuevo.getText())) { //Si el nuevo nombre no contiene espacios...
							if(passwd.equals(this.password)) { //Si la contraseña de confirmación coincide con la contraseña actual del usuario...
								int confirmar = JOptionPane.showConfirmDialog(btnBorrarCuenta,
										"¿Estás seguro de que deseas guardar los cambios?");
								if (confirmar == 0) { // Confirma borrar
									JOptionPane.showMessageDialog(btnConfirmar, "Nombre actualizado con éxito");
									userDAO.updateNombre(tfNombreActual.getText(), tfNombreNuevo.getText());
									frame.dispose();
									pokedex.dispose(); //Cierro la pokedex antigua para que se vea actualizado el nuevo nombre en ella
									new PokedexView(tfNombreNuevo.getText(), frmLoginView, pagina, passwd);
								}
							} else {
								JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  La contraseña es incorrecta");
							}
						} else {
							JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  El nombre no puede estar compuesto por espacios");
						}
					} else {
						JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  El nombre debe tener al menos 4 caracteres y máximo 12");
					}
				} else {
					JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! - El nombre de usuario ya existe");
				}
			} else {
				JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  El nombre a cambiar es igual al actual");
			}
		} else {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Asegurate de rellenar todos los campos");
		}
	}
	
	/**
	 * Método que comprueba los datos introducidos para el cambio de password
	 * Si los datos son correctos según las condiciones se ejecutara la
	 * actualización, de lo contrario señalizará donde esta el fallo
	 */
	public void confirmarCambioPass() {
		String passwdActual = new String (pwActualPassCont.getPassword());
		String passwdNueva1 = new String (pwNewPass.getPassword());
		String passwdNueva2 = new String (pwRepitePass.getPassword());
		if(!passwdActual.isEmpty() && !passwdNueva1.isEmpty() && !passwdNueva2.isEmpty()) { //Si los campos no estan vacios...
			if(passwdNueva1.equals(passwdNueva2)) { //Si las nuevas contraseñas coinciden...
				if(!passwdActual.equals(passwdNueva1)) { //Si la contraseña nueva NO es la misma a la actual...
					if(passwdNueva1.length() >= 4 && passwdNueva1.length() <= 16) { //Si la contraseña nueva no mide lo permitido...
						if(!checkSpaces(passwdNueva1)) { //Si la contraseña nueva NO contiene espacios...
							if(passwdActual.equals(this.password)) { //Si la contraseña de confirmación coincide con la contraseña actual...
								int confirmar = JOptionPane.showConfirmDialog(btnBorrarCuenta,
										"¿Estás seguro de que deseas guardar los cambios?");
								if (confirmar == 0) { // Confirma borrar
									JOptionPane.showMessageDialog(btnConfirmar, "Contraseña actualizada con éxito");
									userDAO.updatePassword(passwdNueva1, username);
									frame.dispose();
									pokedex.dispose(); //Cierro la view y la vuelvo a crear para que salgan reflejados los cambios en la Pokedex
									new PokedexView(username, frmLoginView, pagina, passwdNueva1);
								}
							} else {
								JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  La contraseña actual es incorrecta");
							}
						} else {
							JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  La constraseña no puede estar compuesto por espacios");
						}
					} else {
						JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  La contraseña debe tener al menos 4 caracteres y máximo 16");
					}
				} else {
					JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  La nueva contraseña es igual a la anterior");
				}
			} else {
				JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Las contraseñas nuevas no coinciden");
			}
		} else {
			JOptionPane.showMessageDialog(btnConfirmar, "ERR0R! -  Asegurate de rellenar todos los campos");
		}
	}
	
	/**
	 * Comprueba si un String contiene algún espacio
	 * @param s String a analizar
	 * @return True si el string tiene un espacio, False en caso contrario
	 */
	public boolean checkSpaces(String s) {
		if(s.indexOf(' ') != -1)
			return true;
		return false;
	}
}
