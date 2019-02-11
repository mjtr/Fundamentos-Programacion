package fp.grados.tipos;

import java.util.List;

public interface Expediente {

	List<Nota> getNotas();
	Double getNotaMedia();
	Nota getMejorNota();
    List<Nota> getNotasOrdenadasPorAsignatura();
	
	void nuevaNota(Nota n);

}
