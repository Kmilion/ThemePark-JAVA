package tierraMedia;

//Promocion Absoluta recibe un nombre, un arreglo de atracciones, y un valor neto de descuento y devuelve el valor total menos el descuento.
public class PromocionAbsoluta extends Promocion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double descuento;

	public PromocionAbsoluta(String nombrePromocion, Atraccion[] atraccionesDeLaPromocion, double descuento) {
		super(nombrePromocion, atraccionesDeLaPromocion);
		setDescuento(descuento);
	}

	public double getDescuento() {
		return this.descuento;
	}

	// Error posible
	private void setDescuento(double valor) {
		if (descuentoCorrecto(valor)) {
			this.descuento = valor;
		}
	}

	protected boolean descuentoCorrecto(double valor) {
		return valor < super.calcularCostoTotalSinDescuento();
	}

	@Override
	public Double calcularCostoPromocion() {
		return super.calcularCostoTotalSinDescuento() - this.getDescuento();
	}

	
}
