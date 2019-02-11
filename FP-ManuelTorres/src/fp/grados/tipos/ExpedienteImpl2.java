package fp.grados.tipos;



public class ExpedienteImpl2 extends ExpedienteImpl{
	
		
	/***********************************CONSTRUCTOR***********************************************************/
	
	
	public Double getNotaMedia() {
		
	return 	getNotas().stream().filter(x -> x.getValor()>=5.0).mapToDouble(x -> x.getValor())
			.average().orElse(0.0);
			
		
	}
	
	

		
		
		
	
	
	
	
	
	
	
	
	
	
	
}
