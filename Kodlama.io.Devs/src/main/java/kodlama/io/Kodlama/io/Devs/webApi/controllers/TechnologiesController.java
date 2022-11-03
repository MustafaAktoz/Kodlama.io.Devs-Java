package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.CreateTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.DeleteTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.UpdateTechnologyResponse;

@RestController
@RequestMapping("/api/technologies/")
public class TechnologiesController {
	private TechnologyService technologyService;

	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@PostMapping("create")
	public CreateTechnologyResponse create(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		return technologyService.create(createTechnologyRequest);
	}
	
	@PutMapping("update")
	public UpdateTechnologyResponse update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		return technologyService.update(updateTechnologyRequest);
	}
	
	@DeleteMapping("delete")
	public DeleteTechnologyResponse delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		return technologyService.delete(deleteTechnologyRequest);
	}
	
	@GetMapping("getAll")
	public List<GetAllTechnologyResponse> getAll() {
		return technologyService.getAll();
	}
	
}
