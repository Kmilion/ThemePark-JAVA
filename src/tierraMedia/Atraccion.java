package tierraMedia;

import java.util.Objects;

public class Atraccion implements AtraccionesYPromociones {

	private String nombreAtraccion;
	private double costoAtraccion;
	private double duracionAtraccion;
	private int cupoAtraccion;
	private TipoAtraccion tipo;

	public Atraccion(String nombreAtraccion, double costoAtraccion, double duracionAtraccion, int cupoAtraccion,
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

	public Double getCosto() {
		return costoAtraccion;
	}

	public double getDuracion() {
		return duracionAtraccion;
	}

	public int getCupoAtraccion() {
		return cupoAtraccion;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public void restarCupo() {
		if (this.cupoAtraccion > 0) {
			this.cupoAtraccion--;
		}
	}

	@Override
	public String toString() {
		return nombreAtraccion;
	}

	public String getDatos() {
		return "Nombre: " + nombreAtraccion + "\nTipo: " + tipo + "\nCosto: " + costoAtraccion + " monedas de oro"
				+ "\nDuración: " + duracionAtraccion + " horas";
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
		return Double.doubleToLongBits(costoAtraccion) == Double.doubleToLongBits(other.costoAtraccion)
				&& cupoAtraccion == other.cupoAtraccion
				&& Double.doubleToLongBits(duracionAtraccion) == Double.doubleToLongBits(other.duracionAtraccion)
				&& Objects.equals(nombreAtraccion, other.nombreAtraccion) && tipo == other.tipo;
	}

}
