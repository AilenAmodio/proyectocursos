package proyecto.cursos.curso.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.cursos.curso.entidades.Docente;
import proyecto.cursos.curso.repo.DocenteRepository;

@Controller
@RequestMapping ("/")
public class DocenteController {
	
	@Autowired
	private DocenteRepository docenteRepo;
	
	@RequestMapping("/ingreso")
	public String formulario (Model model) {
		model.addAttribute("docente", new Docente());
		return "/docentes";
	}
	
	@RequestMapping(value = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String save (@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, 
			@PathParam (value = "id") Long dni,	Model model) throws ParseException {
		Docente docente = new Docente(username, password, dni);
		model.addAttribute("docente", docenteRepo.findByUsername(username));
		docenteRepo.save(docente);
		return "/vistaDocente";
	}
	
	@RequestMapping("/vistaDocente") 
	public String list (Model model) {
		model.addAttribute("docente", docenteRepo.findAll());
		return "redirect:/vistaDocente";
	}

	
	@GetMapping ("/docente")
	public String accesoDocente (){
		return "docentes";
	}
}
