package proyecto.cursos.curso.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import proyecto.cursos.curso.entidades.*;
@Repository
@Transactional

public interface CursRepository extends CrudRepository <Curs, Long> {
	
	Optional<Curs> findByNombre(String nombre);
	Optional<Curs> findByNombreAndHora (String nombre, Integer hora);
	
}
