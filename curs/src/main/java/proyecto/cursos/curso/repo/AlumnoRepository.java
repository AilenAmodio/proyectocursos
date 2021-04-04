package proyecto.cursos.curso.repo;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import proyecto.cursos.curso.entidades.Alumno;


@Repository
@Transactional
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

	Optional<Alumno> findByNombre(String nombre);
	Optional<Alumno> findByNombreAndApellido (String nombre, String apellido);
}
