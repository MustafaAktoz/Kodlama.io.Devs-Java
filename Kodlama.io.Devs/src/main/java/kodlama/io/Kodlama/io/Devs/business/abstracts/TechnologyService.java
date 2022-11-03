package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.CreateTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.DeleteTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.UpdateTechnologyResponse;

public interface TechnologyService {
	CreateTechnologyResponse create(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	UpdateTechnologyResponse update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
	DeleteTechnologyResponse delete(DeleteTechnologyRequest deleteTechnologyRequest);
	List<GetAllTechnologyResponse> getAll();
}
