package tierraMedia;

import java.util.ArrayList;
import java.util.Objects;

public class Atraccion implements Sugerencia, Comparable<Atraccion> {

	private String nombre;
	private int costo;
	private double duracion;
	private int cupo;
	private TipoAtraccion tipo;

	public Atraccion(String nombreAtraccion, int costoAtraccion, double duracionAtraccion, int cupoAtraccion,
			TipoAtraccion tipo) {
		this.nombre = nombreAtraccion;
		this.costo = costoAtraccion;
		this.duracion = duracionAtraccion;
		this.cupo = cupoAtraccion;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCosto() {
		return costo;
	}

	public Double getDuracion() {
		return duracion;
	}

	public int getCupoAtraccion() {
		return cupo;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public boolean hayCupo() {
		return this.cupo > 0;
	}

	public void restarCupo() {
		if (this.hayCupo()) {
			this.cupo--;
		}
	}

	public String getDatos() {
		return "Nombre: " + nombre + "\nTipo: " + tipo + "\nCosto: " + costo + " monedas de oro" + "\nDuración: "
				+ duracion + " horas" + "\nCupo: " + cupo;
	}

	@Override
	public ArrayList<Atraccion> getAtraccionesPromocion() {
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		atracciones.add(this);
		return atracciones;
	}



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

	@Override
	public int compareTo(Atraccion otraAtraccion) {
		if (this.getCosto().compareTo(otraAtraccion.getCosto()) == 0) {
			return this.getDuracion().compareTo(otraAtraccion.getDuracion());
		}
		return this.getCosto().compareTo(otraAtraccion.getCosto());
	}

}
