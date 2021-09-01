package tierraMedia;

import java.util.Comparator;

public class Ordenador implements Comparator<Sugerencia> {

	@Override
	public int compare(Sugerencia s1, Sugerencia s2) {
		if (s1.getClass() == s2.getClass()) {
			return compare2(s1, s2);
		} else {
			if (s1 instanceof Promocion && s2 instanceof Promocion) {
				return compare2(s1, s2);
			} else {
				if (s1 instanceof Promocion) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}

	public int compare2(Sugerencia s1, Sugerencia s2) {
		if (s1.getCosto().compareTo(s2.getCosto()) == 0) {
			return s1.getDuracion().compareTo(s2.getDuracion());
		}
		return s1.getCosto().compareTo(s2.getCosto()) * -1;
	}

}
