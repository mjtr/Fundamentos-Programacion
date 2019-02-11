package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.TipoAsignatura;

public class TestAlumno {

	public static void main(String[] args) {

		testConstructorNormal();
		testConstructorNormal2();
		testConstructorExcepcion();

		testSetEmailNormal();
		testSetEmailExcepcion();

		testMatriculaAsignatura();
		testMatriculaAsignaturaExcepcion();

		testEliminaAsignatura();
		testEliminaAsignaturaExcepcion();
		testEvaluaAlumno1();
		testEvaluaAlumno2();

		testEvaluaAlumno1Excepcion();
		testEvaluaAlumno2Excepcion();
		
	}

	private static void testConstructorNormal() {
		System.out
				.println("\n==================================Probando el primer constructor");
		
		testConstructor("12345678Z", "Antonio", "Machado",
				LocalDate.of(1950, 3, 15), "antonio@alum.us.es");
		
	}

	private static void testConstructorNormal2() {
		System.out
				.println("\n==================================Probando el primer constructor,curso del alumno");
		
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		testMatriculaAsignatura(a, asig);
		
		mostrarAlumno(a);
		
	}

	private static void testConstructorExcepcion() {
		System.out
				.println("\n==================================Probando el primer constructor, email incorrecto");
		testConstructor("12345678Z", "Inmaculada", "Arenas Baeza",
				LocalDate.of(1950, 3, 15), "Inma@gmail.com");
	}

	private static void testSetEmailNormal() {
		System.out
				.println("\n==================================Probando setEmail");

		Alumno a = new AlumnoImpl("12345678Z", "Pepe", "Ruiz Rodriguez",
				LocalDate.of(1950, 3, 15), "pepe@alum.us.es");
		testSetEmails(a, "juan@alum.us.es");
	}

	private static void testSetEmailExcepcion() {
		System.out
				.println("\n==================================Probando setEmail, email incorrecto");

		Alumno a = new AlumnoImpl("12345678Z", "Manuel", "Santiago Segura",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testSetEmails(a, "juan@gmail.com ");
	}

	private static void testMatriculaAsignatura() {
		System.out
				.println("\n==================================Probando matriculaAsignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		testMatriculaAsignatura(a, asig);
	}

	private static void testMatriculaAsignaturaExcepcion() {
		System.out
				.println("\n==================================Probando matriculaAsignatura, matricula doble en una asignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		a.matriculaAsignatura(asig);
		testMatriculaAsignatura(a, asig);
	}

	private static void testEliminaAsignatura() {
		System.out
				.println("\n==================================Probando eliminaAsignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		a.matriculaAsignatura(asig);
		testEliminaAsignatura(a, asig);
	}

	private static void testEvaluaAlumno1(){
		
		System.out.println("===================================Probando el evalua alumno: ");
		
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		a.matriculaAsignatura(asig);
		
		testEvaluaAlumno(a,asig, 1995,Convocatoria.PRIMERA, 8.9);
		
		
	}
private static void testEvaluaAlumno1Excepcion(){
		
		System.out.println("===================================Probando el evalua alumno con excepcion: ");
		
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		
		testEvaluaAlumno(a,asig, 1995,Convocatoria.PRIMERA, 8.9);
		
		
	}
	private static void testEvaluaAlumno2(){
		
		System.out.println("==========================================Probando el evalua alumno: ");
		
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
	a.matriculaAsignatura(asig);
		
		testEvaluaAlumno(a,asig, 2005,Convocatoria.PRIMERA, 9.0,true);
		
		
	}
	

	private static void testEvaluaAlumno2Excepcion(){
		
		System.out.println("==========================================Probando el evalua alumno con excepcion: ");
		
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		
		testEvaluaAlumno(a,asig, 2005,Convocatoria.PRIMERA, 9.0,true);
		
		
	}
	private static void testEliminaAsignaturaExcepcion() {
		System.out
				.println("\n==================================Probando eliminaAsignatura, asignatura no matriculada");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1,null);
		testEliminaAsignatura(a, asig);
	}

	private static void testConstructor(String dni, String nombre,
			String apellidos, LocalDate fechaNacimiento, String email) {

		try {
			Alumno a = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento,
					email);
			mostrarAlumno(a);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println(e);
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	private static void testSetEmails(Alumno a, String nuevoEmail) {

		try {
			System.out.println("El email antes de la operación es: "
					+ a.getEmail());
			System.out.println("El nuevo email es: " + nuevoEmail);
			a.setEmail(nuevoEmail);
			System.out.println("El email después de la operación es: "
					+ a.getEmail());
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println(e);
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testMatriculaAsignatura(Alumno a, Asignatura asig) {

		try {
			System.out.println("Las asignaturas antes de la operación son: "
					+ a.getAsignaturas());
			System.out.println("Nueva asignatura a matricular: " + asig);
			a.matriculaAsignatura(asig);
			System.out.println("Las asignaturas después de la operación son: "
					+ a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out
					.println(e);
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testEliminaAsignatura(Alumno a, Asignatura asig) {

		try {
			System.out.println("Las asignaturas antes de la operación son: "
					+ a.getAsignaturas());
			System.out.println("Asignatura a eliminar: " + asig);
			a.eliminaAsignatura(asig);
			System.out.println("Las asignaturas después de la operación son: "
					+ a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out
					.println(e);
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}
	
	
	private static void testEvaluaAlumno(Alumno c,Asignatura a, 
			Integer curso, Convocatoria convocatoria, Double nota, Boolean mencionHonor){
		
		try{
			System.out.println("Expediente del alumno antes de la operación" + c.getExpediente());
			c.evaluaAlumno(a, curso, convocatoria, nota,mencionHonor);
			System.out.println(" ");
			System.out.println("Expediente del alumno después de la operación" + c.getExpediente());

			
		}catch(ExcepcionAlumnoOperacionNoPermitida e){
			System.out.println(e);
			
		}catch(Exception e ){
			
			System.out.println("Se ha capturado una excepción inesperada" + e);
		}
	}
		private static void testEvaluaAlumno(Alumno c,Asignatura a, 
				Integer curso, Convocatoria convocatoria, Double nota){
			
			try{
				System.out.println("Expediente del alumno antes de la operación" + c.getExpediente());
				c.evaluaAlumno(a, curso, convocatoria, nota);
				System.out.println(" ");
				System.out.println("Expediente del alumno después de la operación" + c.getExpediente());

				
			}catch(ExcepcionAlumnoOperacionNoPermitida e){
				System.out.println(e);
				
			}catch(Exception e ){
				
				System.out.println("Se ha capturado una excepción inesperada" + e);
			}
	}

	private static void mostrarAlumno(Alumno a) {
		System.out.println("Alumno --> <" + a + ">");
		System.out.println("\tDNI: <" + a.getDNI() + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tApellidos: <" + a.getApellidos() + ">");
		System.out.println("\tFecha Nacimiento: <"
				+ a.getFechaNacimiento().format(
						DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + a.getEdad() + ">");
		System.out.println("\tEmail:  <" + a.getEmail() + ">");
		System.out.println("\tAsignaturas:  <" + a.getAsignaturas() + ">");
		System.out.println("\tCurso: " + a.getCurso());
		System.out.println("\tExpediente: " + a.getExpediente());
		System.out.println("\tAsignaturas ordenadas por curso: " + a.getAsignaturasOrdenadasPorCurso());
	}
}