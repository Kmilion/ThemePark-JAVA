package tierraMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SistemaDeGestion {

	public static ArrayList<Sugerencia> getSugerenciasPosibles(Usuario u, ArrayList<Sugerencia> sugerencias) {
		OrdenarAtracciones(sugerencias);
		ArrayList<Sugerencia> posibilidades = new ArrayList<Sugerencia>();
		for (Sugerencia s : sugerencias) {
			if (s.getTipo() == u.getTipoPreferido() && s.getCosto() <= u.getDineroDisponible()
					&& s.getDuracion() <= u.getTiempoDisponible() && !contieneAtraccion1(u, s)
					&& !contieneAtraccion2(u, s) && s.hayCupo()) {
				System.out.println(s.getDatos());
				System.out.println("Desea aceptar la sugerencia? s/n");
				Scanner in = new Scanner(System.in);
				Character caracter = in.next().charAt(0);
				caracter = caracter.toLowerCase(caracter);
				try {
					if (caracter == 's') {
						posibilidades.add(s);
					} else if (caracter != 'n') {
						throw new Exception();
					}
				} catch (Exception e) {
					getSugerenciasPosibles(u, sugerencias);
				}
			}
		}
		return posibilidades;
	}

	private static void OrdenarAtracciones(ArrayList<Sugerencia> sugerencias) {
		Collections.sort(sugerencias, new Ordenador());
	}

	public static ArrayList<Sugerencia> getOtrasSugerencias(Usuario u, ArrayList<Sugerencia> sugerencias) {
		OrdenarAtracciones(sugerencias);
		ArrayList<Sugerencia> posibilidades = new ArrayList<Sugerencia>();
		for (Sugerencia s : sugerencias) {
			if (s.getCosto() <= u.getDineroDisponible() && s.getDuracion() <= u.getTiempoDisponible()
					&& !contieneAtraccion1(u, s) && !contieneAtraccion2(u, s) && s.hayCupo()) {
				posibilidades.add(s);
			}
		}
		return posibilidades;
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

	public static void main(String[] args) {

		Usuario eowyn = new Usuario("Eowyn", TipoAtraccion.AVENTURA, 10, 8);
		Usuario gandalf = new Usuario("Gandalf", TipoAtraccion.PAISAJE, 23, 50);
		Usuario sam = new Usuario("Sam", TipoAtraccion.DEGUSTACION, 36, 8);
		Usuario galadriel = new Usuario("Galadriel", TipoAtraccion.PAISAJE, 120, 6);

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		usuarios.add(eowyn);
		usuarios.add(gandalf);
		usuarios.add(sam);
		usuarios.add(galadriel);

		Atraccion moria = new Atraccion("Moria", 10, 2, 6, TipoAtraccion.AVENTURA);
		Atraccion minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccion.PAISAJE);
		Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtraccion.DEGUSTACION);
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TipoAtraccion.AVENTURA);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccion.PAISAJE);
		Atraccion lothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtraccion.DEGUSTACION);
		Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, TipoAtraccion.PAISAJE);
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtraccion.AVENTURA);

		ArrayList<Atraccion> pack1 = new ArrayList<Atraccion>();
		ArrayList<Atraccion> pack2 = new ArrayList<Atraccion>();
		ArrayList<Atraccion> pack3 = new ArrayList<Atraccion>();

		pack1.add(bosqueNegro);
		pack1.add(mordor);
		pack2.add(lothlorien);
		pack2.add(laComarca);
		pack3.add(minasTirith);
		pack3.add(erebor);

		Promocion packAventura = new PromocionPorcentual(TipoAtraccion.AVENTURA, pack1, 20);
		Promocion packDegustacion = new PromocionAbsoluta(TipoAtraccion.DEGUSTACION, pack2, 2);
		Promocion packPaisaje = new PromocionAxB(TipoAtraccion.PAISAJE, pack3);

		ArrayList<Sugerencia> sugerencias = new ArrayList<Sugerencia>();

		sugerencias.add(packAventura);
		sugerencias.add(packDegustacion);
		sugerencias.add(packPaisaje);
		sugerencias.add(moria);
		sugerencias.add(minasTirith);
		sugerencias.add(laComarca);
		sugerencias.add(mordor);
		sugerencias.add(abismoDeHelm);
		sugerencias.add(lothlorien);
		sugerencias.add(erebor);
		sugerencias.add(bosqueNegro);
		
		getSugerenciasPosibles(gandalf, sugerencias);

		/*System.out.println(gandalf.getDatos());

		System.out.println("--------------------------------");

		for (Sugerencia sugerencia : getSugerenciasPosibles(gandalf, sugerencias)) {
			System.out.println(sugerencia.getDatos() + "\n");
		}

		System.out.println("--------------------------------");

		gandalf.comprar(packPaisaje);

		System.out.println(gandalf.getAtraccionesCompradas());

		System.out.println("--------------------------------");

		System.out.println(gandalf.getDatos());

		System.out.println("--------------------------------");

		for (Sugerencia sugerencia : getSugerenciasPosibles(gandalf, sugerencias)) {
			System.out.println(sugerencia.getDatos() + "\n");
		}

		System.out.println("--------------------------------");

		for (Sugerencia sugerencia : getOtrasSugerencias(gandalf, sugerencias)) {
			System.out.println(sugerencia.getDatos() + "\n");
		}*/

	}

}
