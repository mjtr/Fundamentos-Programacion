package fp.grados.tipos;

import java.time.LocalDate;

import java.util.Comparator;
import java.util.HashSet;


import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;

public class AlumnoImpl extends PersonaImpl implements Alumno {

	/*********************************ATRIBUTOS*********************************************/
	
	
	private Set<Asignatura> asignaturas;
	private Expediente expediente;
	
	
	
	/*************************************CONSTRUCTOR*****************************************/
	
	public AlumnoImpl(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
			String email){
	
		super(dni,nombre,apellidos,fechanacimiento,email);
		
		CheckEmails(email);
		
		asignaturas = new HashSet<Asignatura>();
		
		expediente = new ExpedienteImpl();
 
		
		
		
	}
	
	
	public AlumnoImpl(String s){
	
   super(s);
   CheckEmails(getEmail());
		
	asignaturas = new HashSet<Asignatura>();
	expediente = new ExpedienteImpl();
	
	}
	

	
	/*********************************MÉTODOS**************************************/
	
	
	public Set<Asignatura> getAsignaturas(){
	return new HashSet<Asignatura>(asignaturas);
	
	}
	
	public void setEmail(String email){
		
		CheckEmails(email);
    
		super.setEmail(email);
    
	}
	
	
	public Expediente getExpediente() {
		
		return expediente;
	}

	
	public Integer getCurso() {
		
	Integer curso = 0;
	
	for(Asignatura a : asignaturas){
		
		if(a.getCurso() > curso){
		
			curso = a.getCurso();	
		}
		
	}	
		return curso;
	}
	   

	public SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura(){
		
		
		
		SortedMap<Asignatura, Calificacion> res = new TreeMap<Asignatura, Calificacion>();
		
		for(Nota n : getExpediente().getNotas()){

			actualizaCalificacionPorAsignatura(res,n);			
			}
	return res;
	}


	
	private void actualizaCalificacionPorAsignatura(
			SortedMap<Asignatura, Calificacion> m, Nota n) {
		
		Calificacion c = m.get(n.getAsignatura());
		if(c == null || c.compareTo(n.getCalificacion())<0){
			m.put(n.getAsignatura(),n.getCalificacion());
		}
		
		
	}

	//TODO:Boletin 12
	public SortedSet<Asignatura> getAsignaturasOrdenadasPorCurso(){
		
	
		Comparator<Asignatura> ordenaPorCurso = (x,y) -> x.getCurso().compareTo(y.getCurso());
		
		SortedSet<Asignatura> res = new TreeSet<Asignatura>(ordenaPorCurso.reversed().thenComparing(Comparator.naturalOrder()));
		
		res.addAll(asignaturas);
		
		return res;
	}


	
	

	/******************************EL TOSTRING*************************************/
	
	public String toString(){
	
		return "(" +  getCurso() +"º" +")"  + " "  + super.toString() ;
		
		
		
	}
	
	
	/*******************************MÉTODOS PRIVADOS*****************************************/
	
 public void matriculaAsignatura(Asignatura cualquiera){
		
		if(estaMatriculadoEn(cualquiera)==true){
			
			throw new ExcepcionAlumnoOperacionNoPermitida("Ya tienes esa asignatura escogida");
		
		}else{
	  
		asignaturas.add(cualquiera);
		
		}
		
		
	}
	
  public void eliminaAsignatura(Asignatura primera){
	   
	   if(estaMatriculadoEn(primera)== false){
		 
		   throw new ExcepcionAlumnoOperacionNoPermitida("No puedes eliminar una asignatura que no tienes");
		   
	   }else{
		   
		   asignaturas.remove(primera);
	   }

   }
	
	
  public Boolean estaMatriculadoEn(Asignatura cualquiera){
	  
	  Boolean resultado= false;
	  
	   if(asignaturas.contains(cualquiera)){
		   resultado = true;
	   
	   }
	    
	   return resultado;
   }
   
   
   private void CheckEmails(String email){
	   
	  String contener = "@alum.us.es" ;
	   
	if(!email.endsWith(contener) ){
		 
		   
		   throw new ExcepcionAlumnoNoValido("El correo tiene que tener @alum.us.es al final ");
		   
	   }
	   
   
	   
   }


   public void evaluaAlumno(Asignatura a, Integer curso,
		Convocatoria convocatoria, Double nota, Boolean mencionHonor) {
	   
	   
		if(!estaMatriculadoEn(a)){
			
			throw new ExcepcionAlumnoOperacionNoPermitida("El alumno no está matriculado en la asignatura");
			
		}else{
			
		Nota nueva = new NotaImpl(a,curso,convocatoria,nota,mencionHonor);	
			
		expediente.nuevaNota(nueva);
			
	   }
}


   public void evaluaAlumno(Asignatura a, Integer curso,
		Convocatoria convocatoria, Double nota) {
	
	 evaluaAlumno(a,curso,convocatoria,nota,false);
		   
			/*if(!estaMatriculadoEn(a)){
				
				throw new ExcepcionAlumnoOperacionNoPermitida("El alumno no está matriculado en la asignatura");
				
			}else{
				
			Nota nueva = new NotaImpl(a,curso,convocatoria,nota);	
				
			expediente.nuevaNota(nueva);
			
			
			      }*/
	     
	
}





  
   
	
	
}
