package proyecto.cursos.curso.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import proyecto.cursos.curso.entidades.Persona;


@Getter
@Setter
@Entity
@DiscriminatorValue(value= "ALUMNO") 
public class Alumno extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private boolean vacante= true;
	
	public Alumno(String nombre, String apellido) {
		super(nombre, apellido);
}
	public Alumno() {
		
	}
}
