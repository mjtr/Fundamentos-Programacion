 package fp.grados.tipos.test;



import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoEspacio;

public class TestCentro {

	public static void main(String[] args) {
	
		
		testConstructorNormal();
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		
		testNuevoEspacio();
		testNuevoEspacioExcepcion1();
		testNuevoEspacioExcepcion2();
		
		testEliminaEspacio();
		
		testConteosEspacios();
		testMayorCapacidad();
		 testMayorCapacidadExcepcion();
		 
		 testgetDespachos();

	}
	
/*****************************************CASOS DE PRUEBA*****************************************/
  
	
	private static void testConstructorNormal(){
		
		System.out.println("===================Probando el constructor normal");
		
	testConstructor("ETSII","Reina Mercedes",4,1);	
		
	
		
	}
    private static void testConstructorExcepcion1(){
		
		System.out.println("===================Probando la excepcion con número de plantas igual o menor que 0");
		
	testConstructor("ETSII","Reina Mercedes",0,1);	
		
	
		
	}
	
    private static void testConstructorExcepcion2(){
	
	System.out.println("===================Probando la excepción con  número de sotanos menor que 0");
	
testConstructor("ETSII","Reina Mercedes",4,-1);	
	
System.out.println(" ");
	
}
	
	private static void testNuevoEspacio(){
		
		System.out.println("=================================Probando el método nuevo espacio");
		
		Centro a = new CentroImpl("ETSII","Reina Mercedes",4,4);
		
		Espacio e = new EspacioImpl(TipoEspacio.LABORATORIO,"S34",80,-3);
		
	testNuevoEspacio(a,e);
		
	}
	
	
     private static void testNuevoEspacioExcepcion1(){
		
		System.out.println("=================================Probando el método nuevo espacio con espacio fuera de rango");
		
		Centro a = new CentroImpl("ETSII","Reina Mercedes",4,4);
		
		Espacio e = new EspacioImpl(TipoEspacio.LABORATORIO,"S34",80,6);
		
	testNuevoEspacio(a,e);
		
	}
	
    private static void testNuevoEspacioExcepcion2(){
	
	System.out.println("=================================Probando el método nuevo espacio con espacio menor que el rango");
	
	Centro a = new CentroImpl("ETSII","Reina Mercedes",4,4);
	
	Espacio e = new EspacioImpl(TipoEspacio.LABORATORIO,"S34",80,-5);
	
testNuevoEspacio(a,e);
	
}

	
	private static void testEliminaEspacio(){
		
		System.out.println("=================================Probando el método elimina espacio");

		Espacio r = new EspacioImpl(TipoEspacio.TEORIA,"S36",80,3);

		Centro a = new CentroImpl("ETSII","Reina Mercedes",4,4);
		Espacio e = new EspacioImpl(TipoEspacio.LABORATORIO,"S34",80,3);
		a.nuevoEspacio(e);
	
		System.out.println("Espacios antes de la operación: " + a.getEspacios());
		
		a.eliminaEspacio(e);
		a.eliminaEspacio(r);//Para ver si aquí saltaba algún error o algo
		System.out.println("Espacios antes de la operación: " + a.getEspacios());
		
	}
	
	
	
	
	private static void testConteosEspacios(){
		
		
		
		
		System.out.println("=================================Probando el conteo espacios y el getDespacho: ");
		Espacio r = new EspacioImpl(TipoEspacio.TEORIA,"S36",80,3);

		Centro a = new CentroImpl("ETSII","Reina Mercedes",21,21);
		Espacio e = new EspacioImpl(TipoEspacio.LABORATORIO,"S34",200,2);
		Espacio r1 = new EspacioImpl(TipoEspacio.EXAMEN,"S33",53,5);
		Espacio r2 = new EspacioImpl(TipoEspacio.TEORIA,"S32",80,-6);
		Espacio r3 = new EspacioImpl(TipoEspacio.OTRO,"S26",80,8);
		Espacio r4 = new EspacioImpl(TipoEspacio.SEMINARIO,"S16",80,9);
		Espacio r5 = new EspacioImpl(TipoEspacio.LABORATORIO,"S96",80,3);
		Espacio r6 = new EspacioImpl(TipoEspacio.TEORIA,"S06",32,6);
		Espacio r7 = new EspacioImpl(TipoEspacio.TEORIA,"S56",43,-1);
		Espacio r8 = new EspacioImpl(TipoEspacio.EXAMEN,"S78",54,0);
		
		a.nuevoEspacio(e);
		a.nuevoEspacio(r);
		a.nuevoEspacio(r1);
		a.nuevoEspacio(r2);
		a.nuevoEspacio(r3);
		a.nuevoEspacio(r4);
		a.nuevoEspacio(r5);
		a.nuevoEspacio(r6);
		a.nuevoEspacio(r7);
		a.nuevoEspacio(r8);
		
		
		
	System.out.println("Espacios del Centro:" +a.getEspacios());	
		System.out.println(" ");
 
		System.out.println("Conteo Espacios: " + a.getConteosEspacios());
		System.out.println(" ");
		System.out.println("Despachos: " + a.getDespachos());
		
	}
	
private static void testgetDespachos(){
		
		
		
		
		System.out.println("=================================Probando el conteo espacios y el getDespacho: ");
		Espacio r = new EspacioImpl(TipoEspacio.TEORIA,"S36",80,3);
	
		Departamento d = new DepartamentoImpl("LSI");
		Departamento f = new DepartamentoImpl("TDC");
		Profesor nuevo = new ProfesorImpl("12345678Z", "Billy", "El niño", 
				LocalDate.of(1980, 3, 25), "billy@gmail.com",Categoria.TITULAR,d);
		Set<Profesor> conjunto = new HashSet<Profesor>();
		conjunto.add(nuevo);
		Profesor nuevo3 = new ProfesorImpl("12345678Z", "Sara", "Sanchís", 
				LocalDate.of(1995, 3, 25), "sarita@gmail.com",Categoria.AYUDANTE_DOCTOR,d);
		conjunto.add(nuevo3);
		Profesor nuevo7 = new ProfesorImpl("12345678Z", "Romeo", "El niño", 
				LocalDate.of(1980, 3, 25), "billy@gmail.com",Categoria.TITULAR,f);
		Despacho nuevo2 = new DespachoImpl("S34",200,2,conjunto);
		
		Set<Profesor> conjunto2 = new HashSet<Profesor>();
		conjunto2.add(nuevo7);

		Despacho ta = new DespachoImpl("RSS4",13,4,conjunto2);
		Despacho nuevo4 = new DespachoImpl("S34",200,2,conjunto);
		
		Centro a = new CentroImpl("ETSII","Reina Mercedes",21,21);
		Espacio r1 = new EspacioImpl(TipoEspacio.EXAMEN,"S33",53,5);
		Espacio r2 = new EspacioImpl(TipoEspacio.TEORIA,"S32",80,-6);
		Espacio r3 = new EspacioImpl(TipoEspacio.OTRO,"S26",80,8);
		Espacio r4 = new EspacioImpl(TipoEspacio.SEMINARIO,"S16",80,9);
		Espacio r5 = new EspacioImpl(TipoEspacio.LABORATORIO,"S96",80,3);
		Espacio r6 = new EspacioImpl(TipoEspacio.TEORIA,"S06",32,6);
		Espacio r7 = new EspacioImpl(TipoEspacio.TEORIA,"S56",43,-1);
		Espacio r8 = new EspacioImpl(TipoEspacio.EXAMEN,"S78",54,0);
		
		a.nuevoEspacio(r);
		a.nuevoEspacio(r1);
		a.nuevoEspacio(r2);
		a.nuevoEspacio(r3);
		a.nuevoEspacio(r4);
		a.nuevoEspacio(r5);
		a.nuevoEspacio(r6);
		a.nuevoEspacio(r7);
		a.nuevoEspacio(r8);
		a.nuevoEspacio(nuevo4);
		a.nuevoEspacio(nuevo2);
		a.nuevoEspacio(ta);
		
	System.out.println("Espacios del Centro:" +a.getEspacios());	
		System.out.println(" ");
 System.out.println("Despachos del centro: " + a.getDespachos());
 System.out.println("  ");
 System.out.println("Despachos del centro del departamento TCD: " + a.getDespachos(f));
 System.out.println(" ");
 System.out.println("Profesores del Centro: " + a.getProfesores());
 System.out.println(" ");
 System.out.println("Profesores del Centro con departamento lsi : " + a.getProfesores(d));
		
	}
	
	
	
	private static void testMayorCapacidad(){
		
		
		System.out.println("=================================Probando el Espacio Mayor capacidad: ");
		Espacio r = new EspacioImpl(TipoEspacio.TEORIA,"S36",80,3);

		Centro a = new CentroImpl("ETSII","Reina Mercedes",21,21);
		Espacio e = new EspacioImpl(TipoEspacio.LABORATORIO,"S34",200,2);
		Espacio r1 = new EspacioImpl(TipoEspacio.EXAMEN,"S33",53,5);
		Espacio r2 = new EspacioImpl(TipoEspacio.TEORIA,"S32",80,-6);
		Espacio r3 = new EspacioImpl(TipoEspacio.OTRO,"S26",80,8);
		Espacio r4 = new EspacioImpl(TipoEspacio.SEMINARIO,"S16",80,9);
		Espacio r5 = new EspacioImpl(TipoEspacio.LABORATORIO,"S96",80,3);
		Espacio r6 = new EspacioImpl(TipoEspacio.TEORIA,"S06",32,6);
		Espacio r7 = new EspacioImpl(TipoEspacio.TEORIA,"S56",43,-1);
		Espacio r8 = new EspacioImpl(TipoEspacio.EXAMEN,"S78",54,0);
		
		a.nuevoEspacio(e);
		a.nuevoEspacio(r);
		a.nuevoEspacio(r1);
		a.nuevoEspacio(r2);
		a.nuevoEspacio(r3);
		a.nuevoEspacio(r4);
		a.nuevoEspacio(r5);
		a.nuevoEspacio(r6);
		a.nuevoEspacio(r7);
		a.nuevoEspacio(r8);
		
		testEspacioMayorCapacidad(a);
		System.out.println("Espacio de mayor capacidad, me tiene que salir el e , S34: " +  a.getEspacioMayorCapacidad());
		
		
		
		
		
		
	}
	
private static void testMayorCapacidadExcepcion(){
		
		
		System.out.println("=================================Probando el Espacio Mayor capacidad con excepción: ");


		Centro a = new CentroImpl("ETSII","Reina Mercedes",21,21);
	
		
		
		
		testEspacioMayorCapacidad(a);
		
		
	}
	
	
	
	
	
	private static void testEspacioMayorCapacidad(Centro a){
		
		try{
			a.getEspacioMayorCapacidad();
			
		}catch(ExcepcionCentroOperacionNoPermitida e){
			System.out.println(e);
		
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void testConstructor(String nombre,String direccion,Integer plantas,Integer sotanos){
	   
	   try{
		   
		Centro a = new CentroImpl(nombre,direccion,plantas,sotanos);
		mostrarCentro(a);
		   
	   } catch(ExcepcionCentroNoValido s){
		   System.out.println(s);
		   System.out.println(" ");
		   
	   }catch(Exception s){
		   
		   System.out.println("SE HA CAPTURADO UNA EXCEPCIÓN INESPERADA¡¡¡¡¡¡¡¡");
	   }
	   
	   
	   
   }
	
	private static void testNuevoEspacio(Centro a,Espacio e){
		try{
			
			System.out.println("Espacios del Centro antes de la operación:" + a.getEspacios());
			
			a.nuevoEspacio(e);
   
			System.out.println("Espacios del Centro después de la operación: " + a.getEspacios());
		}catch(ExcepcionCentroOperacionNoPermitida s){
			
			System.out.println(s);
			System.out.println(" ");
		}catch(Exception s){
			System.out.println("SE HA CAPTURADO UNA EXCEPCION INESPERADA¡¡¡¡¡¡¡");
		}
		
		
		
		
	}
	
	
	
	
	private static void mostrarCentro(Centro c) {		
		
		System.out.println("         ");
		System.out.println("Centro--> <" + c + ">");
		System.out.println("\tNombre: <" + c.getNombre() + ">");
		System.out.println("\tDirección <" + c.getDireccion() + ">");
		System.out.println("\tPlantas: <" + c.getNumeroPlantas() + ">");
		System.out.println("\tSótanos: <" + c.getNumeroSotanos() + ">");
		System.out.println("\tEspacios: <" + c.getEspacios() + ">");
	    System.out.println("         ");

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
