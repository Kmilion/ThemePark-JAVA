package tierraMedia;

import java.util.ArrayList;

public abstract class Promocion implements Comercializable {

	private TipoAtraccion tipoPromocion;
	private ArrayList<Atraccion> atraccionesPromocion;
	private double duracionPromocion;
	private int costoTotalSinDescuento;

	public Promocion(TipoAtraccion tipoPromocion, ArrayList<Atraccion> atracciones) {
		this.tipoPromocion = tipoPromocion;
		this.atraccionesPromocion = atracciones;
		this.duracionPromocion = this.calcularTiempoPromocion();
		this.costoTotalSinDescuento = this.calcularCostoTotalSinDescuento();
	}

	public TipoAtraccion getTipo() {
		return tipoPromocion;
	}

	public ArrayList<Atraccion> getAtraccionesPromocion() {
		return atraccionesPromocion;
	}

	public double getDuracion() {
		return duracionPromocion;
	}

	public int getCostoTotalSinDescuento() {
		return costoTotalSinDescuento;
	}

	public double calcularTiempoPromocion() {
		double tiempo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			tiempo += atraccion.getDuracion();
		}
		return tiempo;
	}

	public int calcularCostoTotalSinDescuento() {
		int costo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			costo += atraccion.getCosto();
		}
		return costo;
	}

	public abstract int calcularCostoPromocion();

	public abstract int getCosto();

}
