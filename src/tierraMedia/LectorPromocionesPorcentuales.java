package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorPromocionesPorcentuales {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("promocionesPorcentuales.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			PromocionPorcentual[] promocionesPorcentuales = new PromocionPorcentual[1];
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					TipoAtraccion tipoPromocion = TipoAtraccion.valueOf(campos[0]);
					Double porcentajeDeDescuento = Double.parseDouble(campos[1]);
					Atraccion[] atracciones = new Atraccion[2];
					String nombreAtraccionA = campos[2];
					String nombreAtraccionB = campos[3];
					atracciones[0] = new Atraccion(nombreAtraccionA, 3, 4, 12, tipoPromocion);
					atracciones[1] = new Atraccion(nombreAtraccionB, 25, 3, 4, tipoPromocion);

					PromocionPorcentual promocion = new PromocionPorcentual(tipoPromocion, atracciones,
							porcentajeDeDescuento);
					promocionesPorcentuales[i] = promocion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < promocionesPorcentuales.length; j++) {
				System.out.println(promocionesPorcentuales[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
