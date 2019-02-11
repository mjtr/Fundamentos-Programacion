package fp.grados.utiles.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestFactorias {

	public static void main(String[] args) {
	       
		testCrearAlumno();
		testCrearAlumno2();

		testCrearAsignatura();
		 
		testCrearCentro();
		
		testCrearEspacio();
		
		testCrearGrado();
		testCrearGrado2();
		 
	}

	
	
	private static void testCrearAlumno(){
		
		System.out.println("==============================Probando el create alumno normal ");
		testCrearAlumno("12345678Z", "Antonio", "Machado",
				LocalDate.of(1950, 3, 15), "antonio@alum.us.es");
		
		testCrearAlumno("12345678Z", "Manuel", "Torres",
				LocalDate.of(1950, 3, 15), "antonio@alum.us.es");
	}
	
	

	private static void testCrearAlumno2(){
	
		System.out.println(" ");
		System.out.println("===============================Probando crear Alumno a partir de un String: ");	
	
	testCrearAlumno("12345678Z,Juan,Lopez Garcia,20/7/1998,juan@alum.us.es");
		
		testCrearAlumno("	12345678Z,Antonio,Lopez Lopez,3/11/1997,antonio@alum.us.es");
	}
	
	
	
	
	private static void testCrearAsignatura(){
		
		
		System.out.println(" ");
		System.out.println("=========================Probando el create Asignatura normal");
		
		testCrearAsignatura("Fundamentos de Programaci�n","2050001",12.0, TipoAsignatura.ANUAL, 1,null);
		
		
	}
	
	
	private static void testCrearCentro(){
		
		System.out.println(" ");
		System.out.println("=======================================Usando el create Centro : ");
		testCrearCentro("ETSII","Reina Mercedes",4,1);
		
		testCrearCentro("ARQUITECTURA","Reina Mercedes",8,12);
		
	}
	
	
	private static void testCrearEspacio(){
		
		System.out.println(" ");
		System.out.println("============================Usando el create Espacio: " );
		
		testCrearEspacio(TipoEspacio.TEORIA,"A2.10",80,2);
		testCrearEspacio(TipoEspacio.TEORIA,"A4.10",80,0);
		testCrearEspacio(TipoEspacio.TEORIA,"A3.10",80,3);
		
	}
	
	
	private static void testCrearGrado(){
		
	System.out.println("     ");	
	System.out.println("=========================Usando el CREATE GRADOS");	
	testCrearGrado(	"Tecnolog�as Inform�ticas",obligatorias(),optativas(),12.0);
	
	
	
	}
	
	
	private static void testCrearGrado2(){
		System.out.println("     ");	
		System.out.println("=========================Usando el CREATE GRADOS");	
		testCrearGrado(	"Administracion de empresas",obligatorias(),optativas(),12.0);
		
	}
	
	
	private static Set<Asignatura> obligatorias(){
		
		Set<Asignatura> obligatorias = new HashSet<Asignatura>();
	
		
			Departamento s1 = new DepartamentoImpl("LSI");
			Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanch�s", 
					LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programaci�n","2051002",12.0, TipoAsignatura.ANUAL, 1,s1);
		Asignatura a2 = new AsignaturaImpl("Fundamentos F�sicos de la Inform�tica","2050029",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);
	    Asignatura a3 = new AsignaturaImpl("Circuitos Electr�nicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
	    Asignatura a4 = new AsignaturaImpl("Introducci�n a las Matem�ticas Discretas","2050703",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
		
		s1.nuevaAsignatura(a1);
		s1.nuevaAsignatura(a2);
		s1.nuevaAsignatura(a3);
		s1.nuevaAsignatura(a4);
		
	    
		s1.nuevoProfesor(r);

	    
	    obligatorias.add(a1);
		obligatorias.add(a2);
		obligatorias.add(a3);
		obligatorias.add(a4);
		

	return obligatorias;
		
		
		
	}
	private static Set<Asignatura> optativas(){
		

		Set<Asignatura> optativas = new HashSet<Asignatura>();
		
			Departamento s1 = new DepartamentoImpl("LSI");
			Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanch�s", 
					LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programaci�n","2050002",6.0, TipoAsignatura.ANUAL, 1,s1);
		Asignatura a2 = new AsignaturaImpl("Fundamentos F�sicos de la Inform�tica","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);
	    Asignatura a3 = new AsignaturaImpl("Circuitos Electr�nicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
	    Asignatura a4 = new AsignaturaImpl("Introducci�n a las Matem�ticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
		
		s1.nuevaAsignatura(a1);
		s1.nuevaAsignatura(a2);
		s1.nuevaAsignatura(a3);
		s1.nuevaAsignatura(a4);
		
	    
		s1.nuevoProfesor(r);

	    
	    optativas.add(a1);
		optativas.add(a2);
		optativas.add(a3);
		optativas.add(a4);
		

	return optativas;
		
		
		
	}









	
	
	
	
	
	
	private static void testCrearGrado(String nom,Set<Asignatura> asiob,Set<Asignatura> asiop,Double cre){
		
		try{
			System.out.println(" ");
			System.out.println("\n Contador de Grados antes de la operaci�n: " + Grados.getNumGradosCreados());
			System.out.println("\n Conjunto de Grados creados antes de la operci�n: " + Grados.getGradosCreados());
			System.out.println("\n Media de asignaturas grados antes de la operaci�n : " + Grados.getMediaAsignaturasGrados());
			System.out.println("\n Media de las asignaturas optativas antes de la operaci�n: " + Grados.getMediaAsignaturasOptativasGrados());
			System.out.println("\n Media de las asignaturas obligatorias antes de la operaci�n: " + Grados.getMediaAsignaturasObligatoriasGrados());
			
			Grados.createGrado(nom, asiob, asiop, cre);
	        
			
			System.out.println(" ");		
			System.out.println("\n Contador de Grados despu�s de la operaci�n: " + Grados.getNumGradosCreados());
			System.out.println("\n Conjunto de Grados creados despu�s de la operci�n: " + Grados.getGradosCreados());
			System.out.println("\n Media de asignaturas grados despu�s de la operaci�n : " + Grados.getMediaAsignaturasGrados());
			System.out.println("\n Media de las asignaturas optativas despu�s de la operaci�n: " + Grados.getMediaAsignaturasOptativasGrados());
			System.out.println("\n Media de las asignaturas obligatorias despu�s de la operaci�n: " + Grados.getMediaAsignaturasObligatoriasGrados());
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
	
	
	
	
	private static void testCrearEspacio(TipoEspacio tipo,String nombre,Integer capacidad,Integer planta){
		
		
		try{
			
			System.out.println(" ");
			System.out.println("\n Contador de espacios antes de la operaci�n: " + Grados.getNumEspaciosCreados());
			System.out.println("\n Conjunto de Espacios antes de la operaci�n: " + Grados.getEspaciosCreados());
			System.out.println("\n Planta mayor de los espacios antes de la operaci�n: " + Grados.getPlantaMayorEspacio());
			System.out.println("\n Planta menor de los espacios antes de la operaci�n: " + Grados.getPlantaMenorEspacio());
		
			
			Grados.createEspacio(tipo, nombre, capacidad, planta);
			
			System.out.println(" ");
			System.out.println("\n Contador espacios despu�s de la operaci�n: " + Grados.getNumEspaciosCreados());
			System.out.println("\n Conjunto de Espacios despu�s de la operaci�n: " + Grados.getEspaciosCreados());
			System.out.println("\n Planta mayor de los espacios despu�s de la operaci�n: " + Grados.getPlantaMayorEspacio());
			System.out.println("\n Planta menor de los espacios despu�s de la operaci�n: " + Grados.getPlantaMenorEspacio());
		
		}catch(Exception e){
			
			System.out.println(e);
			
			
		}
		
	}
	



	private static void testCrearCentro(String nombre,String direccion,Integer NumeroPlantas,
			Integer NumeroSotanos){
		
		try{
			
			System.out.println(" ");
			System.out.println("\n Contador de Centro antes de operaci�n : " + Grados.getNumCentrosCreados());
			System.out.println("\n Conjunto de Centros antes de la operaci�n : " + Grados.getCentrosCreados());
			System.out.println("\n Planta m�xima : " + Grados.getMaxPlantas());
			System.out.println("\n Sotano m�ximo : " + Grados.getMaxSotanos());
			System.out.println("\n Media de Planta m�xima : " + Grados.getMediaPlantas());
			System.out.println("\n Media s�tanos m�nimos : " + Grados.getMediaSotanos());


			Grados.createCentro(nombre, direccion, NumeroPlantas, NumeroSotanos);
			
			
			System.out.println("\n Contador de Centro despu�s de operaci�n: " + Grados.getNumCentrosCreados());
			System.out.println("\n Conjunto de Centros despu�s de la operaci�n: " + Grados.getCentrosCreados());
			System.out.println("\n Planta m�xima: " + Grados.getMaxPlantas());
			System.out.println("\n Planta m�nima: " + Grados.getMaxSotanos());
			System.out.println("\n Media de Planta m�xima : " + Grados.getMediaPlantas());
			System.out.println("\n Media s�tanos m�nimos : " + Grados.getMediaSotanos());


			
			
			
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
		
		
	}





	private static void testCrearAsignatura(String nombre,String codigo,Double creditos,
		TipoAsignatura tipo,Integer curso,Departamento dep){


		try{
	System.out.println(" ");
	System.out.println("\n Codigos de asignaturas creadas antes de la operacion : "+Grados.getCodigosAsignaturasCreadas());
	System.out.println("\n Conjunto de asignaturas antes de la operaci�n: "+ Grados.getAsignaturasCreadas());
	System.out.println("\n Contador antes de la operaci�n: " + Grados.getNumAsignaturasCreadas());
	Grados.createAsignatura(nombre, codigo, creditos, tipo, curso, dep);
	System.out.println(" ");
	System.out.println("\n Contador despu�s de la operaci�n: " + Grados.getNumAsignaturasCreadas());
	System.out.println("\n Conjunto de asignaturas despu�s de la operaci�n: "+ Grados.getAsignaturasCreadas());
	System.out.println("\n Codigos de asignaturas creadas despue�s de la operaci�n: "+Grados.getCodigosAsignaturasCreadas());

	

		}catch(Exception e){
	System.out.println(e);
	
}


}




	
	private static void testCrearAlumno(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
				String email){
		
		try{
			System.out.println(" ");
			System.out.println("\n Conjunto de alumnos antes de la operaci�n: "+ Grados.getAlumnosCreados());
			System.out.println("\n Contador antes de la operaci�n: " + Grados.getNumAlumnosCreados());
			Grados.createAlumno(dni, nombre, apellidos, fechanacimiento, email);
			System.out.println(" ");
			System.out.println("\n Contador despu�s de la operaci�n: " + Grados.getNumAlumnosCreados());
			System.out.println("\n Conjunto de alumnos despu�s de la operaci�n: "+ Grados.getAlumnosCreados());

			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
		
	}
	
	

	private static void testCrearAlumno(String s){
		
		try{
			
			System.out.println("\n Conjunto de alumnos antes de la operaci�n: "+ Grados.getAlumnosCreados());
			System.out.println("\n Contador antes de la operaci�n: " + Grados.getNumAlumnosCreados());
			Grados.createAlumno(s);
			System.out.println("\n Contador despu�s de la operaci�n: " + Grados.getNumAlumnosCreados());
			System.out.println("\n Conjunto de alumnos despu�s de la operaci�n: "+ Grados.getAlumnosCreados());

			
		}catch(Exception e){
			System.out.println(e);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
