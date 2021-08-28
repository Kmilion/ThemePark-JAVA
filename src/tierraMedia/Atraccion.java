package tierraMedia;

public class Atraccion {

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

	public String getNombreAtraccion() {
		return nombreAtraccion;
	}

	public Double getCostoAtraccion() {
		return costoAtraccion;
	}

	public double getDuracionAtraccion() {
		return duracionAtraccion;
	}

	public int getCupoAtraccion() {
		return cupoAtraccion;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return nombreAtraccion;
	}

}
