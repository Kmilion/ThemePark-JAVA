package tierraMedia;

import java.util.Arrays;

//Promocion AxB recibe un nombre y un arreglo de atracciones y descuenta la más barata.
public class PromocionAxB extends Promocion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PromocionAxB(String nombrePromocion, Atraccion[] atraccionesDeLaPromocion) {
		super(nombrePromocion, atraccionesDeLaPromocion);
	}

	public Double calcularCostoPromocion() {
		double costoTotal = 0;
		for (int i = 0; i < atraccionesDeLaPromocion.length; i++) {
			costoTotal += atraccionesDeLaPromocion[i].getCosto();
		}
		return costoTotal - this.getAtraccionGratuita().getCosto();
	}

	public Atraccion getAtraccionGratuita() {
		Arrays.sort(this.atraccionesDeLaPromocion, new OrdenadorPorPrecio());
		return this.atraccionesDeLaPromocion[0];
	}
	
}
