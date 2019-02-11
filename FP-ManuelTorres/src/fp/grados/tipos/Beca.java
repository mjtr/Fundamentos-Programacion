package fp.grados.tipos;

public interface Beca extends Comparable<Beca> {
  
	String getCodigo();
	
	Double getCuantiaTotal();
	
	Integer getDuracion();
	
	TipoBeca getTipo();

	Double getCuantiaMensual();
	
	void setCuantiaTotal(Double cuantiatotal);
	
	void setDuracion(Integer duracion);
	
	
	/*Si hacemos esto no hace falta volver hacerlo en la clase
	default Double getCuantiaMensual(){
return getCuantiaTotal()/getDuracion();};
*
*
*/
}
