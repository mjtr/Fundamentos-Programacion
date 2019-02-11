package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;


import fp.grados.excepciones.ExcepcionDespachoNoValido;

public class DespachoImpl extends EspacioImpl implements Despacho{
	
	
	/********************************ATRIBUTOS*********************************/
	
	private Set<Profesor> profesor;

	
	
	/*******************************CONSTRUCTORES***************************************/
	
	
	public DespachoImpl(String nombre,Integer capacidad,Integer planta,Set<Profesor> profesor){
		
		
		super(TipoEspacio.OTRO,nombre,capacidad,planta);
		
		CheckCapacidadDespacho(profesor,capacidad);
		
		
		this.profesor = profesor;
		
		
	}
	
    public DespachoImpl(String nombre,Integer capacidad,Integer planta,Profesor profe){
		
		super(TipoEspacio.OTRO,nombre,capacidad,planta);

		
		profesor = new HashSet<Profesor>();
		
		profesor.add(profe);
	
		
	}
	
	
    public DespachoImpl(String nombre,Integer capacidad,Integer planta){
	
	super(TipoEspacio.OTRO,nombre,capacidad,planta);
	
	
   this.profesor = new HashSet<Profesor>();
	
	
}

    
   
    public DespachoImpl(String cadena) { 
    	
    	//“F1.43,1,3”
    	
    	super(cadena + ",OTRO"); 	
    	profesor = new HashSet<Profesor>();
    	
   }
    
    
    
    
    
    
	/*******************************MÉTODOS**********************************/
	
	public Set<Profesor> getProfesores(){
		return new HashSet<Profesor>(profesor);
	}
	
	
	public void setProfesores(Set<Profesor> profesor){
		CheckCapacidadDespacho(profesor,getCapacidad());
		this.profesor = profesor;
		
	}
	
          
	public void setTipo(TipoEspacio s){

		CheckEspacio(s);
		super.setTipo(s);
	}

	
	/********************************TOSTRING**************************************/
    
    public String toString(){
    	
    return super.toString() + profesor.toString();	
    	
    }
	
	
	
	
	/**********************************MÉTODOS PRIVADOS********************************************/
    
    
    private void CheckCapacidadDespacho(Set<Profesor> profe,Integer capacidad){
    	
    Integer s = profe.size();
    
    if(s.compareTo(capacidad) > 0){
    	
    	throw new ExcepcionDespachoNoValido("El número de profesores no puede ser mayor que la capacidad del despacho");
    	
    }
	
	
	
    }
	private void CheckEspacio(TipoEspacio tipo){
	
		throw new UnsupportedOperationException("El despacho tiene que ser de tipo espacio OTRO");
	
		
	}
	
	

}
