package kodlama.io.Kodlama.io.Devs.webApi.controlllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages/")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@PostMapping("create")
	public ProgrammingLanguage create(ProgrammingLanguage programmingLanguage) throws Exception {
		return programmingLanguageService.create(programmingLanguage);
	}
	
	@PostMapping("update")
	public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage) throws Exception {
		return programmingLanguageService.update(programmingLanguage);
	}
	
	@PostMapping("delete")
	public ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage) {
		return programmingLanguageService.delete(programmingLanguage);
	}
	
	@GetMapping("getById")
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageService.getById(id);
	}
	
	@GetMapping("getAll")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}
}
