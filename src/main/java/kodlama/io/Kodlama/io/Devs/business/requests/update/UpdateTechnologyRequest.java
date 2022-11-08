package kodlama.io.Kodlama.io.Devs.business.requests.update;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {
	private int id;
	private String name;
	private ProgrammingLanguage language;
}
