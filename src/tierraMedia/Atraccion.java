package tierraMedia;

public class Atraccion implements Comercializable {

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

	public int getCosto() {
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

	public boolean tieneCupo() {
		return this.cupoAtraccion > 0;
	}

	public void restarCupo() {
		if (this.tieneCupo()) {
			this.cupoAtraccion--;
		}
	}

	public String getDatos() {
		return "Nombre: " + nombreAtraccion + "\nTipo: " + tipo + "\nCosto: " + costoAtraccion + " monedas de oro"
				+ "\nDuración: " + duracionAtraccion + " horas";
	}

}
