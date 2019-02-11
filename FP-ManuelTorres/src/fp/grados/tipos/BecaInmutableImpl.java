package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionBecaNoValida;

public final class BecaInmutableImpl implements BecaInmutable {

	/******************************ATRIBUTOS*******************************/
	
	private static final Double CUANTIA_MINIMA = 1500.0;
	private static final Integer DURACION_MINIMA = 1;
	private final String codigo;
	private final Double cuantiatotal;
	private final Integer duracion;
	private final TipoBeca tipo;
	
	/*******************************CONSTRUCTORES*******************************/
	
	
	
	
	public BecaInmutableImpl(String codigo,Double cuantiatotal,Integer duracion,TipoBeca tipo){
		
		CheckCodigo(codigo);
		CheckCuantiaTotal(cuantiatotal);
		CheckDuracion(duracion);
		
		this.codigo = codigo;
		this.cuantiatotal = cuantiatotal;
		this.duracion = duracion;
		this.tipo = tipo;
	}	
	
   public BecaInmutableImpl(String codigo,TipoBeca tipo){
		
		CheckCodigo(codigo);
			
		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiatotal = CUANTIA_MINIMA;
		this.duracion = DURACION_MINIMA;
	}
	
	
   public BecaInmutableImpl(String s){
	   
	   String [] res = s.split(",");
	   
	   if(res.length != 4){
		   throw new ExcepcionBecaNoValida("Cadena introducida incorrecta");
		   
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
	
	
	public Double getCuantiaMensual() {
		return this.getCuantiaTotal()/this.getDuracion();}

	
/************************************EQUALS********************************/
	
	public boolean equals(Object o){
		boolean res = false;
		if(o instanceof Beca){
			BecaInmutable b = (BecaInmutable)o;
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
	
	public int compareTo(BecaInmutable b){
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
		
	
		
	}
	
	
	private void CheckCuantiaTotal(Double cuantiaTotal){
		if(cuantiaTotal.compareTo(CUANTIA_MINIMA) < 0){
			throw new ExcepcionBecaNoValida("La cuantía total no puede ser menor que la cuantía mínima");
		}
	}
	
	private void CheckDuracion(Integer duracion){
		if(duracion.compareTo(DURACION_MINIMA) < 0){
			throw new ExcepcionBecaNoValida("La duración no puede ser menor que un mes");
		}
		
	}
	
	
	
	
	

	
}
