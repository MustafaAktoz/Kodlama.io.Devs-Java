package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.GetByIdProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.CreateProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.DeleteProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.UpdateProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	DeleteProgrammingLanguageResponse delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest);
	GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest);
	List<GetAllProgrammingLanguageResponse> getAll();
}
