package tierraMedia;

import java.util.Arrays;

public class PromocionPorcentual extends Promocion {

	private double descuento;
	private double costoPromocion;

	public PromocionPorcentual(TipoAtraccion tipoPromocion, Atraccion[] atraccionesPromocion, double descuento) {
		super(tipoPromocion, atraccionesPromocion);
		setDescuento(descuento);
		this.costoPromocion = this.calcularCostoPromocion();
	}

	public double getDescuento() {
		return descuento;
	}

	public double getCostoPromocion() {
		return costoPromocion;
	}

	private boolean descuentoCorrecto(double valor) {
		return valor < 100 && valor > 0;
	}

	private void setDescuento(double descuento) {
		if (descuentoCorrecto(descuento)) {
			this.descuento = descuento;
		}
	}

	public Double calcularCostoPromocion() {
		return super.getCostoTotalSinDescuento() * (1 - this.getDescuento() / 100);
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
