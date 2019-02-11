package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestDepartamento {

	public static void main(String[] args) {
		
		
		testConstructorNormal();
		testNuevaAsignatura();
		testEliminaAsignatura();
		testNuevoProfesor();
		testBorraProfesor();
		testNuevaTutoria1();
		testBorraTutoriasCategoria();
		testExisteProfesorAsignado();
		testEstanTodasAsignaturasAsignadas();
		testEliminaAsignacionProfesorado();
		
		
		TestIgualdad1();
		TestIgualdad2();
		
		TestOrden1();
		TestOrden2();
		TestOrden3();
		

	}

/******************************** CASOS DE PRUEBA ********************************************/

	
	private static void testConstructorNormal() {
		System.out.println("==================================Probando el constructor:");
	
		testConstructor("LSI");
	}

	private static void testNuevaAsignatura(){
		
		System.out.println("=============================Probando el Nueva Asignatura: ");
	System.out.println(" ");
		Departamento s1 = new DepartamentoImpl("DTE");
		System.out.println("Asignaturas del departamento antes de la operación: " + s1.getAsignaturas());
		Asignatura a1 = new AsignaturaImpl("CircuitosElectrónicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);

		s1.nuevaAsignatura(a1);
	System.out.println(" ");
		System.out.println("Asignaturas del departamento después de la operación: " + s1.getAsignaturas() );
		
		System.out.println(" ");
		
	}


	private static void testEliminaAsignatura(){
		
		System.out.println("==================================Probando el Borra Asignatura: ");
	System.out.println("      ");
		Departamento s1 = new DepartamentoImpl("DTE");
		Asignatura a1 = new AsignaturaImpl("CircuitosElectrónicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);
        s1.nuevaAsignatura(a1); System.out.println("Asignaturas del departamento antes de la operación:"+s1.getAsignaturas());
	System.out.println(" ");
        s1.eliminaAsignatura(a1);System.out.println("Asignaturas del departamento después de la operación:" +s1.getAsignaturas());
        
        System.out.println(" ");
        
}
	
	private static void testNuevoProfesor(){
		
		System.out.println("================================Probando el Nuevo Profesor:");
		System.out.println(" ");
		Departamento s1 = new DepartamentoImpl("DTE");
		System.out.println("Profesores del departamento antes de la operación: " + s1.getProfesores());

		Profesor r = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
				LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
		
		s1.nuevoProfesor(r);
		System.out.println(" ");
		System.out.println("Profesores después de la operación: " + s1.getProfesores());
		System.out.println(" ");
		
	}
	

	private static void testBorraProfesor(){
		
		System.out.println("================================Probando el Borra Profesor:");
		System.out.println(" ");
		Departamento s1 = new DepartamentoImpl("DTE");
		
		Profesor r = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
				LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
		
		s1.nuevoProfesor(r);
		System.out.println("Profesores del departamento antes de la operación: " + s1.getProfesores());

		s1.eliminaProfesor(r);
		System.out.println(" ");
		System.out.println("Profesores después de la operación: " + s1.getProfesores());
		System.out.println(" ");
		
	}
	
	private static void testNuevaTutoria1() {
		System.out
				.println("==================================Probando el método borra tutorias:");
		
		Departamento s1 = new DepartamentoImpl("DTE");

	
		Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanchís", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,null);

	Profesor p = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
			LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
	
	s1.nuevoProfesor(r);
	s1.nuevoProfesor(p);		
	testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.WEDNESDAY,r);
	testNuevaTutoria(LocalTime.of(10, 20),120,DayOfWeek.FRIDAY,p);
	testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.MONDAY,r);

	System.out.println("Tutorías de los profesores del departamento antes de la operación: " + r.getTutorias() + p.getTutorias());
	System.out.println(" ");
	
	s1.borraTutorias();
	
	System.out.println("Tutorías de los profesores del departamento después de la operación: " + r.getTutorias() + p.getTutorias());

	
	
	}
	
	 private static void testBorraTutoriasCategoria(){
		 
		 System.out
			.println("==================================Probando el método borra tutorias por categoria:");
		 
			Departamento s1 = new DepartamentoImpl("DTE");

			
			Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanchís", 
					LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.AYUDANTE_DOCTOR,null);

		Profesor p = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
				LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
		
		s1.nuevoProfesor(r);
		s1.nuevoProfesor(p);		
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.WEDNESDAY,r);
		testNuevaTutoria(LocalTime.of(10, 20),120,DayOfWeek.FRIDAY,p);
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.MONDAY,r);

		System.out.println("Tutorías de los profesores del departamento antes de la operación: " +
		r +r.getTutorias() +p+ p.getTutorias());
	
		System.out.println(" ");
		
	s1.borraTutorias(Categoria.AYUDANTE_DOCTOR);
		
		System.out.println("Tutorías de los profesores de del departamento con categoria AYUDANTE_DOCTOR después de la operación: " + r.getTutorias() + p.getTutorias());

		 
	 }
	 
	 private static void testExisteProfesorAsignado(){
			
			System.out.println("=============================Probando el Existe Profesor Asignado: ");
		System.out.println(" ");
			Departamento s1 = new DepartamentoImpl("DTE");
			
			Asignatura a1 = new AsignaturaImpl("CircuitosElectrónicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);

			s1.nuevaAsignatura(a1);
			Profesor r = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
					LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
			
			
			s1.nuevoProfesor(r);
			r.imparteAsignatura(a1, 6.0);
			
			Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,null);

			s1.nuevaAsignatura(a2);
			
		
			System.out.println("Existe profesor asignado,aquí me debería de dar true:  " + s1.existeProfesorAsignado(a1) );
			
			System.out.println(" ");
			System.out.println("Existe Profesor Asignado aquí me debería de dar false: " + s1.existeProfesorAsignado(a2));
		}
	 
	 private static void testEstanTodasAsignaturasAsignadas(){
			
			System.out.println("=============================Probando el Estan Todas las Asignaturas Asignadas ");
		System.out.println(" ");
			Departamento s1 = new DepartamentoImpl("DTE");
			
			Asignatura a1 = new AsignaturaImpl("CircuitosElectrónicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);

			s1.nuevaAsignatura(a1);
			Profesor r = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
					LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
			
			
			s1.nuevoProfesor(r);
			r.imparteAsignatura(a1, 6.0);
			
			Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,null);

			s1.nuevaAsignatura(a2);
			
		
			System.out.println("Estan todas Asignadas aquí me debería de dar false:  " + s1.estanTodasAsignaturasAsignadas() );
			
			System.out.println(" ");
			r.imparteAsignatura(a2, 5.0);
			System.out.println("Estan todas Asignadas aquí me debería de dar true: " + s1.estanTodasAsignaturasAsignadas());
		}
	 
	 private static void testEliminaAsignacionProfesorado(){
			
			System.out.println("=============================Probando el Elimina Asignación Profesorado: ");
		System.out.println(" ");
			Departamento s1 = new DepartamentoImpl("DTE");
			
			Asignatura a1 = new AsignaturaImpl("CircuitosElectrónicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);
			Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,null);

			Profesor r = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
					LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
			
			s1.nuevaAsignatura(a1);
			s1.nuevoProfesor(r);
			r.imparteAsignatura(a1, 6.0);
			s1.nuevaAsignatura(a2);
			r.imparteAsignatura(a2, 5.0);
		
			System.out.println("Asignaturas del profesor antes de la operación  " + r.getAsignaturas() );
			
			System.out.println(" ");
			s1.eliminaAsignacionProfesorado(a1);
			System.out.println("Asignaturas del profesor después de la operación " + r.getAsignaturas());
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	/*********************************COMPROBANDO LA IGUALDAD : *************************************/
	
	
	
	private static void TestIgualdad1(){
		
		
		Departamento s1 = new DepartamentoImpl("DTE");
		Departamento s2 = new DepartamentoImpl("DTE");
		
		TestIgualdad(s1,s2);
		
	}
	
	
	
	private static void TestIgualdad2(){
		
		Departamento s1 = new DepartamentoImpl("DTE");
		Departamento s2 = new DepartamentoImpl("LSI");
		
		TestIgualdad(s1,s2);
		
	}
	
	
	/*****************************COMPROBANDO EL COMPARETO ********************************/
	
private static void TestOrden1(){
		
		
	Departamento s1 = new DepartamentoImpl("DTE");
	Departamento s2 = new DepartamentoImpl("LSI");
		
		
		TestOrden(s1,s2);
		
		
	}
	
	
	private static void TestOrden2(){
		
		
		Departamento s1 = new DepartamentoImpl("DTE");
		Departamento s2 = new DepartamentoImpl("DTE");
		
		
		TestOrden(s1,s2);
		
		
	}
	

	
	private static void TestOrden3(){
		
		
		Departamento s1 = new DepartamentoImpl("LSI");
		Departamento s2 = new DepartamentoImpl("DTE");
		
		
		TestOrden(s1,s2);
		
		
	}
	
	
	/******************************** METODOS AUXILIARES **************************/
	
	
	private static void testConstructor(String nom) {
		
			
		Departamento dep = new DepartamentoImpl(nom);
			
		mostrarDepartamento(dep);
		
	}


	private static void TestIgualdad(Departamento d1,Departamento d2){
		
		
		System.out.println("=================COMPROBANDO LA IGUALDAD:");
		System.out.println("         ");	
		System.out.println("-Objeto 1: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + d1.hashCode() +  ")"   )  ;

		

		mostrarDepartamento(d1);
		System.out.println("         ");	

		System.out.println("-Objeto 2: " );
		System.out.println("         ");
		System.out.println("  (Código hash " +d2.hashCode() +  ")"   )  ;

		mostrarDepartamento(d2);
		
		if(d1.equals(d2)){
			System.out.println("Los objetos son iguales ,segun el equals()");
		}else{
			System.out.println("Los objetos son distintos ,segun el equals()");
		}
		if(d1.hashCode() == d2.hashCode()){
			System.out.println("Los códigos hash son iguales");
			System.out.println("         ");

		}else{
			System.out.println("Los códigos hash son distintos");
			System.out.println("         ");

		}
		
	}
	
	
	private static void TestOrden(Departamento d1,Departamento d2){
		
		System.out.println("==================COMPROBANDO EL COMPARETO: ");
		System.out.println("         ");
		
		System.out.println("-Objeto 1: ");mostrarDepartamento(d1);
		
		System.out.println("-Objeto 2: ");mostrarDepartamento(d2);
		
		if(d1.compareTo(d2) == 0){
			System.out.println("         ");

			System.out.println("Los objetos son iguales según el comareTo().");
		System.out.println("         ");
		}else if(d1.compareTo(d2)<0){
			System.out.println("         ");

			System.out.println("El 1º es menor que el 2º según el  compareTo().");
			System.out.println("         ");

		}else{
			System.out.println("         ");

			System.out.println("El 1º es mayor que el 2º según el  compareTo().");
			System.out.println("         ");

		}
		
		
		
		
	}
	
	
     
    private static void mostrarDepartamento(Departamento dep) {		
		
		System.out.println("         ");
		System.out.println("Departamento--> <" + dep + ">");
		System.out.println("\tNombre: <" + dep.getNombre() + ">");
		System.out.println("\tConjunto de asignaturas: <" + dep.getAsignaturas() + ">");
		System.out.println("\tConjunto de profesores: <" + dep.getProfesores() + ">");
	    System.out.println("         ");

	}


 private static void testNuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia,Profesor profee){
		
		
		
		profee.nuevaTutoria(horaComienzo, duracionMinutos, dia);
	
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
