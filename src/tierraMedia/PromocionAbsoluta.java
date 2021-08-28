package tierraMedia;

import java.util.Arrays;

public class PromocionAbsoluta extends Promocion {

	private double descuento;
	private double costoPromocion;

	public PromocionAbsoluta(TipoAtraccion tipoPromocion, Atraccion[] atraccionesDeLaPromocion, double descuento) {
		super(tipoPromocion, atraccionesDeLaPromocion);
		setDescuento(descuento);
		this.costoPromocion = this.calcularCostoPromocion();
	}

	public double getDescuento() {
		return this.descuento;
	}

	public double getCostoPromocion() {
		return costoPromocion;
	}

	public boolean descuentoCorrecto(double valor) {
		return valor < super.getCostoTotalSinDescuento();
	}

	public void setDescuento(double valor) {
		if (descuentoCorrecto(valor)) {
			this.descuento = valor;
		}
	}

	@Override
	public Double calcularCostoPromocion() {
		return super.getCostoTotalSinDescuento() - this.getDescuento();
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
