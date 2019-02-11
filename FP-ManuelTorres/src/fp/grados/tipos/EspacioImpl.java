package fp.grados.tipos;


import fp.grados.excepciones.ExcepcionEspacioNoValido;

public class EspacioImpl implements Espacio{
	
	   /*************************************ATRIBUTOS**************************************/

	
	private TipoEspacio tipo;
	private String nombre;
	private Integer capacidad, planta;
	
	/******************************CONSTRUCTORES:**********************************************/	
	
	public EspacioImpl(TipoEspacio tipo,String nombre,Integer capacidad,Integer planta){
		
		CheckCapacidad(capacidad);
		
		
		this.tipo = tipo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
				
		
	}
	
	
	public EspacioImpl(String s){
		
		//	“A0.10,0,100,TEORIA”
		
		String [] res = s.split(",");
		
		if(res.length != 4){
			
			throw new IllegalArgumentException("Cadena introducida incorrecta");
		}
		
		
		nombre = res[0].trim();
		planta = new Integer(res[1].trim());
		Integer cap = new Integer(res[2].trim());
		CheckCapacidad(cap);
		
		capacidad = cap;
		tipo = TipoEspacio.valueOf(res[3].trim());
		
		
	}
	
	
	/************************************MÉTODOS*****************************************/
	
	public TipoEspacio getTipo(){
		return tipo;
		}
	
	public String getNombre(){
		return nombre;
		}
	
	public Integer getCapacidad(){
		return capacidad;
		}
	
	public Integer getPlanta(){
		return planta;
		}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
		}
	
	public void setCapacidad(Integer capacidad){
		CheckCapacidad(capacidad);
		
		this.capacidad = capacidad;
		}
	
	public void setTipo(TipoEspacio tipo){
		this.tipo = tipo;
		}
	
	
	/***********************************EQUALS******************************/
	
	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Espacio  ){
			Espacio e = (Espacio) o;
			if(this.getNombre().equals(e.getNombre())&& this.getPlanta().equals(e.getPlanta())){
				res = true;
		}}
		return res;
	}
	
  
	/********************************HASHCODE*************************************/ 
	
	public int hashCode(){
		return this.getNombre().hashCode() + this.getPlanta().hashCode()*31;
	}
	
	
	
	
    /**********************************COMPARETO***************************************/
	
	public int compareTo(Espacio e){
		int res = this.getPlanta().compareTo(e.getPlanta());
		if(res == 0){
			
			res = this.getNombre().compareTo(e.getNombre());
		}
		
		return res;
	}
	
	
	
	/**************************************MÉTODO TOSTRING**********************************/
	
	public String toString(){
		return getNombre() +"("+ "planta " + getPlanta() + ")";
	}
	
	
	
	/************************************MÉTODOS PRIVADOS*******************************************/
	
	
	private static void CheckCapacidad(Integer capacidad){
		
		if(capacidad.compareTo(0)<=0){
			throw new ExcepcionEspacioNoValido("La capacidad no puede ser menor o igual que cero");
			
		}
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
