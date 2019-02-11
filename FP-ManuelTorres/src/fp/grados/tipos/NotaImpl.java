package fp.grados.tipos;




import fp.grados.excepciones.ExcepcionNotaNoValida;

public class NotaImpl implements Nota {

	/****************************************ATRIBUTOS**************************************************/
	
	private Asignatura asignatura;
	private Integer curso;
	private Convocatoria convocatoria;
	private Double valor;
	private Boolean mencion;
	
	
	
	/***************************************CONSTRUCTOR****************************/
	
	public NotaImpl(Asignatura asignatura,Integer curso,Convocatoria convocatoria,Double valor,
			Boolean mencion){
	
		CheckValor(valor);
		CompruebaMencionHonor(valor,mencion);
		
		
		this.asignatura = asignatura;
		this.curso = curso;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencion = mencion;
		
		
	}
	
	
	public NotaImpl(Asignatura a,Integer cur,Convocatoria con,Double v){
		
		CheckValor(v);
		 
		 this.asignatura = a;
		 this.curso = cur;
		 this.convocatoria = con;
		 this.valor = v;
		 
		 mencion = false;
		
		
	}
	
	 //“Fundamentos de Programación#1234567#12.0#ANUAL#1,2014,PRIMERA,10.0,true”
	
	public NotaImpl(String s){
		
		String [] res = s.split(";");
		if(res.length != 5){
			throw new IllegalArgumentException("Cadena introducida incorrecta");
		}
		asignatura = new AsignaturaImpl(res[0]);
		Integer cur = new Integer(res[1].trim());
		Convocatoria c = Convocatoria.valueOf(res[2].trim());
		Double va = new Double(res[3].trim());
		Boolean men = new Boolean(res[4].trim());
		
		CheckValor(va);
		CompruebaMencionHonor(va,men);
		
		curso = cur;
		convocatoria = c;
		valor = va;
		mencion = men;
		
	}
	
	
	/****************************************MÉTODOS*********************************/
	
	public Asignatura getAsignatura(){
		return asignatura;}
	
	public Integer getCursoAcademico(){
		return curso;}
	
	public Convocatoria getConvocatoria(){
		return convocatoria;}
	
	
	public Double getValor(){
		return valor;}
	
	
	public Boolean getMencionHonor(){
	    return mencion;}
	
	
	public Calificacion getCalificacion(){
	
		return AsignaCalificacion(valor,mencion); }
	
	/*******************************************EQUALS************************************/
	
	
	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Nota){
		Nota n = (Nota)o;
		
		if(this.getCursoAcademico().equals(n.getCursoAcademico()) && this.getAsignatura().equals(n.getAsignatura())
				&& this.getConvocatoria().equals(n.getConvocatoria())){
			res = true;
		}
			
		}
		return res;
	}
	
	
	/*************************************HASHCODE************************************/
	
	
	public int hashCode(){
		return this.getCursoAcademico().hashCode() + this.getAsignatura().hashCode()*31 +
				this.getConvocatoria().hashCode()*31*31;
	
	}
	
	
	/********************************COMPARETO*************************************/
	
	public int compareTo(Nota n){
		
	int res = this.getCursoAcademico().compareTo(n.getCursoAcademico()) ;
		if(res == 0){
		
			res = this.getAsignatura().compareTo(n.getAsignatura())	;
			if(res == 0){
				res = this.getConvocatoria().compareTo(n.getConvocatoria());
			}
		}
	
	return res;
	}
	
	
	
	
	
	
	
	/*******************************************MÉTODO TOSTRING**********************************/
		
		
	
	public String toString(){
    
		
		String aniodefinalizar =String.valueOf(getCursoAcademico()+1);

      Character primerdigito = aniodefinalizar.charAt(aniodefinalizar.length()-2);
      Character segundodigito = aniodefinalizar.charAt(aniodefinalizar.length()-1);
			
		 return getAsignatura()+ "," + getCursoAcademico() + "-" + primerdigito +segundodigito+ ", " +getConvocatoria()+"," + getValor()
				 + "," + getCalificacion() ;
         
		}
		
		/****************************************MÉTODOS PRIVADOS**************************************/
		
		
		private Calificacion AsignaCalificacion(Double r,Boolean honor){	
		
			Calificacion nota = null;
			
			if(r.compareTo(5.0)<0.0){nota = Calificacion.SUSPENSO;}
			
			if(r.compareTo(5.0)>=0.0 && r.compareTo(7.0)<0.0){nota = Calificacion.APROBADO;}
			
			if(r.compareTo(7.0)>=0.0 && r.compareTo(9.0) < 0.0){nota = Calificacion.NOTABLE;}
			
			if(r.compareTo(9.0) >= 0.0 && honor.equals(false)){nota = Calificacion.SOBRESALIENTE;}
			
			if(r.compareTo(9.0) >= 0.0 && honor.equals(true)){	nota = Calificacion.MATRICULA_DE_HONOR;	}
			
			
			return nota;
	
		}


      private  void CheckValor(Double valor){
  		if(valor.compareTo(0.0)<0 || valor.compareTo(10.0) >0){
  			
  			throw new ExcepcionNotaNoValida("La nota introducida es incorrecta");
  			
  		}
    	  
      }

       private  void CompruebaMencionHonor(Double nota,Boolean honor){
	  
	
	  if(honor.equals(true) && nota.compareTo(9.0) <0.0){
		  throw new ExcepcionNotaNoValida("Tiene que tener más de un 9 en la nota para que tenga una mención ");
		  
	  }
	  
  }




}
	
