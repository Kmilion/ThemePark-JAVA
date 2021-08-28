package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorPromocionesAxB {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("promocionesAxB.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			PromocionAxB[] promocionesAxB = new PromocionAxB[1];
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Atraccion[] atracciones = new Atraccion[3];
					String nombreAtraccionA = campos[1];
					String nombreAtraccionB = campos[2];
					String nombreAtraccionC = campos[3];
					atracciones[0] = new Atraccion(nombreAtraccionA, 5, 2.5, 25, tipoPromocion);
					atracciones[1] = new Atraccion(nombreAtraccionB, 5, 2, 15, tipoPromocion);
					atracciones[2] = new Atraccion(nombreAtraccionC, 12, 3, 32, tipoPromocion);

					PromocionAxB promocion = new PromocionAxB(tipoPromocion, atracciones);
					promocionesAxB[i] = promocion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < promocionesAxB.length; j++) {
				System.out.println(promocionesAxB[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
