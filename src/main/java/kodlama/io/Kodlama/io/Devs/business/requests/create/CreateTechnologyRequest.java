package kodlama.io.Kodlama.io.Devs.business.requests.create;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTechnologyRequest {
	private String name;
	private ProgrammingLanguage language;
}
