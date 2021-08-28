package tierraMedia;

public class SistemaGestionTrucho {

	public static void main(String[] args) {

		Atraccion moria = new Atraccion("Moria", 10, 2, 6, TipoAtraccion.AVENTURA);
		Atraccion minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccion.PAISAJE);
		Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtraccion.DEGUSTACION);
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TipoAtraccion.AVENTURA);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccion.PAISAJE);
		Atraccion lothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtraccion.DEGUSTACION);
		Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, TipoAtraccion.PAISAJE);
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtraccion.AVENTURA);

		Usuario eowyn = new Usuario("Eowyn", TipoAtraccion.AVENTURA, 10, 8);
		Usuario gandalf = new Usuario("Gandalf", TipoAtraccion.PAISAJE, 100, 5);
		Usuario sam = new Usuario("Sam", TipoAtraccion.DEGUSTACION, 36, 8);
		Usuario galadriel = new Usuario("Sam", TipoAtraccion.PAISAJE, 120, 6);

		Atraccion[] atraccionPA = new Atraccion[2];
		atraccionPA[0] = bosqueNegro;
		atraccionPA[1] = mordor;
		
		Atraccion[] atraccionPP = new Atraccion[2];
		atraccionPP[0] = lothlorien;
		atraccionPP[1] = laComarca;
		
		Atraccion[] atraccionPAxB = new Atraccion[3];
		atraccionPAxB[0] = minasTirith;
		atraccionPAxB[1] = abismoDeHelm;
		atraccionPAxB[2] = erebor;

		PromocionAbsoluta pA = new PromocionAbsoluta(TipoAtraccion.AVENTURA, atraccionPA, 20);
		PromocionPorcentual pP = new PromocionPorcentual(TipoAtraccion.DEGUSTACION, atraccionPP, 2);
		PromocionAxB pAxB = new PromocionAxB(TipoAtraccion.PAISAJE, atraccionPAxB);
		
		moria.restarCupo();
		System.out.println(moria.getCupoAtraccion());
	}

}
