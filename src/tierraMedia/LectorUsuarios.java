package tierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorUsuarios {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("usuarios.txt");
			br = new BufferedReader(fr);
			String linea;
			int i = 0;
			Usuario[] usuarios = new Usuario[4];
			while ((linea = br.readLine()) != null) {
				try {
					String[] campos = linea.split(",");
					String nombre = campos[0];
					TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(campos[1]);
					int dineroDisponible = Integer.parseInt(campos[2]);
					double tiempoDisponible = Double.parseDouble(campos[3]);
					Usuario usuario = new Usuario(nombre, tipoPreferido, dineroDisponible, tiempoDisponible);
					usuarios[i] = usuario;
					i++;
				} catch (NumberFormatException e) {
					System.out.println("Uno de los datos leidos no es un double");
				}
			}
			for (int j = 0; j < usuarios.length; j++) {
				System.out.println(usuarios[j].toString());
				System.out.println("-------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
