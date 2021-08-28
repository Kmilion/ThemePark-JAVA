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
		return super.getCostoTotalSinDescuento() - ultimaAtraccion.getCosto();
	}

	public Double getCosto() {
		return costoPromocion;
	}

	@Override
	public String toString() {
		return "Pack " + super.getTipo() + "\nAtracciones incluidas: "
				+ Arrays.toString(super.getAtraccionesPromocion()) + "\nTiempo de duración: "
				+ super.getDuracion() + " horas" + "\nCosto sin descuento: "
				+ super.getCostoTotalSinDescuento() + " monedas de oro" + "\nCosto final: " + this.getCosto()
				+ " monedas de oro";
	}

}
