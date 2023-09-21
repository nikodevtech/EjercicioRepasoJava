package servicios;

import javax.swing.JOptionPane;

/**
 * Clase que implementa la interfaz menú y es donde se detalla la funcionalidad
 * exacta de los métodos de dicha interfaz.
 */
public class MenuImpl implements MenuInterface {

	@Override
	public int MostrarMenu() {

		return Integer.parseInt(JOptionPane.showInputDialog(
				"\n--- MENU ---\n" + "\n1. Registro empleado\n" + "2. Modificar empleado\n3. Mostrar empleados"
						+ "\n4. Exportar fichero\n0. Salir\n" + "\nIntroduce la opción deseada: "));
	}

}
