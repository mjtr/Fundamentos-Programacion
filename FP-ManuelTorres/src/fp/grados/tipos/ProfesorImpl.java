package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;

public class ProfesorImpl extends PersonaImpl implements Profesor {

	/*************************ATRIBUTOS**************************************/
	
	private Categoria categoria;
	private SortedSet<Tutoria> tutoria;
	private Departamento dep;
	private List<Asignatura> asignaturas;
	private List<Double> creditos;
	private static final Double CREDITOMAX= 24.0;
	
	/*******************************CONSTRUCOR**********************************/
	
	public ProfesorImpl(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
			String email,Categoria categoria,Departamento dep){
		
		
		super(dni,nombre,apellidos,fechanacimiento,email);
		
		CheckEdad(fechanacimiento);
		
		
		this.categoria = categoria;
	    tutoria = new TreeSet<Tutoria>();
	    setDepartamento(dep);
	    
	    asignaturas = new LinkedList<Asignatura>();
	    creditos = new LinkedList<Double>();
  
	}
	

	
	
	/***********************************MÉTODOS******************************/
	
	public Categoria getCategoria(){
		return this.categoria;
	}
	
	
	public SortedSet<Tutoria> getTutorias(){
		return this.tutoria;
	}
	
	
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
	}
	


	public Departamento getDepartamento() {

		return dep;
	}

	
	public Double getDedicacionTotal() {
		
	Double suma = 0.0;
	for(int i = 0;i<creditos.size();i++){
		
		suma += creditos.get(i);	
	}
		
	checkCreditosTotalesProfesor(creditos);
	
	return suma;
	}


	public void setDepartamento(Departamento nuevoProfDep) {
		
		if(nuevoProfDep!=this.dep){
    		 
	    		Departamento antiguoProfDep = this.dep;
	    		this.dep = nuevoProfDep;
	    	
	    	if(antiguoProfDep != null){
	    		
	    		antiguoProfDep.eliminaProfesor(this);
	    	}
	    		if(nuevoProfDep != null){
	    			nuevoProfDep.nuevoProfesor(this);
	    		}
	    		 
	    	 }
		
	}
	
	
	public List<Asignatura> getAsignaturas() {
		
		return new ArrayList<Asignatura>(asignaturas);
	}

	public List<Double> getCreditos() {
		
		return new ArrayList<Double>(creditos);
	}
	
	public void imparteAsignatura(Asignatura asig, Double dedicacion) {
		
			
		CheckAsignaturaDepartamento(asig);
		checkCreditosAsignatura(asig,dedicacion);
		
		if(asignaturas.contains(asig)){
			
			actualizaDedicacion(asig,dedicacion);
		
		}else {
			nuevaAsignatura(asig,dedicacion);
		
		}
	
		
		
		
	}

	private void nuevaAsignatura(Asignatura asig, Double dedicacion) {
	
        asignaturas.add(asig);
		creditos.add(dedicacion);
		checkCreditosTotalesProfesor(creditos);
		
	}




	private void actualizaDedicacion(Asignatura asig, Double dedicacion) {
		
     Integer IndiceAsignatura = asignaturas.indexOf(asig);
		
		creditos.set(IndiceAsignatura,dedicacion);
		
		
	}




	private void checkCreditosAsignatura(Asignatura asig, Double dedicacion) {
		if(asig.getCreditos() < dedicacion || dedicacion <= 0){
			throw new ExcepcionProfesorOperacionNoPermitida("La dedicación no puede ser mayor que el número de créditos de la asignatura ni tampoco puede ser 0");
		}
		
	}




	public Double dedicacionAsignatura(Asignatura asig) {
		
		Double r = 0.0;
		
		Integer pos = asignaturas.indexOf(asig);
		if(pos!=-1){
			
			r = creditos.get(pos);
		}
		
		return r;
		
	}


	public void eliminaAsignatura(Asignatura asig) {

		int pos = asignaturas.indexOf(asig);	
			if(pos!=-1){
				creditos.remove(pos);
				asignaturas.remove(asig);
			}	
		
		
	}

	
	/***********************************EL TOSTRING*****************************/
	
	
	public String toString(){
		
	return super.toString() + "(" + this.getCategoria() + ")";	
		
		
	}
	
		
	/************************************MÉTODOS PRIVADOS**************************/
	
	public void setFechaNacimiento(LocalDate fechanacimiento){
		
		
		super.setFechaNacimiento(fechanacimiento);
		CheckEdad(fechanacimiento);
	}
	
	
	private void CheckEdad(LocalDate fecha){
		
		if(this.getEdad().compareTo(18)< 0){
			throw new ExcepcionProfesorNoValido("El profesor no puede tener menos de 18 años");
		}
		}
	
	
	
	
	public void nuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia){
		
		tutoria.add(new TutoriaImpl(dia,horaComienzo,duracionMinutos));
			
	}
	

	
	
   public void borraTutoria(LocalTime horaComienzo, DayOfWeek dia){
	   
    for(Tutoria indicada: tutoria){
    	
    	
    	if(indicada.getHoraComienzo().equals(horaComienzo) && indicada.getDiaSemana().equals(dia) ){
    	
    		tutoria.remove(indicada);break;
    		
    	}    	
    	  }
   
	}
	

	
	public void borraTutorias(){
		
		tutoria.clear();
		
		
	}

	public void CheckAsignaturaDepartamento(Asignatura cualquiera){
		
		if(getDepartamento()==null || !this.getDepartamento().getAsignaturas().contains(cualquiera)){
			
			throw new ExcepcionProfesorOperacionNoPermitida("El profesor no puede impartir una asignatura de otro departamento");
		}
	
		
	}
	
	
	private void checkCreditosTotalesProfesor(List <Double> d){
    	
    	Double suma = 0.0;
    	
    	for(int i = 0;i< d.size();i++){
    		
    		suma += d.get(i);		
    		
    	}
    		
    	if(suma > CREDITOMAX){
    		
    		throw new ExcepcionProfesorOperacionNoPermitida("El profesor no puede impartir más de 24 créditos");
		
    	}
    		
    }

	


	




	
	
}
