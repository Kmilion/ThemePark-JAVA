package tierraMedia;

import java.util.Comparator;

public class OrdenadorPorPrecio implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion atraccionA, Atraccion atraccionB) {
		return atraccionA.getCosto().compareTo(atraccionB.getCosto());
	}

}
