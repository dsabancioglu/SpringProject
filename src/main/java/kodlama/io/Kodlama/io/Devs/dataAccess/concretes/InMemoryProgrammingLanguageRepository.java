package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository  
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> languages;
	
	public InMemoryProgrammingLanguageRepository() {
		super();
		this.languages = new ArrayList<>();
		languages.add(new ProgrammingLanguage(1, "Java"));
		languages.add(new ProgrammingLanguage(2, "C#"));
		languages.add(new ProgrammingLanguage(3, "Python"));
		languages.add(new ProgrammingLanguage(4, "Javascript"));
	}

	@Override
	public void insert(ProgrammingLanguage language) {
		languages.add(language);
		
	}

	@Override
	public void delete(int id) {
		for(ProgrammingLanguage language: languages) {
			if(language.getId() == id)
				languages.remove(id);
		}
	}

	@Override
	public void update(int id, String name) {
		for(ProgrammingLanguage language: languages) {
			if(language.getId() == id) {
				language.setName(name);
			}
		}
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage language: languages) {
			if(language.getId() == id)
				return language;
		}
		return null;
	}
}
