package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;


import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	void insert(ProgrammingLanguage language);
	void delete(int id);
	void update(int id, String name);
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
}
