package tierraMedia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Parque {

	/* Declaro los aributos de la clase Parque. */
	private ArrayList<Usuario> usuariosParque = new ArrayList<Usuario>();
	private ArrayList<Sugerencia> sugerenciasParque = new ArrayList<Sugerencia>();
	private String nombreParque;

	/* Constructor del Parque, inicializa el nombre del mismo. */
	public Parque(String nombre) {
		this.nombreParque = nombre;
	}

	/* Devuelve el nombre del Parque. */
	public String getNombre() {
		return nombreParque;
	}

	/* Método que permite al Parque agregar ArrayList con Usuarios. */
	public void addUsuario(ArrayList<Usuario> usuarios) {
		this.usuariosParque = usuarios;
	}

	/* Método que permite al Parque agregar ArrayList con Sugerencia. */
	public void addSugerencia(ArrayList<Sugerencia> sugerencias) {
		for (Sugerencia s : sugerencias) {
			this.sugerenciasParque.add(s);
		}
	}

	/*
	 * Si la Sugerencia es una Atraccion devuelve true si se encuentra dentro de las
	 * Atraccion compradas por el Usuario.
	 */
	public static boolean contieneAtraccion1(Usuario u, Sugerencia s) {
		boolean valor = false;
		if (u.getAtraccionesCompradas().contains(s))
			valor = true;
		return valor;
	}

	/*
	 * Si la Sugerencia es una Promocion recorre el ArrayList de Atraccion compradas
	 * por el Usuario y por cada Atraccion comprada pregunta si está contenida
	 * dentro del ArrayList de las Promocion sugeridas.
	 */
	public static boolean contieneAtraccion2(Usuario u, Sugerencia s) {
		boolean valor = false;
		for (Atraccion a : u.getAtraccionesCompradas()) {
			if (s.getAtraccionesPromocion().contains(a))
				valor = true;
		}
		return valor;
	}

	/* Ordena el ArrayList de Sugerencia pasado por parámetro. */
	private static void OrdenarAtracciones(ArrayList<Sugerencia> sugerencias) {
		Collections.sort(sugerencias, new Ordenador());
	}

	public void sugerir() throws IOException {

		OrdenarAtracciones(this.sugerenciasParque);

		for (Usuario u : this.usuariosParque) {
			System.out.println(u.getDatos());
			System.out.println("-------------------");
			for (Sugerencia s : this.sugerenciasParque) {
				if (s.getTipo() == u.getTipoPreferido() && s.getCosto() <= u.getDineroDisponible()
						&& s.getDuracion() <= u.getTiempoDisponible() && !contieneAtraccion1(u, s)
						&& !contieneAtraccion2(u, s) && s.hayCupo()) {
					System.out.println(s.getDatos());
					System.out.println("Desea aceptar la sugerencia? s/n");
					@SuppressWarnings("resource")
					Scanner in = new Scanner(System.in);
					Character caracter = in.next().charAt(0);
					caracter = Character.toLowerCase(caracter);
					try {
						if (caracter == 's') {
							u.comprar(s);
						} else if (caracter != 'n') {
							throw new Exception();
						}
					} catch (Exception e) {
						System.out.println("Valor ingresado no válido. Por favor ingrese s/n");
						sugerir();
					} finally {
						System.out.println("-------------------");
					}
				}
			}
			for (Sugerencia s : this.sugerenciasParque) {
				if (s.getTipo() != u.getTipoPreferido() && s.getCosto() <= u.getDineroDisponible()
						&& s.getDuracion() <= u.getTiempoDisponible() && !contieneAtraccion1(u, s)
						&& !contieneAtraccion2(u, s) && s.hayCupo()) {
					System.out.println(s.getDatos());
					System.out.println("Desea aceptar la sugerencia? s/n");
					@SuppressWarnings("resource")
					Scanner in = new Scanner(System.in);
					Character caracter = in.next().charAt(0);
					caracter = Character.toLowerCase(caracter);
					try {
						if (caracter == 's') {
							u.comprar(s);
						} else if (caracter != 'n') {
							throw new Exception();
						}
					} catch (Exception e) {
						e.fillInStackTrace();
					} finally {
						System.out.println("-------------------");
					}
				}
			}
			escribirUsuario(u);
		}
		escribirAtracciones(sugerenciasParque);
		System.out.print("******** Fin del servicio ********");
	}

	public static void escribirUsuario(Usuario u) throws FileNotFoundException {
		PrintWriter salida = new PrintWriter(u.getNombre() + ".txt");

		salida.println("*******Resumen de compra*******\n");
		salida.println("Nombre: " + u.getNombre());
		String s = "";
		if (!u.getAtraccionesCompradas().isEmpty()) {
			salida.print("Atracciones adquiridas: ");
			for (Atraccion a : u.getAtraccionesCompradas()) {
				s += a.getNombre() + ", ";
			}
			s = s.substring(0, s.length() - 2);
			salida.println(s);
			salida.println("Precio final: " + u.getDineroGastado() + " monedas de oro");
			salida.print("Tiempo aproximado: " + u.getTiempoGastado() + " horas");
		} else {
			s += "El usuario no pudo comprar ninguna atracción.";
			salida.print(s);
		}
		salida.close();
	}

	public static void escribirAtracciones(ArrayList<Sugerencia> sugerencias) throws FileNotFoundException {
		PrintWriter salida = new PrintWriter("resumenAtracciones.txt");

		salida.println("*******Resumen de las atracciones del día*******\n");
		for (Sugerencia a : sugerencias) {
			if (a instanceof Atraccion) {
				salida.println(a.getNombre());
				salida.println("Cupos restantes: " + ((Atraccion) a).getCupoAtraccion());
				salida.println("-----------------");
			}
		}
		salida.close();
	}
}
