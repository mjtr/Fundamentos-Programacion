package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionGradoNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.DepartamentoImpl2;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl2;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;

public class TestGrado2 {

public static void main(String[] args) {
		
	
		testConstructorNormal();
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		
		testSetAsignaturas();
		testSetAsignaturas2();
	

		
	}
	
	/******************************** CASOS DE PRUEBA ********************************************/



private static void testConstructorNormal(){
	
	System.out.println("======================Probando el primer constructor: ");
	
	
	
	testConstructor("Tecnologías Informáticas",obligatorias(),optativas(),12.0);
	
	
}



private static void testConstructorExcepcion1(){
	
	System.out.println("======================Probando la excepción asignaturas optativas tienen que tener el mismo número de créditos ");
	
	
	Set<Asignatura> obligatorias = new HashSet<Asignatura>();
	Set<Asignatura> optativas = new HashSet<Asignatura>();
	
		Departamento s1 = new DepartamentoImpl("LSI");
		Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanchís", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
	Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 1,s1);
	Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);
    Asignatura a3 = new AsignaturaImpl("Circuitos Electrónicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
    Asignatura a4 = new AsignaturaImpl("Introducción a las Matemáticas Discretas","2050003",8.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
	
	s1.nuevaAsignatura(a1);
	s1.nuevaAsignatura(a2);
	s1.nuevaAsignatura(a3);
	s1.nuevaAsignatura(a4);
	
    
	s1.nuevoProfesor(r);

    
    obligatorias.add(a1);
	obligatorias.add(a2);
	optativas.add(a3);
	optativas.add(a4);
	


	
	testConstructor("Tecnologías Informáticas",obligatorias,optativas,12.0);
	
	
}



private static void testConstructorExcepcion2(){

	System.out.println("======================Probando la excepción del número mínimo de créditos ");
	
	
	Set<Asignatura> obligatorias = new HashSet<Asignatura>();
	Set<Asignatura> optativas = new HashSet<Asignatura>();
	
		Departamento s1 = new DepartamentoImpl("LSI");
		Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanchís", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
	Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 1,s1);
	Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);
    Asignatura a3 = new AsignaturaImpl("Circuitos Electrónicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
    Asignatura a4 = new AsignaturaImpl("Introducción a las Matemáticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
	
	s1.nuevaAsignatura(a1);
	s1.nuevaAsignatura(a2);
	s1.nuevaAsignatura(a3);
	s1.nuevaAsignatura(a4);
	
    
	s1.nuevoProfesor(r);

    
    obligatorias.add(a1);
	obligatorias.add(a2);
	optativas.add(a3);
	optativas.add(a4);
	


	
	testConstructor("Tecnologías Informáticas",obligatorias,optativas,30.0);
	
	
}

private static void testSetAsignaturas(){

	System.out.println("======================Probando el Set<Asignaturas>getAsignaturas(Integer Curso): ");
	
	
	Set<Asignatura> obligatorias = new HashSet<Asignatura>();
	Set<Asignatura> optativas = new HashSet<Asignatura>();
	
		Departamento s1 = new DepartamentoImpl("LSI");
		Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanchís", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
	Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 1,s1);
	Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 4,s1);
    Asignatura a3 = new AsignaturaImpl("Circuitos Electrónicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
    Asignatura a4 = new AsignaturaImpl("Introducción a las Matemáticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2,s1);
    Asignatura a5 = new AsignaturaImpl("Cálculo","2054003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3,s1);
    Asignatura a6 = new AsignaturaImpl("Estadísticas","1050003",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2,s1);
    Asignatura a7 = new AsignaturaImpl("Estructuras","2350003",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);

    
	s1.nuevaAsignatura(a1);
	s1.nuevaAsignatura(a2);
	s1.nuevaAsignatura(a3);
	s1.nuevaAsignatura(a4);
	
    
	s1.nuevoProfesor(r);

    
    obligatorias.add(a1);
	obligatorias.add(a2);
	optativas.add(a3);
	optativas.add(a4);
	optativas.add(a5);
	optativas.add(a7);
	obligatorias.add(a6);
	
 Grado g = new GradoImpl2("Tecnologías Informáticas",obligatorias,optativas,10.0);

	System.out.println("Asignaturas del segundo curso: "+g.getAsignaturas(2));
	
	
}
private static void testSetAsignaturas2(){

	System.out.println("======================Probando el Set<Asignaturas>getAsignaturas(String codigo): ");
	
	
	Set<Asignatura> obligatorias = new HashSet<Asignatura>();
	Set<Asignatura> optativas = new HashSet<Asignatura>();
	
		Departamento s1 = new DepartamentoImpl("LSI");
		Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanchís", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
	Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 1,s1);
	Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 4,s1);
    Asignatura a3 = new AsignaturaImpl("Circuitos Electrónicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
    Asignatura a4 = new AsignaturaImpl("Introducción a las Matemáticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2,s1);
    Asignatura a5 = new AsignaturaImpl("Cálculo","2054003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3,s1);
    Asignatura a6 = new AsignaturaImpl("Estadísticas","1050003",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2,s1);
    Asignatura a7 = new AsignaturaImpl("Estructuras","2350003",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);

    
	s1.nuevaAsignatura(a1);
	s1.nuevaAsignatura(a2);
	s1.nuevaAsignatura(a3);
	s1.nuevaAsignatura(a4);
	
    
	s1.nuevoProfesor(r);

    
    obligatorias.add(a1);
	obligatorias.add(a2);
	optativas.add(a3);
	optativas.add(a4);
	optativas.add(a5);
	optativas.add(a7);
	obligatorias.add(a6);
	
 Grado g = new GradoImpl2("Tecnologías Informáticas",obligatorias,optativas,10.0);

	System.out.println("Me debería de devolver una asignatura:  "+ g.getAsignatura("2350003"));
	System.out.println("No me debería de devolver nada: ");
	
}





private static Set<Asignatura> obligatorias(){
	
	Set<Asignatura> obligatorias = new HashSet<Asignatura>();
	Set<Asignatura> optativas = new HashSet<Asignatura>();
	
		Departamento s1 = new DepartamentoImpl("LSI");
		Profesor r = new ProfesorImpl("12345678Z", "Sara", "Cabeza Sanchís", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
	Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 1,s1);
	Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);
    Asignatura a3 = new AsignaturaImpl("Circuitos Electrónicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
    Asignatura a4 = new AsignaturaImpl("Introducción a las Matemáticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
	
	s1.nuevaAsignatura(a1);
	s1.nuevaAsignatura(a2);
	s1.nuevaAsignatura(a3);
	s1.nuevaAsignatura(a4);
	
    
	s1.nuevoProfesor(r);

    
    obligatorias.add(a1);
	obligatorias.add(a2);
	optativas.add(a3);
	optativas.add(a4);
	

return obligatorias;
	
	
	
}
private static Set<Asignatura> optativas(){
	
	Set<Asignatura> obligatorias = new HashSet<Asignatura>();
	Set<Asignatura> optativas = new HashSet<Asignatura>();
	
		Departamento s1 = new DepartamentoImpl2("LSI");
		Profesor r = new ProfesorImpl2("12345678Z", "Sara", "Cabeza Sanchís", 
				LocalDate.of(1950, 3, 15), "sarita_tenista@gmail.com",Categoria.CATEDRATICO,s1);
	Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 1,s1);
	Asignatura a2 = new AsignaturaImpl("Fundamentos Físicos de la Informática","2050009",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1,s1);
    Asignatura a3 = new AsignaturaImpl("Circuitos Electrónicos Digitales","2050004",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
    Asignatura a4 = new AsignaturaImpl("Introducción a las Matemáticas Discretas","2050003",6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1,s1);
	
	s1.nuevaAsignatura(a1);
	s1.nuevaAsignatura(a2);
	s1.nuevaAsignatura(a3);
	s1.nuevaAsignatura(a4);
	
    
	s1.nuevoProfesor(r);

    
    obligatorias.add(a1);
	obligatorias.add(a2);
	optativas.add(a3);
	optativas.add(a4);
	

return optativas;
	
	
	
}


     private static void testConstructor(String nom,Set<Asignatura> asiobli,Set<Asignatura> asiopta,Double cre){
    	 
    	try{
    		
    		Grado g = new GradoImpl2(nom,asiobli,asiopta,cre);
    		mostrarGrado(g);
    	
    	}catch(ExcepcionGradoNoValido e){
    		System.out.println(e);
    		System.out.println(" ");
    		
    		
    	}catch(ExcepcionProfesorOperacionNoPermitida e){
    		
    		System.out.println(e);
    		System.out.println(" ");
    	}
    	
    	catch(Exception e){
    		
    		System.out.println("SE HA CAPTURADO UNA EXCEPCIÓN INESPERADA¡¡¡¡¡¡¡¡");
    		
    	}
    	 
    	 
    	 
    	 
     }




 

 	

 	
 	/******************************** METODOS AUXILIARES **************************/
 	
 	


      private static void mostrarGrado(Grado g){
	
	System.out.println(" ");
	System.out.println("\tGrado: " + g);
	System.out.println("\tNombre: "+ g.getNombre());
	System.out.println("\tNumero Mínimo de Créditos: "+ g.getNumeroMinimoCreditosOptativas());
	System.out.println("\tAsignaturas Obligatorias: " + g.getAsignaturasObligatorias());
	System.out.println("\tAsignaturas Optativas: "+ g.getAsignaturasOptativas());
	System.out.println("\tNúmero total de Creditos: " + g.getNumeroTotalCreditos());
	System.out.println("\tDepartamentos del grado: " + g.getDepartamentos());
	System.out.println("\tProfesores del grado: " + g.getProfesores());
	System.out.println("\tSortedMap de asignaturas y creditos: "+ g.getCreditosPorAsignatura());
	System.out.println("\tDepartamentos ordenados por asignaturas: " + g.getDepartamentosOrdenadosPorAsignaturas());
	
	
}








}