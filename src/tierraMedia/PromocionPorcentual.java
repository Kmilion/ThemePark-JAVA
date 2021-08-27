package tierraMedia;

import java.util.Arrays;

//Promocion Porcentual recibe un nombre, un arreglo de atracciones y un valor porcentual de descuento y devuelve el costo resultante.
public class PromocionPorcentual extends Promocion {

	private double descuento;

	public PromocionPorcentual(String nombrePromocion, Atraccion[] atraccionesDeLaPromocion, double descuento) {
		super(nombrePromocion, atraccionesDeLaPromocion);
		setDescuento(descuento);
	}

	private void setDescuento(double descuento) {
		if (descuentoCorrecto(descuento)) {
			this.descuento = descuento;
		}
	}

	private boolean descuentoCorrecto(double valor) {
		return valor < 100 && valor > 0;
	}

	private double getDescuento() {
		return this.descuento;
	}

	public Double calcularCostoPromocion() {
		return super.calcularCostoTotalSinDescuento() * (1 - this.getDescuento() / 100);
	}

	@Override
	public String toString() {
		return super.getNombrePromocion() + "\nAtracciones incluidas: "+ super.getAtraccionesDeLaPromocion() + "\nLa Promo tiene un "+ this.getDescuento() +"% de descuento";
	}

}
