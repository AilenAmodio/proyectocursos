package proyecto.cursos.curso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.cursos.curso.repo.CursRepository;


@Controller	
@RequestMapping ("/")
public class CursController {
	
	@Autowired
	CursRepository repo;
	
	@GetMapping("/index")
	public String back () {
		return "home";
	}
	
	@RequestMapping("/info")
	public String about() {
		return "info";
	}
	
}
