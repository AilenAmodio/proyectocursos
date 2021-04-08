package proyecto.cursos.curso.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value= "ALUMNO") 
public class Alumno extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	public Boolean vacante = true;

		
	public Alumno(String nombre, String apellido, long dni) {
		this.apellido=apellido;
		this.nombre=nombre;
		this.dni=dni;
	}

	public Alumno() {
	}

	@OneToMany
	private List<Curs> cursos= new ArrayList<>();//listado de alumnos

	public boolean isVacante() {
		return vacante;
	}
	public void setVacante(boolean vacante) {
		this.vacante = vacante;
	}
	public List<Curs> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curs> cursos) {
		this.cursos = cursos;
	}
	@Override
	public void setDni(Long dni) {
		super.setDni(dni);
	}
	
	
}
