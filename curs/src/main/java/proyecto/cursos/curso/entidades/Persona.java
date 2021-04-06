package proyecto.cursos.curso.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Entity
@Table (name = "PERSONA")
@DiscriminatorColumn (name = "PERSONA")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	public String nombre;
	public String apellido;
	public Long dni;

	public Persona (String nombre, String apellido,Long dni) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}
	public Persona() {
		// TODO Auto-generated constructor stub
	}
}
