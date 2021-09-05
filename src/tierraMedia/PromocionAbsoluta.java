package tierraMedia;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {

	private int descuento;
	private int costoPromocion;

	public PromocionAbsoluta(String nombre, TipoAtraccion tipoPromocion, ArrayList<Atraccion> atraccionesDeLaPromocion,
			int descuento) {
		super(nombre, tipoPromocion, atraccionesDeLaPromocion);
		setDescuento(descuento);
		this.costoPromocion = this.calcularCostoPromocion();
	}

	/* Devuelve el descuento neto que uso para armar la Promocion Absoluta. */
	public int getDescuento() {
		return this.descuento;
	}

	/*
	 * Devuelve true si el descuento neto es menor que el costo total sin descuento
	 * de las atracciones incluidas en la Promocion.
	 */
	public boolean descuentoCorrecto(double valor) {
		return valor < super.getCostoTotalSinDescuento();
	}

	/*
	 * Setea el valor del descuento neto siempre que se cumpla la condicion
	 * descuentoCorrecto()
	 */
	public void setDescuento(int valor) {
		if (descuentoCorrecto(valor)) {
			this.descuento = valor;
		}
	}

	/* Calcula el costo de la Promocion con el descuento aplicado. */
	@Override
	public int calcularCostoPromocion() {
		return Math.round(super.getCostoTotalSinDescuento() - this.getDescuento());
	}

	/*
	 * Devuelve el costo de la Promocion y lo convierte a tipo Integer para poder
	 * comparar luego.
	 */
	@Override
	public Integer getCosto() {
		return this.costoPromocion;
	}

	/* Devuelve en formato String los datos de la Promocion. */
	public String getDatos() {
		return super.getNombre() + "\nTipo: " + super.getTipo() + "\nAtracciones incluidas: "
				+ super.getNombreAtracciones() + "\nCosto: " + this.getCosto() + " monedas de oro" + "\nDuración: "
				+ super.getDuracion() + " horas";
	}
}
