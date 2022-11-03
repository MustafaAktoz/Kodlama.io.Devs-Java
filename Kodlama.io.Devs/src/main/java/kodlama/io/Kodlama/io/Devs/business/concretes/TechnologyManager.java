package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.constants.Messages;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.CreateTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.DeleteTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.technology.UpdateTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private ModelMapper modelMapper;

	public TechnologyManager(TechnologyRepository technologyRepository, ModelMapper modelMapper) {
		this.technologyRepository = technologyRepository;
		this.modelMapper = modelMapper;
		
		//Technical Debt
		TypeMap<CreateTechnologyRequest, Technology> propertyMapper = this.modelMapper.createTypeMap(CreateTechnologyRequest.class, Technology.class);
	    propertyMapper.addMappings(
	    		mapper -> mapper.skip(Technology::setId)
	    );
	}

	@Override
	public CreateTechnologyResponse create(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		nameCannotBeDuplicated(createTechnologyRequest.getName());
		nameCannotBeBlank(createTechnologyRequest.getName());
		
		Technology technology = modelMapper.map(createTechnologyRequest, Technology.class);
		Technology saveTechnologyResult = technologyRepository.save(technology);
		
		CreateTechnologyResponse createTechnologyResponse = modelMapper.map(saveTechnologyResult, CreateTechnologyResponse.class);
		return createTechnologyResponse;
	}

	@Override
	public UpdateTechnologyResponse update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		nameCannotBeDuplicated(updateTechnologyRequest.getName());
		nameCannotBeBlank(updateTechnologyRequest.getName());
		
		Technology technology = modelMapper.map(updateTechnologyRequest, Technology.class);
		Technology saveTechnologyResult = technologyRepository.save(technology);
		
		UpdateTechnologyResponse updateTechnologyResponse = modelMapper.map(saveTechnologyResult, UpdateTechnologyResponse.class);
		return updateTechnologyResponse;
	}

	@Override
	public DeleteTechnologyResponse delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology getReferenceByIdTechnologyResult = technologyRepository.getReferenceById(deleteTechnologyRequest.getId());
		technologyRepository.delete(getReferenceByIdTechnologyResult);
		
		DeleteTechnologyResponse deleteTechnologyResponse = modelMapper.map(getReferenceByIdTechnologyResult, DeleteTechnologyResponse.class);
		return deleteTechnologyResponse;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> findAllTechnologyResult = technologyRepository.findAll();
		return modelMapper.map(findAllTechnologyResult, new TypeToken<List<GetAllTechnologyResponse>>() {}.getType());
	}
	
	private void nameCannotBeDuplicated(String name) throws Exception {
		Technology getByNameTechnologyResult = technologyRepository.getByName(name);
		if(getByNameTechnologyResult != null) throw new Exception(Messages.PROGRAMMING_LANGUAGE_NAME_ALREADY_EXISTS);
	}
	
	//Technical Debt
	private void nameCannotBeBlank(String name) throws Exception {
		if(name.isBlank()) throw new Exception("Programming language name cannot be blank");
	}

}
