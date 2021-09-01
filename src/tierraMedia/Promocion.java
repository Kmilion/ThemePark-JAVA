package tierraMedia;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Promocion implements Sugerencia, Comparable<Promocion> {

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

	public Double getDuracion() {
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
	
	public boolean hayCupo() {
		for (Atraccion a : this.atraccionesPromocion) {
			if (!a.hayCupo()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atraccionesPromocion, costoTotalSinDescuento, duracionPromocion, tipoPromocion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atraccionesPromocion, other.atraccionesPromocion)
				&& costoTotalSinDescuento == other.costoTotalSinDescuento
				&& Double.doubleToLongBits(duracionPromocion) == Double.doubleToLongBits(other.duracionPromocion)
				&& tipoPromocion == other.tipoPromocion;
	}

	public abstract int calcularCostoPromocion();

	public abstract Integer getCosto();

	public abstract String getDatos();

	@Override
	public int compareTo(Promocion o) {
		if (this.getCosto().compareTo(o.getCosto()) == 0) {
			return this.getDuracion().compareTo(o.getDuracion());
		}
		return this.getCosto().compareTo(o.getCosto());
	}
}
