package tierraMedia;

import java.io.Serializable;
import java.util.Objects;

public class Atraccion implements Comparable<Atraccion>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreAtraccion;
	private double costo;
	private double tiempo;
	private int cupoInicial;
	private String tipo;

	public Atraccion(String nombre, double costo, double tiempo, int cupo, String tipo) {
		this.nombreAtraccion = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupoInicial = cupo;
		this.tipo = tipo;
	}

	public Double getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, tiempo);
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
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo);
	}

	@Override
	public int compareTo(Atraccion otraAtraccion) {
		return this.getCosto().compareTo(otraAtraccion.getCosto());
	}

	public String getNombreAtraccion() {
		return nombreAtraccion;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombreAtraccion + "\nCosto: " + costo + " monedas de oro" + "\nTiempo: " + tiempo + " horas"
				+ "\nTipo: " + tipo;
	}
	
	

}
