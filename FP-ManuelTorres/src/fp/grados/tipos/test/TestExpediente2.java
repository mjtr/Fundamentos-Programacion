package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionExpedienteOperacionNoPermitida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Expediente;
import fp.grados.tipos.ExpedienteImpl2;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestExpediente2 {

	public static void main(String[] args) {

		
		testConstructorNormal();
		testnuevaNota();
		testnotaMedia();
		
		testExcepcion();
		
		
	}

	
	
	private static void testConstructorNormal(){
		
		System.out.println("======================Probando el constructor normal: ");
		Expediente e = new ExpedienteImpl2();
		mostrarExpediente(e);
		
	}
	
	private static void testnuevaNota(){
		
		System.out.println("======================Probando el nueva Nota: ");
		
		Expediente e = new ExpedienteImpl2();
		Asignatura p = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		Nota n = new NotaImpl(p,1999,Convocatoria.PRIMERA,10.0,true);
		
	System.out.println("Notas del expediente antes de la operación: " + e.getNotas());	
		System.out.println("   ");
	e.nuevaNota(n);
	System.out.println("Notas del expediente después de la operación: " + e.getNotas());
		
	}
	
	private static void testnotaMedia(){
		System.out.println("=========================Probando el nota Media: ");

		Expediente e = new ExpedienteImpl2();
		Asignatura p = new AsignaturaImpl("Fundamentos Físicos de la Informática","7025384", 6.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	
		Nota n = new NotaImpl(p,1999,Convocatoria.PRIMERA,10.0,true);
		Asignatura f = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		Nota w = new NotaImpl(f,1999,Convocatoria.PRIMERA,7.0,false);
		Asignatura pa = new AsignaturaImpl("CED","7029383", 6.0,TipoAsignatura.PRIMER_CUATRIMESTRE,1,null); 	
		Nota na = new NotaImpl(pa,1999,Convocatoria.PRIMERA,4.0,false);
		Asignatura pe = new AsignaturaImpl("Estadística","7089384", 6.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	
		Nota no = new NotaImpl(pe,1999,Convocatoria.PRIMERA,7.0,false);
		
		e.nuevaNota(n);
		e.nuevaNota(w);
		e.nuevaNota(na);
		e.nuevaNota(no);
		
		System.out.println("Notas del expediente: " + e.getNotas());
		System.out.println("Nota media: " + e.getNotaMedia());
		
	}
	
	
	
	private static void testExcepcion(){
		
		System.out.println("=========================Probando la excepción del expediente que no se pueden tener más de dos notas: ");

		Expediente e = new ExpedienteImpl2();
		Asignatura p = new AsignaturaImpl("Fundamentos Físicos de la Informática","7025384", 6.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	
		Nota n = new NotaImpl(p,1999,Convocatoria.PRIMERA,10.0,true);
		Asignatura f = new AsignaturaImpl("Fundamentos de programación","7029384", 12.0,TipoAsignatura.ANUAL,1,null); 	
		Nota w = new NotaImpl(f,1999,Convocatoria.PRIMERA,7.0,false);
		Asignatura pa = new AsignaturaImpl("CED","7029383", 6.0,TipoAsignatura.PRIMER_CUATRIMESTRE,1,null); 	
		Nota na = new NotaImpl(pa,1999,Convocatoria.PRIMERA,4.0,false);
		Asignatura pe = new AsignaturaImpl("Estadística","7089384", 6.0,TipoAsignatura.SEGUNDO_CUATRIMESTRE,1,null); 	
		Nota no = new NotaImpl(pe,1999,Convocatoria.PRIMERA,7.0,false);
		
		Nota n2 = new NotaImpl(p,1999,Convocatoria.TERCERA,8.0,false);
		Nota n1 = new NotaImpl(p,1999,Convocatoria.SEGUNDA,9.0,true);
		
	
		try{
		
		
		
		e.nuevaNota(w);
		e.nuevaNota(na);
		e.nuevaNota(no);
		e.nuevaNota(n1);
		e.nuevaNota(n2);
		e.nuevaNota(n);
		mostrarExpediente(e);

	}catch(ExcepcionExpedienteOperacionNoPermitida r){
		System.out.println(r);
		
		
	}catch(Exception r){
		System.out.println("SE HA CAPTURADO UNA EXCEPCIÓN INESPERADA");
	}
		
		
	}
	
	
	
	
	
	
	private static void mostrarExpediente(Expediente a){
		
		System.out.println(" ");
		System.out.println("\tExpediente: " + a);
        System.out.println("\tNotas: "+ a.getNotas());		
		System.out.println("\tNota Media: " + a.getNotaMedia());
		
		
	}
	
	
	
	


	
	
	
}
