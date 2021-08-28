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

	public Double getCosto() {
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
		return "Pack " + super.getTipo() + "\nAtracciones incluidas: "
				+ Arrays.toString(super.getAtraccionesPromocion()) + "\nTiempo de duración: "
				+ super.getDuracion() + " horas" + "\nCosto sin descuento: "
				+ super.getCostoTotalSinDescuento() + " monedas de oro" + "\nCosto final: " + this.getCosto()
				+ " monedas de oro";
	}

}
