package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.SortedSet;

public interface Profesor extends Persona{
	
	Categoria getCategoria();
	SortedSet<Tutoria> getTutorias();
    Departamento getDepartamento();
	List<Asignatura> getAsignaturas();
	List<Double> getCreditos();
	Double getDedicacionTotal();
	
	void imparteAsignatura(Asignatura asig, Double dedicacion);
    void setDepartamento(Departamento departamento);
    void setCategoria(Categoria categoria);
	void nuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia);
	void borraTutoria(LocalTime horaComienzo, DayOfWeek dia);
	void borraTutorias();
	Double dedicacionAsignatura(Asignatura asig);
	void eliminaAsignatura(Asignatura asig);
	
}
