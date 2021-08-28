package tierraMedia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LecturaEscritura {
	public static void setEscritura() throws IOException {
		File f = new File("datos.obj");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Atraccion("Moria", 10, 2, 6, TipoAtraccion.valueOf("AVENTURA")));
		oos.writeObject(new Atraccion("Minas Tirith", 30, 3, 50, TipoAtraccion.valueOf("PAISAJE")));
		oos.writeObject(new Atraccion("Isengard", 15, 3, 4, TipoAtraccion.valueOf("DEGUSTACION")));
		oos.close();
	}

	public static void getLectura() throws ClassNotFoundException, IOException {
		ObjectInputStream ois = null;
		try {
			File f = new File("datos.obj");
			FileInputStream fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			while (true) {
				Atraccion p = (Atraccion) ois.readObject();
				System.out.println("Nombre: " + p.getNombreAtraccion());
				System.out.println("Costo: " + p.getDuracionAtraccion());
				System.out.println("Tiempo: " + p.getCostoAtraccion());
				System.out.println("*****************");
			}
		} catch (IOException io) {
			System.out.println("\n*********Fin*********");
		} finally {
			ois.close();
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		setEscritura();
		getLectura();
	}
}
