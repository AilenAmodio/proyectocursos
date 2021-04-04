package proyecto.cursos.curso.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import proyecto.cursos.curso.entidades.Alumno;
import proyecto.cursos.curso.repo.AlumnoRepository;

@Controller
@RequestMapping ("/api/alumno")
public class AlumnoController {
	@Autowired 
	AlumnoRepository repo;
	
	@GetMapping("guardar")
	public String saveAlumno(@PathParam (value  = "name" )String name, @PathParam (value = "surname") String surmane){
		Alumno alumno = new Alumno();
		alumno.setNombre(name);
		alumno.setApellido(surmane);
		repo.save(new Alumno());
		return "Home";
	}
	
	@GetMapping("/formulario")
	public String home () {
		return "formulario";
	}
	/*@GetMapping("/")
	public void okAlumno() {
		repo.findAll();
	}*/
	
	@Bean
	public CommandLineRunner loadData (AlumnoRepository repo ) {
		return (args) -> {
			Alumno alumno= new Alumno("ailen", "amodio");
			Alumno alumno1= new Alumno("jim", "halpert");
			alumno1.setDni(1232565);
			alumno.setDni(13131225);
			repo.save(alumno1);
			repo.save(alumno);
		};	
}
	
}