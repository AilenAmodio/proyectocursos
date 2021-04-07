package proyecto.cursos.curso.repo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.cursos.curso.entidades.Alumno;


@Repository
@Transactional
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
	List<Alumno>alumnos =new ArrayList<>();
	
	Optional<Alumno> findByNombre(String nombre);
	
	Optional<Alumno> findByNombreAndApellido (String nombre, String apellido);
	
	List<Alumno> findAll();
	
	List<Alumno> save(Iterable<?>alumno);
	
	
	
	}
