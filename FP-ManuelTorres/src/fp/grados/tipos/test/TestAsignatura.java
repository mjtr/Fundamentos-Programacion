package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.TipoAsignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		
		testConstructorNormal();
		
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		testConstructorExcepcion3();
		testConstructorExcepcion4();
		testConstructorExcepcion5();
		testConstructorExcepcion6();
		testConstructorExcepcion7();		
		
		TestIgualdad1();
		TestIgualdad2();
		
		TestOrden1();
		TestOrden2();
		TestOrden3();
		
	}
	
	/******************************** CASOS DE PRUEBA ********************************************/

	
	private static void testConstructorNormal() {
		System.out.println("-Probando el constructor:");
	
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 1,null);
	}

	private static void testConstructorExcepcion1() {
		System.out.println("        ");
		System.out.println("-Probando el constructor, código de asignatura más largo:");
	testConstructor("Fundamentos de Programación","20500010",12.0, TipoAsignatura.ANUAL, 1,null);
	}
	
	private static void testConstructorExcepcion2() {
		System.out
		.println("-Probando el constructor, código de asignatura más corto");
		testConstructor("Fundamentos de Programación","205000",12.0, TipoAsignatura.ANUAL, 1,null);
	}
	
	private static void testConstructorExcepcion3() {
		System.out
				.println("-Probando el constructor, código de asignatura no numérico");
		testConstructor("Fundamentos de Programación","2A50001",12.0, TipoAsignatura.ANUAL, 1,null);
	}
	
	private static void testConstructorExcepcion4() {
		System.out
				.println("-Probando el constructor, créditos incorrectos (0.0)");
		testConstructor("Fundamentos de Programación","2050001",0.0, TipoAsignatura.ANUAL, 1,null);
	}
		
	private static void testConstructorExcepcion5() {
		System.out
				.println("-Probando el constructor, créditos incorrectos (-1.0)");
		testConstructor("Fundamentos de Programación","2050001",-1.0, TipoAsignatura.ANUAL, 1,null);
	}
	
	
	private static void testConstructorExcepcion6() {
		System.out
				.println("-Probando el constructor, curso menor de 1");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, -2,null);
	}
	
	private static void testConstructorExcepcion7() {
		System.out
				.println("-Probando el constructor, curso mayor de 4");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 5,null);
	}
	

	/*********************************COMPROBANDO LA IGUALDAD : *************************************/
	
	
	
	private static void TestIgualdad1(){
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 3,null);
		
		Asignatura a2 = new AsignaturaImpl("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 3,null);
		
		TestIgualdad(a1,a2);
		
	}
	
	
	
	private static void TestIgualdad2(){
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 2,null);
		
		Asignatura a2 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 2,null);
		
		TestIgualdad(a1,a2);
		
	}
	
	
	/*****************************COMPROBANDO EL COMPARETO ********************************/
	
private static void TestOrden1(){
		
		
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 2,null);
		
		Asignatura a2 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 2,null);
		
		
		TestOrden(a1,a2);
		
		
	}
	
	
	private static void TestOrden2(){
		
		
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 2,null);
		
		Asignatura a2 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 2,null);
		
		
		TestOrden(a1,a2);
		
		
	}
	

	
	private static void TestOrden3(){
		
		
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programación","2050002",12.0, TipoAsignatura.ANUAL, 1,null);
		
		Asignatura a2 = new AsignaturaImpl("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 1,null);
		
		
		TestOrden(a1,a2);
		
		
	}
	
	
	/******************************** METODOS AUXILIARES **************************/
	
	
	private static void testConstructor(String nombre, String codigo, Double creditos,
			TipoAsignatura tipo, Integer curso,Departamento dep) {
		try {
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso,dep);
		
			mostrarAsignatura(a);
		
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out.println(e);
			System.out.println("      ");
		} catch (Exception e) {
			System.out.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}


	private static void TestIgualdad(Asignatura a1,Asignatura a2){
		
		
		System.out.println("=================COMPROBANDO LA IGUALDAD:");
		System.out.println("         ");	
		System.out.println("-Objeto 1: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a1.hashCode() +  ")"   )  ;

		

		mostrarAsignatura(a1);
		System.out.println("         ");	

		System.out.println("-Objeto 2: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a2.hashCode() +  ")"   )  ;

		mostrarAsignatura(a2);
		
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
	
	
	private static void TestOrden(Asignatura a1,Asignatura a2){
		
		System.out.println("==================COMPROBANDO EL COMPARETO: ");
		System.out.println("         ");
		
		System.out.println("-Objeto 1: ");mostrarAsignatura(a1);
		
		System.out.println("-Objeto 2: ");mostrarAsignatura(a2);
		
		if(a1.compareTo(a2) == 0){
			System.out.println("         ");

			System.out.println("Los objetos son iguales según el comareTo().");
		System.out.println("         ");
		}else if(a1.compareTo(a2)<0){
			System.out.println("         ");

			System.out.println("El 1º es menor que el 2º según el  compareTo().");
			System.out.println("         ");

		}else{
			System.out.println("         ");

			System.out.println("El 1º es mayor que el 2º según el  compareTo().");
			System.out.println("         ");

		}
		
		
		
		
	}
	
	
	
	private static void mostrarAsignatura(Asignatura a) {		
		System.out.println("         ");
		System.out.println("Asignatura --> <" + a + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tCódigo: <" + a.getCodigo() + ">");
		System.out.println("\tCréditos: <" + a.getCreditos() + ">");
		System.out.println("\tTipo: <" + a.getTipo() + ">");
		System.out.println("\tCurso: <" + a.getCurso() + ">");
	    System.out.println("\tAcrónimo: <" + a.getAcronimo() + ">");
		System.out.println("         ");

	}

}