package fp.grados.tipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


import java.util.NoSuchElementException;

import fp.grados.excepciones.ExcepcionExpedienteOperacionNoPermitida;

public class ExpedienteImpl implements Expediente{

	/***********************************ATRIBUTOS********************************************/
	
	private List<Nota> notas;
	
	
	/***********************************CONSTRUCTOR***********************************************************/
	
	
	public ExpedienteImpl(){
		
	notas = new LinkedList<Nota>();	
		
		
	}


	
	/*******************************************METODOS********************************************/
	
	public List<Nota> getNotas() {
		
		return new ArrayList<Nota>(notas);
	}


	public void nuevaNota(Nota n) {

		   int pos = notas.indexOf(n);	   
		  
		   if(pos !=-1){
		 
			   notas.remove(pos);
		}
		  
		
		   
		   notas.add(n);
	
		   checkNotas(n);
		   
	}
		
		
	//TODO: Boletin 12
	
	
	public List<Nota> getNotasOrdenadasPorAsignatura(){
		
	Comparator<Nota> OrdenaPorAsignatura = Comparator.comparing(Nota :: getAsignatura).
			thenComparing(Comparator.naturalOrder());
		
		List<Nota> lista = new ArrayList<Nota>();
		lista.addAll(notas);
		
		Collections.sort(lista,OrdenaPorAsignatura);
		
	
		return lista;
	}
	
	
	
	public Nota getMejorNota(){
		
		Comparator<Nota > OrdenaCalificaciones = Comparator.comparing(Nota :: getMencionHonor);
		Comparator<Nota> OrdenaPorValor = Comparator.comparing(Nota :: getValor);
		Comparator<Nota> OrdenaPorConvocatoria = Comparator.comparing(Nota :: getConvocatoria);
		Comparator<Nota> ordenaPorCurso = Comparator.comparing(Nota :: getCursoAcademico);
		Comparator<Nota> cc = OrdenaCalificaciones.reversed().thenComparing(OrdenaPorValor.reversed()).
				thenComparing(OrdenaPorConvocatoria).thenComparing(ordenaPorCurso);

		
		
		return getNotas().stream().min(cc).orElseThrow(NoSuchElementException :: new);
		
	  
	}
	
	
	
	
	
	/****************************************EQUALS**************************************/
	
	public boolean equals(Object o){
		boolean res = false;
		
		if(o instanceof Expediente){
			
			Expediente ex = (Expediente) o;
			
			if(notas.equals(ex.getNotas())){
				
				res = true;
			}
			
		}
		
		return res;
		
	}
	
	/*******************************HASHCODE********************************************/
	
	public int hashCode(){
		
		return this.getNotas().hashCode();
	}
	
	
	/*********************************************TOSTRING******************************************/
	
	public String toString(){
		
		return notas.toString();
		
	}

/******************************************MÉTODOS PRIVADOS************************************************/
	
	public Double getNotaMedia() {
		
		
		
		Double suma = 0.0;
		Double cont = 0.0;
		
		for(Nota n : notas){
			if(n.getValor().compareTo(5.0)>=0.0){
				suma+= n.getValor();
				cont++;
			}
		}
		
		if(cont == 0.0){
			
			//Para que no me haga la division de 0/0;
			cont = 1.0;
			
		}
		
		return suma/cont;
		
		
		
	}
	
	
	private void checkNotas(Nota a){
		
	//	un expediente no puede contener notas para más de dos convocatorias de una misma asignatura y curso
	
	Integer contador = 0;
		for(Nota s : notas){
	
		if(a.getCursoAcademico().equals(s.getCursoAcademico()) && a.getAsignatura().equals(s.getAsignatura())){
		
			contador += 1;
			
			if(contador > 2){
			
			
			throw new ExcepcionExpedienteOperacionNoPermitida("un expediente no puede contener notas para más de dos convocatorias de una misma asignatura y curso");
			}
			
		}
		
		
	}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
