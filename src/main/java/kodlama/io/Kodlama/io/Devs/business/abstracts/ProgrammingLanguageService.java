package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	void insert(ProgrammingLanguage language) throws Exception;  //iş kurallarına uyuyorsa ekle
	void delete(int id);
	void update(int id, String name);
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
}
