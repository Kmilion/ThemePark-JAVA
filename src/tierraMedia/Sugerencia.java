package tierraMedia;

import java.util.ArrayList;

public interface Sugerencia {

	TipoAtraccion getTipo();

	Double getDuracion();

	Integer getCosto();
	
	ArrayList<Atraccion> getAtraccionesPromocion();
	
	String getDatos();
	
	boolean hayCupo();

}
