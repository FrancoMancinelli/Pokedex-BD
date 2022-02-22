package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dao.PokemonDAO;
import dao.TiposDAO;
import models.Pokemon;
import models.Tipos;

import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class PokedexView {

	private JFrame frmPokedex;
	private JPanel panelRojoSuperior;
	private JLabel lblTituloPokedex;
	private JButton btnSalir;
	private JLabel lblNombreUser;
	private JTextField lblPokemonName;
	private JButton btnConfig;
	private JPanel panelFondoPokemon;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JLabel lblPokemonNumber;
	private JLabel lblImagenPokemon;
	private JLabel lblPokemonImg;
	private JPanel panelOpciones;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnCrear;
	private JSeparator separator;
	private JLabel lbltxtAltura;
	private JTextField lblDatoDeAltura;
	private JLabel lbltxtPeso;
	private JTextField lblDatoDePeso;
	private JLabel lbltxtCategoria;
	private JTextField lblDatoDeCategoria;
	private JLabel lbltxtHabilidad;
	private JTextField lblDatoDeHabilidad;
	private JLabel lblConfig;
	private JFrame frmLoginView;
	private String username;
	private int pagina;
	private PokemonDAO pokemonDAO;
	private ArrayList<Pokemon> pokemones;
	private JButton btnAceptarAct;
	private JButton btnCancelarAct;
	private JLabel lblTipo1;
	private JLabel lblTipo2;
	private JLabel lblDatoTipo1;
	private JLabel lblDatoTipo2;
	private JLabel lblPokedex;
	private JComboBox<String> cbTipo1Act;
	private JComboBox<String> cbTipo2Act;
	private ArrayList<Tipos> tipos1;
	private ArrayList<Tipos> tipos2;
	private TiposDAO tipos1DAO;
	private TiposDAO tipos2DAO;
	

	
	/**
	 * Create the application.
	 */
	public PokedexView(String username, JFrame LoginView, int pagina) {	
		this.frmLoginView = LoginView;
		this.username = username;
		this.pagina = pagina;
		this.pokemonDAO = new PokemonDAO();
		this.pokemones = pokemonDAO.getAll();
		this.tipos1DAO = new TiposDAO();
		this.tipos2DAO = new TiposDAO();
		this.tipos1 = tipos1DAO.getAllTipo1();
		this.tipos2 = tipos2DAO.getAllTipo2();
		initialize();
		printPokemon();
		
	}

	/**
	 * Inicializa el contenido del frame.
	 */
	public void initialize() {
		
		setUIComponents();
		setListeners();
		setActualizarOFF();
		
	}
	
	/**
	 * Configura la interfaz gráfica de la ventana
	 */
	private void setUIComponents() {
		frmPokedex = new JFrame();
		frmPokedex.getContentPane().setBackground(Color.DARK_GRAY);
		frmPokedex.setTitle("Pokedex - Men\u00FA");
		frmPokedex.setBounds(100, 100, 665, 495);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);
		
		panelRojoSuperior = new JPanel();
		panelRojoSuperior.setBackground(Color.RED);
		panelRojoSuperior.setBounds(0, 0, 652, 56);
		frmPokedex.getContentPane().add(panelRojoSuperior);
		panelRojoSuperior.setLayout(null);
		
		lblTituloPokedex = new JLabel("Pokedex");
		lblTituloPokedex.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblTituloPokedex.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPokedex.setBounds(230, 10, 187, 34);
		lblTituloPokedex.setForeground(Color.WHITE);
		panelRojoSuperior.add(lblTituloPokedex);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setForeground(null);
		btnSalir.setBounds(10, 17, 89, 23);
		btnSalir.setBorder(null);
		panelRojoSuperior.add(btnSalir);
		
		lblNombreUser = new JLabel(username);
		lblNombreUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombreUser.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNombreUser.setForeground(new Color(255, 255, 255));
		lblNombreUser.setBounds(441, 12, 156, 33);
		panelRojoSuperior.add(lblNombreUser);
		
		
		btnConfig = new JButton("");
		btnConfig.setIcon(new ImageIcon(PokedexView.class.getResource("/img/config2.png")));
		btnConfig.setBackground(Color.RED);
		btnConfig.setForeground(Color.RED);
		btnConfig.setBounds(607, 15, 29, 29);
		btnConfig.setBorder(null);
		panelRojoSuperior.add(btnConfig);
		
		panelFondoPokemon = new JPanel();
		panelFondoPokemon.setBackground(Color.WHITE);
		panelFondoPokemon.setBounds(68, 67, 515, 282);
		frmPokedex.getContentPane().add(panelFondoPokemon);
		panelFondoPokemon.setLayout(null);
		
		lblPokemonName = new JTextField("");
		lblPokemonName.setFont(new Font("Verdana", Font.BOLD, 24));
		lblPokemonName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonName.setBounds(35, 8, 208, 35);
		panelFondoPokemon.add(lblPokemonName);
		
		lblPokemonNumber = new JLabel("");
		lblPokemonNumber.setForeground(new Color(128, 128, 128));
		lblPokemonNumber.setFont(new Font("Verdana", Font.BOLD, 20));
		lblPokemonNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokemonNumber.setBounds(331, 15, 89, 27);
		panelFondoPokemon.add(lblPokemonNumber);
		
		lblPokemonImg = new JLabel();
		lblPokemonImg.setBounds(67, 80, 148, 152);
		lblPokemonImg.setIcon(pokemones.get(pagina).getImagen2());
		panelFondoPokemon.add(lblPokemonImg);
		
		separator = new JSeparator();
		separator.setBounds(35, 50, 435, 14);
		panelFondoPokemon.add(separator);
		
		lbltxtAltura = new JLabel("Altura:");
		lbltxtAltura.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtAltura.setBounds(279, 67, 85, 14);
		panelFondoPokemon.add(lbltxtAltura);
		
		lblDatoDeAltura = new JTextField("");
		lblDatoDeAltura.setForeground(new Color(128, 128, 128));
		lblDatoDeAltura.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDeAltura.setBounds(361, 67, 97, 20);
		panelFondoPokemon.add(lblDatoDeAltura);
		
		lbltxtPeso = new JLabel("Peso:");
		lbltxtPeso.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtPeso.setBounds(289, 94, 75, 28);
		panelFondoPokemon.add(lbltxtPeso);
		
		lblDatoDePeso = new JTextField("");
		lblDatoDePeso.setForeground(new Color(128, 128, 128));
		lblDatoDePeso.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDePeso.setBounds(361, 100, 97, 20);
		panelFondoPokemon.add(lblDatoDePeso);
		
		lbltxtCategoria = new JLabel("Categoria:");
		lbltxtCategoria.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtCategoria.setBounds(252, 130, 112, 28);
		panelFondoPokemon.add(lbltxtCategoria);
		
		lblDatoDeCategoria = new JTextField("");
		lblDatoDeCategoria.setForeground(new Color(128, 128, 128));
		lblDatoDeCategoria.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDeCategoria.setBounds(361, 135, 97, 20);
		panelFondoPokemon.add(lblDatoDeCategoria);
		
		lbltxtHabilidad = new JLabel("Habilidad:");
		lbltxtHabilidad.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lbltxtHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtHabilidad.setBounds(262, 165, 102, 27);
		panelFondoPokemon.add(lbltxtHabilidad);
		
		lblDatoDeHabilidad = new JTextField("");
		lblDatoDeHabilidad.setForeground(new Color(128, 128, 128));
		lblDatoDeHabilidad.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
		lblDatoDeHabilidad.setBounds(361, 169, 97, 20);
		panelFondoPokemon.add(lblDatoDeHabilidad);
		
		lblTipo1 = new JLabel("Tipo 1:");
		lblTipo1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblTipo1.setBounds(252, 205, 102, 27);
		panelFondoPokemon.add(lblTipo1);
		
		lblTipo2 = new JLabel("Tipo 2:");
		lblTipo2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblTipo2.setBounds(252, 244, 102, 27);
		panelFondoPokemon.add(lblTipo2);
		
		lblDatoTipo1 = new JLabel("");
		lblDatoTipo1.setBounds(361, 207, 97, 25);
		panelFondoPokemon.add(lblDatoTipo1);
		
		lblDatoTipo2 = new JLabel("");
		lblDatoTipo2.setBounds(361, 244, 97, 25);
		panelFondoPokemon.add(lblDatoTipo2);
		
		cbTipo1Act = new JComboBox<String>();
		cbTipo1Act.setBounds(361, 207, 97, 25);
		panelFondoPokemon.add(cbTipo1Act);
		
		cbTipo2Act = new JComboBox<String>();
		cbTipo2Act.setBounds(361, 244, 97, 27);
		panelFondoPokemon.add(cbTipo2Act);
		
		btnAnterior = new JButton("<");
		btnAnterior.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAnterior.setBackground(Color.WHITE);
		btnAnterior.setBounds(10, 67, 46, 282);
		
		frmPokedex.getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguiente.setBackground(Color.WHITE);
		btnSiguiente.setBounds(596, 67, 46, 282);
		
		frmPokedex.getContentPane().add(btnSiguiente);
		
		panelOpciones = new JPanel();
		panelOpciones.setBounds(10, 365, 632, 73);
		frmPokedex.getContentPane().add(panelOpciones);
		panelOpciones.setBackground(Color.WHITE);
		panelOpciones.setLayout(null);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(0, 51, 204));
		btnBorrar.setForeground(new Color(255, 255, 255));
		btnBorrar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnBorrar.setBounds(60, 11, 120, 40);
		btnBorrar.setBorder(null);
		panelOpciones.add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(0, 51, 204));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setFont(new Font("Verdana", Font.BOLD, 16));
		btnActualizar.setBounds(242, 11, 150, 40);
		btnActualizar.setBorder(null);
		panelOpciones.add(btnActualizar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBackground(new Color(0, 51, 204));
		btnCrear.setForeground(new Color(255, 255, 255));
		btnCrear.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCrear.setBounds(457, 11, 120, 40);
		btnCrear.setBorder(null);
		panelOpciones.add(btnCrear);
		
		btnAceptarAct = new JButton("Aceptar");
		btnAceptarAct.setBounds(142, 11, 119, 40);
		panelOpciones.add(btnAceptarAct);
		btnAceptarAct.setForeground(new Color(255, 255, 255));
		btnAceptarAct.setFont(new Font("Verdana", Font.BOLD, 16));
		btnAceptarAct.setBorder(null);
		btnAceptarAct.setBackground(new Color(0, 51, 204));
		
		btnCancelarAct = new JButton("Cancelar");
		btnCancelarAct.setBounds(354, 11, 131, 40);
		panelOpciones.add(btnCancelarAct);
		btnCancelarAct.setForeground(new Color(255, 255, 255));
		btnCancelarAct.setFont(new Font("Verdana", Font.BOLD, 16));
		btnCancelarAct.setBorder(null);
		btnCancelarAct.setBackground(new Color(0, 51, 204));
		
		fillTipos();
		
		frmPokedex.setVisible(true);
		
	}
	
	/**
	 * Configura las acciones al presionar un botón
	 */
	private void setListeners() {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginView.setVisible(true);	
				frmPokedex.dispose();
			}
		});
		
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printAnterior();
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printSiguiente();
			} 
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPokedex.setVisible(false);
				new CrearView(frmPokedex, username);

			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmar = JOptionPane.showConfirmDialog(btnBorrar,
						"¿Estás seguro de que deseas borrar este Pokemon?");
				if (confirmar == 0) { // Quiere borrar
					pokemonDAO.deletePokemon(pokemones.get(pagina));
					pokemones.remove(pokemones.get(pagina));
					if (pokemones.size() > 0) {
						printAnterior();
					} else {
						JOptionPane.showMessageDialog(btnBorrar, "Te has quedado sin Pokemones");
						printVacio();
					}
				}
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setActualizarON();
				//JOptionPane.showMessageDialog(btnActualizar, "Esta opción se encuentra en desarrollo. Disuclpe las molestias");
			}
		});
		
		btnAceptarAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePokemon();
				setActualizarOFF();
				printPokemon();
				
			}
		});
		
		btnCancelarAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setActualizarOFF();
			}
		});
	}
	
	private void printPokemon() {
		Pokemon p = pokemones.get(pagina);
		if(pokemones.size() > 0) {
		lblPokemonName.setText(p.getNombre());
		lblPokemonNumber.setText("N°"+p.getNumero());
		lblDatoDeAltura.setText(String.valueOf(p.getAltura()));
		lblDatoDePeso.setText(String.valueOf(p.getPeso()));
		lblDatoDeCategoria.setText(p.getCategoria());
		lblDatoDeHabilidad.setText(p.getHabilidad());	
		if(p.getTipo1() != null)
			lblDatoTipo1.setText(p.getTipo1().getNombre());
		if(p.getTipo2() != null) 
			lblDatoTipo2.setText(p.getTipo2().getNombre()); 
		}
		lblPokemonImg.setIcon(pokemones.get(pagina).getImagen2());

	}
	
	private void printSiguiente() {
		pagina++;
		if(pagina == pokemones.size()) {
			pagina = 0;
		}
		printPokemon();
	}
	
	private void printAnterior() {
		pagina--;
		if(pagina < 0) {
			pagina = pokemones.size() - 1;
		}
			printPokemon();
	}
	
	private void printVacio() {
		lblPokemonName.setText("");
		lblPokemonNumber.setText("");
		lblDatoDeAltura.setText("");
		lblDatoDePeso.setText("");
		lblDatoDeCategoria.setText("");
		lblDatoDeHabilidad.setText("");
		btnBorrar.setVisible(false);
		btnActualizar.setVisible(false);
		cbTipo1Act.setVisible(false);
		cbTipo2Act.setVisible(false);
	}
	
	private void setActualizarOFF() {
		lblPokemonName.setEditable(false);
		lblDatoDeAltura.setEditable(false);
		lblDatoDePeso.setEditable(false);
		lblDatoDeCategoria.setEditable(false);
		lblDatoDeHabilidad.setEditable(false);
		btnBorrar.setVisible(true);
		btnActualizar.setVisible(true);
		btnCrear.setVisible(true);
		btnAceptarAct.setVisible(false);
		btnCancelarAct.setVisible(false);
		btnSiguiente.setEnabled(true);
		btnAnterior.setEnabled(true);
		cbTipo1Act.setVisible(false);
		cbTipo2Act.setVisible(false);
		lblDatoTipo1.setVisible(true);
		lblDatoTipo2.setVisible(true);
	}
	
	private void setActualizarON() {
		lblPokemonName.setEditable(true);
		lblDatoDeAltura.setEditable(true);
		lblDatoDePeso.setEditable(true);
		lblDatoDeCategoria.setEditable(true);
		lblDatoDeHabilidad.setEditable(true);
		btnBorrar.setVisible(false);
		btnActualizar.setVisible(false);
		btnCrear.setVisible(false);
		btnAceptarAct.setVisible(true);
		btnCancelarAct.setVisible(true);
		btnSiguiente.setEnabled(false);
		btnAnterior.setEnabled(false);
		cbTipo1Act.setVisible(true);
		cbTipo2Act.setVisible(true);
		lblDatoTipo1.setVisible(false);
		lblDatoTipo2.setVisible(false);
		int a = (pokemones.get(pagina).getTipo1().getId());
		int b = (pokemones.get(pagina).getTipo2().getId());
		
		cbTipo1Act.setSelectedIndex(pokemones.get(pagina).getTipo1().getId()-1);
		cbTipo2Act.setSelectedIndex(pokemones.get(pagina).getTipo2().getId()-1);

	}
	
	private void updatePokemon() {
		Pokemon p = pokemones.get(pagina);
		p.setNombre(lblPokemonName.getText());
		p.setAltura(Double.parseDouble(lblDatoDeAltura.getText()));
		p.setPeso(Double.parseDouble(lblDatoDePeso.getText()));
		p.setCategoria(lblDatoDeCategoria.getText());
		p.setHabilidad(lblDatoDeHabilidad.getText());
		Tipos t1 = new Tipos(cbTipo1Act.getSelectedIndex()+1, cbTipo1Act.getSelectedItem().toString());
		Tipos t2 = new Tipos(cbTipo2Act.getSelectedIndex()+1, cbTipo2Act.getSelectedItem().toString());
		p.setTipo1(t1);
		p.setTipo2(t2);
		pokemonDAO.updatePokemon(p);
	}
	
	private void fillTipos() {
		for(Tipos t : tipos1) {
			cbTipo1Act.addItem(t.getNombre());
		}
		
		for(Tipos t : tipos2) {
			cbTipo2Act.addItem(t.getNombre());
		}
	}
}
