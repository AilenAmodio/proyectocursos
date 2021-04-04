package proyecto.cursos.curso.entidades;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Admi extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;

	public Admi(String nombre, String apellido) {
		super(nombre, apellido);
	}
}
