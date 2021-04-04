package proyecto.cursos.curso.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proyecto.cursos.curso.entidades.Docente;
import proyecto.cursos.curso.repo.DocenteRepository;

@Controller
@RequestMapping ("/api")
public class DocenteController {
	
	@Autowired
	DocenteRepository repo;
	
	@GetMapping("guardar")
	public String saveDocente(@PathParam (value= "username") String username, @PathParam(value = "password") String password) {
		Docente docente = new Docente();
		docente.setUsername(username);
		docente.setPassword(password);
		repo.save(new Docente()); 
		return "docentes";
	}
	
	@GetMapping ("/docente")
	public String accesoDocente (){
		return "docentes";
	}
	
	/*@GetMapping("/")
	public void okDocentes() {
		repo.findAll();
	}*/
	
	@Bean
	public CommandLineRunner loadDat (DocenteRepository repo ) {
		return (args) -> {
			Docente docente = new Docente("michael", "scott");
			docente.setDni(1234567);
			repo.save(docente);
		};
}
}
