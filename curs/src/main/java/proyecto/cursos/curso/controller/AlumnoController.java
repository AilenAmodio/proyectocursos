package proyecto.cursos.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.cursos.curso.entidades.Alumno;
import proyecto.cursos.curso.repo.AlumnoRepository;

@Controller
@RequestMapping ("/")
public class AlumnoController {
	
	@Autowired
	AlumnoRepository alumnoRepo;

	@RequestMapping("/formulario")
		public String formulario (Model model) {
			model.addAttribute("alumno", new Alumno());
			return "/formulario";
		}
	
	@RequestMapping(value = "/save", method = { RequestMethod.POST, RequestMethod.PUT })
	public String save (@RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
			@RequestParam(value = "dni") Long dni, Model model) 
		throws ParseException {
		Alumno alumno = new Alumno(nombre, apellido, dni);
		model.addAttribute("alumno", alumnoRepo.findByNombre(nombre));
		alumnoRepo.save(alumno);
		return "redirect:/listado";
	}
	
	@RequestMapping("/listado") 
	public String list (Model model) {
		model.addAttribute("alumno", alumnoRepo.findAll());
		return "listado";
	}

	
}