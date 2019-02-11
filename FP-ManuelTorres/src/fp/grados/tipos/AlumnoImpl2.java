package fp.grados.tipos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;


public class AlumnoImpl2 extends AlumnoImpl {
	
	
	/*************************************CONSTRUCTOR*****************************************/
	
	public AlumnoImpl2(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
			String email){
	
		super(dni,nombre,apellidos,fechanacimiento,email);
		
		
	}
	
	
	public AlumnoImpl2(String s){
	
   super(s);
   
	}
	

	
	/*********************************MÉTODOS**************************************/

	public Integer getCurso() {
	
		if(getAsignaturas().isEmpty()){
			return 0;
		}else{
		return	getAsignaturas().stream().max(Comparator.comparing(Asignatura :: getCurso)).
			orElseThrow(() -> new ExcepcionAlumnoOperacionNoPermitida("Fallo en integerCurso de java 8 "))
			.getCurso();
		}
	
	 
	//return	getAsignaturas().stream().max(Comparator.comparing(Asignatura :: getCurso)).get().getCurso();
	 
	
		}
	
	//TODO:Revisar este método
	public SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura(){
		
		Function<Nota,Calificacion> f1 = e-> e.getCalificacion(); 
	    Function <Nota,Asignatura> f2 = n-> n.getAsignatura();
	    
		return new TreeMap<>(
				
				getExpediente().getNotas().stream()
				.collect(Collectors.toMap(f2, f1,(x1,x2)-> calificacionMayor(x1,x2))));
	}
	
	private Calificacion calificacionMayor(Calificacion c1,Calificacion c2){
		
		if(c1.compareTo(c2)>=0){
			return c1;
		}else
			return c2;
		
		
	}
	
	
	
	
	
	
	
	
	
	
}