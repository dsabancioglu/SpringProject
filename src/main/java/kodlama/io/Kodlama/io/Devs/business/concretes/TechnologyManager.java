package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.create.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.delete.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.update.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {
	
	private TechnologyRepository technologyRepository;

	@Override
	public void add(CreateTechnologyRequest technology) {
		Technology technology_ = new Technology();
		technology_.setName(technology.getName());
		technology_.setLanguage(technology.getLanguage());
		
		technologyRepository.save(technology_);
	}

	@Override
	public void delete(DeleteTechnologyRequest technology) {
		int id = technology.getId();
		Technology technology_ = getById(id);

		technologyRepository.delete(technology_);
	}

	@Override
	public void update(UpdateTechnologyRequest technology) {
		Technology technology_ = getById(technology.getId());
		technology_.setName(technology.getName());
		technology_.setLanguage(technology.getLanguage());
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> getAllTechnologiesResponses = new ArrayList<>();
		
		GetAllTechnologiesResponse getAllTechnologiesResponse = new GetAllTechnologiesResponse();
		
		for(Technology technology: technologies) {
			getAllTechnologiesResponse.setId(technology.getId());
			getAllTechnologiesResponse.setName(technology.getName());
			getAllTechnologiesResponses.add(getAllTechnologiesResponse);
		}
		return getAllTechnologiesResponses;
	}

	@Override
	public Technology getById(int id) {
		List<Technology> technologies = technologyRepository.findAll();
		
		for(Technology technology: technologies) {
			if(id == technology.getId())
				return technology;
		}
		
		return null;
	}

}
