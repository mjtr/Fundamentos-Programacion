package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;





import fp.grados.excepciones.ExcepcionTutoriaNoValida;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestTutoria {

	public static void main(String[] args) {
		
		testConstructor1Normal();
		testExcepcion1Constructor1();
		testExcepcion2Constructor1();
		testExcepcion3Constructor1();
		test4Constructor1();
		
		testConstructor2Normal();
		testExcepcion1Constructor2();
		testExcepcion2Constructor2();
		testExcepcion3Constructor2();
		test4Constructor2();
		
		TestIgualdad1();
		TestIgualdad2();
		TestIgualdad3();
		
		TestOrden1();
		TestOrden2();
		TestOrden3();
		TestOrden4();
		TestOrden5();
		TestOrden6();
		
		
		
		
	}

	
	private static void testConstructor1Normal(){
		System.out.println("==================Probando el Constructor 1: ");
	
		
		
		testConstructor1(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		
	}
	
	private static void testConstructor2Normal(){
		
	
		System.out.println("===================Probando el Constructor 2: ");
		
		testConstructor2(DayOfWeek.MONDAY,LocalTime.of(13, 40),130);
		
		
		
	}
	
	
	
	/****************************EXCEPCIONES CONSTRUCTOR 1******************************************/
	
	
	private static void testExcepcion1Constructor1(){
		System.out.println("==========Probando el Constructor 1,con día de tutoria en SÁBADO ");
		
		
		
		testConstructor1(DayOfWeek.SATURDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
	
	
	}
	
	private static void testExcepcion2Constructor1(){
		System.out.println("==========Probando el Constructor 1,con día de tutoria en DOMINGO ");
	
		
		
		testConstructor1(DayOfWeek.SUNDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
	
	
	}
	
	private static void testExcepcion3Constructor1(){
		System.out.println("==========Probando el Constructor 1,con duración menor que 15");
	
		
		
		testConstructor1(DayOfWeek.MONDAY,LocalTime.of(13, 40),LocalTime.of(13, 50));
	
	
	}
	
	private static void test4Constructor1(){
		System.out.println("==========Probando el Constructor 1,con duración igual que 15");
	
		
		
		testConstructor1(DayOfWeek.MONDAY,LocalTime.of(13, 40),LocalTime.of(13, 55));
	
	
	}
	
	
	

	/****************************EXCEPCIONES CONSTRUCTOR 2****************************************/
	
	
	private static void testExcepcion1Constructor2(){
		System.out.println("==========Probando el Constructor 2,con día de tutoria en SÁBADO ");
		
		
		
		testConstructor2(DayOfWeek.SATURDAY,LocalTime.of(13, 40),150);
	
	
	}
	

	private static void testExcepcion2Constructor2(){
		System.out.println("==========Probando el Constructor 2,con día de tutoria en DOMINGO ");
		
		
		
		testConstructor2(DayOfWeek.SATURDAY,LocalTime.of(13, 40),120);
	
	
	}
	
	
	private static void testExcepcion3Constructor2(){
		System.out.println("==========Probando el Constructor 2,con duración menor que 15");
		
		
		
		testConstructor2(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),10);
	
	
	}
	
	private static void test4Constructor2(){
		System.out.println("==========Probando el Constructor 2,con duración igual que 15");
		
		
		
		testConstructor2(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),15);
	
	
	}
	
	

	/*********************************COMPROBANDO LA IGUALDAD : *************************************/
	
	
	
	private static void TestIgualdad1(){
		
		Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		Tutoria a2 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		TestIgualdad(a1,a2);
		
	}
	
	
	
	private static void TestIgualdad2(){
		
		Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		Tutoria a2 = new TutoriaImpl(DayOfWeek.MONDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		TestIgualdad(a1,a2);
		
	}
	
private static void TestIgualdad3(){
		
		Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		Tutoria a2 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 58),LocalTime.of(15, 20));
		
		TestIgualdad(a1,a2);
		
	}

	
	/*****************************COMPROBANDO EL COMPARETO ********************************/
	
private static void TestOrden1(){
		
		
	Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
	
	Tutoria a2 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		
		TestOrden(a1,a2);
		
		
	}
	
	
	private static void TestOrden2(){
		
      Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
	  Tutoria a2 = new TutoriaImpl(DayOfWeek.THURSDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
		
		TestOrden(a1,a2);
		
		
	}
	

	
	private static void TestOrden3(){
		
		
     Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
		
     Tutoria a2 = new TutoriaImpl(DayOfWeek.MONDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));;
		
		
		TestOrden(a1,a2);
		
		
	}
	
	private static void TestOrden4(){
		
		
	     Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
			
	     Tutoria a2 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 50),LocalTime.of(15, 20));;
			
			
			TestOrden(a1,a2);
			
			
		}
	private static void TestOrden5(){
		
		
	     Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 50),LocalTime.of(15, 20));
			
	     Tutoria a2 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));;
			
			
			TestOrden(a1,a2);
			
			
		}
	private static void TestOrden6(){
		
		
	     Tutoria a1 = new TutoriaImpl(DayOfWeek.WEDNESDAY,LocalTime.of(13, 40),LocalTime.of(15, 20));
			
	     Tutoria a2 = new TutoriaImpl(DayOfWeek.MONDAY,LocalTime.of(13, 58),LocalTime.of(15, 20));;
			
			
			TestOrden(a1,a2);
			
			
		}
	
	
	/******************************MÉTODOS AUXILIARES*****************************/
	
	
	
	private static void testConstructor1(DayOfWeek diaSemana,LocalTime horaComienzo,LocalTime horaFin){
		try {
			
			Tutoria b = new TutoriaImpl(diaSemana, horaComienzo,horaFin);
			mostrarTutoria(b);
		} catch (ExcepcionTutoriaNoValida e) {
			System.out.println(e);
			System.out.println("       ");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}
	
	private static void testConstructor2(DayOfWeek diaS,LocalTime horaC,Integer duracion){
		try {
			
			Tutoria b = new TutoriaImpl(diaS, horaC,duracion);
			mostrarTutoria(b);
		} catch (ExcepcionTutoriaNoValida e) {
			System.out.println(e);
			System.out.println("       ");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}
	
private static void TestIgualdad(Tutoria t1,Tutoria t2){
		
		
		System.out.println("==================COMPROBANDO LA IGUALDAD:");
		System.out.println("         ");	
		System.out.println("-Objeto 1: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + t1.hashCode() +  ")"   )  ;

		

		mostrarTutoria(t1);
		System.out.println("         ");	

		System.out.println("-Objeto 2: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + t2.hashCode() +  ")"   )  ;

		mostrarTutoria(t2);
		
		if(t1.equals(t2)){
			System.out.println("Los objetos son iguales ,segun el equals()");
		}else{
			System.out.println("Los objetos son distintos ,segun el equals()");
		}
		if(t1.hashCode() == t2.hashCode()){
			System.out.println("Los códigos hash son iguales");
			System.out.println("         ");

		}else{
			System.out.println("Los códigos hash son distintos");
			System.out.println("         ");

		}
		
	}
	
	
	private static void TestOrden(Tutoria a1,Tutoria a2){
		
		System.out.println("======================COMPROBANDO EL COMPARETO: ");
		System.out.println("         ");
		
		System.out.println("-Objeto 1: ");mostrarTutoria(a1);
		
		System.out.println("-Objeto 2: ");mostrarTutoria(a2);
		
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
	
	
	private static void mostrarTutoria(Tutoria p){
		System.out.println("       ");
		System.out.println("El toString: "+p);
		System.out.println("        ");
		System.out.println("Dia de la semana----> " + p.getDiaSemana());
		System.out.println("Hora de comiemzo-----> " + p.getHoraComienzo());
		System.out.println("Hora final------> "+ p.getHoraFin());
		System.out.println("Duración de la tutoría-----> "+ p.getDuracion() + " minutos");
		System.out.println("      ");
		
	}
}
