package tierraMedia;

import java.util.ArrayList;

public class ParqueDeAtracciones {

	private String nombre;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Promocion> promociones;

	public ParqueDeAtracciones(String nombre) {
		this.nombre = nombre;
		this.usuarios = new ArrayList<Usuario>();
		this.atracciones = new ArrayList<Atraccion>();
		this.promociones = new ArrayList<Promocion>();
	}

	public String getNombre() {
		return nombre;
	}

	public void addUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void addAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public void addPromociones(ArrayList<Promocion> promociones) {
		this.promociones = promociones;
	}

	public boolean contieneAtraccion(Usuario u, Promocion promo) {

	}

	public boolean todasTienenCupo(Promocion p) {
		boolean valor = true;
		for (Atraccion a : p.getAtraccionesPromocion()) {
			if (!a.tieneCupo()) {
				valor = false;
			}
		}
		return valor;
	}

	public ArrayList<Comercializable> getOfertasPorTipoPreferido(Usuario u) {
		ArrayList<Comercializable> ofertas = new ArrayList<Comercializable>();
		for (Promocion p : promociones) {
			if (p.getTipo() == u.getTipoPreferido() && p.getCosto() < u.getDineroDisponible()
					&& !contieneAtraccion(u, p) && todasTienenCupo(p)) {
				{
					ofertas.add(p);
				}
			}
		}
		for (Atraccion a : atracciones) {
			if (a.getTipo() == u.getTipoPreferido() && a.getCosto() < u.getDineroDisponible()
					&& !u.getAtraccionesCompradas().contains(a) && a.tieneCupo()) {
				ofertas.add(a);
			}
		}
		return ofertas;
	}
}
