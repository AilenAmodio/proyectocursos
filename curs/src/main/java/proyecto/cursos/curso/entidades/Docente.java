package proyecto.cursos.curso.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Setter
@Getter
@Entity 
@Table (name = "DOCENTES")
public class Docente extends Persona implements Serializable{

	protected static final long serialVersionUID = 1L;
	public String username;
	public String password;

	@OneToMany
	private List <Curs> cursos = new ArrayList<>();
	
	public Docente(Long dni, String username, String password) {
		this.username = username;
		this.password = password;
		this.dni=dni;
	}

	public Docente () {		
	}
}	
	
