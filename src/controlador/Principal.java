package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidades.Empleado;
import servicios.*;
/**
 *  Clase Main que es por donde inicia la aplicación, solo estan definidos el procedimiento de ejecución que sigue la aplicación
 */
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean cerrarMenu = false;
		int opcion;

		// Lista que actua como bbdd empleados en al aplicación
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();

		// Ruta del archivo que se guardaran los datos de los empleados
		String rutaFicheroEmpleados = "C:\\Users\\Puesto9\\Desktop\\DatosEmpleados.txt";

		MenuInterface menuInterface = new MenuImpl();
		ControlEmpleadoInterface controlEmpleadoInterface = new ControlEmpleadoImpl();
		GestionFicheroInterface gestionFichero = new GestionFicheroImpl();

		do {
			try {
				opcion = menuInterface.MostrarMenu();

				switch (opcion) {
				case 1:
					controlEmpleadoInterface.RegistroEmpleado(listaEmpleados);
					break;
				case 2:
					controlEmpleadoInterface.ModificarEmpleado(listaEmpleados);
					break;
				case 3:
					controlEmpleadoInterface.MostrarEmpleados(listaEmpleados);
					break;
				case 4:
					gestionFichero.exportarFichero(rutaFicheroEmpleados, listaEmpleados);
					break;
				case 0:
					cerrarMenu = true;
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"\n**[ERROR] ocurrió una excepción no esperada: " + e.getMessage() + " **");
			}
		} while (!cerrarMenu);
		JOptionPane.showMessageDialog(null, "\nDesconectando, saliendo de la aplicación!");
	}
}
