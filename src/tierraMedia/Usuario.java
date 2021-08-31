package tierraMedia;

import java.util.ArrayList;

public class Usuario {

	private String nombreUsuario;
	private TipoAtraccion tipoPreferido;
	private int dineroDisponible;
	private double tiempoDisponible;
	private ArrayList<Atraccion> atraccionesCompradas;

	public Usuario(String nombre, TipoAtraccion tipoPreferido, int dineroDisponible, double tiempoDisponible) {
		this.nombreUsuario = nombre;
		this.tipoPreferido = tipoPreferido;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionesCompradas = new ArrayList<Atraccion>();
	}

	public String getNombre() {
		return nombreUsuario;
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

	public void restarTiempo(Comercializable oferta) {
		this.tiempoDisponible -= oferta.getDuracion();
	}

	public void restarDinero(Comercializable oferta) {
		this.dineroDisponible -= oferta.getCosto();
	}

	public void comprar(Promocion oferta) {
		for (Atraccion atraccion : oferta.getAtraccionesPromocion()) {
			this.atraccionesCompradas.add(atraccion);
			atraccion.restarCupo();
		}
		this.restarTiempo(oferta);
		this.restarDinero(oferta);
	}

	public void comprar(Atraccion oferta) {
		this.atraccionesCompradas.add(oferta);
		oferta.restarCupo();
		this.restarDinero(oferta);
		this.restarTiempo(oferta);
	}

	public String getDatos() {
		return "Nombre: " + nombreUsuario + "\nPrefiere las atracciones del tipo: " + tipoPreferido + "\nDispone de: "
				+ dineroDisponible + " monedas de oro\nDispone de: " + tiempoDisponible + " horas";
	}

}
