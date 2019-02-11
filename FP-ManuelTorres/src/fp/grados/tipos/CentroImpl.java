package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;

public class CentroImpl implements Centro{
	
	/****************************ATRIBUTOS*********************************/
	
	private String nombre,direccion;
	private Integer NumeroPlantas,NumeroSotanos;
	private Set<Espacio> espacios;
	
	
	/*************************CONTRUCTOR********************************/
	
	
	
	public CentroImpl(String nombre,String direccion,Integer NumeroPlantas,Integer NumeroSotanos){
		
		CheckPlantas(NumeroPlantas);
		CheckSotanos(NumeroSotanos);
		
	this.nombre = nombre;
	this.direccion = direccion;
	this.NumeroPlantas = NumeroPlantas;
	this.NumeroSotanos = NumeroSotanos;
	
	espacios = new HashSet<Espacio>();

	
	}
	
	/******************************************MÉTODOS***************************************/
	
	public String getNombre(){
		return this.nombre;
	}

	
	public String getDireccion() {
		
		return this.direccion;
	}

	
	public Integer getNumeroPlantas() {
		
		return NumeroPlantas;
	}

	
	public Integer getNumeroSotanos() {
		
		return NumeroSotanos;
	}

	
	public Set<Espacio> getEspacios() {
		
		return new HashSet<Espacio>(espacios);
	}

	
	public void nuevoEspacio(Espacio e) {
	
	
		
		if(e.getPlanta().compareTo(getNumeroPlantas()-1)>0 || e.getPlanta().compareTo(-getNumeroSotanos())< 0){
		
		throw new ExcepcionCentroOperacionNoPermitida("La planta del espacio introducido es incorrecto");
		
	}else {
		espacios.add(e);
	}
		
		
		
	}


	public void eliminaEspacio(Espacio e) {
	
		for(Espacio s: espacios){
			
		if(s.equals(e)){
			
			espacios.remove(s);break;
		}
	}
		
		
	}
	
	
	public  Integer[] getConteosEspacios() {
	
	  Integer[] res = {0,0,0,0,0};
	  
	  for(Espacio e : this.getEspacios()){
	  
	  switch(e.getTipo()){
	 
	  case TEORIA:  
		  res[0]++;break;
	  
	  case LABORATORIO: 
		  res[1]++;break;
	  
	  case SEMINARIO:
		  res[2]++;break;
	  
	  case EXAMEN:
		  res[3]++;break;
	  
	  case OTRO:
		  res[4]++;break;
	 
	  
	  } 
	  }
		
	return res;	
					
	}

	
	public Set<Despacho> getDespachos() {
	
		
		
		Set<Despacho> conjunto = new HashSet<Despacho>();
		
		for(Espacio a: getEspacios()){
			
			
			if(a instanceof Despacho ){
				
	    conjunto.add( (Despacho)a);
					
			}
		}
		
		return conjunto;
	}


	public Set<Despacho> getDespachos(Departamento d) {
		
		Set<Despacho> conjunto = new HashSet<Despacho>();
	
		for(Despacho a : getDespachos()){
			
			  if(existeProfesorDepartamento(a.getProfesores(),d)){
			  
				  conjunto.add(a);
			 
			}
			
		}
		
		return conjunto;
		
	}

	//TODO:Boletin 12
	
	public SortedSet<Espacio> getEspaciosOrdenadosPorCapacidad(){
		
		Comparator <Espacio> OrdenaPorCapacidad = Comparator.comparing(Espacio :: getCapacidad);
		SortedSet<Espacio> res = new TreeSet<Espacio>(OrdenaPorCapacidad.reversed().thenComparing(Comparator.naturalOrder()));
		
		res.addAll(getEspacios());
		
		
		return res ;
		
		
	}
	
	
	public Set<Profesor> getProfesores() {
		
		Set<Profesor> res = new HashSet<Profesor>();
		for(Despacho d : this.getDespachos()){
			
			res.addAll(d.getProfesores());
			
			
		}
		
		
		return res;
		
	}

	
	public Set<Profesor> getProfesores(Departamento d) {
		Set<Profesor> res = new HashSet<Profesor>();
		
		for(Profesor p : this.getProfesores()){
			
			if(p.getDepartamento().equals(d))
			
				res.add(p);
			
		}
		
		
		return res;
	
	}

	public Espacio getEspacioMayorCapacidad() {
	
		Espacio a = null;
		Boolean esPrimero = true;
		
		for(Espacio s : getEspacios()){
			
		if(esPrimero){
			
			a = s;
			esPrimero = false;
		}	else if (a.getCapacidad().compareTo(s.getCapacidad())<0){
		
			a = s;
			
		}
			
			}
		
     if(a == null ){
			
			throw new  ExcepcionCentroOperacionNoPermitida("El centro no tiene ningún espacio");
			
		}
		
		return a;
		
		
	}
	
	/*************************************EQUALS***********************************/
	
	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Centro){	
		Centro centro = (Centro)o;
		
		if(this.getNombre().equals(centro.getNombre())){
			res = true;
		}
		}
		return res;
	}
	
	/**************************************HASHCODE*****************************************/
	
	
	public int hashCode(){
		
		return this.getNombre().hashCode();
		
	}
	
	
	
	/************************************COMPARETO******************************************/
	
	public int compareTo(Centro d){
		
		int res = getNombre().compareTo(d.getNombre());
		
		return res;
	}
	
	
	/***********************************TOSTRING************************************/
	
	public String toString(){
		
		return getNombre();
		
	}
	
	
	/******************************METODOS PRIVADOS***************************************/

	
	private void CheckPlantas(Integer numeroDePlantas){
		
		if(numeroDePlantas.compareTo(1)<0){
			
			throw new ExcepcionCentroNoValido("El número de plantas tiene que ser mayor o igual que uno");
			
		}
		
	}

	private void CheckSotanos(Integer sota){
		
		if(sota.compareTo(0)<0){
			
			throw new ExcepcionCentroNoValido("El número de sótanos tiene que ser mayor o igual que cero");
		}
	}

	
	private Boolean existeProfesorDepartamento(Set<Profesor> prof , Departamento dep){
		
		Boolean res = false;
		for(Profesor p : prof){
			
			if(p.getDepartamento().equals(dep)){
				res = true;break;
			}
		}
		
		return res;
		
		
	}

	
	public SortedMap<Profesor, Despacho> getDespachosPorProfesor() {

		SortedMap<Profesor,Despacho> conjunto = new TreeMap<Profesor,Despacho>();
		
		for(Despacho d : getDespachos()){
		
		    actualizaDespachoProfesor(conjunto,d);
		
	}
			
		return conjunto;
	
	
	}
	
	  
	  private void actualizaDespachoProfesor(SortedMap<Profesor,Despacho>m , Despacho d){
	  
	  for(Profesor p : getProfesores()){
	  m.put(p,d);
	  
	   }
	  
	
	

	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
