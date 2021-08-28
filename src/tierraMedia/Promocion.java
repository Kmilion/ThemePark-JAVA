package tierraMedia;

import java.util.ArrayList;

public abstract class Promocion implements AtraccionesYPromociones {

	private TipoAtraccion tipoPromocion;
	private Atraccion[] atraccionesPromocion;
	private double duracionPromocion;
	private double costoTotalSinDescuento;

	public Promocion(TipoAtraccion tipoPromocion, Atraccion[] atracciones) {
		this.tipoPromocion = tipoPromocion;
		this.atraccionesPromocion = atracciones;
		this.duracionPromocion = this.calcularTiempoPromocion();
		this.costoTotalSinDescuento = this.calcularCostoTotalSinDescuento();
	}

	public TipoAtraccion getTipo() {
		return tipoPromocion;
	}

	public Atraccion[] getAtraccionesPromocion() {
		return atraccionesPromocion;
	}

	public double getDuracion() {
		return duracionPromocion;
	}

	public double getCostoTotalSinDescuento() {
		return costoTotalSinDescuento;
	}

	public double calcularTiempoPromocion() {
		double tiempo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			tiempo += atraccion.getDuracion();
		}
		return tiempo;
	}

	public abstract Double calcularCostoPromocion();

	public double calcularCostoTotalSinDescuento() {
		double costo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			costo += atraccion.getCosto();
		}
		return costo;
	}

}
