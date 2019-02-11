package fp.grados.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;

public class DepartamentoImpl implements Departamento{

	
	/***********************************ATRIBUTOS******************************/
	
	private String nombre;
	private Set<Asignatura> asignaturas;
	private Set<Profesor> profesores;
	
	/**************************CONTRUCTORES*************************************/
	
	public DepartamentoImpl(String nombre){
		
		this.nombre = nombre;
		asignaturas = new HashSet<Asignatura>();
		profesores = new HashSet<Profesor>();
		
	}

	/*******************************************MÉTODOS************************************/
	
	
	
	
	public String getNombre() {
	
		return nombre;
	}

	
	public Set<Asignatura> getAsignaturas() {
		
		//Se realiza una copia de asignaturas
		
		return new HashSet<Asignatura>(asignaturas);
	}


	public Set<Profesor> getProfesores() {
		
		Set<Profesor> copy = new HashSet<Profesor>(profesores);
		
		
		return copy;
	}

	
	public void nuevaAsignatura(Asignatura asig) {

		
		asignaturas.add(asig);
		asig.setDepartamento(this);
		
		
	}

	
	public void eliminaAsignatura(Asignatura asig) {
		
		
	
				asignaturas.remove(asig);
				asig.setDepartamento(null);
			
				
	}


	public void nuevoProfesor(Profesor prof) {
	
		profesores.add(prof);
		prof.setDepartamento(this);
	}


	public void eliminaProfesor(Profesor prof) {
		
			profesores.remove(prof);
			prof.setDepartamento(null);
			
		}
	
	

	
	public void borraTutorias() {
		
		
	for(Profesor p: profesores){
	
		p.borraTutorias();;
		
	}
	
		
		
	}

	
	public void borraTutorias(Categoria c) {
	
		
		for(Profesor p : this.getProfesores()){
			
			if(p.getCategoria().equals(c)){
				p.borraTutorias();
			}
			
		}
		
		
	}

	
	public Boolean existeProfesorAsignado(Asignatura a) {
		Boolean res = false;
		
		for(Profesor p: profesores){
			
			if(p.getAsignaturas().contains(a)){
				res = true;break;
			}
			
		}
		
		
		return res;
	}

	
	public Boolean estanTodasAsignaturasAsignadas() {
		
		Boolean res = true;
		
		for(Asignatura a : getAsignaturas()){
			
			for(Profesor p: getProfesores()){
				
				if(!p.getAsignaturas().contains(a)){
					
					res = false;
				}	
			}	
		}
		return res;
	}
	
	
	
	
	
	public void eliminaAsignacionProfesorado(Asignatura a) {
		
		for(Profesor p: getProfesores()){
		if(	p.dedicacionAsignatura(a)>0){
			p.eliminaAsignatura(a);
		}
			
		}
	
		
	}
	
	
	
	

	public	SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura(){
	
	
	SortedMap<Asignatura, SortedSet<Profesor>> res = new TreeMap<Asignatura, SortedSet<Profesor>>();
	
	for(Profesor p : getProfesores()){
		
		
		actualizaProfesoresAsignatura(res,p);
		
			
		}
	return res;
	}
	
	


    private void actualizaProfesoresAsignatura(
		SortedMap<Asignatura, SortedSet<Profesor>> m, Profesor p) {
    	
    	for(Asignatura a : p.getAsignaturas()){
    		
    		SortedSet<Profesor> sp = m.get(a);
    		if(sp == null){
    			
    			sp = new TreeSet<Profesor>();
    		}
    		
    		sp.add(p);
    		m.put(a, sp);
    	}
    	
    	
    	
	
}

    //TODO:REVISAR ESTE MÉTEDO ANTES DE ENVIARLO
	public SortedMap<Profesor, SortedSet<Tutoria>> getTutoriasPorProfesor(){
	
    	 SortedMap<Profesor, SortedSet<Tutoria>> conj = new TreeMap<Profesor, SortedSet<Tutoria>>();
    	 
    	 for(Profesor p : getProfesores()){
    		 
    	  conj.put(p,p.getTutorias());
    	 
    	 }
	

    	 return conj;
    }


	//TODO:Boletin 12
	
	public Profesor getProfesorMaximaDedicacionMediaPorAsignatura(){
		
	Comparator< Profesor> OrdenaPorDedicacion = Comparator.comparing(profe -> profe.getDedicacionTotal()/profe.getAsignaturas().size());
	Predicate<Profesor> predicado = profe -> !profe.getAsignaturas().isEmpty();	
		
		return	getProfesores().stream().filter(predicado)
			.max(OrdenaPorDedicacion).orElseThrow(NoSuchElementException :: new );
		
		
	}


	
	
/************************************EQUALS************************************/
	
	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Departamento){
			Departamento dep = (Departamento)o;
			
			if(this.getNombre().equals(dep.getNombre())){
				res = true;
			}
		}
		
		return res;
		
		
	}
	
	
	/*************************HASHCODE*******************************************************/
	
	public int hashCode(){
		
		return this.getNombre().hashCode();
		
	}
	
	/********************************COMPARETO*******************************************/
	
	
	public int compareTo(Departamento dep){
		
		int res = this.getNombre().compareTo(dep.getNombre());
		return res;
	}
	

	/*******************************************TOSTRING********************************/
	
	
	
	public String toString(){
		
		return getNombre();
		
	}

	
	
	
}
