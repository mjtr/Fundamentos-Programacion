package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;

public class ProfesorImpl2 extends PersonaImpl implements Profesor {

	/*************************ATRIBUTOS**************************************/
	
	private Categoria categoria;
	private SortedSet<Tutoria> tutoria;
	private Departamento dep;
	private Map<Asignatura,Double> conjunto;
	private static final Double CREDITOMAX= 24.0;
	
	/*******************************CONSTRUCOR**********************************/
	
	public ProfesorImpl2(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
			String email,Categoria categoria,Departamento dep){
		
		
		super(dni,nombre,apellidos,fechanacimiento,email);
		
		CheckEdad(fechanacimiento);
		
		
		this.categoria = categoria;
	    tutoria = new TreeSet<Tutoria>();
	    setDepartamento(dep);
	    
	 conjunto = new HashMap<Asignatura,Double>();
  
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
	
	for(Double cre : getCreditos()){
		
		suma += cre;	
	}
		
	checkCreditosTotalesProfesor(getCreditos());
	
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
		
		
		 
		 return new ArrayList<Asignatura>(conjunto.keySet());
		 
		
		//return new ArrayList<Asignatura>(asignaturas(conjunto));
	}

	public List<Double> getCreditos() {
		
		return new ArrayList<Double>(conjunto.values());
		//return new ArrayList<Double>(creditos(conjunto));
	}
	
	/*public void imparteAsignatura(Asignatura asig, Double dedicacion) {
		
			
		CheckAsignaturaDepartamento(asig);
		checkCreditosAsignatura(asig,dedicacion);
		
		if(asignaturas(conjunto).contains(asig)){
			
			actualizaDedicacion(asig,dedicacion);
		
		}else {
			nuevaAsignatura(asig,dedicacion);
		
		}
	
	*/
		

		 
		  	public void imparteAsignatura(Asignatura asig, Double dedicacion) {
		
			
		CheckAsignaturaDepartamento(asig);
		checkCreditosAsignatura(asig,dedicacion);
		
		if(conjunto.containsKey(asig)){
			
			actualizaDedicacion(asig,dedicacion);
		
		}else {
			
			nuevaAsignatura(asig,dedicacion);
		
		}
		
		}
	
		private void checkDedicacion(Double dedicacion){
		
		if(getDedicacionTotal() + dedicacion > CREDITOMAX)
		throw new ExcepcionProfesorOperacionNoPermitida();
		
		
		}
		
		
		private void nuevaAsignatura(Asignatura asig, Double creditosNuevos) {
	
      checkDedicacion(creditosNuevos);
      conjunto.put(asig,creditosNuevos);
	 checkCreditosTotalesProfesor(getCreditos());
		
	}

		
	private void actualizaDedicacion(Asignatura asig, Double creditosNuevos) {
		
     Double creditosAntes = conjunto.get(asig);
		checkDedicacion(creditosNuevos - creditosAntes);
		conjunto.put(asig,creditosNuevos);
		
		
	}


     public void eliminaAsignatura(Asignatura asig) {

		conjunto.remove(asig);
			
			}	
		
		
	public Double dedicacionAsignatura(Asignatura asig) {
		
		Double r = conjunto.get(asig);
		
		
		if(r== null){
			
			r = 0.0;
		}
		
		return r;
		
	}
		 
		
		
		
	
/*
	private void nuevaAsignatura(Asignatura asig, Double dedicacion) {
	
        asignaturas(conjunto).add(asig);
		creditos(conjunto).add(dedicacion);
		checkCreditosTotalesProfesor(creditos(conjunto));
		
	}




	private void actualizaDedicacion(Asignatura asig, Double dedicacion) {
		
     Integer IndiceAsignatura = asignaturas(conjunto).indexOf(asig);
		
		creditos(conjunto).set(IndiceAsignatura,dedicacion);
		
		
	}


*/

	private void checkCreditosAsignatura(Asignatura asig, Double dedicacion) {
		if(asig.getCreditos() < dedicacion || dedicacion <= 0){
			throw new ExcepcionProfesorOperacionNoPermitida("La dedicación no puede ser mayor que el número de créditos de la asignatura ni tampoco puede ser 0");
		}
		
	}



/*
	public Double dedicacionAsignatura(Asignatura asig) {
		
		Double r = 0.0;
		
		Integer pos = asignaturas(conjunto).indexOf(asig);
		if(pos!=-1){
			
			r = creditos(conjunto).get(pos);
		}
		
		return r;
		
	}


	public void eliminaAsignatura(Asignatura asig) {

		int pos = asignaturas(conjunto).indexOf(asig);	
			if(pos!=-1){
				creditos(conjunto).remove(pos);
				asignaturas(conjunto).remove(asig);
			}	
		
		
	}

	*/
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


    private void checkCreditosTotalesProfesor(List<Double> creditos){
    	
    	Double suma = 0.0;  
    	
    	for(int i= 0; i < creditos.size();i++){
    		
    		suma += creditos.get(i);  		
    	}
    		
    	if(suma > CREDITOMAX){
    		
    		throw new ExcepcionProfesorOperacionNoPermitida("El profesor no puede impartir más de 24 créditos");
	
    	}
    	
    }

/*
	private List<Asignatura> asignaturas(Map<Asignatura,Double> conjunto){
		
		List<Asignatura> res = new ArrayList<Asignatura>(conjunto.keySet());
		
		return res;
	}


   private List<Double> creditos (Map<Asignatura,Double> conjunto){
		
		List<Double> res = new ArrayList<Double>(conjunto.values());

		return res;
	}
	
	*/
}
