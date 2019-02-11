package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;


public interface Alumno extends Persona{

	Set<Asignatura> getAsignaturas();
	Expediente getExpediente();
	Integer getCurso();
	SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura();
	SortedSet<Asignatura> getAsignaturasOrdenadasPorCurso();
	
	void matriculaAsignatura(Asignatura asig);
	void eliminaAsignatura(Asignatura asig);
	Boolean estaMatriculadoEn(Asignatura asig);
	void evaluaAlumno(Asignatura a, Integer curso, Convocatoria convocatoria, Double nota, Boolean mencionHonor);
	void evaluaAlumno(Asignatura a, Integer curso, Convocatoria convocatoria, Double nota);
	
	
	
}
