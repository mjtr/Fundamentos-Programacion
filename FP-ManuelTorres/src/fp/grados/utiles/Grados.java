package fp.grados.utiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.AlumnoImpl2;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.CentroImpl2;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoBeca;
import fp.grados.tipos.TipoEspacio;
import fp.grados.tipos.Tutoria;


public class Grados {
	
	public static <T> List<T> leeFichero(String nombreFichero,
			Function<String, T> funcion_deString_aT) {
		List<T> res = null;
		try {
			res = Files.lines(Paths.get(nombreFichero))
					.map(funcion_deString_aT).collect(Collectors.toList());
		} catch (IOException e) {
			System.out
					.println("Error en lectura del fichero: " + nombreFichero);
		}

		return res;
	}
	
	
	
	public static <T> void escribeFichero(List<T> objetos, Function<T,String> funcion, String nombreFichero) {
		List<String> s = objetos.stream()
			.map(funcion)
			.collect(Collectors.toList());
		try {
			Files.write(Paths.get(nombreFichero), s);
		} catch (IOException e) {
			System.out.println("Error en la escritura del fichero");
		}
	}


		
		/*********************************ALUMNO****************************************************/
		
		
		
		
		private static Set<Alumno> setAlumno = new HashSet<Alumno>();
		private static Boolean usarJava8 = false;
		public static void setUsarJava8(Boolean x){
			usarJava8 = x;
			
		}
		
		
		public static Alumno createAlumno(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
				String email){
			Alumno a = null;
			if(usarJava8){
				a = new AlumnoImpl2(dni,nombre,apellidos,fechanacimiento,email);
			}else{
				a = new AlumnoImpl(dni,nombre,apellidos,fechanacimiento,email);
			}
			
			actualiza(a);
			return a;
			
			
		}
		
		public static Alumno createAlumno(Alumno alumno){
			//Copia del alumno
			Alumno res;
			if(usarJava8){
			res = new AlumnoImpl2(alumno.getDNI(),alumno.getNombre(),
					alumno.getApellidos(),alumno.getFechaNacimiento(),
					alumno.getEmail());
			}else{
			res = new AlumnoImpl(alumno.getDNI(),alumno.getNombre(),
					alumno.getApellidos(),alumno.getFechaNacimiento()
					,alumno.getEmail());
			}
			
			copiaAsignaturasAlumno(res,alumno);
			copiaNotasAlumno(res,alumno);
			actualiza(res);
			return res;
		}
		

		private static void copiaNotasAlumno(Alumno res, Alumno alumno) {
           
			for(Nota n: alumno.getExpediente().getNotas()){
				res.evaluaAlumno(n.getAsignatura(),n.getCursoAcademico(), n.getConvocatoria(), n.getValor()
						,n.getMencionHonor());
			}

		}



		private static void copiaAsignaturasAlumno(Alumno res, Alumno alumno) {

			for(Asignatura a : alumno.getAsignaturas()){
				res.matriculaAsignatura(a);
			}
			
		}


		public static Alumno createAlumno(String s){
			Alumno a = null;
			
			if(usarJava8){
				a = new AlumnoImpl2(s);
			}else{
				a = new AlumnoImpl(s);
			}
			
			actualiza(a);
			return a;
		}
		
		private static void actualiza(Alumno a) {
			
			setAlumno.add(a);

		}

		
		public static List<Alumno> createAlumnos(String nombreFichero) {
			List<Alumno> res = leeFichero(nombreFichero, s -> createAlumno(s));
			return res;
		}
		
		

		
	public static Integer getNumAlumnosCreados(){
			
			return setAlumno.size();
			}
		
		
		public static Set<Alumno> getAlumnosCreados(){
		
			return new HashSet<Alumno>(setAlumno);
	}
		
	
	
		/*********************************ASIGNATURA****************************************************/

		
		private static Set<Asignatura> setAsig = new HashSet<Asignatura>();
		private static Map<String,Asignatura> mapAsig = new HashMap<String,Asignatura>();
		
		
		public static Asignatura createAsignatura(String nombre,String codigo,Double creditos,
				TipoAsignatura tipo,Integer curso,Departamento dep){
			
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo,curso , dep);
		
			actualiza(a);

			return a ; 
			
		}
				
		private static void actualiza(Asignatura a) {
		
			setAsig.add(a);
		
			if(!mapAsig.containsKey(a.getCodigo())){
				
				mapAsig.put(a.getCodigo(), a);
			}
			
		}

		public static Asignatura createAsignatura(String s){
			Asignatura a = new AsignaturaImpl(s);
			actualiza(a);
			return a;
		}
		
		
		public static List<Asignatura> createAsignaturas(String nombreFichero) {
			List<Asignatura> res = leeFichero(nombreFichero, s -> createAsignatura(s));
			return res;
		}

		
		
		public static Integer getNumAsignaturasCreadas(){
			return setAsig.size();
		}
		
		public static Set<Asignatura> getAsignaturasCreadas(){
			return new HashSet<Asignatura>(setAsig);
		}
		

		public static Asignatura getAsignaturaCreada(String cod){
			
			return mapAsig.get(cod);
			
		}
		
		public static Set<String> getCodigosAsignaturasCreadas(){
			
			return new HashSet<String>(mapAsig.keySet());
		}
	
	
		
		/*********************************BECA****************************************************/

		private static Set<Beca> setBecas = new HashSet<Beca>();
		private static Map<TipoBeca,Integer> mapBecas = new HashMap<TipoBeca,Integer>();
		
		
		public static Beca createBeca(String codigo,Double cuantiatotal,Integer duracion,TipoBeca tipo){
			
			Beca b = new BecaImpl(codigo, cuantiatotal, duracion, tipo);
			
			actualiza(b);
			
			return b;
			
		}
		
		private static void actualiza(Beca b) {
			
			
			setBecas.add(b);
			Integer x = mapBecas.get(b.getTipo());
			
			if(x==null){
				
				mapBecas.put(b.getTipo(), 1);
				
			}else{
				mapBecas.put(b.getTipo(), x+1);
			}
			
			
		}

		public static Beca createBeca(String codigo,TipoBeca tipo){
			
			Beca b = new BecaImpl(codigo,tipo);
			actualiza(b);
			
			return b;
			
		}
		
		
		
		public static Beca createBeca(Beca b){
			
			Beca copia = new BecaImpl(b.getCodigo(),b.getCuantiaTotal(),b.getDuracion(),b.getTipo());
			actualiza(copia);
			return copia;
		
		}
		
		public static Beca createBeca(String s){
			Beca b = new BecaImpl(s);
			actualiza(b);
			return b;
		}
		
		
		public static List<Beca> createBecas(String nombreFichero) {
			List<Beca> res = leeFichero(nombreFichero, s -> createBeca(s));
			return res;
		}
		

		
		public Integer getNumBecasCreadas(){
			return setBecas.size();
		}
		
		public Set<Beca> getBecasCreadas(){
			return new HashSet<Beca>(setBecas);
		}
		
		public Integer  getNumBecasTipo(TipoBeca tb){
			return mapBecas.get(tb);
			
		}
		
		
		/*********************************CENTRO****************************************************/

		
		
		private static Set<Centro> setCentro = new HashSet<Centro>();
		private static Integer PlantaMax = null;
		private static Integer SotanoMax = null;
		private static Integer numeroPlantas = 0;
		private static Integer numeroSotanos = 0;

		
		
		public static Centro createCentro(String nombre,String direccion,Integer NumeroPlantas,
				Integer NumeroSotanos){
			
			Centro c = null;
			
			if(usarJava8){
				
				 c = new CentroImpl2(nombre,direccion, NumeroPlantas, NumeroSotanos);

			}else{
				 c = new CentroImpl(nombre,direccion, NumeroPlantas, NumeroSotanos);
				
			}
			
		
			actualiza(c);
			return c;
			
		}
		
	
		private static void actualiza(Centro c) {

			
	
			setCentro.add(c);
			numeroPlantas += c.getNumeroPlantas();
			numeroSotanos += c.getNumeroSotanos();
			obtenerNumeroMax(c);	
		}
		
		private static void obtenerNumeroMax(Centro c) {
			
			if(PlantaMax == null || PlantaMax < c.getNumeroPlantas()){
				PlantaMax = c.getNumeroPlantas();
			}
			
			if(SotanoMax == null || SotanoMax < c.getNumeroSotanos()){
				SotanoMax = c.getNumeroSotanos();
			}
			
		}

		public static Centro CreateCentro(Centro c){
			Centro copia = new CentroImpl(c.getNombre(),c.getDireccion(),c.getNumeroPlantas(),c.getNumeroSotanos());
			actualiza(copia);
			return copia;
			
		}
		
	
		public static Integer getNumCentrosCreados(){
			
			return setCentro.size();	
		}
		
		
		public static Set<Centro> getCentrosCreados(){
			return new HashSet<Centro>(setCentro);
		}
		
		
		public static Integer getMaxPlantas(){
			return PlantaMax;
			
		}
		
		public static Integer getMaxSotanos(){
			return SotanoMax;
			
		}
		
		public static Double getMediaPlantas(){
		if(setCentro.size() == 0){
		return 0.0;
			
		}else{
			return 1.0*numeroPlantas/setCentro.size();
			}
			
		}
		
		public static Double getMediaSotanos(){
			if(setCentro.size() == 0){
				return 0.0;
			}else{
			return 1.0* numeroSotanos/setCentro.size();
			}
		}
		
		
		
		/*********************************DEPARTAMENTO****************************************************/

	

		private static Set<Departamento> setDpto = new HashSet<Departamento>();
		
		public static Departamento createDepartamento(String nombre){
			Departamento d = new DepartamentoImpl(nombre);
			actualiza(d);
			return d;
		}
			
		
		private static void actualiza(Departamento d) {
			setDpto.add(d);
		}
		
		
		
		public static Integer getNumDepartamentosCreados(){
			return setDpto.size();
		}
		
		public static Set<Departamento> getDepartamentosCreados(){
			return new HashSet<Departamento>(setDpto);
		}

	
		
		
	/*********************************DESPACHO****************************************************/


        private static Set<Despacho> setDespacho = new HashSet<Despacho>();
		
		
		public static Despacho createDespacho(String nombre,Integer capacidad,
				Integer planta){
			
			Despacho d = new DespachoImpl(nombre,capacidad,planta);
			actualiza(d);
			return d;
			
		}
		
		private static void actualiza(Despacho d) {
	
			setDespacho.add(d);
			
		}

		public static Despacho createDespacho(Despacho d){
			Despacho copia = new DespachoImpl(d.getNombre(),d.getCapacidad(),d.getPlanta());
		actualiza(copia);
			return copia;
		}
		
		
		
		public static Despacho createDespacho(String s){
			Despacho d = new DespachoImpl(s);
			
			actualiza(d);
			return d;
		}
		
		public static List<Despacho> createDespachos(String fichero){
			List<Despacho> res = leeFichero(fichero, s -> createDespacho(s));
			return res;
		}

		
		

		
/*********************************ESPACIO****************************************************/

		
		private static SortedSet<Espacio> espacios = new TreeSet<Espacio>();
		private static Integer PlantaMaxima = null;
		private static Integer PlantaMinima = null;
		
		public static Espacio createEspacio(TipoEspacio tipo,String nombre,Integer capacidad,Integer planta){
			
			Espacio e = new EspacioImpl( tipo, nombre, capacidad, planta);
		    actualiza(e);
			return e;
			
			
			
		}
		
		
		
		private static void actualiza(Espacio e) {
		
			espacios.add(e);
			obtenerPlanta(e);
			
			
			
		}

		private static void obtenerPlanta(Espacio e) {
		
			
			if(PlantaMaxima == null || PlantaMaxima < e.getPlanta()){
				PlantaMaxima = e.getPlanta();
			}
			
			if(PlantaMinima == null || PlantaMinima > e.getPlanta()){
				PlantaMinima = e.getPlanta();
			}
		
		}

		public static Espacio createEspacio(Espacio e) {
			Espacio copia = new EspacioImpl(e.getTipo(),e.getNombre(),e.getCapacidad(),e.getPlanta());
			actualiza(e);
			return copia;
			
		}
		
		
		
		
		public static Espacio createEspacio(String s){
			
			Espacio e = new EspacioImpl(s);
			
			actualiza(e);
			return e;
		}
		
		public static List<Espacio> createEspacios(String fichero){
			List<Espacio> res = leeFichero(fichero, s -> createEspacio(s));
			return res;
		}

	
		public static Integer getNumEspaciosCreados(){
			return espacios.size();
		}
		
		public static SortedSet<Espacio> getEspaciosCreados(){
			return new TreeSet<Espacio>(espacios);
		}
		
        
		public static Integer getPlantaMayorEspacio(){
			
			if( !setDespacho.isEmpty()){
				
				for(Despacho d : setDespacho){
					
					if(PlantaMaxima == null || PlantaMaxima < d.getPlanta() ){
						PlantaMaxima = d.getPlanta();
					}
					
				}
				
			}
			
			return PlantaMaxima;
		}
		
		
		public static Integer getPlantaMenorEspacio(){
			

			if( !setDespacho.isEmpty()){
				
				for(Despacho d : setDespacho){
					
					if(PlantaMinima == null || PlantaMinima > d.getPlanta() ){
						PlantaMinima = d.getPlanta();
					}
					
				}
				
			}
			
			return PlantaMinima;
			
		}
		
		/*********************************GRADO****************************************************/

	    private static Integer NumeroObligatorias = 0;
	    private static Integer NumeroOptativas = 0;
        private static Integer NumeroTotal = 0;
        private static Set<Grado> setGrado = new HashSet<Grado>();
		
		public static Grado createGrado(String nom,Set<Asignatura> asiob,Set<Asignatura> asiop,Double cre){
			
			Grado g = new GradoImpl( nom, asiob, asiop, cre);
			actualiza(g);
			return g;
			
		}
		
		
		
		private static void actualiza(Grado g) {
	
			setGrado.add(g);
			NumeroObligatorias += g.getAsignaturasObligatorias().size();
			NumeroOptativas += g.getAsignaturasOptativas().size();
			NumeroTotal = NumeroObligatorias + NumeroOptativas;
			
		}

	

		public static Integer getNumGradosCreados(){
			
			return setGrado.size();
		}
		
		public static Set<Grado> getGradosCreados(){
			
			return new HashSet<Grado>(setGrado);
			
		}
		
		public static Double getMediaAsignaturasGrados(){
			
			if(setGrado.size() == 0){
				return 0.0;
			}else{
			return 1.0*NumeroTotal/setGrado.size();
			}
		}
		
		public static Double getMediaAsignaturasObligatoriasGrados(){
			
			if(setGrado.size() == 0){
				return 0.0;
			}else{
			return 1.0*NumeroObligatorias/setGrado.size();
			}
		}
			
		public static Double getMediaAsignaturasOptativasGrados(){
			
			if(setGrado.size() == 0){
				return 0.0;
			}else{
			return 1.0*NumeroOptativas/setGrado.size();
			}
		}


		/*********************************PROFESOR****************************************************/

		
		private static Set<Profesor> setProfes = new HashSet<Profesor>();
		private static Boolean usarProfesorImpl2= false;
		
		
		public static Profesor createProfesor(String dni,String nombre,String apellidos,LocalDate fechanacimiento,
			String email,Categoria categoria,Departamento dep){
			
			Profesor p = null;
			
			if(usarProfesorImpl2){
			
			 p = new ProfesorImpl2( dni,nombre, apellidos, fechanacimiento,
			email, categoria, dep);
			}else{

		   p = new ProfesorImpl( dni,nombre, apellidos, fechanacimiento,
				email, categoria, dep);
			}
			
			
			actualiza(p);
			
			return p;
			
		}
		
		private static void actualiza(Profesor p) {
			setProfes.add(p);
			
		}


		
		public static void setUsarImplementacionMapProfesor(Boolean x){
			
			usarProfesorImpl2 = x;
		}
		
		 public static Profesor createProfesor(Profesor p){
			
			 
			Profesor res = createProfesor(p.getDNI(),p.getNombre(),p.getApellidos(),p.getFechaNacimiento(),p.getEmail()
					,p.getCategoria(),p.getDepartamento());
			
			completaProfesor(res,p);
			
			return res;
			
		}

		

		 private static void completaProfesor(Profesor pnuevo, Profesor pantiguo) {
		
			
			 for(Asignatura a : pantiguo.getAsignaturas()){
				 
				 
				 pnuevo.imparteAsignatura(a, pantiguo.dedicacionAsignatura(a));
				 
			 }
			 
			 for(Tutoria t : pantiguo.getTutorias()){
				 pnuevo.nuevaTutoria(t.getHoraComienzo(),t.getDuracion(), t.getDiaSemana());
			 }
			 
			 
		}

	     
		 public static Integer getNumProfesoresCreados(){
		
			 return setProfes.size();
	}
	
	
		 public static Set<Profesor>  getProfesoresCreados(){
		
		return new HashSet<Profesor>(setProfes);
		
	}
	
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
		 }
	
	
		
