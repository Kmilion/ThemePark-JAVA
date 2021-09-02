package tierraMedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParqueTierraMedia {

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
	private String nombre;

	public ParqueTierraMedia(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void addUsuario(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void addSugerencia(ArrayList<Sugerencia> sugerencias) {
		for (Sugerencia s : sugerencias) {
			this.sugerencias.add(s);
		}
	}

	public void sugerir() throws IOException {
		OrdenarAtracciones(this.sugerencias);
		for (Usuario u : this.usuarios) {
			for (Sugerencia s : this.sugerencias) {
				if (s.getTipo() == u.getTipoPreferido() && s.getCosto() <= u.getDineroDisponible()
						&& s.getDuracion() <= u.getTiempoDisponible() && !contieneAtraccion1(u, s)
						&& !contieneAtraccion2(u, s) && s.hayCupo()) {
					System.out.println(u.getDatos());
					System.out.println("-------------------");
					System.out.println(s.getDatos());
					System.out.println("Desea aceptar la sugerencia? s/n");
					System.out.println("-------------------");
					Scanner in = new Scanner(System.in);
					Character caracter = in.next().charAt(0);
					caracter = caracter.toLowerCase(caracter);
					try {
						if (caracter == 's') {
							u.comprar(s);
						} else if (caracter != 'n') {
							throw new Exception();
						}
					} catch (Exception e) {
						System.out.println("Valor ingresado no válido. Por favor ingrese s/n");
						sugerir();
					}
				}
			}
			for (Sugerencia s : this.sugerencias) {
				if (s.getTipo() != u.getTipoPreferido() && s.getCosto() <= u.getDineroDisponible()
						&& s.getDuracion() <= u.getTiempoDisponible() && !contieneAtraccion1(u, s)
						&& !contieneAtraccion2(u, s) && s.hayCupo()) {
					System.out.println(u.getDatos());
					System.out.println("-------------------");
					System.out.println(s.getDatos());
					System.out.println("Desea aceptar la sugerencia? s/n");
					System.out.println("-------------------");
					Scanner in = new Scanner(System.in);
					Character caracter = in.next().charAt(0);
					caracter = caracter.toLowerCase(caracter);
					try {
						if (caracter == 's') {
							u.comprar(s);
						} else if (caracter != 'n') {
							throw new Exception();
						}
					} catch (Exception e) {
						e.fillInStackTrace();
					}
				}
			}
		}

		System.out.println("Resumen de los usuarios y sus atracciones: ");

		for (Usuario u : this.usuarios) {
			System.out.println(u.getDatos());
			System.out.println("Atracciones en su itinerario: ");
			for (Atraccion a : u.getAtraccionesCompradas()) {
				System.out.println(a.getNombre());
			}
			System.out.println("----------------");
		}

		System.out.println("Estado final de las atracciones:");

		for (Sugerencia a : this.sugerencias) {
			if (a instanceof Atraccion) {
				System.out.println(a.getDatos());
				System.out.println("----------------");
			}
		}

		escribirUsuarios("Final.txt", this.usuarios);
	}

	public static int calcularCostoTotal(ArrayList<Atraccion> atracciones) {
		int costo = 0;
		for (Atraccion a : atracciones) {
			costo += a.getCosto();
		}
		return costo;
	}

	public static double calcularTiempoTotal(ArrayList<Atraccion> atracciones) {
		double tiempo = 0;
		for (Atraccion a : atracciones) {
			tiempo += a.getDuracion();
		}
		return tiempo;
	}

	public static void escribirUsuarios(String archivo, ArrayList<Usuario> usuarios) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));

		salida.println("*******Resumen de las compras realizadas*******");
		salida.println("");

		for (Usuario u : usuarios) {
			salida.println("Nombre: " + u.getNombre());
			salida.print("Atracciones adquiridas: ");
			String s = "";
			if (!u.getAtraccionesCompradas().isEmpty()) {
				for (Atraccion a : u.getAtraccionesCompradas()) {
					s += a.getNombre() + ", ";
				}
			} else {
				s += "El usuario no pudo comprar ninguna atracción, ";
			}
			s = s.substring(0, s.length() - 2);
			salida.println(s);
			salida.println("Precio final: " + calcularCostoTotal(u.getAtraccionesCompradas()) + " monedas de oro");
			salida.println("Tiempo aproximado: " + calcularTiempoTotal(u.getAtraccionesCompradas()) + " horas");
			salida.println("");
		}
		salida.close();
	}

	private static void OrdenarAtracciones(ArrayList<Sugerencia> sugerencias) {
		Collections.sort(sugerencias, new Ordenador());
	}

	public static boolean contieneAtraccion1(Usuario u, Sugerencia s) {
		boolean valor = false;
		if (u.getAtraccionesCompradas().contains(s))
			valor = true;
		return valor;
	}

	public static boolean contieneAtraccion2(Usuario u, Sugerencia s) {
		boolean valor = false;
		for (Atraccion a : u.getAtraccionesCompradas()) {
			if (s.getAtraccionesPromocion().contains(a))
				valor = true;
		}
		return valor;
	}

}
