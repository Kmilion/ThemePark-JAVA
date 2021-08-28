package tierraMedia;

import java.util.Arrays;

public abstract class Promocion {

	private TipoAtraccion tipoPromocion;
	private Atraccion[] atraccionesPromocion;
	private double duracionPromocion;
	private double costoTotalSinDescuento;

	public Promocion(TipoAtraccion tipoPromocion, Atraccion[] atraccionesPromocion) {
		this.tipoPromocion = tipoPromocion;
		this.atraccionesPromocion = atraccionesPromocion;
		this.duracionPromocion = this.calcularTiempoPromocion();
		this.costoTotalSinDescuento = this.calcularCostoTotalSinDescuento();
	}

	public TipoAtraccion getTipoPromocion() {
		return tipoPromocion;
	}

	public Atraccion[] getAtraccionesPromocion() {
		return atraccionesPromocion;
	}

	public double getDuracionPromocion() {
		return duracionPromocion;
	}


	public double getCostoTotalSinDescuento() {
		return costoTotalSinDescuento;
	}

	public double calcularTiempoPromocion() {
		double tiempo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			tiempo += atraccion.getDuracionAtraccion();
		}
		return tiempo;
	}

	public abstract Double calcularCostoPromocion();

	public double calcularCostoTotalSinDescuento() {
		double costo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			costo += atraccion.getCostoAtraccion();
		}
		return costo;
	}

}
