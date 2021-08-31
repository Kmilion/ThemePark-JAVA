package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorPromocionesAxB {

	public static ArrayList<PromocionAxB> getPromocionesAxB() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<PromocionAxB> listaPromocionesAxB = new ArrayList<PromocionAxB>();
		try {
			fr = new FileReader("promocionesAxB.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
					String nombreAtraccionA = campos[1];
					String nombreAtraccionB = campos[2];
					String nombreAtraccionC = campos[3];
					atracciones.add(new Atraccion(nombreAtraccionA, 5, 2.5, 25, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionB, 5, 2, 15, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionC, 12, 3, 32, tipoPromocion));

					PromocionAxB promocion = new PromocionAxB(tipoPromocion, atracciones);
					listaPromocionesAxB.add(promocion);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (PromocionAxB promocion : listaPromocionesAxB) {
				System.out.println(promocion.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPromocionesAxB;
	}
}
