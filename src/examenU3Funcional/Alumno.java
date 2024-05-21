//Examen unidad 3
//Michelle Obeso y Javier Rojo
//Funcional

package examenU3Funcional;

public class Alumno {
	String usuario;
	String contrasena;
	String Nombres;
	String apellidoP;
	String apellidoM;
	String Correo;
	long Teléfono;
	
	// fecha de nacimiento
	int dia;
	int mes;
	int anio;
	
	String nivelEstudios;
	
	public Alumno(String usuario, String contrasena, String nombres, String apellidoP, String apellidoM, String correo, long teléfono,
			int dia, int mes, int anio, String nivelEstudios) {
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.Nombres = nombres;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		Correo = correo;
		Teléfono = teléfono;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.nivelEstudios = nivelEstudios;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public long getTeléfono() {
		return Teléfono;
	}

	public void setTeléfono(long teléfono) {
		Teléfono = teléfono;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	
}
