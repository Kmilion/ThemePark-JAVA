package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParqueTest {

	public static ArrayList<Usuario> getUsuarios() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			fr = new FileReader("usuarios.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					String nombre = campos[0];
					TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(campos[1]);
					int dineroDisponible = Integer.parseInt(campos[2]);
					double tiempoDisponible = Double.parseDouble(campos[3]);
					Usuario usuario = new Usuario(nombre, tipoPreferido, dineroDisponible, tiempoDisponible);
					listaUsuarios.add(usuario);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (Usuario usuario : listaUsuarios) {
				System.out.println(usuario.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public static ArrayList<Atraccion> getAtracciones() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
		try {
			fr = new FileReader("atracciones.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					String nombre = campos[0];
					int costo = Integer.parseInt(campos[1]);
					double tiempo = Double.parseDouble(campos[2]);
					int cupo = Integer.parseInt(campos[3]);
					TipoAtraccion tipo = TipoAtraccion.valueOf(campos[4]);
					Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo);
					listaAtracciones.add(atraccion);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (Atraccion atraccion : listaAtracciones) {
				System.out.println(atraccion.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaAtracciones;
	}

	public static ArrayList<PromocionPorcentual> getPromocionesPorcentuales() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<PromocionPorcentual> listaPromocionesPorcentuales = new ArrayList<PromocionPorcentual>();
		try {
			fr = new FileReader("promocionesPorcentuales.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Double porcentajeDeDescuento = Double.parseDouble(campos[1]);
					ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones.add(new Atraccion(nombreAtraccionA, 3, 4, 12, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionB, 25, 3, 4, tipoPromocion));

					PromocionPorcentual promocion = new PromocionPorcentual(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					listaPromocionesPorcentuales.add(promocion);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (PromocionPorcentual promocion : listaPromocionesPorcentuales) {
				System.out.println(promocion.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPromocionesPorcentuales;
	}

	public static ArrayList<PromocionAbsoluta> getPromocionesAbsolutas() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<PromocionAbsoluta> listaPromocionesAbsolutas = new ArrayList<PromocionAbsoluta>();
		try {
			fr = new FileReader("promocionesAbsolutas.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					int porcentajeDeDescuento = Integer.parseInt(campos[1]);
					ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones.add(new Atraccion(nombreAtraccionA, 3, 6.5, 150, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionB, 35, 1, 30, tipoPromocion));

					PromocionAbsoluta promocion = new PromocionAbsoluta(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					listaPromocionesAbsolutas.add(promocion);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (PromocionAbsoluta promocion : listaPromocionesAbsolutas) {
				System.out.println(promocion.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPromocionesAbsolutas;
	}

	public static ArrayList<PromocionAxB> getPromocionesAxB() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<PromocionAxB> listaPromocionesAxB = new ArrayList<PromocionAxB>();
		try {
			fr = new FileReader("promocionesAxB.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
					String nombreAtraccionA = campos[1];
					String nombreAtraccionB = campos[2];
					String nombreAtraccionC = campos[3];
					atracciones.add(new Atraccion(nombreAtraccionA, 5, 2.5, 25, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionB, 5, 2, 15, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionC, 12, 3, 32, tipoPromocion));

					PromocionAxB promocion = new PromocionAxB(tipoPromocion, atracciones);
					listaPromocionesAxB.add(promocion);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (PromocionAxB promocion : listaPromocionesAxB) {
				System.out.println(promocion.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPromocionesAxB;
	}

	public static void main(String[] args) {

		getUsuarios();
		getAtracciones();
		getPromocionesPorcentuales();
		getPromocionesAbsolutas();
		getPromocionesAxB();

	}

}
