package servicios;

import java.util.List;

import entidades.Empleado;

/**
 * Interfaz que tiene la cabecera de los métodos que dan servicio a la gestión
 * de ficheros.
 */
public interface GestionFicheroInterface {

	/**
	 * Este método realiza la escritura en el fichero de la ruta que recibe por
	 * argumento
	 * 
	 * @param rutaFichero    ruta absoluta donde se encuentra el fichero
	 * @param listaEmpleados lista con los empleados registrados
	 */
	void exportarFichero(String rutaFichero, List<Empleado> listaEmpleados);
}
