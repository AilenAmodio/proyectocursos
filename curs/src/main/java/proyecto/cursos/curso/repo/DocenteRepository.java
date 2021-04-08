package proyecto.cursos.curso.repo;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.cursos.curso.entidades.Docente;

@Repository
@Transactional
public interface DocenteRepository extends JpaRepository<Docente, Long> {
	
	Optional<Docente> findByUsername(String username);
	
	Optional<Docente> findByDni (Long dni);
	
}
