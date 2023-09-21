package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JOptionPane;

import entidades.Empleado;

/**
 * Clase que implementa la interfaz para la gestión del tratamiento de fichero,
 * en ella se definen el detalle y la funcionalidad de dichos métodos.
 */
public class GestionFicheroImpl implements GestionFicheroInterface {

	@Override
	public void exportarFichero(String rutaFichero, List<Empleado> listaEmpleados) {

		FileWriter fichero = null;
		PrintWriter pw = null;

		try {

			fichero = new FileWriter(rutaFichero, true);
			pw = new PrintWriter(fichero);

			if (listaEmpleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay empleados registrados en el sistema, imposible exportar");
			} else {
				for (Empleado empleado : listaEmpleados)
					pw.println(empleado.crearRegistro());

				JOptionPane.showMessageDialog(null,
						"Archivo con los datos de los empleados escrito correctamente en " + rutaFichero);
			}
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "[ERROR] - FICHERO NO ENCONTRARO: " + fichero + "\n" + ioe);
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (IOException ioe2) {
				JOptionPane.showMessageDialog(null, "[ERROR] - ERROR AL CERRAR FICHERO: " + fichero + "\n" + ioe2);
			}
		}
	}

}
