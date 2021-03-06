package fp.grados.tipos;

public interface Asignatura extends Comparable<Asignatura> {

	String getNombre();
	
	String getAcronimo();//Es derivada
	
	String getCodigo();
	
	Double getCreditos();
	
	TipoAsignatura getTipo();
	
	Integer getCurso();
	
	Departamento getDepartamento();
	
	void setDepartamento(Departamento departamento);

	
	
}
