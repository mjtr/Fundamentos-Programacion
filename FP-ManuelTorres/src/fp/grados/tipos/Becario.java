package fp.grados.tipos;

import java.time.LocalDate;

public interface Becario extends Alumno{

	Beca getBeca();
	LocalDate getFechaComienzo();
	LocalDate getFechaFin();//Derivada
	
	
	void setFechaComienzo(LocalDate fechaComienzo);
	
	
	
	
	
	
}
