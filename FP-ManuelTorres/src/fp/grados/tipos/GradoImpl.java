package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;

import fp.grados.excepciones.ExcepcionGradoNoValido;

public class GradoImpl implements Grado {
	
	/*************************************ATRIBUTOS*****************************************/
	
	private String nombre;
	private Double minCreditos;
	private Set<Asignatura> asignaturasOptativas;
	private Set<Asignatura> asignaturasObligatorias;

	
	/*************************************CONSTRUCTOR***************************************************/
	
	public GradoImpl(String nom,Set<Asignatura> asiob,Set<Asignatura> asiop,Double cre){

		checkAsignaturasCreditos(asiop);
		checkCreditos(cre,asiop);
		
		nombre = nom;
		minCreditos = cre;
		asignaturasObligatorias = asiob;
		asignaturasOptativas = asiop;
		
		
		
	}


	
	/******************************************MÉTODOS**********************************/

	
	public String getNombre() {
		
		return nombre;
	}


	
	public Double getNumeroMinimoCreditosOptativas() {
		
		return minCreditos;
	}


	
	public Set<Asignatura> getAsignaturasObligatorias() {
		
		return new HashSet<Asignatura>(asignaturasObligatorias);
	}


	
	public Set<Asignatura> getAsignaturasOptativas() {

		return new HashSet<Asignatura>(asignaturasOptativas);
	}


	public Double getNumeroTotalCreditos() {
	
		Double suma = 0.0;
		for(Asignatura a: asignaturasObligatorias){
			
			suma += a.getCreditos();
			
			
		}
		
		return suma + minCreditos;
		
	}


	public Set<Departamento> getDepartamentos() {
	
		return aplanarAsignaturas(asignaturasOptativas,asignaturasObligatorias);
	}


	public Set<Profesor> getProfesores() {

		return aplanarProfesores(getDepartamentos());

	}
	
	public Set<Asignatura> getAsignaturas(Integer curso) {
		
		Set<Asignatura> contenedor = new HashSet<Asignatura>();
        Set<Asignatura> conjunto = new HashSet<Asignatura>(asignaturasObligatorias);
		conjunto.addAll(asignaturasOptativas);
	
	for(Asignatura a: conjunto){
		
		if(a.getCurso().equals(curso)){
		
			contenedor.add(a);
		}
			}			
		return contenedor;
		
	}



	public Asignatura getAsignatura(String codigo) {
		
		Asignatura devolver = null;
		Set<Asignatura> conjunto = new HashSet<Asignatura>();
		conjunto.addAll(asignaturasObligatorias);
		conjunto.addAll(asignaturasOptativas);
		
		for(Asignatura a: conjunto){
			
			if(a.getCodigo().equals(codigo)){
				
				devolver = a ;break;
				
			}
			
		}
		
		return devolver;
	}
	
	
   public SortedMap<Asignatura, Double> getCreditosPorAsignatura() { 
		
	   SortedMap<Asignatura, Double> res = new TreeMap<Asignatura, Double>();
	   Set<Asignatura> completas = new HashSet<Asignatura>(asignaturasObligatorias);
	   completas.addAll(asignaturasOptativas);
		
	   for(Asignatura a : completas){
		   
		   res.put(a, a.getCreditos());
		   
		   
	   }
	   
	   
		return res;
		
	}
	
   //TODO: Boletin 12
	
   public SortedSet<Departamento> getDepartamentosOrdenadosPorAsignaturas(){
	   
	  Comparator<Departamento> OrdenaDep = Comparator.comparing(x -> x.getAsignaturas().size());
	  
	  SortedSet<Departamento> res = new TreeSet<Departamento>(OrdenaDep.reversed().thenComparing(Comparator.naturalOrder()));
	   
	  res.addAll(getDepartamentos());
	
	   

	   return res;
   }
	
	
	
	
	
	
	
	
	/*****************************************EQUALS***************************************/
	
	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Grado){
			Grado g = (Grado)o;
			if(this.getNombre().equals(g.getNombre())){
				res = true;
			}
		}
		return res;
	}
	
	
	/**************************************HASHCODE*******************************************/
	
	public int hashCode(){
		
		return this.getNombre().hashCode();
		
	}
	
	
	/**********************************COMPARETO************************************/
	
	
	public int compareTo(Grado g){
	
		int res = this.getNombre().compareTo(g.getNombre());
		return res;
		
	}
	
	/************************************TOSTRING*********************************/
	
	public String toString(){
		
	return this.getNombre();	
		
		
	}
	
	
	/************************************RESTRICCIONES*****************************/
	
	private void checkAsignaturasCreditos(Set<Asignatura> conjunto){
		
		Double comparador = 0.0;
		Boolean esPrimero = true;
		
		for(Asignatura a:conjunto){
			
			if(esPrimero ){
				comparador = a.getCreditos();
				esPrimero = false;
				
			}
			
			if(!a.getCreditos().equals(comparador)){
				
				throw new ExcepcionGradoNoValido("Todas las asignaturas optativas deben de tener el mismo número de créditos");
			}	
			
		}
		
	}
	
	
	
	private void checkCreditos(Double creditos,Set<Asignatura>op){
		
		Double comparador = 0.0;
		
		for(Asignatura a : op){
	
			comparador += a.getCreditos();
		}
		
		if(creditos.compareTo(0.0)<0.0 || creditos.compareTo(comparador)>0.0){
			
			throw new ExcepcionGradoNoValido("El número mínimo de créditos de asignaturas"
				+ " optativas que debe cursar un alumno debe estar comprendido"
				+ " entre cero y el número total de créditos de asignaturas optativas del grado");
		
		}
	}
	
	
	/************************************MÉTODOS PRIVADOS***************************************/
	
	private Set<Departamento> aplanarAsignaturas(Set<Asignatura> s1,Set<Asignatura>s2){
		
		Set<Departamento> conjunto = new HashSet<Departamento>();
		Set<Asignatura> asignaturas = new HashSet<Asignatura>(s1);
		asignaturas.addAll(s2);
			
	for(Asignatura a:asignaturas){	
		
		conjunto.add(a.getDepartamento());
			
		}
		
		return conjunto;
		
	}
	
	private Set<Profesor> aplanarProfesores(Set<Departamento> dept){
		
	Set<Profesor> prof = new HashSet<Profesor>();
	for(Departamento p: dept){
		
		
	prof.addAll(p.getProfesores());	
		
		
	}
		
		
		return prof;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
