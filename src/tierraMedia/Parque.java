package tierraMedia;

import java.io.File;
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
	public Parque(String nombre, String archivoUsuarios, String archivoAtracciones, String promoP, String promoA,
			String promoAxB) {
		this.nombreParque = nombre;
		this.usuariosParque = getUsuarios(archivoUsuarios);
		this.sugerenciasParque = getSugerencias(archivoAtracciones, promoP, promoA, promoAxB);
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

	public ArrayList<Usuario> getUsuarios(String archivo) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				String linea = sc.nextLine();
				String campos[] = linea.split(",");

				String nombre = campos[0];
				TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(campos[1]);
				int dineroDisponible = Integer.parseInt(campos[2]);
				double tiempoDisponible = Double.parseDouble(campos[3]);
				Usuario usuario = new Usuario(nombre, tipoPreferido, dineroDisponible, tiempoDisponible);

				usuarios.add(usuario);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return usuarios;
	}

	private ArrayList<Sugerencia> getSugerencias(String archivoAtracciones, String PromoP, String PromoA,
			String PromoAxB) {
		ArrayList<Sugerencia> sugerencias = new ArrayList<Sugerencia>();
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		ArrayList<Promocion> promocionesPorcentuales = new ArrayList<Promocion>();
		ArrayList<Promocion> promocionesAbsolutas = new ArrayList<Promocion>();
		ArrayList<Promocion> promocionesAxB = new ArrayList<Promocion>();

		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivoAtracciones));

			while (sc.hasNext()) {

				String linea = sc.nextLine();
				String campos[] = linea.split(",");
				ArrayList<String> datos = new ArrayList<String>();
				for (String s : campos) {
					datos.add(s);
				}
				String nombre = datos.get(0);
				int costo = Integer.parseInt(datos.get(1));
				double tiempo = Double.parseDouble(datos.get(2));
				int cupo = Integer.parseInt(datos.get(3));
				TipoAtraccion tipo = TipoAtraccion.valueOf(datos.get(4));

				Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo);
				atracciones.add(atraccion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		Scanner scA = null;
		try {
			scA = new Scanner(new File(PromoP));

			while (scA.hasNext()) {

				String linea = scA.nextLine();
				String campos[] = linea.split(",");
				ArrayList<String> datos = new ArrayList<String>();
				for (String s : campos) {
					datos.add(s);
				}
				String nombrePromocion = datos.get(0);
				TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(datos.get(1));
				Integer porcentajeDeDescuento = Integer.parseInt(datos.get(2));
				ArrayList<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();
				for (int i = 3; i < datos.size(); i++) {
					for (Atraccion s : atracciones) {
						if (datos.get(i).equals(s.getNombre())) {
							atraccionesPromo.add(s);
						}
					}
				}
				Promocion promocion = new PromocionPorcentual(nombrePromocion, tipoPromocion, atraccionesPromo,
						porcentajeDeDescuento);
				promocionesPorcentuales.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scA.close();

		Scanner scB = null;
		try {
			scB = new Scanner(new File(PromoA));

			while (scB.hasNext()) {

				String linea = scB.nextLine();
				String campos[] = linea.split(",");
				ArrayList<String> datos = new ArrayList<String>();
				for (String s : campos) {
					datos.add(s);
				}
				String nombrePromocion = datos.get(0);
				TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(datos.get(1));
				Integer precio = Integer.parseInt(datos.get(2));
				ArrayList<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();
				for (int i = 3; i < datos.size(); i++) {
					for (Atraccion s : atracciones) {
						if (datos.get(i).equals(s.getNombre())) {
							atraccionesPromo.add(s);
						}
					}
				}
				Promocion promocion = new PromocionAbsoluta(nombrePromocion, tipoPromocion, atraccionesPromo, precio);
				promocionesAbsolutas.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scB.close();

		Scanner scC = null;
		try {
			scC = new Scanner(new File(PromoAxB));

			while (scC.hasNext()) {

				String linea = scC.nextLine();
				String campos[] = linea.split(",");
				ArrayList<String> datos = new ArrayList<String>();
				for (String s : campos) {
					datos.add(s);
				}
				String nombrePromocion = datos.get(0);
				TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(datos.get(1));
				ArrayList<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();
				for (int i = 2; i < datos.size(); i++) {
					for (Atraccion s : atracciones) {
						if (datos.get(i).equals(s.getNombre())) {
							atraccionesPromo.add(s);
						}
					}
				}
				Promocion promocion = new PromocionAxB(nombrePromocion, tipoPromocion, atraccionesPromo);
				promocionesAxB.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scC.close();

		for (Atraccion a : atracciones) {
			sugerencias.add(a);
		}
		for (Promocion p : promocionesPorcentuales) {
			sugerencias.add(p);
		}
		for (Promocion p : promocionesAbsolutas) {
			sugerencias.add(p);
		}
		for (Promocion p : promocionesAxB) {
			sugerencias.add(p);
		}

		return sugerencias;

	}

	/*
	 * Si la Sugerencia es una Atraccion devuelve true si se encuentra dentro de las
	 * Atraccion compradas por el Usuario.
	 */
	public boolean contieneAtraccion1(Usuario u, Sugerencia s) {
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
	public boolean contieneAtraccion2(Usuario u, Sugerencia s) {
		boolean valor = false;
		for (Atraccion a : u.getAtraccionesCompradas()) {
			if (s.getAtraccionesPromocion().contains(a))
				valor = true;
		}
		return valor;
	}

	/* Ordena el ArrayList de Sugerencia pasado por parámetro. */
	private void OrdenarAtracciones(ArrayList<Sugerencia> sugerencias) {
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

	public void escribirUsuario(Usuario u) throws FileNotFoundException {
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

	public void escribirAtracciones(ArrayList<Sugerencia> sugerencias) throws FileNotFoundException {
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
