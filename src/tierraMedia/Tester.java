package tierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void iniciarParque(Parque p) throws IOException {

		System.out.println("******** Bievenido a " + p.getNombre() + " ********");
		p.sugerir();

	}

	public static ArrayList<Usuario> getUsuarios(String archivo) {
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

	private static ArrayList<Sugerencia> getSugerencias(String archivoAtracciones, String PromoP, String PromoA,
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
				Promocion promocion = new PromocionAbsoluta(nombrePromocion, tipoPromocion, atraccionesPromo,
						precio);
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

	public static void main(String[] args) throws IOException {

		Parque superpark = new Parque("Parque de Atracciones de la Tierra Media");

		ArrayList<Usuario> usuarios = getUsuarios("usuarios.txt");
		superpark.addUsuario(usuarios);

		ArrayList<Sugerencia> sugerencias = getSugerencias("atracciones.txt", "promocionesPorcentuales.txt",
				"promocionesAbsolutas.txt", "promocionesAxB.txt");
		superpark.addSugerencia(sugerencias);

		iniciarParque(superpark);
	}

}
