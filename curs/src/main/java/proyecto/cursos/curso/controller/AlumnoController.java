package proyecto.cursos.curso.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.cursos.curso.entidades.Alumno;
import proyecto.cursos.curso.entidades.Curs;
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
	public String save(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
		@RequestParam(value = "dni") Long dni,
		Model model) throws ParseException {
		Optional<Alumno> alumno = alumnoRepo.findByNombre(nombre);;
		model.addAttribute("alumno", alumnoRepo.findByNombre(nombre));
		return "redirect:/listado";
	}
	
	@RequestMapping("/listado") 
	public String list (Model model) {
		model.addAttribute("alumno", alumnoRepo.findAll());
		return "listado";
	}

	
}