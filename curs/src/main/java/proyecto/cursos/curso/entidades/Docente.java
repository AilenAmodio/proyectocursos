package proyecto.cursos.curso.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Setter
@Getter
@Entity 
@DiscriminatorValue (value= "DOCENTE")
@Table (name = "DOCENTES")
public class Docente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	public String username;
	public String password;

	@OneToMany
	private List <Curs> cursos = new ArrayList<>();
	
	public Docente(String nombre, String apellido, Long dni) {
		super(nombre, apellido, dni);
	}

	protected Docente(Long dni, String username, String password) {
		this.username = username;
		this.password = password;
		this.dni=dni;
	//	this.cursos = cursos;
	}

	
	public Docente () {
		
	}

}	
	
