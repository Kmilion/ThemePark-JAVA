package tierraMedia;

import java.util.Comparator;

public class Ordenador implements Comparator<Sugerencia> {

	/*
	 * @getClass() devuelve el objeto Class que representa la clase en tiempo de
	 * ejecución de un objeto.
	 */

	/*
	 * @Override public int compare(Sugerencia s1, Sugerencia s2) { if
	 * (s1.getClass() == s2.getClass()) { return compare2(s1, s2); } else { if (s1
	 * instanceof Promocion && s2 instanceof Promocion) { return compare2(s1, s2); }
	 * else { if (s1 instanceof Promocion) { return -1; } else { return 1; } } } }
	 */

	@Override
	public int compare(Sugerencia primeraSugerencia, Sugerencia segundaSugerencia) {
		if (primeraSugerencia.getClass() == segundaSugerencia.getClass()) {
			return compare2(primeraSugerencia, segundaSugerencia);
		}
		if (primeraSugerencia instanceof Promocion) {
			return -1;
		} else {
			return 1;
		}
	}

	public int compare2(Sugerencia primeraSugerencia, Sugerencia segundaSugerencia) {
		if (primeraSugerencia.getCosto().compareTo(segundaSugerencia.getCosto()) == 0) {
			return primeraSugerencia.getDuracion().compareTo(segundaSugerencia.getDuracion()) * -1;
		}
		return primeraSugerencia.getCosto().compareTo(segundaSugerencia.getCosto()) * -1;
	}

}
