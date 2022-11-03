package kodlama.io.Kodlama.io.Devs.business.requests.technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTechnologyRequest {
	private int programmingLanguageId;
	private String name;
}
