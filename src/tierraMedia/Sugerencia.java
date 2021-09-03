package tierraMedia;

import java.util.ArrayList;

public interface Sugerencia {

	TipoAtraccion getTipo();

	Integer getCosto();

	Double getDuracion();

	ArrayList<Atraccion> getAtraccionesPromocion();

	boolean hayCupo();

	String getDatos();

}
