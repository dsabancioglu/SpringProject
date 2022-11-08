package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.create.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.delete.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.update.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageRepository repository;
	
	@Autowired 
	public ProgrammingLanguageManager(ProgrammingLanguageRepository repository) {
		this.repository = repository;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		ProgrammingLanguage language_ = new ProgrammingLanguage(); //mapp
		
		List<ProgrammingLanguage> languages = repository.findAll();
		
		if(createLanguageRequest == null) {
			throw new Exception("Programlama dili boş girilemez.");
		}
		else {
			for(ProgrammingLanguage language: languages) {
				if(createLanguageRequest.getName() == language.getName()) 
					throw new Exception("Programlama dili aynı olamaz.");
			}
			language_.setName(createLanguageRequest.getName());
			repository.save(language_);
		}
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		ProgrammingLanguage language = getById(deleteLanguageRequest.getId());
		
		repository.delete(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		ProgrammingLanguage language = getById(updateLanguageRequest.getId());
		
		language.setName(updateLanguageRequest.getName());
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<GetAllLanguagesResponse> responses = new ArrayList<>();
		List<ProgrammingLanguage> languages = repository.findAll();
		
		GetAllLanguagesResponse getAllLanguagesResponse = new GetAllLanguagesResponse();
		
		for(ProgrammingLanguage language: languages) {
			getAllLanguagesResponse.setId(language.getId());
			getAllLanguagesResponse.setName(language.getName());
			responses.add(getAllLanguagesResponse);
		}
		return responses;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		List<ProgrammingLanguage> languages = repository.findAll();
		
		for(ProgrammingLanguage language: languages) {
			if(language.getId() == id)
				return language;
		}
		return null;
	}

}
