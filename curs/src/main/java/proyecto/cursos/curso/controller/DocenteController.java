package proyecto.cursos.curso.controller;

import javax.websocket.server.PathParam;

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
import proyecto.cursos.curso.entidades.Alumno;
import proyecto.cursos.curso.entidades.Curs;
import proyecto.cursos.curso.entidades.Docente;
import proyecto.cursos.curso.repo.DocenteRepository;

@Controller
@RequestMapping ("/")
public class DocenteController {
	
	@Autowired
	DocenteRepository repo;
	
	/*@GetMapping("/")
	public String index	() {
		return "index";
	}*/

	
	@RequestMapping(value = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String save (@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,
			Model model) throws ParseException {
		Docente docente = new Docente();
		docente.setId(repo.count());
		repo.save(docente);
		model.addAttribute("docente", docente);
		return "redirect:/index";
	}
	
	
	@GetMapping ("/docente")
	public String accesoDocente (){
		return "docentes";
	}
	
	/*@GetMapping("/")
	public void okDocentes() {
		repo.findAll();
	}*/
	}
