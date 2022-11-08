package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.create.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.delete.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.update.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
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
	public List<GetAllLanguagesResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add") 
	public void add(CreateLanguageRequest language) throws Exception{
		programmingLanguageService.add(language);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest technology) {
		programmingLanguageService.delete(technology);
	}
	
	@PutMapping("/update") 
	public void update(UpdateLanguageRequest language) {
		programmingLanguageService.update(language);
	}
	
	@GetMapping("/getById")
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageService.getById(id);
	}
}
