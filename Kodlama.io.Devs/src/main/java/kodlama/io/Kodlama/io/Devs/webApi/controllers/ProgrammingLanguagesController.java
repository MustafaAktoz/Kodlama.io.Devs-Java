package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.GetByIdProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.CreateProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.DeleteProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.UpdateProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programmingLanguages/")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@PostMapping("create")
	public CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		return programmingLanguageService.create(createProgrammingLanguageRequest);
	}
	
	@PutMapping("update")
	public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		return programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@DeleteMapping("delete")
	public DeleteProgrammingLanguageResponse delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		return programmingLanguageService.delete(deleteProgrammingLanguageRequest);
	}
	
	@GetMapping("getById")
	public GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
		return programmingLanguageService.getById(getByIdProgrammingLanguageRequest);
	}
	
	@GetMapping("getAll")
	public List<GetAllProgrammingLanguageResponse> getAll() {
		return programmingLanguageService.getAll();
	}
}
