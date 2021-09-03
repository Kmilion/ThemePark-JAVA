package tierraMedia;

import java.util.ArrayList;
import java.util.Objects;

public class Atraccion implements Sugerencia, Comparable<Atraccion> {

	/* Atributos de la clase Atraccion. */
	private String nombre;
	private int costo;
	private double duracion;
	private int cupo;
	private TipoAtraccion tipo;

	/* Constructor de una Atraccion simple. */
	public Atraccion(String nombreAtraccion, int costoAtraccion, double duracionAtraccion, int cupoAtraccion,
			TipoAtraccion tipo) {
		this.nombre = nombreAtraccion;
		this.costo = costoAtraccion;
		this.duracion = duracionAtraccion;
		this.cupo = cupoAtraccion;
		this.tipo = tipo;
	}

	/* Devuelve el nombre de la Atraccion. */
	public String getNombre() {
		return nombre;
	}

	/* Devuelve el costo de la Atraccion. */
	public Integer getCosto() {
		return costo;
	}

	/* Devuelve la duracion de la Atraccion. */
	public Double getDuracion() {
		return duracion;
	}

	/* Devuelve el cupo de una Atraccion. */
	public int getCupoAtraccion() {
		return cupo;
	}

	/* Devuelve el tipo de la Atraccion. */
	public TipoAtraccion getTipo() {
		return tipo;
	}

	/* Devuelve true si la Atraccion tiene cupo. */
	public boolean hayCupo() {
		return this.cupo > 0;
	}

	/* Resta un cupo de la Atraccion siempre que pueda. */
	public void restarCupo() {
		if (this.hayCupo()) {
			this.cupo--;
		}
	}

	/*
	 * Implementa un método de la Interfaz Sugerencia que devuelve un ArrayList con
	 * las Atraccion que la componen, en este caso va a devolver un ArrayList con
	 * una sola Atraccion.
	 */
	@Override
	public ArrayList<Atraccion> getAtraccionesPromocion() {
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(this);
		return atracciones;
	}

	/* Sobreescribo equals y hashCode para poder comparar una Atracción con otra. */
	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, duracion, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && cupo == other.cupo
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Objects.equals(nombre, other.nombre) && tipo == other.tipo;
	}

	/*
	 * Sobreescribe el método compareTo y lo implementa para que compare por costo y
	 * si son iguales en costo que compare por tiempo.
	 */
	@Override
	public int compareTo(Atraccion otraAtraccion) {
		if (this.getCosto().compareTo(otraAtraccion.getCosto()) == 0) {
			return this.getDuracion().compareTo(otraAtraccion.getDuracion());
		}
		return this.getCosto().compareTo(otraAtraccion.getCosto());
	}

	/* Devuelve los datos de la Atraccion en formato String. */
	public String getDatos() {
		return "Nombre: " + nombre + "\nTipo: " + tipo + "\nCosto: " + costo + " monedas de oro" + "\nDuración: "
				+ duracion + " horas" + "\nCupo: " + cupo;
	}

}
