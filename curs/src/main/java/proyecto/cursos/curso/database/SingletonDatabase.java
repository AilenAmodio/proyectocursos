package proyecto.cursos.curso.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import proyecto.cursos.curso.entidades.Alumno;
import proyecto.cursos.curso.entidades.Docente;

@Component
@Scope("singleton")
public class SingletonDatabase {
	List<Docente> docentes = new ArrayList<>();
	List<Alumno> alumnos = new ArrayList<>();
	
	public void guardar(Docente docente) {
		docentes.add(docente);
	}
	
	public List<Docente> FindAll() {
		return docentes;
	}
	
	public int size() {
		return docentes.size();
	}
	
	public void save(Alumno alumno) {
		alumnos.add(alumno);
	}
	
	public int count() {
		return alumnos.size();
	}
	
	/*public List<Alumno> findAll() {
		return alumnos;
	}*/
	

	public List<Alumno> findAll() {
		return alumnos.stream().filter(alumno -> alumno.isVacante()).collect(Collectors.toList());
	}
	
}