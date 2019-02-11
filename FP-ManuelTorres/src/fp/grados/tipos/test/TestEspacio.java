package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionEspacioNoValido;

import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;

public class TestEspacio {

	public static void main(String[] args) {
	
		
	testConstructor();
	testExcepcionConstructor1();
	testExcepcion2Constructor1();

	testSetNombre1();
	
	testSetTipo();
	
	testSetCapacidad1();
	testSetCapacidadExcepcion1();
	testSetCapacidadExcepcion2();
	
	TestIgualdad1();
	TestIgualdad2();
	TestIgualdad3();
	TestIgualdad4();
	
	TestOrden1();
	TestOrden2();
	TestOrden3();
	
	}

	
	/*************************CONSTRUCTOR 1********************************/
	
	private static void testConstructor(){
		System.out.println("==============Probando el primer constructor: ");
		System.out.println("     ");
	
	testConstructor1(TipoEspacio.TEORIA,"A2.10",80,2);
	}
	
	/***************************PROBANDO EL SET TIPO*************************/
	  
	

	private static void testSetTipo(){
		
		System.out.println("========================Probando set Tipo");
		Espacio a = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
		
		
		
		testSetTipo(a,TipoEspacio.SEMINARIO);
		
		
	}
	
	
	
	
	
	/***************PROBANDO EXCEPCIONES CONSTRUCTOR 1*****************************/
	
	private static void testExcepcionConstructor1(){
		
		System.out.println("-Probando el primer constructor,con capacidad inferior a 0");
		testConstructor1(TipoEspacio.TEORIA,"A2.10",-9,2);
	}
	
private static void testExcepcion2Constructor1(){
		
		System.out.println("-Probando el primer constructor,con capacidad igual a 0");
		testConstructor1(TipoEspacio.TEORIA,"A2.10",0,2);
	}

/****************************PROBANDO SetNombre********************************/

private static void testSetNombre1(){
	System.out
	.println("==================================Probando setNombre");
	Espacio b = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",70,2);
	testSetNombre(b, "A1.11");
	System.out.println("        ");
}




/*************************PROBANDO SET CAPACIDAD************************************/


private static void testSetCapacidad1(){
	System.out
	.println("==================================Probando setCapacidad");
	Espacio b = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",70,2);
	testSetCapacidad(b, 50);
	System.out.println("        ");
}

private static void testSetCapacidadExcepcion1(){
	System.out
	.println("==================================Probando setCapacidad con capacidad igual a 0");
	Espacio b = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",90,2);
	testSetCapacidad(b, 0);
	System.out.println("        ");
}

private static void testSetCapacidadExcepcion2(){
	System.out
	.println("==================================Probando setCapacidad con capacidad menor a 0");
	Espacio b = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",70,2);
	testSetCapacidad(b,-40);
	System.out.println("        ");
}


/*********************************COMPROBANDO LA IGUALDAD : *************************************/



private static void TestIgualdad1(){
	
	Espacio a1 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
	
	Espacio a2 = new EspacioImpl(TipoEspacio.LABORATORIO,"A2.10",80,2);	
	
	TestIgualdad(a1,a2);
	
}



private static void TestIgualdad2(){
	Espacio a1 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
	
	Espacio a2 = new EspacioImpl(TipoEspacio.TEORIA,"A2.11",80,2);	
	
	TestIgualdad(a1,a2);
	
}

private static void TestIgualdad3(){
	Espacio a1 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
	
	Espacio a2 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,1);	
	
	TestIgualdad(a1,a2);
	
}

private static void TestIgualdad4(){
	Espacio a1 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
	
	Espacio a2 = new EspacioImpl(TipoEspacio.TEORIA,"A2.11",80,1);	
	
	TestIgualdad(a1,a2);
	
}
/*****************************COMPROBANDO EL COMPARETO ********************************/

private static void TestOrden1(){
	
    Espacio a1 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
	
	Espacio a2 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);	
	
	
	TestOrden(a1,a2);
	
	
}


private static void TestOrden2(){
	
	
    Espacio a1 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
	
	Espacio a2 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,1);	
	
	TestOrden(a1,a2);
	
	
}



private static void TestOrden3(){
	
	
    Espacio a1 = new EspacioImpl(TipoEspacio.TEORIA,"A2.10",80,2);
	
	Espacio a2 = new EspacioImpl(TipoEspacio.TEORIA,"A2.11",80,2);	
	
	
	TestOrden(a1,a2);
	
	
}







/****************************MÉTODOS AUXILIARES********************************/

private static void testSetTipo(Espacio a,TipoEspacio c){
	
		System.out.println("El tipo antes de cambiarlo es: " + a.getTipo());
        
		System.out.println("El nuevo valor es: " + c);
	    a.setTipo(c);
	System.out.println("El tipo después de cambiarlo es: " + a.getTipo());
	System.out.println("        ");
	
	
}
private static void testSetNombre(Espacio a,String c){
	
		System.out.println("El nombre antes de cambiarlo es: " + a.getNombre());
       
		System.out.println("El nuevo nombre es: " + c);
	    a.setNombre(c);
	    
	    System.out.println("El nombre después de cambiarlo es: " + a.getNombre());
	}

private static void testSetCapacidad(Espacio a,Integer c){
	try{
		System.out.println("La capacidad antes de cambiarla es: " + a.getCapacidad());
        
		System.out.println("El nuevo valor es: " + c);
	    a.setCapacidad(c);
	System.out.println("La capacidad después de cambiarla es: " + a.getCapacidad());
	
	}catch (ExcepcionEspacioNoValido e) {
		System.out.println(e);
		System.out.println("    ");
	} catch (Exception e) {
		System.out
				.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
	}
}
	
	
	private static void testConstructor1(TipoEspacio tipo, String nombre,Integer capacidad,Integer planta){
		try {
			Espacio b = new EspacioImpl(tipo,nombre,capacidad,planta);
			mostrarEspacio(b);
		} catch (ExcepcionEspacioNoValido e) {
			System.out.println(e);
			System.out.println("       ");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}
	
	
private static void TestIgualdad(Espacio a1,Espacio a2){
		
		
		System.out.println("=============================COMPROBANDO LA IGUALDAD:");
		System.out.println("         ");	
		System.out.println("-Objeto 1: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a1.hashCode() +  ")"   )  ;

		

		mostrarEspacio(a1);
		System.out.println("         ");	

		System.out.println("-Objeto 2: " );
		System.out.println("         ");
		System.out.println("  (Código hash " + a2.hashCode() +  ")"   )  ;

		mostrarEspacio(a2);
		
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
	
	
	private static void TestOrden(Espacio a1,Espacio a2){
		
		System.out.println("====================COMPROBANDO EL COMPARETO: ");
		System.out.println("         ");
		
		System.out.println("-Objeto 1: ");mostrarEspacio(a1);
		
		System.out.println("-Objeto 2: ");mostrarEspacio(a2);
		
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
	
	
	
	
	private static void mostrarEspacio(Espacio edificio){
		
		System.out.println(edificio);
		System.out.println("       ");
		System.out.println("Tipo de Aula: <" + edificio.getTipo() + ">");
		System.out.println("Nombre del aula: <" + edificio.getNombre()+ ">");
		System.out.println("Capacidad del aula: <" + edificio.getCapacidad() + " personas" + ">");
		System.out.println("Planta en la que se encuentra: <" + edificio.getPlanta() +  ">");
		System.out.println("     ");
	}
	
	
	
}
