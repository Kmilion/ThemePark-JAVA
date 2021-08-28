package tierraMedia;

public class Usuario {

	private String nombreUsuario;
	private TipoAtraccion tipoPreferido;
	private double presupuesto;
	private double tiempoDisponible;

	public Usuario(String nombre, TipoAtraccion tipoPreferido, double presupuesto, double tiempoDisponible) {
		this.nombreUsuario = nombre;
		this.tipoPreferido = tipoPreferido;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	public String getNombre() {
		return nombreUsuario;
	}

	public TipoAtraccion getTipoPreferido() {
		return tipoPreferido;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombreUsuario + "\nPrefiere las atracciones del tipo: " + tipoPreferido + "\nDispone de: "
				+ presupuesto + " monedas de oro\nDispone de: " + tiempoDisponible + " horas";
	}

}
