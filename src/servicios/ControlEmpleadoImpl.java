package servicios;

import java.util.List;

import javax.swing.JOptionPane;

import entidades.Empleado;

/**
 * Clase que implementa la interfaz que da servicio a la gestión de empleados,
 * aquí es donde se detalla la funcionalidad concreta de los métodos de dicha
 * interfaz.
 */
public class ControlEmpleadoImpl implements ControlEmpleadoInterface {

	@Override
	public void RegistroEmpleado(List<Empleado> listaEmpleados) {

		String nombre, apellidos, dni, fechaNacimiento, titulacion, numCuentaBancaria;
		int numEmpleado, numSeguridadSocial;

		numEmpleado = CrearID(listaEmpleados);
		nombre = JOptionPane.showInputDialog("\n\tNombre del empleado: ");
		apellidos = JOptionPane.showInputDialog("\n\tApellidos del empleado: ");
		dni = JOptionPane.showInputDialog("\n\tDNI del empleado: ");
		fechaNacimiento = JOptionPane.showInputDialog("\n\tFecha de nacimiento del empleado: ");
		titulacion = JOptionPane.showInputDialog("\n\tTitulación mas alta del empleado: ");
		numCuentaBancaria = JOptionPane.showInputDialog("\n\tIBAN bancario del empleado: ");
		numSeguridadSocial = Integer
				.parseInt(JOptionPane.showInputDialog("\n\tNúmero de Seguridad social del empleado: "));

		listaEmpleados.add(new Empleado(numEmpleado, nombre, apellidos, dni, fechaNacimiento, titulacion,
				numSeguridadSocial, numCuentaBancaria));
		JOptionPane.showMessageDialog(null, "\n\t** Empleado registrado correctamente en el sistema!! **");
	}

	@Override
	public void ModificarEmpleado(List<Empleado> listaEmpleados) {

		if (!listaEmpleados.isEmpty()) {

			int empleadoEncontrado = EncuentraEmpleado(listaEmpleados);

			if (empleadoEncontrado != -1) { // Entra en el if solo si el empleado existe en la lista por el nº empleado
											// indicado por el usuario

				int posicionEmpleado = empleadoEncontrado;

				int campoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog(
						"\n--- Campos del empleado a modificar ---\n1. Nombre\n\t2. Apellidos\n\t3. DNI\n\t4. Fecha de nacimiento"
								+ "\n\t5. Titulación\n\t6. Número Seguridad Social\n\t7. IBAN bancario"
								+ "\n\nIntroduce el número del campo que quiere modificar: "));
				switch (campoSeleccionado) {
				case 1:
					String nuevoNombre = JOptionPane.showInputDialog("\n\tNuevo nombre del empleado: ");
					// listaEmpleados.get(posicionEmpleado).setNombre() = nombre;
					listaEmpleados.get(posicionEmpleado).setNombre(nuevoNombre);
					break;
				case 2:
					String nuevosApellidos = JOptionPane.showInputDialog("\n\tNuevos apellidos del empleado: ");
					listaEmpleados.get(posicionEmpleado).setApellidos(nuevosApellidos);

					break;
				case 3:
					String nuevoDni = JOptionPane.showInputDialog("\n\tNuevo DNI del empleado: ");
					listaEmpleados.get(posicionEmpleado).setDni(nuevoDni);
					break;
				case 4:

					String nuevaFechaNacimiento = JOptionPane
							.showInputDialog("\n\tNueva fecha de nacimiento del empleado: ");
					listaEmpleados.get(posicionEmpleado).setFechaNacimiento(nuevaFechaNacimiento);
					break;
				case 5:
					String nuevaTitulacion = JOptionPane.showInputDialog("\n\tNueva titulación mayor del empleado: ");
					listaEmpleados.get(posicionEmpleado).setTitulacion(nuevaTitulacion);
					break;
				case 6:
					int nuevoNumSeguridadSocial = Integer.parseInt(
							JOptionPane.showInputDialog("\n\tNuevo número de seguridad social del empleado: "));
					listaEmpleados.get(posicionEmpleado).setNumSeguridadSocial(nuevoNumSeguridadSocial);
					break;
				case 7:
					String nuevoIban = JOptionPane.showInputDialog("\n\tNueva IBAN bancario del empleado: ");
					listaEmpleados.get(posicionEmpleado).setNumCuentaBancaria(nuevoIban);
					break;
				default:
					JOptionPane.showMessageDialog(null, "No se reconoce el campo a modificar introducido");
					;
					break;
				}
				if (campoSeleccionado > 1 && campoSeleccionado < 7)
					JOptionPane.showMessageDialog(null, "Empleado modificado correctamente");
			} else {
				JOptionPane.showMessageDialog(null,
						"No hay empleados registrados en el sistema con el nº empleado introducido");
			}
		} else {
			JOptionPane.showMessageDialog(null, "No hay empleados registrados en el sistema");
		}
	}

	@Override
	public void MostrarEmpleados(List<Empleado> listaEmpleados) {
		if (listaEmpleados.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay empleados registrados en el sistema");
		else {
			for (Empleado e : listaEmpleados) {
				System.out.println(e.toString());
			}
			JOptionPane.showMessageDialog(null, "Mostrando los datos de los empleados por consola");
		}
	}

	/**
	 * Genera un número entero como identificador unívoco (Nº empleado) por cada
	 * nuevo empleado registrado en el sistema
	 * 
	 * @param listaEmpleados --> Lista con los empleados registrados
	 * @return número entero que será el nº empleado
	 */
	private int CrearID(List<Empleado> listaEmpleados) {

		int idMayor = 0;

		if (listaEmpleados.isEmpty())
			return 1;
		else {
			for (Empleado empleado : listaEmpleados) {
				if (empleado.getNumEmpleado() > idMayor)
					idMayor = empleado.getNumEmpleado();
			}
			return ++idMayor;
		}
	}

	/**
	 * Buesca en la lista de empleados la posición de dicho empleado por su número
	 * de empleado
	 * 
	 * @param listaEmpleados --> Lista de los empleados registrados en el sistema
	 * @return Si se encuentra el empleado por su nº devuelve su posición en la
	 *         lista en caso contrario -1
	 */
	private int EncuentraEmpleado(List<Empleado> listaEmpleados) {

		int numEmpleadoElegido, posicionEmpleado = 0;
		boolean numEmpleadoEncontrado = false;

		numEmpleadoElegido = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número del empleado: "));

		for (int i = 0; i < listaEmpleados.size(); i++) {
			if (listaEmpleados.get(i).getNumEmpleado() == numEmpleadoElegido) {
				posicionEmpleado = i;
				numEmpleadoEncontrado = true;
				break;
			}
		}

		if (numEmpleadoEncontrado)
			return posicionEmpleado;
		else
			return -1;
	}

}
