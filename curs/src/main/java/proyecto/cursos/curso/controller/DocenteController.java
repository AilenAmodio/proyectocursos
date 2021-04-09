package proyecto.cursos.curso.controller;

import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.cursos.curso.entidades.Docente;
import proyecto.cursos.curso.repo.DocenteRepository;

@Controller
@RequestMapping ("/")
public class DocenteController {
	
	@Autowired
	DocenteRepository docenteRepo;
	
	@RequestMapping("/docentes")
	public String formulario (Model model) {
		model.addAttribute("docente", new Docente());
		return "/docentes";
	}
	
	
	@RequestMapping(value = "/guardar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String guardar (@RequestParam(value = "username") String username , @RequestParam(value = "password") String password, 
			@PathParam (value = "dni") Long dni, Model model)
		throws ParseException {
		Docente docente = new Docente(dni, username, password);
		model.addAttribute("docente", docenteRepo.findByUsername(username));
		docenteRepo.save(docente);
		return "redirect:/vistaDocente";
		
	}
	
	@RequestMapping("/vistaDocente") 
	public String lista (Model model) {
		model.addAttribute("docente", docenteRepo.findAll());
		return "vistaDocente";
	}
}
