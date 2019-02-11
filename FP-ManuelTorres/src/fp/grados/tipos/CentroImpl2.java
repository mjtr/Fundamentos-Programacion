package fp.grados.tipos;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;



public class CentroImpl2 extends CentroImpl {
	
	
	/*************************CONTRUCTOR********************************/
	
	
	
	public CentroImpl2(String nombre,String direccion,Integer NumeroPlantas,Integer NumeroSotanos){
		
		super(nombre,direccion,NumeroPlantas,NumeroSotanos);
	
	}
	
	public Espacio getEspacioMayorCapacidad() {
		
	return	getEspacios().stream().max(Comparator.comparing(x-> x.getCapacidad())).
			orElseThrow(ExcepcionCentroOperacionNoPermitida :: new);
	
	}
	
	
	public  Integer[] getConteosEspacios() {
		
		Integer[] res = new Integer[TipoEspacio.values().length];

	  res[0] = cuentaEspacios(TipoEspacio.TEORIA);
      res[1] = cuentaEspacios(TipoEspacio.LABORATORIO);
      res[2] = cuentaEspacios(TipoEspacio.SEMINARIO);
      res[3] = cuentaEspacios(TipoEspacio.EXAMEN);
      res[4] = cuentaEspacios(TipoEspacio.OTRO);
	
		return res;	
	
						
		}
	
	private Integer cuentaEspacios(TipoEspacio otro) {
				return (int) getEspacios().stream().filter(x-> x.getTipo().equals(otro)).count();
	}


	

	public Set<Despacho> getDespachos() {

	return getEspacios().stream().filter(x -> x instanceof Despacho)
			.map(x -> (Despacho)x).collect(Collectors.toSet());
		
		
}
	
	public Set<Despacho> getDespachos(Departamento dep) {
		

		return getDespachos().stream()
				.filter(d ->  pertenece(d,dep))
				.collect(Collectors.toSet());
		

	}

	private Boolean pertenece(Despacho d, Departamento dep) {
		
		return d.getProfesores().stream().anyMatch(x -> x.getDepartamento().equals(dep));
		
	}

	
	public Set<Profesor> getProfesores() {
		
		return getDespachos().stream()
				.flatMap(x -> x.getProfesores().stream()).collect(Collectors.toSet());
		
	}
	
	
	public Set<Profesor> getProfesores(Departamento d) {
		
	return getProfesores().stream()
			.filter(x -> x.getDepartamento().equals(d)).collect(Collectors.toSet());
		
	}
	
	
	
	
	public SortedMap<Profesor, Despacho> getDespachosPorProfesor() {

		Map<Profesor, Despacho> mapa =
	getDespachos().stream().flatMap(x -> x.getProfesores().stream())
	.collect(Collectors.toMap(x -> x, p -> encuentraDespacho(p)));	
				
	return new TreeMap<>(mapa);
	}

	private Despacho encuentraDespacho(Profesor p) {
		//Tambien valdria un findAny
		
		return getDespachos().stream()
				.filter(d -> d.getProfesores().contains(p))
				.findFirst().get();
		
	}
		
	
	
	
	
	
	
	
}
