package tierraMedia;

import java.util.ArrayList;

public class ParqueTestTrucho {

	public static void main(String[] args) {

		ArrayList<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

		Atraccion moria = new Atraccion("Moria", 10, 2, 6, TipoAtraccion.AVENTURA);
		Atraccion minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccion.PAISAJE);
		Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtraccion.DEGUSTACION);
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TipoAtraccion.AVENTURA);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccion.PAISAJE);
		Atraccion lothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtraccion.DEGUSTACION);
		Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, TipoAtraccion.PAISAJE);
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtraccion.AVENTURA);

		listaAtracciones.add(moria);
		listaAtracciones.add(minasTirith);
		listaAtracciones.add(laComarca);
		listaAtracciones.add(mordor);
		listaAtracciones.add(abismoDeHelm);
		listaAtracciones.add(lothlorien);
		listaAtracciones.add(erebor);
		listaAtracciones.add(bosqueNegro);

		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

		Usuario eowyn = new Usuario("Eowyn", TipoAtraccion.AVENTURA, 10, 8);
		Usuario gandalf = new Usuario("Gandalf", TipoAtraccion.PAISAJE, 100, 5);
		Usuario sam = new Usuario("Sam", TipoAtraccion.DEGUSTACION, 36, 8);
		Usuario galadriel = new Usuario("Sam", TipoAtraccion.PAISAJE, 120, 6);

		listaUsuarios.add(eowyn);
		listaUsuarios.add(gandalf);
		listaUsuarios.add(sam);
		listaUsuarios.add(galadriel);

		ArrayList<Atraccion> atraccionPA1 = new ArrayList<Atraccion>();
		atraccionPA1.add(bosqueNegro);
		atraccionPA1.add(mordor);

		ArrayList<Atraccion> atraccionPA2 = new ArrayList<Atraccion>();
		atraccionPA2.add(lothlorien);
		atraccionPA2.add(laComarca);

		ArrayList<Atraccion> atraccionPA3 = new ArrayList<Atraccion>();
		atraccionPA3.add(abismoDeHelm);
		atraccionPA3.add(erebor);

		ArrayList<Atraccion> atraccionPP1 = new ArrayList<Atraccion>();
		atraccionPP1.add(lothlorien);
		atraccionPP1.add(laComarca);

		ArrayList<Atraccion> atraccionPP2 = new ArrayList<Atraccion>();
		atraccionPP2.add(bosqueNegro);
		atraccionPP2.add(mordor);

		ArrayList<Atraccion> atraccionPP3 = new ArrayList<Atraccion>();
		atraccionPP3.add(abismoDeHelm);
		atraccionPP3.add(minasTirith);

		ArrayList<Atraccion> atraccionPAxB1 = new ArrayList<Atraccion>();
		atraccionPAxB1.add(minasTirith);
		atraccionPAxB1.add(abismoDeHelm);
		atraccionPAxB1.add(erebor);

		ArrayList<Atraccion> atraccionPAxB2 = new ArrayList<Atraccion>();
		atraccionPAxB2.add(bosqueNegro);
		atraccionPAxB2.add(mordor);

		ArrayList<Atraccion> atraccionPAxB3 = new ArrayList<Atraccion>();
		atraccionPAxB3.add(lothlorien);
		atraccionPAxB3.add(laComarca);

		ArrayList<Promocion> listaPromociones = new ArrayList<Promocion>();

		PromocionAbsoluta pA1 = new PromocionAbsoluta(TipoAtraccion.AVENTURA, atraccionPA1, 15);
		PromocionAbsoluta pA2 = new PromocionAbsoluta(TipoAtraccion.DEGUSTACION, atraccionPA2, 10);
		PromocionAbsoluta pA3 = new PromocionAbsoluta(TipoAtraccion.PAISAJE, atraccionPA3, 5);

		PromocionPorcentual pP1 = new PromocionPorcentual(TipoAtraccion.DEGUSTACION, atraccionPP1, 50);
		PromocionPorcentual pP2 = new PromocionPorcentual(TipoAtraccion.AVENTURA, atraccionPP2, 50);
		PromocionPorcentual pP3 = new PromocionPorcentual(TipoAtraccion.PAISAJE, atraccionPP3, 50);

		PromocionAxB pAxB1 = new PromocionAxB(TipoAtraccion.PAISAJE, atraccionPAxB1);
		PromocionAxB pAxB2 = new PromocionAxB(TipoAtraccion.AVENTURA, atraccionPAxB2);
		PromocionAxB pAxB3 = new PromocionAxB(TipoAtraccion.DEGUSTACION, atraccionPAxB3);

		listaPromociones.add(pA1);
		listaPromociones.add(pA2);
		listaPromociones.add(pA3);
		listaPromociones.add(pP1);
		listaPromociones.add(pP2);
		listaPromociones.add(pP3);
		listaPromociones.add(pAxB1);
		listaPromociones.add(pAxB2);
		listaPromociones.add(pAxB3);
		
		ParqueDeAtracciones park = new ParqueDeAtracciones("SuperPark");
		
		park.addUsuarios(listaUsuarios);
		park.addAtracciones(listaAtracciones);
		park.addPromociones(listaPromociones);
		
	}

}
