package models;

import javax.swing.ImageIcon;

import enums.TipoPokemons;

public class Pokemon {

	//Atributos
	protected int numero;
	protected String nombre;
	protected double altura;
	protected double peso;
	protected String categoria;
	protected String habilidad;
	protected ImageIcon imagen;
	protected Tipos tipo1;
	protected Tipos tipo2;

	
	//Constructor
	
	public Pokemon(int numero, String nombre, double altura, double peso, String categoria, String habilidad, ImageIcon imagen) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
		this.imagen = imagen;
	}
	
	public Pokemon(int numero, String nombre,  double altura, double peso, String categoria, String habilidad) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.altura = altura;
		this.peso = peso;
		this.categoria = categoria;
		this.habilidad = habilidad;
	}

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getHabilidad() {
		return habilidad;
	}


	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}


	public ImageIcon getImagen() {
		return imagen;
	}


	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public Tipos getTipo1() {
		return tipo1;
	}

	public void setTipo1(Tipos tipo1) {
		this.tipo1 = tipo1;
	}

	public Tipos getTipo2() {
		return tipo2;
	}

	public void setTipo2(Tipos tipo2) {
		this.tipo2 = tipo2;
	}
	
	
	
	
}
