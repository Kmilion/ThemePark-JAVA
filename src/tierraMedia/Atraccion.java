package tierraMedia;

import java.util.ArrayList;
import java.util.Objects;

public class Atraccion implements Sugerencia, Comparable<Atraccion> {

	private String nombreAtraccion;
	private int costoAtraccion;
	private double duracionAtraccion;
	private int cupoAtraccion;
	private TipoAtraccion tipo;

	public Atraccion(String nombreAtraccion, int costoAtraccion, double duracionAtraccion, int cupoAtraccion,
			TipoAtraccion tipo) {
		this.nombreAtraccion = nombreAtraccion;
		this.costoAtraccion = costoAtraccion;
		this.duracionAtraccion = duracionAtraccion;
		this.cupoAtraccion = cupoAtraccion;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombreAtraccion;
	}

	public Integer getCosto() {
		return costoAtraccion;
	}

	public Double getDuracion() {
		return duracionAtraccion;
	}

	public int getCupoAtraccion() {
		return cupoAtraccion;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public boolean hayCupo() {
		return this.cupoAtraccion > 0;
	}

	public void restarCupo() {
		if (this.hayCupo()) {
			this.cupoAtraccion--;
		}
	}

	public String getDatos() {
		return "Nombre: " + nombreAtraccion + "\nTipo: " + tipo + "\nCosto: " + costoAtraccion + " monedas de oro"
				+ "\nDuración: " + duracionAtraccion + " horas";
	}

	@Override
	public ArrayList<Atraccion> getAtraccionesPromocion() {
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(this);
		return atracciones;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(costoAtraccion, cupoAtraccion, duracionAtraccion, nombreAtraccion, tipo);
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
		return costoAtraccion == other.costoAtraccion && cupoAtraccion == other.cupoAtraccion
				&& Double.doubleToLongBits(duracionAtraccion) == Double.doubleToLongBits(other.duracionAtraccion)
				&& Objects.equals(nombreAtraccion, other.nombreAtraccion) && tipo == other.tipo;
	}

	@Override
	public int compareTo(Atraccion o) {
		if (this.getCosto().compareTo(o.getCosto()) == 0) {
			return this.getDuracion().compareTo(o.getDuracion());
		}
		return this.getCosto().compareTo(o.getCosto());
	}

}
