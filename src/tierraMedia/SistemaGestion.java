package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SistemaGestion {

	public static Usuario[] getUsuarios() {
		FileReader fr = null;
		BufferedReader br = null;
		Usuario[] usuarios = new Usuario[4];
		try {
			fr = new FileReader("usuarios.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					String nombre = campos[0];
					TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(campos[1]);
					double dineroDisponible = Double.parseDouble(campos[2]);
					double tiempoDisponible = Double.parseDouble(campos[3]);
					Usuario usuario = new Usuario(nombre, tipoPreferido, dineroDisponible, tiempoDisponible);
					usuarios[i] = usuario;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < usuarios.length; j++) {
				System.out.println(usuarios[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public static Atraccion[] getAtracciones() {
		FileReader fr = null;
		BufferedReader br = null;
		Atraccion[] atracciones = new Atraccion[8];
		try {
			fr = new FileReader("atracciones.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					String nombre = campos[0];
					double costo = Double.parseDouble(campos[1]);
					double tiempo = Double.parseDouble(campos[2]);
					int cupo = Integer.parseInt(campos[3]);
					TipoAtraccion tipo = TipoAtraccion.valueOf(campos[4]);
					Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo);
					atracciones[i] = atraccion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < atracciones.length; j++) {
				System.out.println(atracciones[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return atracciones;
	}

	public static PromocionPorcentual[] getPromocionesPorcentuales() {
		FileReader fr = null;
		BufferedReader br = null;
		PromocionPorcentual[] promocionesPorcentuales = new PromocionPorcentual[1];
		try {
			fr = new FileReader("promocionesPorcentuales.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Double porcentajeDeDescuento = Double.parseDouble(campos[1]);
					Atraccion[] atracciones = new Atraccion[2];
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones[0] = new Atraccion(nombreAtraccionA, 3, 4, 12, tipoPromocion);
					atracciones[1] = new Atraccion(nombreAtraccionB, 25, 3, 4, tipoPromocion);

					PromocionPorcentual promocion = new PromocionPorcentual(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					promocionesPorcentuales[i] = promocion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < promocionesPorcentuales.length; j++) {
				System.out.println(promocionesPorcentuales[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return promocionesPorcentuales;
	}

	public static PromocionAbsoluta[] getPromocionesAbsolutas() {
		FileReader fr = null;
		BufferedReader br = null;
		PromocionAbsoluta[] promocionesAbsolutas = new PromocionAbsoluta[1];
		try {
			fr = new FileReader("promocionesAbsolutas.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Double porcentajeDeDescuento = Double.parseDouble(campos[1]);
					Atraccion[] atracciones = new Atraccion[2];
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones[0] = new Atraccion(nombreAtraccionA, 3, 6.5, 150, tipoPromocion);
					atracciones[1] = new Atraccion(nombreAtraccionB, 35, 1, 30, tipoPromocion);

					PromocionAbsoluta promocion = new PromocionAbsoluta(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					promocionesAbsolutas[i] = promocion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < promocionesAbsolutas.length; j++) {
				System.out.println(promocionesAbsolutas[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return promocionesAbsolutas;
	}

	public static PromocionAxB[] getPromocionesAxB() {
		FileReader fr = null;
		BufferedReader br = null;
		PromocionAxB[] promocionesAxB = new PromocionAxB[1];
		try {
			fr = new FileReader("promocionesAxB.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Atraccion[] atracciones = new Atraccion[3];
					String nombreAtraccionA = campos[1];
					String nombreAtraccionB = campos[2];
					String nombreAtraccionC = campos[3];
					atracciones[0] = new Atraccion(nombreAtraccionA, 5, 2.5, 25, tipoPromocion);
					atracciones[1] = new Atraccion(nombreAtraccionB, 5, 2, 15, tipoPromocion);
					atracciones[2] = new Atraccion(nombreAtraccionC, 12, 3, 32, tipoPromocion);

					PromocionAxB promocion = new PromocionAxB(tipoPromocion, atracciones);
					promocionesAxB[i] = promocion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < promocionesAxB.length; j++) {
				System.out.println(promocionesAxB[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return promocionesAxB;
	}

	public static void main(String[] args) {

		getUsuarios();
		getAtracciones();
		getPromocionesPorcentuales();
		getPromocionesAbsolutas();
		getPromocionesAxB();

	}

}
