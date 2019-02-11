 package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;

public class AsignaturaImpl implements Asignatura {
	
   /*************************************ATRIBUTOS**************************************/
	
	
	private String nombre,codigo;
	private Double creditos;
	private TipoAsignatura  tipo;
	private Integer curso;
	private Departamento dep;
	
	
	
	
	/******************************CONSTRUCTORES:**********************************************/	
	
	
	
	public AsignaturaImpl(String nombre,String codigo,Double creditos,TipoAsignatura tipo
	,Integer curso,Departamento dep){
	
		CheckCodigo(codigo);
		CheckCreditos(creditos);
		CheckCurso(curso);
		
	this.nombre	= nombre;
    this.codigo = codigo;
    this.creditos = creditos;
    this.tipo = tipo;
	this.curso	 = curso;
    setDepartamento(dep);
	
	
	}

	public AsignaturaImpl(String s){
		
		
		String [] res = s.split("#");
		
		if(res.length != 5){
			throw new IllegalArgumentException("Cadena introducida incorrecta");
		}
		
		
		String cod = res[1].trim();
		Double cred = new Double(res[2].trim());
		Integer cur  = new Integer(res[4].trim());
		
		CheckCodigo(cod);
		CheckCreditos(cred);
		CheckCurso(cur);
		
		
		nombre = res[0].trim();
		codigo = cod;
		creditos = cred;
		tipo = TipoAsignatura.valueOf(res[3].trim());
		curso  = cur;
		dep = null;
		
	}
	
	
	
	
	
	/************************************MÉTODOS*****************************************/
	
	public String getNombre(){
		return this.nombre;}
	
	
	public String getCodigo(){
       return this.codigo;}
	
	
	
	public Double getCreditos(){  
		return this.creditos;   }
	
	
	public TipoAsignatura getTipo(){
		return this.tipo;}
   
	public Integer getCurso(){
        return this.curso;}
   
	public String getAcronimo(){
	
		
    	return ObtenerAcronimo(nombre);
		
		}
   
     public Departamento getDepartamento(){
    	
    	 return dep;} 
  
     public void setDepartamento(Departamento nuevoDep){
    
    	 //El setDepartamento del profesor es exactamente igual que este,cambiando lo de elimina asignatura y nueva asignatura
    	 
    	 
    	 if(nuevoDep != this.dep){
    		 
    		Departamento oldDpto = this.dep;
    		this.dep = nuevoDep;
    	if(oldDpto != null){
    		
    		oldDpto.eliminaAsignatura(this);
    	}
    		if(nuevoDep != null){
    			nuevoDep.nuevaAsignatura(this);
    		}
    		 
    	 }
    	
    }

 /***********************************EQUALS******************************/
     
     public boolean equals(Object o){
    	 boolean res = false;
    	 if(o instanceof Asignatura){
    		 Asignatura a = (Asignatura)o;
    		 if(this.getCodigo().equals(a.getCodigo())){
    			 res = true;
    		 }
    	 }
    	 return res;
     }
   
     /********************************HASHCODE*************************************/ 
     
     public int hashCode(){
    	 
    	 return this.getCodigo().hashCode();
     }
   
     /**********************************COMPARETO***************************************/
 
     public int compareTo(Asignatura a){
	  
	 int res = this.getCodigo().compareTo(a.getCodigo()); 
	  return res;
  }
     

    
	/**************************************MÉTODO TOSTRING**********************************/
    
    public String toString(){
    	return "(" + this.getCodigo()+ ") " + this.getNombre();
    }



	/************************************MÉTODOS PRIVADOS*******************************************/
    
    
    private void CheckCodigo(String cod){
    	
    	
    	Integer s = cod.length();
    	
    	if(!s.equals(7)){
   		 
			throw new ExcepcionAsignaturaNoValida("El código introducido debe estar formado por 7 dígitos");	
		
    	}
    	for(int j = 0;j <= cod.length()-1;j++){
			
		if(!Character.isDigit(cod.charAt(j))){
			
			throw new ExcepcionAsignaturaNoValida("El código introducido debe estar formado por 7 dígitos");	
		}
		}
				 	
    }
    
    private  void CheckCreditos(Double x){
    	if(x.compareTo(0.0)<=0){
			throw new ExcepcionAsignaturaNoValida("Los créditos no pueden ser menor o igual que cero");
			} 
    	}
    
		
	private  void CheckCurso(Integer curso){
		
		if(curso.compareTo(4)> 0 || curso.compareTo(1) <0){
    		throw new ExcepcionAsignaturaNoValida("El curso tiene que estar comprendido entre uno y cuatro");
    	 
		}
		
	}
  
    
    
   private String ObtenerAcronimo(String nombre){
    	
    	String asig = "";
    	for(int j = 0;j<nombre.length();j++){
    	
    		if(Character.isUpperCase(nombre.charAt(j))){
    			asig = asig + nombre.charAt(j);
    		}
    	}
    	
    	
    	return asig;
    }




    
    
	
}
