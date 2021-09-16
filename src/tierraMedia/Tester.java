package tierraMedia;

import java.io.IOException;

public class Tester {

	public static void iniciarParque(Parque p) throws IOException {
		System.out.println("******** Bievenido a " + p.getNombre() + " ********");
		p.sugerir();
	}

	public static void main(String[] args) throws IOException {
		Parque superpark = new Parque("Parque de Atracciones de la Tierra Media", "usuarios.txt", "atracciones.txt",
				"promocionesPorcentuales.txt", "promocionesAbsolutas.txt", "promocionesAxB.txt");
		iniciarParque(superpark);
	}
}
