package fp.grados.tipos;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;


public class GradoImpl2 extends GradoImpl {
	

	/*************************************CONSTRUCTOR***************************************************/
	
	public GradoImpl2(String nom,Set<Asignatura> asiob,Set<Asignatura> asiop,Double cre){


		super( nom, asiob, asiop, cre);

		
	}



	public Double getNumeroTotalCreditos() {
	
		return this.getAsignaturasObligatorias().stream()
				.mapToDouble(x -> x.getCreditos()).sum() + this.getNumeroMinimoCreditosOptativas();
		
		
	}

	//TODO:

	public Set<Departamento> getDepartamentos() {
	
		return Conjunto()
				.map(x-> x.getDepartamento()).collect(Collectors.toSet());
		
		
	}


	public Set<Profesor> getProfesores() {

		return getDepartamentos().stream()
				.flatMap(x-> x.getProfesores().stream()).collect(Collectors.toSet());

	}

	public Set<Asignatura> getAsignaturas(Integer curso) {
		
 		return Conjunto().filter(x -> x.getCurso().equals(curso)).collect(Collectors.toSet());
		
	}

	private Stream<Asignatura> Conjunto(){

		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream());
	
	}


	public Asignatura getAsignatura(String codigo) {

	return Conjunto().filter(x ->x.getCodigo().equals(codigo)).findFirst()
				.orElseThrow(() -> new ExcepcionAsignaturaNoValida("Código no válido"));
			
	}
	
	
   public SortedMap<Asignatura, Double> getCreditosPorAsignatura() { 
		
	   Map<Asignatura, Double> mapa = 
				 Conjunto()
				  .collect(Collectors.toMap(Function.identity(),a -> a.getCreditos()));

	   return new TreeMap<>(mapa);
	}
	
   // Boletin 12
	
   public SortedSet<Departamento> getDepartamentosOrdenadosPorAsignaturas(){
	   
	  Comparator<Departamento> OrdenaDep = Comparator.comparing(x -> x.getAsignaturas().size());
	  
	  SortedSet<Departamento> res = new TreeSet<Departamento>(OrdenaDep.reversed().thenComparing(Comparator.naturalOrder()));
	   
	  res.addAll(getDepartamentos());

	   return res;
   }
	
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
