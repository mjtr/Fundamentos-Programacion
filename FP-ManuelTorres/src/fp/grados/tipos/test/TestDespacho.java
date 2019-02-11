package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionDespachoNoValido;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoEspacio;

public class TestDespacho {

	public static void main(String[] args) {
		
		
		testConstructor1Normal();
		testExcepcionConstructor1();
		
		testConstructor2Normal();
		
		testConstructor3Normal();
		
		testSetTipoExcepcion();
	
		testSetProfesorNormal();
		
		
		}

		
		/*************************CASOS DE PRUEBA********************************/
		
		private static void testConstructor1Normal(){
			System.out.println("======================Probando el primer constructor: ");
			System.out.println("     ");
		
			
		testConstructor1("A2.10",10,2,ConjuntoProfesores());
		
		}
		
		private static void testConstructor2Normal(){
			System.out.println("==========================Probando el segundo constructor: ");
			System.out.println("     ");
		
			Profesor nuevo = new ProfesorImpl("12345678Z", "Billy", "El niño", 
				LocalDate.of(1980, 3, 25), "billy@gmail.com",Categoria.TITULAR,null);
		
			
		testConstructor2("A2.10",80,2,nuevo);
		
		}
		
		private static void testConstructor3Normal(){
			System.out.println("=======================Probando el tercer constructor: ");
			System.out.println("     ");
		
			
		testConstructor3("A2.10",80,2);
		
		}
		
		
		
		/***************PROBANDO EXCEPCIONES CONSTRUCTOR 1*****************************/
		
		private static void testExcepcionConstructor1(){
			
			System.out.println("================Probando el primer constructor,con capacidad inferior al número de profesores:");
			
			testConstructor1("A2.10",2,2,ConjuntoProfesores());

		}
		


	/*************************PROBANDO SET TIPO************************************/

		private static void testSetTipoExcepcion(){
			System.out.println("===================Probando el setTipo normal: ");
			System.out.println("     ");
		
			

			Despacho s = new DespachoImpl("A2.10",80,2,ConjuntoProfesores());
			TipoEspacio c = TipoEspacio.LABORATORIO;
			
		
		
		testSetTipo(s,c);
		
		}
	
		
		
		/*****************************PROBANDO EL SET PROFESOR**************************************/


		private static void testSetProfesorNormal(){
			System.out.println("===================Probando el setProfesor normal: ");
			System.out.println("     ");
		
			

			Despacho s = new DespachoImpl("A2.10",80,2,ConjuntoProfesores());
			
			Set<Profesor> dinosaurio = new HashSet<Profesor>();
			
			Profesor velociraptor = new ProfesorImpl("12345678Z", "Velociraptor", "Parque Jurásico", 
					LocalDate.of(0012, 3, 15), "veloci@gmail.com",Categoria.AYUDANTE,null);
			Profesor T_rex = new ProfesorImpl("12345678Z", "Tiranosaurio Rex", "Parque Jurásico", 
					LocalDate.of(0012, 3, 15), "tini@gmail.com",Categoria.INTERINO,null);
		
			dinosaurio.add(velociraptor);
			dinosaurio.add(T_rex);
		
		
		testSetProfesor(s,dinosaurio);
		
		}
		
		
		
		
		
		
	
	/****************************MÉTODOS AUXILIARES********************************/

	private static  Set<Profesor> ConjuntoProfesores(){
		
		//He creado este método para no estar creando cada dos por tres un Set de Profesores
		//Tengo este y lo uso para todos 
		
		Set<Profesor> zeus = new HashSet<Profesor>();
		
		Profesor r = new ProfesorImpl("12345678Z", "Benito", "Pérez Galdós", 
				LocalDate.of(1950, 3, 15), "Benito@gmail.com",Categoria.CATEDRATICO,null);
		Profesor d = new ProfesorImpl("12345678Z", "Antonio", "Machado", 
				LocalDate.of(1950, 3, 15), "Antonio@gmail.com",Categoria.CATEDRATICO,null);

		Profesor x = new ProfesorImpl("12345678Z", "Pío", "Baroja", 
				LocalDate.of(1950, 3, 15), "Manolito@gmail.com",Categoria.CATEDRATICO,null);
		
		zeus.add(r);
		zeus.add(d);
		zeus.add(x);
		
		return zeus;
		
		
		
	}
	
	
	

	private static void testSetTipo(Despacho a,TipoEspacio c){
		try{
			System.out.println("El tipo antes de cambiarlo es: " + a.getTipo());
	        
			System.out.println("El nuevo valor es: " + c);
		    a.setTipo(c);
		System.out.println("El tipo después de cambiarlo es: " + a.getTipo());
		System.out.println("        ");
		
		}catch (UnsupportedOperationException e) {
			System.out.println(e);
			System.out.println("    ");
		}catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}
	
	private static void testSetProfesor(Despacho a, Set<Profesor> conjunto){
		try{
			System.out.println("El conjunto de profesores antes de cambiarlo es: " + a.getProfesores());
	        
			System.out.println("El nuevo conjunto es: " + conjunto);
		 a.setProfesores(conjunto);
		System.out.println("El conjunto de profesores después de cambiarlo es: " + a.getProfesores());
		System.out.println("        ");
		
		}catch (ExcepcionDespachoNoValido e) {
			System.out.println(e);
			System.out.println("    ");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}
	
	
		private static void testConstructor1(String nombre,Integer capacidad,
				Integer planta,Set<Profesor> profee){
			try {
				Despacho b = new DespachoImpl(nombre,capacidad,planta,profee);
				mostrarDespacho(b);
			} catch (ExcepcionDespachoNoValido e) {
				System.out.println(e);
				System.out.println("       ");
			} catch (Exception e) {
				System.out
						.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
			}
		}
		
		private static void testConstructor2(String nombre,Integer capacidad,Integer planta,Profesor profe){
			
			try {
				Despacho b = new DespachoImpl(nombre,capacidad,planta,profe);
				mostrarDespacho(b);
			} catch (ExcepcionDespachoNoValido e) {
				System.out.println(e);
				System.out.println("       ");
			}catch (Exception e) {
				System.out
						.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
			}
		}
		
		private static void testConstructor3(String nombre,Integer capacidad,
				Integer planta){
			try {
				Despacho b = new DespachoImpl(nombre,capacidad,planta);
				mostrarDespacho(b);
			} catch (ExcepcionDespachoNoValido e) {
				System.out.println(e);
				System.out.println("       ");
			} catch (Exception e) {
				System.out
						.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
			}
		}
	
		
		
		private static void mostrarDespacho(Despacho dexter){
			System.out.println("       ");
			System.out.println("Despacho: "+ dexter);
			System.out.println("       ");
			System.out.println("Tipo de Aula: <" + dexter.getTipo() + ">");
			System.out.println("Nombre del aula: <" + dexter.getNombre()+ ">");
			System.out.println("Capacidad del aula: <" + dexter.getCapacidad() + " personas" + ">");
			System.out.println("Planta en la que se encuentra: <" + dexter.getPlanta() +  ">");
			System.out.println("Profesores: "+ dexter.getProfesores());
			System.out.println("     ");
			
			
			
			
		}
		
		
		
	}