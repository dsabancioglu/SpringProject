package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/languages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getAll")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/insert")  //TODO
	public void insert(ProgrammingLanguage language) throws Exception{
		programmingLanguageService.insert(language);
	}
	
	@DeleteMapping("/delete={id}")
	public void delete(@PathVariable() int id) {
		programmingLanguageService.delete(id);
	}
	
	@PutMapping("/update={id}") //TODO
	public void update(@PathVariable int id, String name) {
		programmingLanguageService.update(id, name);
	}
	
	@GetMapping("/{id}")
	public ProgrammingLanguage getById(@PathVariable() int id) {
		return programmingLanguageService.getById(id);
	}
}
