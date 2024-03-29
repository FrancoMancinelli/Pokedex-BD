package ui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import dao.PokemonDAO;
import dao.TiposDAO;
import models.Pokemon;
import models.Tipos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class CrearView {

	private JFrame frame;
	private JTextField textFldSetNombre;
	private JTextField textFldSetAltura;
	private JTextField textFldSetPeso;
	private JTextField textFldSetCategoria;
	private JTextField textFldSetHabilidad;
	private JLabel lblSetNombre;
	private JLabel lblSetTipo1;
	private JLabel lblSetAltura;
	private JLabel lblSetPeso;
	private JLabel lblSetCategoria;
	private JLabel lblSetHabilidad;
	private JButton btnConfirmarCrear;
	private JButton btnVolverPkx;
	private JFrame PokedexView;
	private String username;
	private JLabel lblPokedex;
	private PokemonDAO pokemonDAO;
	private TiposDAO tipos1DAO;
	private TiposDAO tipos2DAO;
	private JLabel lblSetTipo2;
	private JComboBox<String> cbTipo1;
	private JComboBox<String> cbTipo2;
	private ArrayList<Tipos> tipos1;
	private ArrayList<Tipos> tipos2;
	private String password;
	private JLabel imgfondo;
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
	public CrearView(JFrame PokedexView, String username, String password) {
		this.pokemonDAO = new PokemonDAO();
		this.PokedexView = PokedexView;
		this.username = username;
		this.password = password;
		this.tipos1DAO = new TiposDAO();
		this.tipos2DAO = new TiposDAO();
		this.tipos1 = tipos1DAO.getAllTipo1();
		this.tipos2 = tipos2DAO.getAllTipo2();

		initialize();
	}

	/**
	 * Inicializa el contenido del frame.
	 */
	private void initialize() {
		setUIComponents();
		setListeners();
	}

	/**
	 * Configura la interfaz gr�fica de la ventana
	 */
	private void setUIComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		textFldSetNombre = new JTextField();
		textFldSetNombre.setBounds(287, 188, 159, 24);
		frame.getContentPane().add(textFldSetNombre);
		textFldSetNombre.setColumns(10);

		lblSetNombre = new JLabel("Nombre:");
		lblSetNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetNombre.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetNombre.setBounds(171, 186, 100, 22);
		frame.getContentPane().add(lblSetNombre);

		lblSetTipo1 = new JLabel("Tipo 1:");
		lblSetTipo1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetTipo1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetTipo1.setBounds(75, 292, 90, 22);
		frame.getContentPane().add(lblSetTipo1);

		lblSetAltura = new JLabel("Altura:");
		lblSetAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetAltura.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetAltura.setBounds(346, 259, 84, 22);
		frame.getContentPane().add(lblSetAltura);

		textFldSetAltura = new JTextField();
		textFldSetAltura.setBounds(438, 261, 120, 24);
		frame.getContentPane().add(textFldSetAltura);
		textFldSetAltura.setColumns(10);

		lblSetPeso = new JLabel("Peso:");
		lblSetPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetPeso.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetPeso.setBounds(65, 259, 100, 22);
		frame.getContentPane().add(lblSetPeso);

		textFldSetPeso = new JTextField();
		textFldSetPeso.setColumns(10);
		textFldSetPeso.setBounds(171, 261, 120, 24);
		frame.getContentPane().add(textFldSetPeso);

		lblSetCategoria = new JLabel("Categoria:");
		lblSetCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetCategoria.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetCategoria.setBounds(328, 223, 102, 22);
		frame.getContentPane().add(lblSetCategoria);

		textFldSetCategoria = new JTextField();
		textFldSetCategoria.setBounds(438, 223, 120, 24);
		frame.getContentPane().add(textFldSetCategoria);
		textFldSetCategoria.setColumns(10);

		lblSetHabilidad = new JLabel("Habilidad:");
		lblSetHabilidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetHabilidad.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetHabilidad.setBounds(65, 224, 100, 24);
		frame.getContentPane().add(lblSetHabilidad);

		textFldSetHabilidad = new JTextField();
		textFldSetHabilidad.setBounds(171, 224, 120, 24);
		frame.getContentPane().add(textFldSetHabilidad);
		textFldSetHabilidad.setColumns(10);

		btnConfirmarCrear = new JButton("Crear");
		btnConfirmarCrear.setFont(new Font("Verdana", Font.BOLD, 18));
		btnConfirmarCrear.setForeground(new Color(255, 255, 255));
		btnConfirmarCrear.setBackground(new Color(0, 51, 204));
		btnConfirmarCrear.setBounds(265, 337, 113, 48);
		frame.getContentPane().add(btnConfirmarCrear);

		lblPokedex = new JLabel("");
		lblPokedex.setIcon(new ImageIcon(CrearView.class.getResource("/img/pokemon.png")));
		lblPokedex.setBounds(192, 81, 256, 104);
		frame.getContentPane().add(lblPokedex);

		lblSetTipo2 = new JLabel("Tipo 2:");
		lblSetTipo2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetTipo2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblSetTipo2.setBounds(340, 292, 90, 22);
		frame.getContentPane().add(lblSetTipo2);

		cbTipo1 = new JComboBox<String>();
		cbTipo1.setBounds(171, 295, 120, 22);
		frame.getContentPane().add(cbTipo1);

		cbTipo2 = new JComboBox<String>();
		cbTipo2.setBounds(438, 295, 120, 22);
		frame.getContentPane().add(cbTipo2);
		
		btnVolverPkx = new JButton("Volver");
		btnVolverPkx.setBounds(65, 65, 85, 25);
		frame.getContentPane().add(btnVolverPkx);
		btnVolverPkx.setFont(new Font("Verdana", Font.BOLD, 14));
		btnVolverPkx.setBackground(new Color(255, 255, 255));
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 27, 455);
		frame.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(26, 27, 27, 403);
		frame.getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(53, 403, 535, 27);
		frame.getContentPane().add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 429, 639, 27);
		frame.getContentPane().add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.RED);
		panel_4.setBounds(585, 27, 27, 404);
		frame.getContentPane().add(panel_4);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(612, 0, 27, 455);
		frame.getContentPane().add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setBounds(0, 0, 639, 27);
		frame.getContentPane().add(panel_6);
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.RED);
		panel_7.setBounds(53, 25, 535, 27);
		frame.getContentPane().add(panel_7);
		
		imgfondo = new JLabel("");
		imgfondo.setBounds(48, 45, 544, 370);
		frame.getContentPane().add(imgfondo);
		imgfondo.setIcon(new ImageIcon(LoginView.class.getResource("/img/fondo.jpg")));

		fillTipos();
	}

	/**
	 * Configura las acciones al presionar un bot�n
	 */
	public void setListeners() {
		btnVolverPkx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PokedexView.setVisible(true);
				frame.dispose();
			}
		});

		btnConfirmarCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPokemon();
			}
		});
	}

	/**
	 * M�todo que inserta un Pokemon a la base de datos
	 */
	public void insertarPokemon() {

		double alt = Double.parseDouble(textFldSetAltura.getText());
		double pes = Double.parseDouble(textFldSetPeso.getText());
		PokemonDAO pDAO = new PokemonDAO();

		if (textFldSetNombre.getText().isEmpty() || textFldSetPeso.getText().isEmpty() || 
			textFldSetAltura.getText().isEmpty() || textFldSetCategoria.getText().isEmpty() || 
			textFldSetHabilidad.getText().isEmpty()) { //Si los campos de datos estan vacios...
				JOptionPane.showMessageDialog(btnConfirmarCrear, "ERR0R! - Rellena todos los campos");
		if(!pDAO.pokemonExistente(textFldSetNombre.getText())) { //Si el Pokemon NO existe en la Pokedex...
			} else {
				try {
					Pokemon p = new Pokemon(0, textFldSetNombre.getText(), alt, pes, textFldSetCategoria.getText(), textFldSetHabilidad.getText());
					// Sacar el valor de los tipos de los comboboxes
					Tipos tipo1 = tipos1.get(cbTipo1.getSelectedIndex());
					p.setTipo1(tipo1);
					Tipos tipo2 = tipos2.get(cbTipo2.getSelectedIndex());
					p.setTipo2(tipo2);
					
	
					pokemonDAO.insertPokemon(p);
					new PokedexView(username, PokedexView, 0, password);
					frame.dispose();
					JOptionPane.showMessageDialog(btnConfirmarCrear, "Pokemon a�adido con �xito");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(btnConfirmarCrear, "ERR0R! - La altura y peso deben ser decimales");
				}
			}
		} else {
			JOptionPane.showMessageDialog(btnConfirmarCrear, "ERR0R! - El Pokemon ya existe");
		}
	}

	/**
	 * Rellena los ComboBoxes con los diferentes tipos
	 */
	private void fillTipos() {
		for(Tipos t : tipos1) {
			cbTipo1.addItem(t.getNombre());
		}
		
		for(Tipos t : tipos2) {
			cbTipo2.addItem(t.getNombre());
		}
	}
}
