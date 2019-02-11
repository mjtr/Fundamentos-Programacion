package fp.grados.tipos;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionBecarioNoValido;


public class BecarioImpl extends AlumnoImpl  implements Becario {

	/****************************ATRIBUTOS************************************/
	
	private Beca beca;
	private LocalDate fechaComienzo;
	
	
	
	/****************************CONTRUCTORES:*************************************/
	
	public BecarioImpl(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
			String email,Beca beca,LocalDate fechaComienzo){
		
		
		super(dni,nombre,apellidos,fechanacimiento,email);
		
		CheckFechaComienzo(fechaComienzo);
		
		this.beca = beca;
		this.fechaComienzo = fechaComienzo;
		
		
		
	}
	
	public BecarioImpl(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
			String email,String codigo,Double cuantiatotal,Integer duracion,
			TipoBeca tipo,LocalDate fechaComienzo){
		
		
		super(dni,nombre,apellidos,fechanacimiento,email);
		
		Beca nueva = new BecaImpl(codigo,cuantiatotal,duracion,tipo);
		
		CheckFechaComienzo(fechaComienzo);
		
        this.beca = nueva;
		this.fechaComienzo = fechaComienzo;
		
		
		/******************************MÉTODOS**************************/
		
		
	}

	
	public Beca getBeca() {
		
		return this.beca;
	}


	public LocalDate getFechaComienzo() {
	
		return this.fechaComienzo;
	}

	public LocalDate getFechaFin() {
		
		return ObtenerFechaFin(fechaComienzo,beca.getDuracion());
	}

	
	public void setFechaComienzo(LocalDate fechaComienzo) {
		
		CheckFechaComienzo(fechaComienzo);
		
		this.fechaComienzo = fechaComienzo;
		
	}
	
    public void setEmail(String email){
		
		CheckEmail(email);
		
		
	}
	

    /****************************toString************************************/
	
	
	public String toString(){
		
		return super.toString() + " " +beca.toString() ;
		
		
	}
	
	
	
	
	/*******************************MÉTODOS PRIVADOS****************************************/
	
	
	private LocalDate ObtenerFechaFin(LocalDate fechaCo,Integer duracion){
		
	LocalDate fechaFin = fechaCo.plusMonths(duracion);
		
	return fechaFin;
		
		
	}
	
	
	private void CheckFechaComienzo(LocalDate fechaCo){
	
		/*En las prácticas de laboratorio se ha hecho así:
		  
		  if(fechaCo.isAfter(	LocalDate.now())==false){
		  throw new...
		  }
		  Pero como yo ya tenía hecho esto,lo dejo así
		 */
		
		
		LocalDate fechaActual = LocalDate.now();
		
		if(fechaCo.getYear() <  fechaActual.getYear()){
			
          throw new ExcepcionBecarioNoValido("La fecha de comienzo tiene que ser posterior a la actual");
		
		}else if(fechaCo.getYear() == fechaActual.getYear()){
			
			if(fechaCo.getMonthValue() < fechaActual.getMonthValue()){
				  throw new ExcepcionBecarioNoValido("La fecha de comienzo tiene que ser posterior a la actual");
				
			}else if(fechaCo.getMonthValue() == fechaActual.getMonthValue()){
				
				if(fechaCo.getDayOfMonth() <= fechaActual.getDayOfMonth()){
					
					  throw new ExcepcionBecarioNoValido("La fecha de comienzo tiene que ser posterior a la actual");
									
				}
				}
			}
		
		}
	
	
	private void CheckEmail(String email){
		
		throw new UnsupportedOperationException("No se puede modificar el email");
		
	}
	
	
	
	
	
	
}
