package fp.grados.tipos;

public interface Espacio extends Comparable<Espacio>{
	TipoEspacio getTipo();
	String getNombre();
	Integer getCapacidad();
	Integer getPlanta();

	
	void setNombre(String Nombre);
	void setCapacidad(Integer Capacidad);
	void setTipo(TipoEspacio TipoEspacio);
	
}
