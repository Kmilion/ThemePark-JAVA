package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorPromocionesAbsolutas {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("promocionesAbsolutas.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			PromocionAbsoluta[] promocionesAbsolutas = new PromocionAbsoluta[1];
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Double porcentajeDeDescuento = Double.parseDouble(campos[1]);
					Atraccion[] atracciones = new Atraccion[2];
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones[0] = new Atraccion(nombreAtraccionA, 3, 6.5, 150, tipoPromocion);
					atracciones[1] = new Atraccion(nombreAtraccionB, 35, 1, 30, tipoPromocion);

					PromocionAbsoluta promocion = new PromocionAbsoluta(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					promocionesAbsolutas[i] = promocion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < promocionesAbsolutas.length; j++) {
				System.out.println(promocionesAbsolutas[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
