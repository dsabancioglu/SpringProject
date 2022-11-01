package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
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
	public void insert(ProgrammingLanguage language) throws Exception {
		List<ProgrammingLanguage> languages = repository.getAll();
		
		for(ProgrammingLanguage language1: languages) {
			if(language == null)
				throw new Exception("Programlama dili boş girilemez.");
			if(language1.getName() == language.getName()) 
				throw new Exception("Programlama dili aynı olamaz.");
		}
		repository.insert(language);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	@Override
	public void update(int id, String name) {
		repository.update(id, name);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return repository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return repository.getById(id);
	}

}
