package proyecto.cursos.curso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.cursos.curso.entidades.Curs;
import proyecto.cursos.curso.repo.CursRepository;


@Controller	
@RequestMapping ("/api/curso")
public class CursController {
	
	@Autowired
	CursRepository repo;
	
	@GetMapping("/index")
	public String back () {
		return "home";
	}
	/*@GetMapping ("/guardar")
	public void saveCurso() {
		repo.save(new Curs(4, "Ingles"));
		repo.save(new Curs(3, "Programacion"));
	}	*/
	
	@GetMapping("/formulario")
	public String home () {
		return "formulario";
	}
	/*@GetMapping("/")
	public void okCurso () {
		repo.findAll();
	}*/
		
	@Bean
	public CommandLineRunner loadDt (CursRepository repo) {
		return (args) ->{
		};
	}
	
	
}
