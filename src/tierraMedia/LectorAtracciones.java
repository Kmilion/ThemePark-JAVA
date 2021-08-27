package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorAtracciones {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("atracciones.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			Atraccion[] atracciones = new Atraccion[8];
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					String nombre = campos[0];
					double costo = Double.parseDouble(campos[1]);
					double tiempo = Double.parseDouble(campos[2]);
					int cupo = Integer.parseInt(campos[3]);
					String tipo = campos[4];
					Atraccion atraccion = new Atraccion(nombre, costo, tiempo, cupo, tipo);
					atracciones[i] = atraccion;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < atracciones.length; j++) {
				System.out.println(atracciones[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
