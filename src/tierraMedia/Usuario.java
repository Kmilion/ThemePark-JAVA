package tierraMedia;

import java.util.ArrayList;

public class Usuario {

	/* Atributos de la clase Usuario. */
	private String nombre;
	private TipoAtraccion tipoPreferido;
	private int dineroDisponible;
	private double tiempoDisponible;
	private ArrayList<Atraccion> atraccionesCompradas;
	private int dineroInicial;
	private double tiempoInicial;

	/* Constructor de un Usuario simple. */
	public Usuario(String nombre, TipoAtraccion tipoPreferido, int dineroDisponible, double tiempoDisponible) {
		this.nombre = nombre;
		this.tipoPreferido = tipoPreferido;
		this.dineroDisponible = dineroDisponible;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionesCompradas = new ArrayList<Atraccion>();
		this.dineroInicial = dineroDisponible;
		this.tiempoInicial = tiempoDisponible;
	}

	/* Devuelve el nombre del Usuario. */
	public String getNombre() {
		return nombre;
	}

	/* Devuelve el tipo de atraccion preferido del Usuario. */
	public TipoAtraccion getTipoPreferido() {
		return tipoPreferido;
	}

	/* Devuelve el dinero del que dispone el Usuario para comprar. */
	public int getDineroDisponible() {
		return dineroDisponible;
	}

	/* Devuele el tiempo del que dispone el Usuario para comprar. */
	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	/* Devuelve un ArrayList con las Atraccion compradas por el usuario. */
	public ArrayList<Atraccion> getAtraccionesCompradas() {
		return atraccionesCompradas;
	}

	/*
	 * Resta el tiempo de la Sugerencia, pasada por parámetro, al tiempo del
	 * Usuario.
	 */
	public void restarTiempo(Sugerencia sugerencia) {
		this.tiempoDisponible -= sugerencia.getDuracion();
	}

	/*
	 * Resta el costo de la Sugerencia, pasada por parámetro, al dinero del Usuario.
	 */
	public void restarDinero(Sugerencia sugerencia) {
		this.dineroDisponible -= sugerencia.getCosto();
	}

	/*
	 * Por cada una de las Atraccion incluidas en la Sugerencia pasada por
	 * parámetro, agrega al ArrayList de atracciones compradas las Atraccion que
	 * forman parte de la Sugerencia y cada una de esas Atraccion disminuye su cupo.
	 * A su vez, a través del método comprar el Usuario resta de su tiempo
	 * disponible el Usuario disminuye su tiempo y dinero disponibles en función de
	 * la Sugerencia pasada por parámetro.
	 */
	public void comprar(Sugerencia oferta) {
		for (Atraccion atraccion : oferta.getAtraccionesPromocion()) {
			this.atraccionesCompradas.add(atraccion);
			atraccion.restarCupo();
		}
		this.restarTiempo(oferta);
		this.restarDinero(oferta);
	}

	public int getDineroGastado() {
		return this.dineroInicial - this.dineroDisponible;
	}

	public double getTiempoGastado() {
		return this.tiempoInicial - this.tiempoDisponible;
	}

	/* Devuelve los datos del Usuario en formato String. */
	public String getDatos() {
		return "Nombre: " + nombre + "\nTipo preferido: " + tipoPreferido + "\nDinero disponible: " + dineroDisponible
				+ " monedas de oro\nTiempo disponible: " + tiempoDisponible + " horas";
	}
}
