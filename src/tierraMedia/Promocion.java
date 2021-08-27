package tierraMedia;

import java.util.Arrays;

public abstract class Promocion {

	protected String nombrePromocion;
	protected Atraccion[] atraccionesDeLaPromocion;
	protected double costoPromocion;
	protected double tiempoPromocion;

	public Promocion(String nombrePromocion, Atraccion[] atraccionesDeLaPromocion) {
		this.nombrePromocion = nombrePromocion;
		this.atraccionesDeLaPromocion = atraccionesDeLaPromocion;
		this.costoPromocion = this.calcularCostoPromocion();
		this.tiempoPromocion = this.calcularTiempoPromocion();
	}

	public abstract Double calcularCostoPromocion();

	public Double calcularTiempoPromocion() {
		double tiempoTotal = 0;
		for (Atraccion atraccion : atraccionesDeLaPromocion) {
			tiempoTotal += atraccion.getTiempo();
		}
		return tiempoTotal;
	}

	public double getCostoPromocion() {
		return this.costoPromocion;
	}

	public double getTiempoPromocion() {
		return this.tiempoPromocion;
	}

	protected double calcularCostoTotalSinDescuento() {
		double costoTotal = 0;
		for (Atraccion atraccion : atraccionesDeLaPromocion) {
			costoTotal += atraccion.getCosto();
		}
		return costoTotal;
	}

	@Override
	public String toString() {
		return "Promocion: " + nombrePromocion + "\n" + "Atracciones incluidas: "
				+ Arrays.toString(atraccionesDeLaPromocion) + "\n" + "Costo total: " + this.calcularCostoPromocion();
	}
	
	public String getNombrePromocion() {
		return nombrePromocion;
	}
	
	public Atraccion[] getAtraccionesDeLaPromocion() {
		return atraccionesDeLaPromocion;
	}

	
}
