package fp.grados.tipos;

public interface Nota extends Comparable<Nota>{
      
	   Asignatura getAsignatura();
    
	   Convocatoria getConvocatoria();
      
	   Double getValor();
       
       Boolean getMencionHonor();
      
       Calificacion getCalificacion();
      
       Integer getCursoAcademico();




}
