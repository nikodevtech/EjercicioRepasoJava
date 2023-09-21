package servicios;

import java.util.List;
import entidades.Empleado;

/**
 * Interfaz que define la cabecera de los métodos que se tendrán que implementar
 * para dar servicio a todo lo relacionado con los empleados.
 */
public interface ControlEmpleadoInterface {

	/**
	 * Método encargado de pedir los datos del nuevo empleado para el registro
	 * 
	 * @param listaEmpleados --> Lista con los empleados registrados
	 */
	void RegistroEmpleado(List<Empleado> listaEmpleados);

	/**
	 * Pide los datos a modificar del empleado ya registrado
	 * 
	 * @param listaEmpleados --> Lista con los empleados registrados
	 */
	void ModificarEmpleado(List<Empleado> listaEmpleados);

	/**
	 * Método que itera la lista con los empleados para poder mostrar sus datos
	 * 
	 * @param listaEmpleados --> Lista con los empleados registrados
	 */
	void MostrarEmpleados(List<Empleado> listaEmpleados);

}
