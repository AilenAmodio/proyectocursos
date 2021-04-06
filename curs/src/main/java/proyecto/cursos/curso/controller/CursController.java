package proyecto.cursos.curso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyecto.cursos.curso.database.SingletonDatabase;
import proyecto.cursos.curso.entidades.Alumno;
import proyecto.cursos.curso.entidades.Curs;
import proyecto.cursos.curso.repo.CursRepository;


@Controller	
@RequestMapping ("/")
public class CursController {
	
	@Autowired
	SingletonDatabase singletonDatabase;
	
	@GetMapping("/index")
	public String back () {
		return "home";
	}
	
	@RequestMapping("/info")
	public String about() {
		return "info";
	}
	
}
