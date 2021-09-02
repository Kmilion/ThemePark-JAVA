package tierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public static void iniciarParque(ParqueTierraMedia p) throws IOException {

		System.out.println("Bievenido a " + p.getNombre() + "!");
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

	private static ArrayList<Sugerencia> getAtracciones(String archivo) {
		ArrayList<Sugerencia> atracciones = new ArrayList<Sugerencia>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				String linea = sc.nextLine();
				String campos[] = linea.split(",");

				String nombre = campos[0];
				int costo = Integer.parseInt(campos[1]);
				double tiempo = Double.parseDouble(campos[2]);
				int cupo = Integer.parseInt(campos[3]);
				TipoAtraccion tipo = TipoAtraccion.valueOf(campos[4]);
				Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo);

				atracciones.add(atraccion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return atracciones;
	}

	private static ArrayList<Sugerencia> getPromocionesPorcentuales(String archivo) {
		ArrayList<Sugerencia> promocionesPorcentuales = new ArrayList<Sugerencia>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				String linea = sc.nextLine();
				String campos[] = linea.split(",");

				TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
				Double porcentajeDeDescuento = Double.parseDouble(campos[1]);
				ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
				String nombreAtraccionA = campos[2];
				String nombreAtraccionB = campos[3];
				atracciones.add(new Atraccion(nombreAtraccionA, 3, 4, 12, tipoPromocion));
				atracciones.add(new Atraccion(nombreAtraccionB, 25, 3, 4, tipoPromocion));

				Promocion promocion = new PromocionPorcentual(tipoPromocion, atracciones, porcentajeDeDescuento);

				promocionesPorcentuales.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return promocionesPorcentuales;
	}

	private static ArrayList<Sugerencia> getPromocionesAbsolutas(String archivo) {
		ArrayList<Sugerencia> promocionesAbsolutas = new ArrayList<Sugerencia>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				String linea = sc.nextLine();
				String campos[] = linea.split(",");

				TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
				Integer descuentoNeto = Integer.parseInt(campos[1]);
				ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
				String nombreAtraccionA = campos[2];
				String nombreAtraccionB = campos[3];
				atracciones.add(new Atraccion(nombreAtraccionA, 35, 1, 30, tipoPromocion));
				atracciones.add(new Atraccion(nombreAtraccionB, 3, 6.5, 150, tipoPromocion));

				Promocion promocion = new PromocionAbsoluta(tipoPromocion, atracciones, descuentoNeto);

				promocionesAbsolutas.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return promocionesAbsolutas;
	}

	private static ArrayList<Sugerencia> getPromocionesAxB(String archivo) {
		ArrayList<Sugerencia> promocionesAxB = new ArrayList<Sugerencia>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {

				String linea = sc.nextLine();
				String campos[] = linea.split(",");

				TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
				ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
				String nombreAtraccionA = campos[1];
				String nombreAtraccionB = campos[2];
				String nombreAtraccionC = campos[3];
				atracciones.add(new Atraccion(nombreAtraccionA, 5, 2.5, 25, tipoPromocion));
				atracciones.add(new Atraccion(nombreAtraccionB, 5, 2, 15, tipoPromocion));
				atracciones.add(new Atraccion(nombreAtraccionC, 12, 3, 32, tipoPromocion));

				Promocion promocion = new PromocionAxB(tipoPromocion, atracciones);
				promocionesAxB.add(promocion);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();

		return promocionesAxB;
	}

	public static void main(String[] args) throws IOException {

		ParqueTierraMedia superpark = new ParqueTierraMedia("Parque de Atracciones de la Tierra Media");

		ArrayList<Usuario> usuarios = getUsuarios("usuarios.txt");
		superpark.addUsuario(usuarios);

		ArrayList<Sugerencia> atracciones = getAtracciones("atracciones.txt");

		ArrayList<Sugerencia> promocionesPorcentuales = getPromocionesPorcentuales("promocionesPorcentuales.txt");
		ArrayList<Sugerencia> promocionesAbsolutas = getPromocionesAbsolutas("promocionesAbsolutas.txt");
		ArrayList<Sugerencia> promocionesAxB = getPromocionesAxB("promocionesAxB.txt");

		superpark.addSugerencia(atracciones);
		superpark.addSugerencia(promocionesPorcentuales);
		superpark.addSugerencia(promocionesAbsolutas);
		superpark.addSugerencia(promocionesAxB);

		iniciarParque(superpark);
	}

}
