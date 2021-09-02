package tierraMedia;

import java.util.ArrayList;

public class Usuario {

	private String nombre;
	private TipoAtraccion tipoPreferido;
	private int dineroDisponible;
	private double tiempoDisponible;
	private ArrayList<Atraccion> atraccionesCompradas;

	public Usuario(String nombre, TipoAtraccion tipoPreferido, int dineroDisponible, double tiempoDisponible) {
		this.nombre = nombre;
		this.tipoPreferido = tipoPreferido;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionesCompradas = new ArrayList<Atraccion>();
	}

	public String getNombre() {
		return nombre;
	}

	public TipoAtraccion getTipoPreferido() {
		return tipoPreferido;
	}

	public int getDineroDisponible() {
		return dineroDisponible;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public ArrayList<Atraccion> getAtraccionesCompradas() {
		return atraccionesCompradas;
	}

	public void restarTiempo(Sugerencia sugerencia) {
		this.tiempoDisponible -= sugerencia.getDuracion();
	}

	public void restarDinero(Sugerencia sugerencia) {
		this.dineroDisponible -= sugerencia.getCosto();
	}

	public void comprar(Sugerencia oferta) {
		for (Atraccion atraccion : oferta.getAtraccionesPromocion()) {
			this.atraccionesCompradas.add(atraccion);
			atraccion.restarCupo();
		}
		this.restarTiempo(oferta);
		this.restarDinero(oferta);
	}

	public String getDatos() {
		return "Nombre: " + nombre + "\nTipo preferido: " + tipoPreferido + "\nDinero disponible: "
				+ dineroDisponible + " monedas de oro\nTiempo disponible: " + tiempoDisponible + " horas";
	}

}
