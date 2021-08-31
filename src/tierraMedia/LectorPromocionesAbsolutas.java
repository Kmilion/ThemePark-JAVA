package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorPromocionesAbsolutas {

	public static ArrayList<PromocionAbsoluta> getPromocionesAbsolutas() {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<PromocionAbsoluta> listaPromocionesAbsolutas = new ArrayList<PromocionAbsoluta>();
		try {
			fr = new FileReader("promocionesAbsolutas.txt");
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					int porcentajeDeDescuento = Integer.parseInt(campos[1]);
					ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones.add(new Atraccion(nombreAtraccionA, 3, 6.5, 150, tipoPromocion));
					atracciones.add(new Atraccion(nombreAtraccionB, 35, 1, 30, tipoPromocion));

					PromocionAbsoluta promocion = new PromocionAbsoluta(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					listaPromocionesAbsolutas.add(promocion);
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (PromocionAbsoluta promocion : listaPromocionesAbsolutas) {
				System.out.println(promocion.getDatos());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaPromocionesAbsolutas;
	}
}
