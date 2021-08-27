package tierraMedia;

public class Usuario {

	private String nombre;
	private String tipoPreferido;
	private double presupuesto;
	private double tiempoDisponible;

	public Usuario(String nombre, String tipoPreferido, double presupuesto, double tiempoDisponible) {
		this.nombre = nombre;
		this.tipoPreferido = tipoPreferido;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nPrefiere las atracciones del tipo: " + tipoPreferido + "\nDispone de: "
				+ presupuesto + " monedas de oro\nDispone de: " + tiempoDisponible + " horas";
	}

}
