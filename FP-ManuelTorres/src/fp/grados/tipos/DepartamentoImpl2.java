package fp.grados.tipos;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DepartamentoImpl2 extends DepartamentoImpl{

	

	
	/**************************CONTRUCTORES*************************************/
	
	public DepartamentoImpl2(String nombre){
		
	super(nombre);
		
	}

	/*******************************************MÉTODOS************************************/
	
	
	
	
	public void borraTutorias() {
		
		getProfesores().stream().forEach(x -> x.borraTutorias());
				
	}

	
	public void borraTutorias(Categoria c) {
	
		getProfesores().stream().filter(x -> x.getCategoria().equals(c))
		.forEach(x -> x.borraTutorias());
		
		
	}

	
	public Boolean existeProfesorAsignado(Asignatura a) {
		
		return getProfesores().stream()
				.anyMatch(x -> x.dedicacionAsignatura(a).compareTo(0.0) > 0);
		
	}

	
	public Boolean estanTodasAsignaturasAsignadas() {
		
	return 	getAsignaturas().stream().allMatch(a -> existeProfesorAsignado(a));
		
	}
	
	
	public void eliminaAsignacionProfesorado(Asignatura a) {
		
		getProfesores().stream().filter(x -> x.dedicacionAsignatura(a).compareTo(0.0)>0)
		.forEach(y-> y.eliminaAsignatura(a));

	}
	

	public	SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura(){
	
	
	SortedMap<Asignatura, SortedSet<Profesor>> res = new TreeMap<Asignatura, SortedSet<Profesor>>();
	
	for(Profesor p : getProfesores()){
		
		
		actualizaProfesoresAsignatura(res,p);
		
			
		}
	return res;
	}
	
	


    private void actualizaProfesoresAsignatura(
		SortedMap<Asignatura, SortedSet<Profesor>> m, Profesor p) {
    	
    	for(Asignatura a : p.getAsignaturas()){
    		
    		SortedSet<Profesor> sp = m.get(a);
    		if(sp == null){
    			
    			sp = new TreeSet<Profesor>();
    		}
    		
    		sp.add(p);
    		m.put(a, sp);
    	}
    	 	
    	
	
}

    
	public SortedMap<Profesor, SortedSet<Tutoria>> getTutoriasPorProfesor(){
	
		Function<Profesor,Profesor> f1 = Function.identity();
		Function<Profesor,SortedSet<Tutoria>> f2 = p-> p.getTutorias();
		
		return new TreeMap<Profesor,SortedSet<Tutoria>>(
				getProfesores().stream().collect(Collectors.toMap(f1, f2)));
		
    	
    }


	//TODO:Boletin 12
	
	public Profesor getProfesorMaximaDedicacionMediaPorAsignatura(){
		
	Comparator< Profesor> OrdenaPorDedicacion = Comparator.comparing(profe -> profe.getDedicacionTotal()/profe.getAsignaturas().size());
	Predicate<Profesor> predicado = profe -> !profe.getAsignaturas().isEmpty();	
		
		return	getProfesores().stream().filter(predicado)
			.max(OrdenaPorDedicacion).orElseThrow(NoSuchElementException :: new );
		
		
	}



	
	
}