package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.create.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.delete.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.update.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	void add(CreateLanguageRequest language) throws Exception;  //iş kurallarına uyuyorsa ekle --> entity yi kullanıcıya gösterme buralara rquest response ekle
	void delete(DeleteLanguageRequest language);
	void update(UpdateLanguageRequest language);
	List<GetAllLanguagesResponse> getAll();
	ProgrammingLanguage getById(int id);
}
