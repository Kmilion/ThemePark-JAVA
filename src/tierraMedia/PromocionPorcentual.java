package tierraMedia;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	private double descuento;
	private int costoPromocion;

	public PromocionPorcentual(TipoAtraccion tipoPromocion, ArrayList<Atraccion> atracciones, double descuento) {
		super(tipoPromocion, atracciones);
		this.setDescuento(descuento);
		this.costoPromocion = this.calcularCostoPromocion();
	}

	public double getDescuento() {
		return descuento;
	}

	private boolean descuentoCorrecto(double valor) {
		return valor < 100 && valor > 0;
	}

	private void setDescuento(double descuento) {
		if (descuentoCorrecto(descuento)) {
			this.descuento = descuento;
		}
	}

	public int calcularCostoPromocion() {
		return (int) Math.round(super.getCostoTotalSinDescuento() * (1 - this.getDescuento() / 100));
	}


	public String getDatos() {
		return "Pack " + super.getTipo() + "\nAtracciones incluidas: " + super.getAtraccionesPromocion()
				+ "\nTiempo de duración: " + super.getDuracion() + " horas" + "\nCosto sin descuento: "
				+ super.getCostoTotalSinDescuento() + " monedas de oro" + "\nCosto final: " + this.getCosto()
				+ " monedas de oro";
	}

	@Override
	public Integer getCosto() {
		return this.costoPromocion;
	}
}
