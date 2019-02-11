package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;
 
public class TutoriaImpl implements Tutoria{


	/************************ATRIBUTOS*************************/
	
	private DayOfWeek diaSemana;
	private LocalTime horaComienzo;
	private LocalTime horaFin;
   
	
	
	/*****************************CONTRUCTORES**********************+*/
	
	
	public TutoriaImpl(DayOfWeek diaSemana,LocalTime horaComienzo,LocalTime horaFin){
		
		CheckDiaSemana(diaSemana);
	
		CheckDuracion(CalculaDuracion(horaComienzo,horaFin));
		this.diaSemana = diaSemana;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaFin;
		
		
		
	}

	public TutoriaImpl(DayOfWeek diaS,LocalTime horaC,Integer duracion){
		
		CheckDiaSemana(diaS);
		CheckDuracion(duracion);
		
		this.diaSemana = diaS;
		this.horaComienzo = horaC;
		this.horaFin = this.horaComienzo.plusMinutes(duracion);
		
	}
	
	
	public TutoriaImpl(String s){
		//“L,15:30,17:30”
		
		String [] res = s.split(",");
		
		if(res.length != 3){
			throw new IllegalArgumentException("Cadena introducida incorrecta");
			
		}

		horaComienzo = LocalTime.parse(res[1].trim());
		horaFin = LocalTime.parse(res[2].trim());
		
		
		DayOfWeek dia = convierteDia(res[0].trim().toUpperCase());
		
		CheckDiaSemana(dia);
		CheckDuracion(CalculaDuracion(horaComienzo,horaFin));
			
		
		this.diaSemana = dia;
	
		
		
	}

	
	private DayOfWeek convierteDia(String d) {

		//Para que en el caso de que no sea ninguno me salte la excepcion,por eso pongo que sea domingo
		
		
		DayOfWeek res = DayOfWeek.SUNDAY;
		
		if(d.equals("L")){
			res = DayOfWeek.MONDAY;
		}else if(d.equals("M")){
			res = DayOfWeek.TUESDAY;
		}else if(d.equals("X")){
			res = DayOfWeek.WEDNESDAY;
		}else if ( d.equals("J")){
			res = DayOfWeek.THURSDAY;
		}else if(d.equals("V")){
			res = DayOfWeek.FRIDAY;
		}
		
		return res;
	}

	/*****************************MÉTODOS********************************/
	
	public DayOfWeek getDiaSemana(){
	
		
		return this.diaSemana;}
	
	public LocalTime getHoraComienzo(){
		return this.horaComienzo;}
	
	public LocalTime getHoraFin(){
		return this.horaFin;}
	
	public Integer getDuracion(){
		CheckDuracion(CalculaDuracion(horaComienzo, horaFin));
		
		return CalculaDuracion(horaComienzo, horaFin);
		
	}
	
	/********************************EQUALS***************************************/
	
	public boolean equals (Object o ){
		boolean res = false;
		if(o instanceof Tutoria){
			Tutoria t = (Tutoria) o ;
			
			if (this.getDiaSemana().equals(t.getDiaSemana()) && this.getHoraComienzo().equals(t.getHoraComienzo())){
				res = true;
			}
		}
	return res;
	}
	

	/******************************HASHCODE*********************************/
	

	public int hashCode(){
		return this.getDiaSemana().hashCode() + this.getHoraComienzo().hashCode()*31;
	}
	
	
	/**********************************COMPARETO**********************************/
	
	public int compareTo(Tutoria t){
		int res = this.getDiaSemana().compareTo(t.getDiaSemana());
		if(res == 0){
			 
			res = this.getHoraComienzo().compareTo(t.getHoraComienzo());
			
		}
		return res;
	}
	
	
	
	/********************************MÉTODO TOSTRING************************************/
	
	public String toString(){
	String b = 	DarSiglasDiaSemana(getDiaSemana());
	
		return b + " "+ getHoraComienzo()+"-" + getHoraFin();
	}
	
	
	
	/***********************MÉTODOS PRIVADOS**************************/
	
	
	private  void CheckDuracion(Integer duracion){
        
		if(duracion.compareTo(15)<0){
			  
			  throw new ExcepcionTutoriaNoValida("Las tutorías deben de ser de al menos 15 minutos");
		  }
		
	}
	

	
	private  String DarSiglasDiaSemana(DayOfWeek r){
		String letra = "";
		
		switch(r){
		case MONDAY:
		letra = "L";break;
		case TUESDAY:
			letra = "M";break;
		case WEDNESDAY : 
			letra = "X";break;
			
		case THURSDAY:
             letra = "J";break;
			 
		case FRIDAY:
			letra = "V";break;
			default: break;
		
		
		}
		
		
		return letra;
	}
	
	
	private Integer CalculaDuracion(LocalTime horaComienzo,LocalTime horaFin){
		
		Integer Horas = horaFin.getHour()- horaComienzo.getHour();
		Integer Minutos = horaFin.getMinute() - horaComienzo.getMinute();
		  Integer duracion = Horas*60 + Minutos;
		
		return duracion;
	}
	
	
	private  void CheckDiaSemana(DayOfWeek DiaSemana){
		
		if(DiaSemana.equals(DayOfWeek.SATURDAY)){
			throw new ExcepcionTutoriaNoValida("Las tutorías no pueden ser en fin de semana");
			
		}else if(DiaSemana.equals(DayOfWeek.SUNDAY)){
			
			throw new ExcepcionTutoriaNoValida("Las tutorías no pueden ser en fin de semana");
		}
		
		
	}
	
	
	
}
