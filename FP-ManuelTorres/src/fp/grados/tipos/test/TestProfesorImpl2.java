package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;










import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;


public class TestProfesorImpl2 {

	public static void main(String[] args) {

		testConstructor1Normal();
		testConstructor1Normal2();
		testConstructor1Excepcional1();
		
		testSetCategoria();
		
		testNuevaTutoria1();
	
		testBorraTutoria1();
		testBorraTutoria2();
		
		tesBorraTodasTutorias();
		
		testImparteAsignatura();
		testImparteAsignaturaExcepcion1();
		testImparteAsignaturaExcepcion2();
		
		testDedicacionPorAsignatura();

		testEliminaAsignatura();
		
	}


	/************************CASOS DE PRUEBA***************************/
	
	private static void testConstructor1Normal() {
		System.out.println("==================================Probando el primer constructor");
		testConstructor1("12345678Z", "Pablo", "Benito Balderrama", 
				LocalDate.of(1950, 3, 15), "pablito@gmail.com",Categoria.TITULAR,null);
		System.out.println("      ");
	}

	private static void testConstructor1Normal2() {
		System.out.println("==================================Probando el primer constructor con profesor de edad 18 a�os");
		testConstructor1("12345678Z", "Pablo", "Benito Balderrama", 
				LocalDate.of(1996, 3, 15), "pablito@gmail.com",Categoria.TITULAR,null);
		System.out.println("      ");
	}


	
	
	private static void testNuevaTutoria1() {
		System.out
				.println("==================================Probando el m�todo nueva tutor�a:");
		
	Profesor r = new ProfesorImpl2("12345678Z", "Sara", "Cabeza Sanch�s", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,null);
		
				
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.WEDNESDAY,r);
		
	
		
		
	}

	private static void testSetCategoria(){
		
		
		System.out.println("=========================Probando el set Categoria");
		System.out.println("            ");
		Profesor r = new ProfesorImpl2("12345678Z", "Sara", "Cabeza Sanch�s", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,null);
		
		testSetCategoria(r,Categoria.COLABORADOR);
		
	System.out.println("         ");	
		
	}
	
	
	
	private static void testBorraTutoria1() {
		System.out
				.println("==================================Probando el m�todo Borra Tutorias:");
		Profesor r = new ProfesorImpl2("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com",Categoria.CATEDRATICO,null);
		System.out.println("***A�ADO PRIMERO DOS TUTOR�AS");
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.WEDNESDAY,r);
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.FRIDAY,r);
		System.out.println("*****AHORA BORRO UNA DE LAS DOS");
		testBorraTutoria(LocalTime.of(13, 40),DayOfWeek.WEDNESDAY,r);
		
	}
	private static void testBorraTutoria2() {
		System.out
				.println("=====================Probando el m�todo Borra Tutorias sin que pueda borrar la tutoria indicada,ya que no est�,para ver si me salta alg�n error:");
		Profesor r = new ProfesorImpl2("12345678Z", "Antonio", "Vald�s Ram�rez", 
				LocalDate.of(1950, 3, 15), "antonio@gmail.com",Categoria.CATEDRATICO,null);
		
		
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.THURSDAY,r);
		testBorraTutoria(LocalTime.of(13, 40),DayOfWeek.WEDNESDAY,r);
		System.out.println("Por lo que se ve no hace nada en el caso de que no est� la tutor�a,esta bien el m�todo entonces");
		
	}

	
	
private static void tesBorraTodasTutorias(){
	
	System.out.println("============================Probando el m�todo que borra todas las tutor�as");
	
	
	Profesor r = new ProfesorImpl2("12345678Z", "Anabel�n", "Garc�a N��ez", 
			LocalDate.of(1950, 3, 15), "belen@gmail.com",Categoria.CATEDRATICO,null);
	
	System.out.println("*****A�ADO TUTOR�AS");
	testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.WEDNESDAY,r);
	testNuevaTutoria(LocalTime.of(16, 40),90,DayOfWeek.THURSDAY,r);
	testNuevaTutoria(LocalTime.of(19, 40),90,DayOfWeek.THURSDAY,r);
System.out.println("***AHORA LAS BORRO TODAS");
	r.borraTutorias();
	
System.out.println("Tutor�as despu�s de la operaci�n: " + r.getTutorias());
	
	
}



     private static void testImparteAsignatura(){
	
    	 System.out.println(" ");
    	 System.out.println("=====================Probando el imparte Asignatura : ");
	Departamento d = new DepartamentoImpl("LSI");
	Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1,d);
	
	
	Profesor r = new ProfesorImpl2("12345678Z", "Anabel�n", "Garc�a N��ez", 
			LocalDate.of(1950, 3, 15), "belen@gmail.com",Categoria.CATEDRATICO,d);
	 Asignatura a3 = new AsignaturaImpl("Circuitos Electr�nicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,d);
	    Asignatura a4 = new AsignaturaImpl("Introducci�n a las Matem�ticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2,d);
	    d.nuevaAsignatura(a3);
	    d.nuevaAsignatura(a4);
	    
	testImparteAsignatura(a,7.0,r);
	testImparteAsignatura(a3,5.0,r);
	testImparteAsignatura(a4,2.0,r);
System.out.println(" ");

}

     private static void testImparteAsignaturaExcepcion1(){
    		
    	 System.out.println(" ");
    	 System.out.println("=====================Probando el imparte Asignatura con excepci�n cr�ditos profe menor que 24  : ");
	Departamento d = new DepartamentoImpl("LSI");
	Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",28.0, TipoAsignatura.ANUAL, 1,d);
	
	
	Profesor r = new ProfesorImpl2("12345678Z", "Anabel�n", "Garc�a N��ez", 
			LocalDate.of(1950, 3, 15), "belen@gmail.com",Categoria.CATEDRATICO,d);
	 Asignatura a3 = new AsignaturaImpl("Circuitos Electr�nicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,d);
	    Asignatura a4 = new AsignaturaImpl("Introducci�n a las Matem�ticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2,d);
	    d.nuevaAsignatura(a3);
	    d.nuevaAsignatura(a4);
	    
	testImparteAsignatura(a,25.0,r);
	


}
     private static void testImparteAsignaturaExcepcion2(){
    		
    	 System.out.println(" ");
    	 System.out.println("=====================Probando el imparte Asignatura con cr�ditos negativos o igual a 0: ");
	Departamento d = new DepartamentoImpl("LSI");
	Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1,d);
	
	
	Profesor r = new ProfesorImpl2("12345678Z", "Anabel�n", "Garc�a N��ez", 
			LocalDate.of(1950, 3, 15), "belen@gmail.com",Categoria.CATEDRATICO,d);
	 Asignatura a3 = new AsignaturaImpl("Circuitos Electr�nicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,d);
	    Asignatura a4 = new AsignaturaImpl("Introducci�n a las Matem�ticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2,d);
	    d.nuevaAsignatura(a3);
	    d.nuevaAsignatura(a4);
	    
	testImparteAsignatura(a,0.0,r);

}

     
private static void testDedicacionPorAsignatura(){
	
	 System.out.println("=====================Probando el Dedicaci�n Por asignatura ");
		Departamento d = new DepartamentoImpl("LSI");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1,d);
		
		
		Profesor r = new ProfesorImpl2("12345678Z", "Anabel�n", "Garc�a N��ez", 
				LocalDate.of(1950, 3, 15), "belen@gmail.com",Categoria.CATEDRATICO,d);
		 Asignatura a3 = new AsignaturaImpl("Circuitos Electr�nicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,d);
		    Asignatura a4 = new AsignaturaImpl("Introducci�n a las Matem�ticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2,d);
		    d.nuevaAsignatura(a3);
		    d.nuevaAsignatura(a4);
		    
		testImparteAsignatura(a,6.0,r);	
	
	System.out.println(r.dedicacionAsignatura(a));
	System.out.println(r.dedicacionAsignatura(a3));
	System.out.println(r.dedicacionAsignatura(a4));
	
}



private static void testEliminaAsignatura(){
	
	
	 System.out.println("=====================Probando el Elimina Asignatura ");
		Departamento d = new DepartamentoImpl("LSI");
		Asignatura a = new AsignaturaImpl("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1,d);
		
		
		Profesor r = new ProfesorImpl2("12345678Z", "Anabel�n", "Garc�a N��ez", 
				LocalDate.of(1950, 3, 15), "belen@gmail.com",Categoria.CATEDRATICO,d);
		 Asignatura a3 = new AsignaturaImpl("Circuitos Electr�nicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,d);
		    Asignatura a4 = new AsignaturaImpl("Introducci�n a las Matem�ticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2,d);
		    d.nuevaAsignatura(a3);
		    d.nuevaAsignatura(a4);
		    
		testImparteAsignatura(a,6.0,r);	
	
		r.eliminaAsignatura(a4);
	System.out.println("Asignaturas del profesor antes de la operaci�n:"+ r.getAsignaturas());
		r.eliminaAsignatura(a);
	System.out.println("Asignaturas del profesor despu�s de la operaci�n: " + r.getAsignaturas());
	
}

	/****************************PROBANDO LA EXCEPCI�N DEL PRIMER CONSTRUCTOR********************************/
	
private static void testConstructor1Excepcional1() {
	System.out
			.println("==================================Probando el primer constructor con edad menor que 18 a�os");
	testConstructor1("47392842P", "Juan", "Nadie Nadie", 
			LocalDate.of(1999, 3, 15), "juan.nadie@gmail.com",Categoria.CATEDRATICO,null);
}

	
	/********************************M�TODOS AUXILIARES***************************************/
	
private static void testSetCategoria(Profesor profe, Categoria cualquiera) {


		System.out.println("La Categor�a antes de la operaci�n es: "
				+ profe.getCategoria());
		System.out.println("La nueva Categor�a es: " + cualquiera);
		profe.setCategoria(cualquiera);
		System.out
				.println("Categoria despu�s de la operaci�n es: "
						+ profe.getCategoria());
	
}


    private static void testNuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia,Profesor profee){
		
		System.out.println("Tutor�as antes de la operaci�n nueva tutor�a: " + profee.getTutorias());
		
		profee.nuevaTutoria(horaComienzo, duracionMinutos, dia);
		
		System.out.println("Tutor�as despu�s de la operaci�n nueva tutor�a: " + profee.getTutorias());
	
		
	}
	
	
	private static void testBorraTutoria(LocalTime horaComienzo, DayOfWeek dia,Profesor ninja) {
		
		
		System.out.println("Tutor�as antes de la operaci�n borra tutoria: " + ninja.getTutorias());

		
		ninja.borraTutoria(horaComienzo, dia);
	
		System.out.println("Tutor�as despu�s de la operaci�n borra tutoria: " + ninja.getTutorias());

		
		
	}
	
	
	
	
	private static void testConstructor1(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email,Categoria categoria,Departamento dep) {

		try {
			Profesor p = new ProfesorImpl2(dni, nombre, apellidos, 
					fechaNacimiento, email,categoria,dep);
			mostrarProfesor(p);
	
		} catch (ExcepcionProfesorNoValido e) {
			System.out.println(e);
			System.out.println("      ");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepci�n inesperada. El constructor no funciona correctamente");
		}

	}
	
	private static void testImparteAsignatura(Asignatura a,Double d,Profesor p){
		
		try {
			
			p.imparteAsignatura(a, d);
			mostrarProfesor(p);
	
		}  catch (ExcepcionProfesorNoValido e) {
			System.out.println(e);
			System.out.println("      ");
		}catch (ExcepcionProfesorOperacionNoPermitida e) {
			System.out.println(e);
			System.out.println("      ");
		} catch (Exception e) {
			System.out
				.println("******************** Se ha capturado una excepci�n inesperada. El imparteAsignatura no funciona correctamente");
		
			
	}	
		
	}
	
	
	
	
	
	
	private static void mostrarProfesor(Profesor profee) {
		System.out.println("        ");
		System.out.println("\tProfesor: <" + profee + ">");
		System.out.println("        ");
		System.out.println("\tNombre: <" + profee.getNombre() + ">");
		System.out.println("\tApellidos: <" + profee.getApellidos() + ">");
		System.out.println("\tDNI: <" + profee.getDNI() + ">");
		System.out.println("\tFecha Nacimiento: <"
				+ profee.getFechaNacimiento().format(
						DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + profee.getEdad() + ">");
		System.out.println("\tEmail:  <" + profee.getEmail() + ">");
		System.out.println("\tCategor�a: <"+ profee.getCategoria()+ ">");
		System.out.println("\tTutor�as: <"+ profee.getTutorias()+ ">");
		System.out.println("\tDepartamento: <"+ profee.getDepartamento()+ ">");
		System.out.println("\tAsignaturas del profesor: " + profee.getAsignaturas());
		System.out.println("\tDedicaci�n total: <" + profee.getDedicacionTotal() + ">");
		System.out.println("\tDedicaci�n por asignatura: <" + profee.getCreditos() + ">");
		System.out.println("        ");

	}
}