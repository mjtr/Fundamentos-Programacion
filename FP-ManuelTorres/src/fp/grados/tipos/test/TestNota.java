package fp.grados.tipos.test;




import fp.grados.excepciones.ExcepcionNotaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Convocatoria;



public class TestNota {

	public static void main(String[] args) {
	
		testConstructor1Normal();
		testConstructor1Excepcion1();
		testConstructor1Excepcion2();
		testConstructor1Excepcion3();
		
		
		testConstructor2Normal();
		testConstructor2Excepcion1();
		testConstructor2Excepcion2();
		
		TestIgualdad1();
		TestIgualdad2();
		TestIgualdad3();
		TestIgualdad4();
		TestIgualdad5();
		
		TestOrden1();
		TestOrden2();
		TestOrden3();
		TestOrden4();
		
		

		
	}

	private static void testConstructor1Normal(){
	
	Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		System.out.println("======================Probando el primer Constructor: ");
		
		testConstructor1(p,1999,Convocatoria.PRIMERA,10.0,true);
		
	System.out.println("    ");
	
	
	}
	
	/*******************PROBANDO EXCEPCIONES DEL TESTCONSTRUCTOR1*******************************/
	
	private static void testConstructor1Excepcion1() {
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		System.out.println("        ");
		System.out.println("===========================Probando el primer constructor,Nota con valor superior a diez ");

	testConstructor1(p,2000,Convocatoria.PRIMERA,11.0,true);
	}
	
	
	private static void testConstructor1Excepcion2(){
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		System.out.println("        ");
		System.out.println("=====================Probando el primer constructor,Nota con valor inferior a cero ");

	testConstructor1(p,2000,Convocatoria.PRIMERA,-1.0,false);
	}
	

	private static void testConstructor1Excepcion3(){
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		System.out.println("        ");
		System.out.println("==========================Probando el primer constructor,Nota con valor inferior a 9 y con mencion de honor ");

	testConstructor1(p,2000,Convocatoria.PRIMERA,5.0,true);
	}

	/**************************CONSTRUCTOR 2: ***********************************/
	
	private static void testConstructor2Normal(){
		
		System.out.println("  ");
		System.out.println("==================Probando el segundo Constructor. ");
		System.out.println("     ");
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 
		
		testConstructor2(p,2011,Convocatoria.SEGUNDA,9.0);
	
	}
	

	/******************PROBANDO EXCEPCIONES DEL CONSTRUCTOR 2: ***************************/
	
	
	
	private static void testConstructor2Excepcion1() {
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		System.out.println("        ");
		System.out.println("===========================Probando el segundo constructor,Nota con valor superior a diez ");

	testConstructor2(p,2011,Convocatoria.SEGUNDA,11.0);
	}
	
	
	private static void testConstructor2Excepcion2() {
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		System.out.println("        ");
		System.out.println("======================Probando el segundo constructor,Nota con valor inferior a 0 ");

	testConstructor2(p,2011,Convocatoria.SEGUNDA,-3.0);
	}
	

	/******************************COMPROBANDO EL EQUALS***************************/
	
	
	private static void TestIgualdad1(){
		
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

		
		Nota b1 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0,true);
		
		Nota b2 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0,true);
		
		TestIgualdad(b1,b2);
		
	}
	
	
	
	private static void TestIgualdad2(){
		
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

		

		Nota a1 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0);
		
		Nota a2 = new NotaImpl(p,2010,Convocatoria.PRIMERA,10.0);
		
		TestIgualdad(a1,a2);
		
	}
	
	
	private static void TestIgualdad3(){
		
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

		

		Nota a1 = new NotaImpl(p,2000,Convocatoria.PRIMERA,6.0);
		
		Nota a2 = new NotaImpl(p,2000,Convocatoria.SEGUNDA,6.0);
		
		TestIgualdad(a1,a2);
		
	}
	private static void TestIgualdad4(){
		
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

		Asignatura s = new AsignaturaImpl("Estructuras de Computadores","7029456", 12.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	

		

		Nota a1 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0,true);
		
		Nota a2 = new NotaImpl(s,2000,Convocatoria.PRIMERA,10.0,true);
		
		TestIgualdad(a1,a2);
		
	}
	
	
private static void TestIgualdad5(){
		
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

		Asignatura s = new AsignaturaImpl("Estructuras de Computadores","7029456", 12.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	

		

		Nota a1 = new NotaImpl(p,2005,Convocatoria.TERCERA,10.0);
		
		Nota a2 = new NotaImpl(s,2000,Convocatoria.PRIMERA,10.0);
		
		TestIgualdad(a1,a2);
		
	}
	

	
	/*****************************COMPROBANDO EL COMPARETO ********************************/
	

	private static void TestOrden1(){
		
	Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

	
	Nota a1 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0,true);
	
	Nota a2 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0,true);
	
		
		
		TestOrden(a1,a2);
		
		
	}
	
	
	private static void TestOrden2(){
		
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

		Asignatura s = new AsignaturaImpl("Matemáticas Discretas","7029753", 6.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	

		
        Nota a1 = new NotaImpl(p,2004,Convocatoria.PRIMERA,10.0,true);
		
		Nota a2 = new NotaImpl(s,2000,Convocatoria.PRIMERA,10.0,true);
		
		
		
		TestOrden(a1,a2);
		
		
	}
	

	
	private static void TestOrden3(){
		
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	

		
		
        Nota a1 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0,true);
		
		Nota a2 = new NotaImpl(p,2000,Convocatoria.SEGUNDA,10.0,true);
		
		
		
		TestOrden(a1,a2);
		
		
	}
private static void TestOrden4(){
	
	    Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	


		Asignatura r = new AsignaturaImpl("Estadísticas","6829384", 6.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	

		
        Nota a1 = new NotaImpl(p,2000,Convocatoria.PRIMERA,10.0,true);
		
		Nota a2 = new NotaImpl(r,2012,Convocatoria.TERCERA,10.0);
		
		
		
		TestOrden(a1,a2);
		
		
	}

	
	
	
	
	/*******************MÉTODOS AUXILIARES **********************************************/



	
 private static void testConstructor1(Asignatura asignatura, Integer curso,Convocatoria convocatoria,
			Double valor,Boolean mencion){
		try {
			Nota b = new NotaImpl(asignatura, curso, convocatoria, valor,mencion);
			mostrarNota(b);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println(e);
			System.out.println("       ");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}

	
	
	private static void testConstructor2(Asignatura asignatura, Integer curso,Convocatoria convocatoria,
			Double valor){
		try {
			Nota b = new NotaImpl(asignatura, curso, convocatoria, valor);
			mostrarNota(b);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println(e);
			System.out.println("       ");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}
	
private static void TestIgualdad(Nota a1,Nota a2){
		
		
		System.out.println("*****COMPROBANDO LA IGUALDAD:");
		System.out.println("         ");	
		System.out.println("-Objeto 1: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a1.hashCode() +  ")"   )  ;

		

		mostrarNota(a1);
	

		System.out.println("-Objeto 2: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a2.hashCode() +  ")"   )  ;

		mostrarNota(a2);
		
		if(a1.equals(a2)){
			System.out.println("Los objetos son iguales ,segun el equals()");
		}else{
			System.out.println("Los objetos son distintos ,segun el equals()");
		}
		if(a1.hashCode() == a2.hashCode()){
			System.out.println("Los códigos hash son iguales");
			System.out.println("         ");

		}else{
			System.out.println("Los códigos hash son distintos");
			System.out.println("         ");

		}
		
	}
	
	
	private static void TestOrden(Nota a1,Nota a2){
		
		System.out.println("****COMPROBANDO EL COMPARETO: ");
		System.out.println("         ");
		
		System.out.println("-Objeto 1: ");
		
		mostrarNota(a1);
		
		System.out.println("-Objeto 2: ");
		
		mostrarNota(a2);
		
		if(a1.compareTo(a2) == 0){
			System.out.println("         ");

			System.out.println("Los objetos son iguales según el comareTo().");
		System.out.println("         ");
		}else if(a1.compareTo(a2)<0){
			

			System.out.println("El 1º es menor que el 2º según el  compareTo().");
		    System.out.println("         ");

		}else{
			

			System.out.println("El 1º es mayor que el 2º según el  compareTo().");
		    System.out.println("         ");


		}
	}
	
	
	
	
	
	private static void mostrarNota(Nota a){
		System.out.println("      ");
		System.out.println("El toString---->" + a);
		System.out.println("       ");
		System.out.println("Asignatura ----> " + a.getAsignatura() );
		System.out.println("Curso Académico ----> " + a.getCursoAcademico());
		System.out.println("Convocatoria ----> " + a.getConvocatoria());
		System.out.println("Valor ----> " + a.getValor());
		System.out.println("Mención de honor ---> " +  a.getMencionHonor() );
		System.out.println("Calificación ---> " + a.getCalificacion());
		System.out.println("         ");
	}
	
	
	
	
	
}
