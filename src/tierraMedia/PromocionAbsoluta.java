package tierraMedia;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {

	private int descuento;
	private int costoPromocion;

	public PromocionAbsoluta(TipoAtraccion tipoPromocion, ArrayList<Atraccion> atraccionesDeLaPromocion,
			int descuento) {
		super(tipoPromocion, atraccionesDeLaPromocion);
		setDescuento(descuento);
		this.costoPromocion = this.calcularCostoPromocion();
	}

	public int getDescuento() {
		return this.descuento;
	}

	public boolean descuentoCorrecto(double valor) {
		return valor < super.getCostoTotalSinDescuento();
	}

	public void setDescuento(int valor) {
		if (descuentoCorrecto(valor)) {
			this.descuento = valor;
		}
	}

	@Override
	public int calcularCostoPromocion() {
		return (int) Math.round(super.getCostoTotalSinDescuento() - this.getDescuento());
	}

	@Override
	public int getCosto() {
		return costoPromocion;
	}

	public String getDatos() {
		return "Pack " + super.getTipo() + "\nAtracciones incluidas: " + super.getAtraccionesPromocion()
				+ "\nTiempo de duración: " + super.getDuracion() + " horas" + "\nCosto sin descuento: "
				+ super.getCostoTotalSinDescuento() + " monedas de oro" + "\nCosto final: " + this.getCosto()
				+ " monedas de oro";
	}

}
