package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.NoSuchElementException;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl2;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestDepartamento2 {

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
		


	}

/******************************** CASOS DE PRUEBA ********************************************/

	
	private static void testConstructorNormal() {
		System.out.println("==================================Probando el constructor:");
	
		testConstructor("LSI");
	}

	private static void testNuevaAsignatura(){
		
		System.out.println("=============================Probando el Nueva Asignatura: ");
	System.out.println(" ");
		Departamento s1 = new DepartamentoImpl2("DTE");
		System.out.println("Asignaturas del departamento antes de la operaci�n: " + s1.getAsignaturas());
		Asignatura a1 = new AsignaturaImpl("CircuitosElectr�nicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);

		s1.nuevaAsignatura(a1);
	System.out.println(" ");
		System.out.println("Asignaturas del departamento despu�s de la operaci�n: " + s1.getAsignaturas() );
		
		System.out.println(" ");
		
	}


	private static void testEliminaAsignatura(){
		
		System.out.println("==================================Probando el Borra Asignatura: ");
	System.out.println("      ");
		Departamento s1 = new DepartamentoImpl2("DTE");
		Asignatura a1 = new AsignaturaImpl("CircuitosElectr�nicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);
        s1.nuevaAsignatura(a1); System.out.println("Asignaturas del departamento antes de la operaci�n:"+s1.getAsignaturas());
	System.out.println(" ");
        s1.eliminaAsignatura(a1);System.out.println("Asignaturas del departamento despu�s de la operaci�n:" +s1.getAsignaturas());
        
        System.out.println(" ");
        
}
	
	private static void testNuevoProfesor(){
		
		System.out.println("================================Probando el Nuevo Profesor:");
		System.out.println(" ");
		Departamento s1 = new DepartamentoImpl2("DTE");
		System.out.println("Profesores del departamento antes de la operaci�n: " + s1.getProfesores());

		Profesor r = new ProfesorImpl("12345678Z", "Benito", "P�rez Gald�s", 
				LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
		
		s1.nuevoProfesor(r);
		System.out.println(" ");
		System.out.println("Profesores despu�s de la operaci�n: " + s1.getProfesores());
		System.out.println(" ");
		
	}
	

	private static void testBorraProfesor(){
		
		System.out.println("================================Probando el Borra Profesor:");
		System.out.println(" ");
		Departamento s1 = new DepartamentoImpl2("DTE");
		
		Profesor r = new ProfesorImpl("12345678Z", "Benito", "P�rez Gald�s", 
				LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
		
		s1.nuevoProfesor(r);
		System.out.println("Profesores del departamento antes de la operaci�n: " + s1.getProfesores());

		s1.eliminaProfesor(r);
		System.out.println(" ");
		System.out.println("Profesores despu�s de la operaci�n: " + s1.getProfesores());
		System.out.println(" ");
		
	}
	
	private static void testNuevaTutoria1() {
		System.out
				.println("==================================Probando el m�todo borra tutorias:");
		
		Departamento s1 = new DepartamentoImpl2("DTE");

	
		Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanch�s", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,null);

	Profesor p = new ProfesorImpl("12345678Z", "Benito", "P�rez Gald�s", 
			LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
	
	s1.nuevoProfesor(r);
	s1.nuevoProfesor(p);		
	testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.WEDNESDAY,r);
	testNuevaTutoria(LocalTime.of(10, 20),120,DayOfWeek.FRIDAY,p);
	testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.MONDAY,r);

	System.out.println("Tutor�as de los profesores del departamento antes de la operaci�n: " + r.getTutorias() + p.getTutorias());
	System.out.println(" ");
	
	s1.borraTutorias();
	
	System.out.println("Tutor�as de los profesores del departamento despu�s de la operaci�n: " + r.getTutorias() + p.getTutorias());

	
	
	}
	
	 private static void testBorraTutoriasCategoria(){
		 
		 System.out
			.println("==================================Probando el m�todo borra tutorias por categoria:");
		 
			Departamento s1 = new DepartamentoImpl2("DTE");

			
			Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanch�s", 
					LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.AYUDANTE_DOCTOR,null);

		Profesor p = new ProfesorImpl("12345678Z", "Benito", "P�rez Gald�s", 
				LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
		
		s1.nuevoProfesor(r);
		s1.nuevoProfesor(p);		
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.WEDNESDAY,r);
		testNuevaTutoria(LocalTime.of(10, 20),120,DayOfWeek.FRIDAY,p);
		testNuevaTutoria(LocalTime.of(13, 40),60,DayOfWeek.MONDAY,r);

		System.out.println("Tutor�as de los profesores del departamento antes de la operaci�n: " +
		r +r.getTutorias() +p+ p.getTutorias());
	
		System.out.println(" ");
		
	s1.borraTutorias(Categoria.AYUDANTE_DOCTOR);
		
		System.out.println("Tutor�as de los profesores de del departamento con categoria AYUDANTE_DOCTOR despu�s de la operaci�n: " + r.getTutorias() + p.getTutorias());

		 
	 }
	 
	 private static void testExisteProfesorAsignado(){
			
			System.out.println("=============================Probando el Existe Profesor Asignado: ");
		System.out.println(" ");
			Departamento s1 = new DepartamentoImpl2("DTE");
			
			Asignatura a1 = new AsignaturaImpl("CircuitosElectr�nicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);

			s1.nuevaAsignatura(a1);
			Profesor r = new ProfesorImpl("12345678Z", "Benito", "P�rez Gald�s", 
					LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
			
			
			s1.nuevoProfesor(r);
			r.imparteAsignatura(a1, 6.0);
			
			Asignatura a2 = new AsignaturaImpl("Fundamentos F�sicos de la Inform�tica","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,null);

			s1.nuevaAsignatura(a2);
			
		
			System.out.println("Existe profesor asignado,aqu� me deber�a de dar true:  " + s1.existeProfesorAsignado(a1) );
			
			System.out.println(" ");
			System.out.println("Existe Profesor Asignado aqu� me deber�a de dar false: " + s1.existeProfesorAsignado(a2));
		}
	 
	 private static void testEstanTodasAsignaturasAsignadas(){
			
			System.out.println("=============================Probando el Estan Todas las Asignaturas Asignadas ");
		System.out.println(" ");
			Departamento s1 = new DepartamentoImpl2("DTE");
			
			Asignatura a1 = new AsignaturaImpl("CircuitosElectr�nicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);

			s1.nuevaAsignatura(a1);
			Profesor r = new ProfesorImpl("12345678Z", "Benito", "P�rez Gald�s", 
					LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
			
			
			s1.nuevoProfesor(r);
			r.imparteAsignatura(a1, 6.0);
			
			Asignatura a2 = new AsignaturaImpl("Fundamentos F�sicos de la Inform�tica","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,null);

			s1.nuevaAsignatura(a2);
			
		
			System.out.println("Estan todas Asignadas aqu� me deber�a de dar false:  " + s1.estanTodasAsignaturasAsignadas() );
			
			System.out.println(" ");
			r.imparteAsignatura(a2, 5.0);
			System.out.println("Estan todas Asignadas aqu� me deber�a de dar true: " + s1.estanTodasAsignaturasAsignadas());
		}
	 
	 private static void testEliminaAsignacionProfesorado(){
			
			System.out.println("=============================Probando el Elimina Asignaci�n Profesorado: ");
		System.out.println(" ");
			Departamento s1 = new DepartamentoImpl2("DTE");
			
			Asignatura a1 = new AsignaturaImpl("CircuitosElectr�nicos y Digitales","2050001",12.0, TipoAsignatura.ANUAL, 2,null);
			Asignatura a2 = new AsignaturaImpl("Fundamentos F�sicos de la Inform�tica","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,null);

			Profesor r = new ProfesorImpl("12345678Z", "Benito", "P�rez Gald�s", 
					LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
			
			s1.nuevaAsignatura(a1);
			s1.nuevoProfesor(r);
			r.imparteAsignatura(a1, 6.0);
			s1.nuevaAsignatura(a2);
			r.imparteAsignatura(a2, 5.0);
		
			System.out.println("Asignaturas del profesor antes de la operaci�n  " + r.getAsignaturas() );
			
			System.out.println(" ");
			s1.eliminaAsignacionProfesorado(a1);
			System.out.println("Asignaturas del profesor despu�s de la operaci�n " + r.getAsignaturas());
			
			mostrarDepartamento(s1);
		}
	 
	 
	 
	 
	 
	 
	
	
	
	/******************************** METODOS AUXILIARES **************************/
	
	
	private static void testConstructor(String nom) {
		
			
		Departamento dep = new DepartamentoImpl2(nom);
			
		mostrarDepartamento(dep);
		
	}


	
	
     
    private static void mostrarDepartamento(Departamento dep) {		
		
    	try{
    	
		System.out.println("         ");
		System.out.println("Departamento--> <" + dep + ">");
		System.out.println("\tNombre: <" + dep.getNombre() + ">");
		System.out.println("\tConjunto de asignaturas: <" + dep.getAsignaturas() + ">");
		System.out.println("\tConjunto de profesores: <" + dep.getProfesores() + ">");
		System.out.println("\tMap de Asignaturas y Profesores : <" + dep.getProfesoresPorAsignatura() + ">");
		System.out.println("\tMap de Profesor y Tutorias : <" + dep.getTutoriasPorProfesor() + ">");
		System.out.println("M�xima dedicacion del profesor"+ dep.getProfesorMaximaDedicacionMediaPorAsignatura());
		System.out.println("         ");

    	}catch(NoSuchElementException e){
    		
    		System.out.println("No hay profesores en el departamento");
    	}
	}


 private static void testNuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia,Profesor profee){
		
		
		
		profee.nuevaTutoria(horaComienzo, duracionMinutos, dia);
	
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
