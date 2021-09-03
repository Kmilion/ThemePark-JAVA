package tierraMedia;

import java.util.ArrayList;

public class PromocionAxB extends Promocion {

	private int costoPromocion;

	public PromocionAxB(TipoAtraccion tipoPromocion, ArrayList<Atraccion> atraccionesDeLaPromocion) {
		super(tipoPromocion, atraccionesDeLaPromocion);
		this.costoPromocion = this.calcularCostoPromocion();
	}

	public int calcularCostoPromocion() {
		int ultimaCoordenada = super.getAtraccionesPromocion().size() - 1;
		Atraccion ultimaAtraccion = super.getAtraccionesPromocion().get(ultimaCoordenada);
		return (int) (super.getCostoTotalSinDescuento() - ultimaAtraccion.getCosto());
	}

	@Override
	public Integer getCosto() {
		return this.costoPromocion;
	}

	public String getDatos() {
		return "Pack " + super.getTipo() + "\nAtracciones incluidas: " + super.getAtraccionesPromocion()
				+ "\nTiempo de duración: " + super.getDuracion() + " horas" + "\nCosto sin descuento: "
				+ super.getCostoTotalSinDescuento() + " monedas de oro" + "\nCosto final: " + this.getCosto()
				+ " monedas de oro";
	}
}
