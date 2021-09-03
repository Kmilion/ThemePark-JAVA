package tierraMedia;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Promocion implements Sugerencia, Comparable<Promocion> {

	/* Atributos de la clase abstracta Promocion. */
	private TipoAtraccion tipoPromocion;
	private ArrayList<Atraccion> atraccionesPromocion;
	private double duracionPromocion;
	private int costoTotalSinDescuento;

	/* Constructor de promocion, solo se usa para inicializar los atributos. */
	public Promocion(TipoAtraccion tipoPromocion, ArrayList<Atraccion> atracciones) {
		this.tipoPromocion = tipoPromocion;
		this.atraccionesPromocion = atracciones;
		this.duracionPromocion = this.calcularTiempoPromocion();
		this.costoTotalSinDescuento = this.calcularCostoTotalSinDescuento();
	}

	/* Devuelve el tipo de la Promocion. */
	public TipoAtraccion getTipo() {
		return tipoPromocion;
	}

	/* Devuelve un ArrayList con las atracciones incluidas en la Promocion. */
	public ArrayList<Atraccion> getAtraccionesPromocion() {
		return atraccionesPromocion;
	}

	/* Devuelve la duracion de la Promocion. */
	public Double getDuracion() {
		return duracionPromocion;
	}

	/*
	 * Devuelve el costo total de las Atraccion incluidas en la Promocion sin tener
	 * en cuenta el descuento que aplique.
	 */
	public int getCostoTotalSinDescuento() {
		return costoTotalSinDescuento;
	}

	/* Calcula el tiempo total de las Atraccion incluidas en la Promocion. */
	public double calcularTiempoPromocion() {
		double tiempo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			tiempo += atraccion.getDuracion();
		}
		return tiempo;
	}

	/* Calcula el tiempo total de las Atraccion incluidas en la Promocion. */
	public int calcularCostoTotalSinDescuento() {
		int costo = 0;
		for (Atraccion atraccion : atraccionesPromocion) {
			costo += atraccion.getCosto();
		}
		return costo;
	}

	/* Devuelve true si las Atraccion de la Promocion tienen cupo. */
	public boolean hayCupo() {
		for (Atraccion a : this.atraccionesPromocion) {
			if (!a.hayCupo()) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Declara el método abstracto calcularCostoPromocion() que se implementa luego
	 * en cada subclase.
	 */
	public abstract int calcularCostoPromocion();

	/*
	 * Declara el método abstracto getCosto() que se implementa luego en cada
	 * subclase.
	 */
	public abstract Integer getCosto();

	/*
	 * Declara el método abstracto getDatos() que se implementa luego en cada
	 * subclase.
	 */
	public abstract String getDatos();

	/* Sobreescribo equals y hashCode para poder comparar una Promocion con otra. */
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

	/*
	 * Sobreescribe el método compareTo y lo implementa para que compare por costo y
	 * si son iguales en costo que compare por tiempo.
	 */
	@Override
	public int compareTo(Promocion otraPromocion) {
		if (this.getCosto().compareTo(otraPromocion.getCosto()) == 0) {
			return this.getDuracion().compareTo(otraPromocion.getDuracion());
		}
		return this.getCosto().compareTo(otraPromocion.getCosto());
	}
}
