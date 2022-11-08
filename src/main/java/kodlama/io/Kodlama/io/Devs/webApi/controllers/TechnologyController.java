package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.create.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.delete.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.update.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	private TechnologyService service;
	
	@Autowired
	public TechnologyController(TechnologyService service) {
		this.service = service;
	}

	@PostMapping("/add")
	public void add(CreateTechnologyRequest technology) {
		service.add(technology);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest technology) {
		service.delete(technology);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest technology) {
		service.update(technology);
	}
	
	@GetMapping("/getAll")
	public List<GetAllTechnologiesResponse> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/getById")
	public Technology getById(int id) {
		return service.getById(id);
	}
}
