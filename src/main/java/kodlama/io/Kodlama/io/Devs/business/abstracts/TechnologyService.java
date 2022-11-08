package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.create.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.delete.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.update.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

public interface TechnologyService {
	void add(CreateTechnologyRequest technology);
	void delete(DeleteTechnologyRequest technology); //ürünü silmek istediğinizden emin misiniz? silmek istediğim ürünü gönderiyorum
	void update(UpdateTechnologyRequest technology);
	List<GetAllTechnologiesResponse> getAll();
	Technology getById(int id);
}
