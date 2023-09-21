package entidades;

/**
 * Clase que representa a la entidad Empleado, contiene atributos, constructor,
 * propiedades y los getter & setter.
 */
public class Empleado {

	// Atributos
	int numEmpleado;
	String nombre;
	String apellidos;
	String dni;
	String fechaNacimiento;
	String titulacion;
	int numSeguridadSocial;
	String numCuentaBancaria;

	// Constructor
	public Empleado(int numEmpleado, String nombre, String apellidos, String dni, String fechaNacimiento,
			String titulacion, int numSeguridadSocial, String numCuentaBancaria) {
		this.numEmpleado = numEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.titulacion = titulacion;
		this.numSeguridadSocial = numSeguridadSocial;
		this.numCuentaBancaria = numCuentaBancaria;
	}

	// Propiedades getter y setter
	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public int getNumSeguridadSocial() {
		return numSeguridadSocial;
	}

	public void setNumSeguridadSocial(int numSeguridadSocial) {
		this.numSeguridadSocial = numSeguridadSocial;
	}

	public String getNumCuentaBancaria() {
		return numCuentaBancaria;
	}

	public void setNumCuentaBancaria(String numCuentaBancaria) {
		this.numCuentaBancaria = numCuentaBancaria;
	}

	// Métodos
	@Override
	public String toString() {
		return "\n\t--- Datos del empleado con Nº" + numEmpleado + "---\n\n\tNombre y apellidos: " + nombre + " "
				+ apellidos + "\n\tDNI: " + dni + "\n\tFecha de nacimiento: " + fechaNacimiento + "\n\tTitulación:"
				+ titulacion + "\n\tNúmero Seguridad Social: " + numSeguridadSocial + "\n\tIban bancario: "
				+ numCuentaBancaria + "\n\tNúmero de empleado: " + numEmpleado;
	}

	/**
	 * Crea el registro de cada empleado con los datos de los campo separados por ;
	 * 
	 * @return un string con formato que son los datos del empleado
	 */
	public String crearRegistro() {
		return getNombre() + ";" + getApellidos() + ";" + getDni() + ";" + getFechaNacimiento() + ";" + getTitulacion()
				+ ";" + getNumEmpleado();
	}

}
