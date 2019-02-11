package fp.grados.tipos.test;

import fp.grados.tipos.Persona;
import fp.grados.utiles.Grados;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.PersonaImpl;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.NotaImpl;

import java.util.List;


public class TestFicheros {

	public static void main(String[] args) {
	
		//Persona
		List<Persona> lista = Grados.leeFichero("res/personas.txt",s -> new PersonaImpl(s));
		
		System.out.println("Personas : " + lista);
		
		//Alumno
        List<Alumno> lista2 = Grados.leeFichero("res/alumnos.txt",s -> new AlumnoImpl(s));
		
		System.out.println("Alumnos : " + lista2);
		
		//Nota
	     List<Nota> lista3 = Grados.leeFichero("res/notas.txt",s -> new NotaImpl(s));
			
			System.out.println("Notas : " + lista3);
			
			//Asignatura
			
			 List<Asignatura> lista4 = Grados.leeFichero("res/asignaturas.txt",s -> new AsignaturaImpl(s));
				
				System.out.println("Asignaturas : " + lista4);

	}

}
