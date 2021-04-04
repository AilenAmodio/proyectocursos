package proyecto.cursos.curso.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import proyecto.cursos.curso.entidades.Persona;


@Getter
@Setter
@Entity
@DiscriminatorValue(value= "ALUMNO") 
public class Alumno extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Alumno(String nombre, String apellido) {
		super(nombre, apellido);
}
	public Alumno() {
		
	}
	
	@OneToMany
	private List<Curs> cursos= new ArrayList<>();//listado de alumnos
	
}
