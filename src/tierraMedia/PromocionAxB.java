package tierraMedia;

import java.util.Arrays;

public class PromocionAxB extends Promocion {

	private double costoPromocion;

	public PromocionAxB(TipoAtraccion tipoPromocion, Atraccion[] atraccionesDeLaPromocion) {
		super(tipoPromocion, atraccionesDeLaPromocion);
		this.costoPromocion = this.calcularCostoPromocion();
	}

	public Double calcularCostoPromocion() {
		int ultimaPosicion = super.getAtraccionesPromocion().length - 1;
		Atraccion ultimaAtraccion = super.getAtraccionesPromocion()[ultimaPosicion];
		return super.getCostoTotalSinDescuento() - ultimaAtraccion.getCostoAtraccion();
	}

	public double getCostoPromocion() {
		return costoPromocion;
	}

	@Override
	public String toString() {
		return "Pack " + super.getTipoPromocion() + "\nAtracciones incluidas: "
				+ Arrays.toString(super.getAtraccionesPromocion()) + "\nTiempo de duración: "
				+ super.getDuracionPromocion() + " horas" + "\nCosto sin descuento: "
				+ super.getCostoTotalSinDescuento() + " monedas de oro" + "\nCosto final: " + this.getCostoPromocion()
				+ " monedas de oro";
	}

}
