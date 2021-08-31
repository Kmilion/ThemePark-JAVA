package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorPromocionesPorcentuales {
	public static ArrayList<PromocionPorcentual> getPromocionesPorcentuales() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<PromocionPorcentual> listaPromocionesPorcentuales = new ArrayList<PromocionPorcentual>();
		try {
			fr = new FileReader("promocionesPorcentuales.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Double porcentajeDeDescuento = Double.parseDouble(campos[1]);
					ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones.add(new Atraccion(nombreAtraccionA, 3, 4, 12, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionB, 25, 3, 4, tipoPromocion));

					PromocionPorcentual promocion = new PromocionPorcentual(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					listaPromocionesPorcentuales.add(promocion);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (PromocionPorcentual promocion : listaPromocionesPorcentuales) {
				System.out.println(promocion.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPromocionesPorcentuales;
	}
}
