package proyecto.cursos.curso.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table (name = "CURSOS")
@DiscriminatorColumn (name = "CURSO")
public class Curs implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private Long id; //numero de curso
	
	public Curs(int horas, String nombrecurso) {
		// TODO Auto-generated constructor stub
	}
	private Integer hora;
	protected String nombre;
	protected Integer fecha; // duracion ¿meses?
	private Boolean vacantes =true;
	
	@ManyToOne
	private Docente docente;
	

	
}
