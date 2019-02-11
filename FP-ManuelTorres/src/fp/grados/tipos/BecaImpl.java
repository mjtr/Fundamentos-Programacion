package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionBecaNoValida;

public class BecaImpl implements Beca {

	/******************************ATRIBUTOS*******************************/
	
	private static final Double CUANTIA_MINIMA = 1500.0;
	
	private String codigo;
	private Double cuantiatotal;
	private Integer duracion;
	private TipoBeca tipo;
	
	/*******************************CONSTRUCTORES*******************************/
	
	
	
	
	public BecaImpl(String codigo,Double cuantiatotal,Integer duracion,TipoBeca tipo){
		
		CheckCodigo(codigo);
		CheckCuantiaTotal(cuantiatotal);
		CheckDuracion(duracion);
		
		this.codigo = codigo;
		this.cuantiatotal = cuantiatotal;
		this.duracion = duracion;
		this.tipo = tipo;
	}	
	
   public BecaImpl(String codigo,TipoBeca tipo){
		
		CheckCodigo(codigo);
			
		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiatotal = CUANTIA_MINIMA;
		this.duracion = 1;
	}
	
	
   public BecaImpl(String s){
	   
	   String [] res = s.split(",");
	   
	   if(res.length != 4){
		   throw new IllegalArgumentException("Cadena introducida incorrecta");
		    }
	   
	   String cod = res[0].trim();
	   Double cuanTotal = new Double(res[1].trim());
	   Integer dur = new Integer(res[2].trim());
	   
	    CheckCodigo(cod);
		CheckCuantiaTotal(cuanTotal);
		CheckDuracion(dur);
		
		codigo = cod;
		cuantiatotal = cuanTotal;
		duracion = dur;
		tipo = TipoBeca.valueOf(res[3].trim());

	   
	   
   }
   
   
	/***********************************MÉTODOS***************************************/
		
	public String getCodigo(){ 
		return this.codigo; }
	
	public Double getCuantiaTotal(){
		return this.cuantiatotal;}
	
	public Integer getDuracion(){
		return this.duracion;}
	
	public TipoBeca getTipo(){
		return tipo;}
	
	public void setCuantiaTotal (Double CuantiaTotal){
		
		CheckCuantiaTotal(CuantiaTotal);
		
		this.cuantiatotal= CuantiaTotal;}
	
	public void setDuracion(Integer Duracion){
		CheckDuracion(Duracion);
		
		this.duracion= Duracion;}
	
	public Double getCuantiaMensual() {
		return this.getCuantiaTotal()/this.getDuracion();}

	
/************************************EQUALS********************************/
	
	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Beca){
			Beca b = (Beca)o;
			if(this.getCodigo().equals(b.getCodigo()) && this.getTipo().equals(b.getTipo())){
				res = true;
			}
		}
		return res;
	}
	
/**********************************HASHCODE**********************************************/
	
	public int hashCode(){
		
		return this.getCodigo().hashCode() + this.getTipo().hashCode()*31;
	}
	
	
/**********************************COMPARETO*****************************************/
	
	public int compareTo(Beca b){
		int res = this.getCodigo().compareTo(b.getCodigo());
		if(res==0){
			res = getTipo().compareTo(b.getTipo());
		}
		return res;
		
	}
	
	
	
	
/************************************MÉTODO TOSTRING******************************************/
	
	public String toString(){
		return "[" + this.getCodigo() + ", " + this.getTipo().toString().toLowerCase() + "]";
	}


/**************************************MÉTODOS PRIVADOS*********************************************/
	
	
	private void CheckCodigo(String codigo){
	Integer digitoscodigo = codigo.length();
		
		if(!digitoscodigo.equals(7)){
			throw new ExcepcionBecaNoValida("El tamaño del código de la beca tiene que ser de 7 dígitos");
			
		}for(int i=0;i<codigo.length()-4;i++){
			
			if(!Character.isLetter(codigo.charAt(i))){
				throw new ExcepcionBecaNoValida("Las tres primeras cifras del código tienen que ser caracteres");
			}
			
		} for (int j =3;j<codigo.length();j++){
			
			if(!Character.isDigit(codigo.charAt(j))){
				throw new ExcepcionBecaNoValida("Las cuatro últimas cifras del código tienen que ser números");
			}
		}
		
		/*	En clase lo ha hecho de la siguiente manera: 
		 * Boolean esCorrecto = codigo.length()==7 && Character.isLetter(codigo.charAt(0))
			&& Character.isLetter(codigo.charAt(1)) && Character.isLetter(codigo.charAt(2))
			&& Character.isDigit(codigo.charAt(3)) && Character.isDigit(codigo.charAt(4))
			&& Character.isDigit(codigo.charAt(5)) && Character.isDigit(codigo.charAt(6));
		
		if(!esCorrecto){
			throw new ExcepcionBecaNoValida(" Código incorrecto");
		}*/
		
		
	}
	
	
	private void CheckCuantiaTotal(Double cuantiaTotal){
		if(cuantiaTotal.compareTo(CUANTIA_MINIMA) < 0){
			throw new ExcepcionBecaNoValida("La cuantía total no puede ser menor que la cuantía mínima");
		}
	}
	
	private void CheckDuracion(Integer duracion){
		if(duracion.compareTo(1) < 0){
			throw new ExcepcionBecaNoValida("La duración no puede ser menor que un mes");
		}
		
	}
	
	
	
	
	

	
}
