package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionBecaNoValida;

import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;

import fp.grados.tipos.TipoBeca;


public class TestBeca {

	public static void main(String[] args) {
		
		testConstructor1Normal();
		testConstructor1Excepcion1();
		testConstructor1Excepcion2();
		testConstructor1Excepcion3();
		testConstructor1Excepcion4();
		testConstructor1Excepcion5();
		testConstructor1Excepcion6();
		
		testConstructor2Normal();
		testConstructor2Excepcion1();
		testConstructor2Excepcion2();
		testConstructor2Excepcion3();
		testConstructor2Excepcion4();
		
		testSetCuantiaTotalNormal();
		testSetCuantiaTotalExcepcion1();
		
		testSetDuracionNormal();
		testSetDuracionExcepcion1();
		
		TestIgualdad1();
		TestIgualdad2();
		TestIgualdad3();
		TestIgualdad4();
		
		TestOrden1();
		TestOrden2();
		TestOrden3();
		TestOrden4();
		TestOrden5();
		
		
		
	}
	
	/******************************** CASOS DE PRUEBA **************************/

	private static void testConstructor1Normal() {
		System.out
				.println("==================================Probando el primer constructor");
		testConstructor1("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		System.out.println("        ");
	}

	private static void testConstructor1Excepcion1() {
		System.out
				.println("==================================Probando el primer constructor, pocos caracteres en el c�digo");
		testConstructor1("ABC12",10000.0,6,TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion2() {
		System.out
				.println("==================================Probando el primer constructor, demasiados caracteres en el c�digo");
		testConstructor1("ABC12345",10000.0,6,TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion3() {
		System.out
				.println("==================================Probando el primer constructor, pocas letras en el c�digo");
		testConstructor1("AB12345",10000.0,6,TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion4() {
		System.out
				.println("==================================Probando el primer constructor, pocos d�gitos en el c�digo");
		testConstructor1("ABCD123",10000.0,6,TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion5() {
		System.out
				.println("==================================Probando el primer constructor, cuant�a total menor a la m�nima");
		testConstructor1("ABC1234",0.0,6,TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor1Excepcion6() {
		System.out
				.println("==================================Probando el primer constructor, duraci�n menor a 1");
		testConstructor1("ABC1234",10000.0,-1,TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Normal() {
		System.out
				.println("==================================Probando el segundo constructor");
		testConstructor2("ABC1234",TipoBeca.ORDINARIA);
	}

	private static void testConstructor2Excepcion1() {
		System.out
				.println("==================================Probando el segundo constructor, pocos caracteres en el c�digo");
		testConstructor2("ABC12",TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor2Excepcion2() {
		System.out
				.println("==================================Probando el segundo constructor, demasiados caracteres en el c�digo");
		testConstructor2("ABC12345",TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor2Excepcion3() {
		System.out
				.println("==================================Probando el segundo constructor, pocas letras en el c�digo");
		testConstructor2("AB12345",TipoBeca.ORDINARIA);
	}
	
	private static void testConstructor2Excepcion4() {
		System.out
				.println("==================================Probando el segundo constructor, pocos d�gitos en el c�digo");
		testConstructor2("ABCD123",TipoBeca.ORDINARIA);
	}
	
	private static void testSetCuantiaTotalNormal(){
		System.out
		.println("==================================Probando setCuantiaTotal");
		Beca b = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 12000.0);
		System.out.println("        ");
	}
	
	private static void testSetCuantiaTotalExcepcion1(){
		System.out
		.println("==================================Probando setCuantiaTotal con cuant�a total menor a la m�nima");
		Beca b = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		testSetCuantiaTotal(b, 120.0);
		
	}
	
	private static void testSetDuracionNormal(){
		System.out
		.println("==================================Probando setDuracion");
		Beca b = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		testSetDuracion(b, 12);
		System.out.println("        ");
	}
	
	private static void testSetDuracionExcepcion1(){
		System.out
		.println("==================================Probando setDuracion con duraci�n menor a 1");
		Beca b = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		testSetDuracion(b, 0);
		System.out.println("        ");
	}
	
	/******************************COMPROBANDO EL EQUALS***************************/
	
	private static void TestIgualdad1(){
		Beca b1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca b2 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		TestIgualdad(b1,b2);
		
	}
	
	
	
	private static void TestIgualdad2(){
		Beca a1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca a2 = new BecaImpl("ARC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		TestIgualdad(a1,a2);
		
	}
	
	
	private static void TestIgualdad3(){
		Beca a1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca a2 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.MOVILIDAD);
		
		TestIgualdad(a1,a2);
		
	}
	private static void TestIgualdad4(){
		Beca a1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca a2 = new BecaImpl("ARC1234",10000.0,6,TipoBeca.MOVILIDAD);
		
		TestIgualdad(a1,a2);
		
	}
	
	
	
	
	
	
	
	/*****************************COMPROBANDO EL COMPARETO ********************************/
	
private static void TestOrden1(){
		
		
		Beca a1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca a2 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		
		TestOrden(a1,a2);
		
		
	}
	
	
	private static void TestOrden2(){
		
		
		Beca a1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca a2 = new BecaImpl("ARC1244",10000.0,6,TipoBeca.ORDINARIA);
		
		
		TestOrden(a1,a2);
		
		
	}
	

	
	private static void TestOrden3(){
		
		
		Beca a1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca a2 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.MOVILIDAD);
		
		
		TestOrden(a1,a2);
		
		
	}
private static void TestOrden4(){
		
		
		Beca a1 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
		
		Beca a2 = new BecaImpl("ARC1234",10000.0,6,TipoBeca.MOVILIDAD);
		
		
		TestOrden(a1,a2);
		
		
	}
private static void TestOrden5(){
	
	
	Beca a1 = new BecaImpl("ABC1244",10000.0,6,TipoBeca.ORDINARIA);
	
	Beca a2 = new BecaImpl("ABC1234",10000.0,6,TipoBeca.ORDINARIA);
	
	
	TestOrden(a1,a2);
	
	
}
	
	
	
	/******************************** METODOS AUXILIARES **************************/
	
	private static void testConstructor1(String codigo, Double cuantiaTotal, Integer duracion,
			TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println(e);
			System.out.println("       ");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testConstructor2(String codigo, TipoBeca tipo) {
		try {
			Beca b = new BecaImpl(codigo, tipo);
			mostrarBeca(b);
		} catch (ExcepcionBecaNoValida e) {
			System.out.println(e);
			System.out.println("      ");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}
	

	private static void testSetCuantiaTotal(Beca b, Double cuantiaTotal){
		try {
			System.out.println("La cuant�a total antes de la operaci�n es: "+ b.getCuantiaTotal());
			System.out.println("El nuevo valor es: "+  cuantiaTotal);
			b.setCuantiaTotal(cuantiaTotal);
			System.out.println("La cuant�a total despu�s de la operaci�n es: "+ b.getCuantiaTotal());
		} catch (ExcepcionBecaNoValida e) {
			System.out.println(e);
			System.out.println("    ");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	private static void testSetDuracion(Beca b, Integer duracion){
		try {
			System.out.println("La duraci�n antes de la operaci�n es: "+ b.getDuracion());
			System.out.println("El nuevo valor es: "+  duracion);
			b.setDuracion(duracion);
			System.out.println("La duraci�n despu�s de la operaci�n es: "+ b.getDuracion());
		} catch (ExcepcionBecaNoValida e) {
			System.out.println(e);
			System.out.println("       ");
		} catch (Exception e) {
			System.out
					.println("******************** ���Se ha capturado una EXCEPCI�N INESPERADA!!!");
		}
	}

	
private static void TestIgualdad(Beca a1,Beca a2){
		
		
		System.out.println("========================COMPROBANDO LA IGUALDAD:");
		System.out.println("         ");	
		System.out.println("-Objeto 1: " );
		System.out.println("         ");
		System.out.println("  (C�digo hash " + a1.hashCode() +  ")"   )  ;

		

		mostrarBeca(a1);
	

		System.out.println("-Objeto 2: " );
		System.out.println("         ");
		System.out.println("  (C�digo hash " + a2.hashCode() +  ")"   )  ;

		mostrarBeca(a2);
		
		if(a1.equals(a2)){
			System.out.println("Los objetos son iguales ,segun el equals()");
		}else{
			System.out.println("Los objetos son distintos ,segun el equals()");
		}
		if(a1.hashCode() == a2.hashCode()){
			System.out.println("Los c�digos hash son iguales");
			System.out.println("         ");

		}else{
			System.out.println("Los c�digos hash son distintos");
			System.out.println("         ");

		}
		
	}
	
	
	private static void TestOrden(Beca a1,Beca a2){
		
		System.out.println("======================COMPROBANDO EL COMPARETO: ");
		System.out.println("         ");
		
		System.out.println("-Objeto 1: ");mostrarBeca(a1);
		
		System.out.println("-Objeto 2: ");mostrarBeca(a2);
		
		if(a1.compareTo(a2) == 0){
			System.out.println("         ");

			System.out.println("Los objetos son iguales seg�n el comareTo().");
		System.out.println("         ");
		}else if(a1.compareTo(a2)<0){
			System.out.println("         ");

			System.out.println("El 1� es menor que el 2� seg�n el  compareTo().");
			System.out.println("         ");

		}else{
			System.out.println("         ");

			System.out.println("El 1� es mayor que el 2� seg�n el  compareTo().");
			System.out.println("         ");

		}
	}
	
	
	private static void mostrarBeca(Beca b) {
		System.out.println("          ");
		System.out.println("Beca --> <" + b + ">");
		System.out.println("\tC�digo: <" + b.getCodigo() + ">");
		System.out.println("\tCuant�a total: <" + b.getCuantiaTotal() + ">");
		System.out.println("\tDuraci�n: <" + b.getDuracion() + ">");
		System.out.println("\tTipo: <" + b.getTipo() + ">");
		System.out.println("\tCuant�a mensual: <" + b.getCuantiaMensual() + ">");
		System.out.println("          ");

	}

}