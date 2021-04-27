package proyecto.cursos.curso.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto.cursos.curso.entidades.Alumno;
import proyecto.cursos.curso.repo.AlumnoRepository;

@Controller
@RequestMapping("/")
public class AlumnoController {

	@Autowired
	AlumnoRepository alumnoRepo;


	@RequestMapping("/formulario")
	public String formulario(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "/formulario";
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST, RequestMethod.PUT })
	public String save(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "apellido") String apellido,
			@RequestParam(value = "dni") Long dni, Model model) throws ParseException {
		Alumno alumno = new Alumno(nombre, apellido, dni);
		model.addAttribute("alumno", alumnoRepo.findByNombre(nombre));
		alumnoRepo.save(alumno);
		return "redirect:/listado";
	}

	@RequestMapping("/listado")
	public String list(Model model) {
		model.addAttribute("alumnos", alumnoRepo.findAll());
		return "listado";
	}

	@RequestMapping(value = "/editar", method = { RequestMethod.POST, RequestMethod.PUT })
	public String edit(@RequestParam(value = "nombre") String nombre, Model model) {
		Optional<Alumno> alumno = alumnoRepo.findByNombre(nombre);
		model.addAttribute("alumno", alumno);
		return "editar";
	}

	/*
	 * @RequestMapping(value = "/editar/{dni}", method = { RequestMethod.POST,
	 * RequestMethod.PUT }) public String edit( @RequestParam(value = "nombre")
	 * String nombre,
	 * 
	 * @RequestParam(value = "apellido") String apellido, @RequestParam(value =
	 * "dni") Long dni,
	 * 
	 * @RequestParam(value = "vacante", required = false) Boolean activo, Model
	 * model) throws ParseException {
	 * 
	 * Optional<Alumno> alumno = alumnoRepo.findByNombre(nombre); // //
	 * alumno.setId(id); // alumno.setNombre(nombre); //
	 * alumno.setApellido(apellido); // alumno.setDni(dni);
	 * 
	 * // return "redirect:/listado"; }
	 */

	/*
	 * @RequestMapping("delete") public String borrar(@RequestParam (value= "dni")
	 * Long dni, Model model) { Alumno alumno = alumnoRepo.findByDni(dni).get();
	 * model.addAttribute("alumno", alumno);
	 * 
	 * return "borrar"; }
	 */

	@PostMapping(value = "/borrar")
	public String borrarAlumno(@RequestParam(value = "dni") Long dni, Model model) {
		try {
			Alumno alu = alumnoRepo.findByDni(dni).get();
			alumnoRepo.delete(alu);

		} catch (Exception e) {

			model.addAttribute("error", "No se pudo eliminar el alumno");

			return "error";

		}

		return "redirect:/listado";
	}

	@GetMapping(value = "/error")
	public String error() {
		return "error";
	}
}
