package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.grados.excepciones.ExcepcionPersonaNoValida;

import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;



public class TestPersona {

	public static void main(String[] args) {

		testConstructor1Normal();
		testConstructor1Excepcional1();
		testConstructor1Excepcional2();
		testConstructor1Excepcional3();
		testConstructor1Excepcional4();

		testConstructor2Normal();
		testConstructor2Excepcional1();
		testConstructor2Excepcional2();
		testConstructor2Excepcional3();
		
		testSetDNINormal();
		testSetDNIExcepcional1();
		testSetDNIExcepcional2();
		testSetDNIExcepcional3();
		
		testSetEmailNormal();
		testSetEmailExcepcional2();
		testSetEmailExcepcional3();
		
		TestSetNombreNormal();
		
		TestSetFechaNacimientoNormal();
		
		TestSetApellidosNormal();
		
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


	/************************PROBANDO EL PRIMER CONSTRUCTOR***************************/
	
	private static void testConstructor1Normal() {
		System.out.println("==================================Probando el primer constructor");
		testConstructor1("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		System.out.println("      ");
	}

	private static void testConstructor1Excepcional1() {
		System.out
				.println("==================================Probando el primer constructor con dni sin letra");
		testConstructor1("123456789", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testConstructor1Excepcional2() {
		System.out
				.println("==================================Probando el primer constructor con dni de longitud menor de la esperada");
		testConstructor1("1234567X", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testConstructor1Excepcional3() {
		System.out
				.println("==================================Probando el primer constructor con letra en dni que no se corresponde a los dígitos");
		testConstructor1("12345678X", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testConstructor1Excepcional4() {
		System.out
				.println("==================================Probando el primer constructor con email sin arroba");
		testConstructor1("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadiegmail.com");
	}	
	
	
	
	/*****************************PROBANDO EL SETDNI**********************************/
	
	
	private static void testSetDNINormal(){
		System.out
		.println("==================================Probando setDNI");
			Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
			testSetDNI(p, "12345677J");	
			System.out.println("      ");
	}
	
	private static void testSetDNIExcepcional1(){
		System.out
		.println("==================================Probando setDNI con dni sin letra");
		
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
			LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetDNI(p, "123456779");	
	}

	private static void testSetDNIExcepcional2(){
		System.out
		.println("==================================Probando setDNI con dni de longitud menor de la esperada");
		
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
			LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetDNI(p, "12345677");	
	}
	

	private static void testSetDNIExcepcional3(){
		System.out
		.println("==================================Probando setDNI con letra en dni que no se corresponde a los dígitos");

		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
			LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetDNI(p, "12345677X");	
	}


	/***************************PROBANDO EL SEGUNDO CONSTRUCTOR*****************************/
	
	
	private static void testConstructor2Normal(){
		
		System.out.println("==================================Probando el SEGUNDO constructor");
		testConstructor2("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
		System.out.println("      ");
		
		
		
	}
	
	
	
	private static void testConstructor2Excepcional1() {
		System.out
				.println("==================================Probando el segundo constructor con dni sin letra");
		testConstructor2("123456789", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
	}

	private static void testConstructor2Excepcional2() {
		System.out
				.println("==================================Probando el segundo constructor con dni de longitud menor de la esperada");
		testConstructor2("1234567X", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
	}

	private static void testConstructor2Excepcional3() {
		System.out
				.println("==================================Probando el segundo constructor con letra en dni que no se corresponde a los dígitos");
		testConstructor2("12345678X", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
	}

	
	/********************************PROBANDO EL SetEmail***************************************/
	
	private static void testSetEmailNormal(){
		System.out
		.println("==================================Probando setEmail normal");
			Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
			testSetEmail(p, "Manuel2@gmail.com");	
			System.out.println("      ");
			
	}
	
	private static void testSetEmailExcepcional2(){
		System.out
		.println("==================================Probando setEmail sin el carácter @");
		
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
			LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetEmail(p, "Manolitogemail.com");	
	}
	private static void testSetEmailExcepcional3(){
		System.out
		.println("==================================Probando setEmail con email vacio");
		
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
			LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		testSetEmail(p, " ");	
	}
	
	/*******************************PROBANDO EL SET NOMBRE NORMAL********************/
	
	private static void TestSetNombreNormal(){
	
		System.out.println("=================Probando el setNombre: ");
		
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		testSetNombre(p,"Ramón");
		
	}
	
	/*******************************PROBANDO EL SET APELLIDOS NORMAL********************/
	
	private static void TestSetApellidosNormal(){
		
		System.out.println("=================Probando el setApellidos: ");
		
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		testSetApellidos(p,"Chamorro González");
		
	}
	
	
	
	/*******************************PROBANDO EL SET FECHA NACIMIENTO  NORMAL********************/
	
	
private static void TestSetFechaNacimientoNormal(){
		
		System.out.println("=================Probando el setFechaNacimiento: ");
		
		Persona p = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		LocalDate nuevaFecha = LocalDate.of(1993, 7,29);
		
		
		testSetFechaNacimiento(p,nuevaFecha);
		
	}
	
	
	
	
	
	
	/**********************************PROBANDO EL EQUALS**********************************************/
	
	

	private static void TestIgualdad1(){
		Persona b1 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		Persona b2 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		TestIgualdad(b1,b2);
		
	}
	
	
	
	private static void TestIgualdad2(){
		Persona a1 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
		
		Persona a2 = new PersonaImpl("12345678Z", "Juan", "Perez Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		TestIgualdad(a1,a2);
		
	}
	
	
	private static void TestIgualdad3(){
		Persona a1 = new PersonaImpl("47392842P", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		Persona a2 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
		
		TestIgualdad(a1,a2);
		
	}
	
	private static void TestIgualdad4(){
		Persona a1 = new PersonaImpl("12345678Z", "Antonio", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		Persona a2 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		TestIgualdad(a1,a2);
		
	}
	
	
	/******************************PROBANDO EL COMPARETO*********************************/
	
	
private static void TestOrden1(){
		
		
	Persona a1 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		Persona a2 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		
		TestOrden(a1,a2);
		
		
	}
	
	
private static void TestOrden2(){
	
	
	Persona a1 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		Persona a2 = new PersonaImpl("12345678Z", "Juan", "Pérez Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		
		TestOrden(a1,a2);
		
		
	}
	

	
private static void TestOrden3(){
	
	
	Persona a1 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		Persona a2 = new PersonaImpl("12345678Z", "Antonio", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		
		TestOrden(a1,a2);
		
		
	}

private static void TestOrden4(){
	
	
	Persona a1 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		Persona a2 = new PersonaImpl("47392842P", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
		
		
		TestOrden(a1,a2);
		
		
	}

private static void TestOrden5(){
	
	
	Persona a1 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
		
		Persona a2 = new PersonaImpl("12345678Z", "Juan", "Nadie Nadie", 
				LocalDate.of(1950, 3, 15));
		
		
		TestOrden(a1,a2);
		
		
	}
	
	
	
	
	/********************************MÉTODOS AUXILIARES***************************************/
	
	private static void testSetNombre(Persona primen,String nomb){
System.out.println("             ");
	System.out.println("El nombre antes de cambiarlo es: "+ primen.getNombre());
	System.out.println("El nuevo nombre es: " + nomb);	
	primen.setNombre(nomb);
	System.out.println("El nombre después de cambiarlo es: " + primen.getNombre());	
	
	System.out.println("             ");
	}


	private static void testSetApellidos(Persona primen,String apell){

		System.out.println("             ");

		
	System.out.println("El apellido antes de cambiarlo es: "+ primen.getApellidos());
	System.out.println("El nuevo apellido es: " + apell);	
	primen.setApellidos(apell);
	System.out.println("El apellido después de cambiarlo es: " + primen.getApellidos());	
	System.out.println("             ");

	
	}
	private static void testSetFechaNacimiento(Persona primen,LocalDate fech){
		System.out.println("             ");

		System.out.println("La fecha de nacimiento antes de cambiarla es: "+ primen.getFechaNacimiento());
		System.out.println("La nueva fecha es: " + fech);	
		primen.setFechaNacimiento(fech);
		System.out.println("La fecha de nacimiento después de cambiarla es: " + primen.getFechaNacimiento());	
		System.out.println("             ");

		
		}



	private static void testConstructor1(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email) {

		try {
			Persona p = new PersonaImpl(dni, nombre, apellidos, 
					fechaNacimiento, email);
			mostrarPersona(p);
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println(e);
			System.out.println("      ");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada. El constructor no funciona correctamente");
		}

	}

	private static void testConstructor2(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento) {

		try {
			Persona p = new PersonaImpl(dni, nombre, apellidos, 
					fechaNacimiento);
			mostrarPersona(p);
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println(e);
			System.out.println("      ");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada. El constructor no funciona correctamente");
		}

	}
	
	
	
	private static void testSetDNI(Persona p, String nuevoDNI) {

		try {
			System.out.println("El dni antes de la operación es: "+  p.getDNI());
			System.out.println("El nuevo dni es: "+  nuevoDNI);
			p.setDNI(nuevoDNI);
			System.out.println("El dni después de la operación es: "+  p.getDNI());
		} catch (ExcepcionPersonaNoValida e) {
			System.out.println(e);
			System.out.println("      ");
		} catch (Exception e) {
			System.out.println("******************** Se ha capturado una excepción inesperada. setDNI no funciona correctamente");
		}
	}

	private static void testSetEmail(Persona s,String nuevoEmail){
		
		try{
			System.out.println("          ");
			System.out.println("El email antes de la operación es: " + s.getEmail());
			System.out.println("El nuevo email es: " + nuevoEmail);
			s.setEmail(nuevoEmail);
			System.out.println("El email después de la operación es: " + s.getEmail());
		}catch (ExcepcionPersonaNoValida e){
			System.out.println(e);
			System.out.println("        ");
		}catch (Exception e){
			System.out.println("**************Se ha capturado una excepción inesperado. setEmail no funciona correctamente");
		}
		
	}
	
     private static void TestIgualdad(Persona a1,Persona a2){
		
		
		System.out.println("======================COMPROBANDO LA IGUALDAD:");
		System.out.println("         ");	
		System.out.println("-Objeto 1: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a1.hashCode() +  ")"   )  ;

		

		mostrarPersona(a1);
	

		System.out.println("-Objeto 2: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a2.hashCode() +  ")"   )  ;

		mostrarPersona(a2);
		
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
	
	
	private static void TestOrden(Persona a1,Persona a2){
		
		System.out.println("=========================COMPROBANDO EL COMPARETO: ");
		System.out.println("         ");
		
		System.out.println("-Objeto 1: ");mostrarPersona(a1);
		
		System.out.println("-Objeto 2: ");mostrarPersona(a2);
		
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
	
	
	
	private static void mostrarPersona(Persona p) {
		System.out.println("        ");
		System.out.println("Persona --> " + p   );
		System.out.println("        ");
		System.out.println("\tNombre: <" + p.getNombre() + ">");
		System.out.println("\tApellidos: <" + p.getApellidos() + ">");
		System.out.println("\tDNI: <" + p.getDNI() + ">");
		System.out.println("\tFecha Nacimiento: <"
				+ p.getFechaNacimiento().format(
						DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + p.getEdad() + ">");
		System.out.println("\tEmail:  <" + p.getEmail() + ">");
		System.out.println("        ");

	}

}