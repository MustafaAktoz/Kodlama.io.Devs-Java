package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.constants.Messages;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.GetByIdProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.CreateProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.DeleteProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetAllProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.programmingLanguage.UpdateProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapper modelMapper;
	

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, ModelMapper modelMapper) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
		nameCannotBeDuplicated(createProgrammingLanguageRequest.getName());
		nameCannotBeBlank(createProgrammingLanguageRequest.getName());
		
		ProgrammingLanguage programmingLanguage = modelMapper.map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
		ProgrammingLanguage saveProgrammingLanguageResult = programmingLanguageRepository.save(programmingLanguage);
		
		CreateProgrammingLanguageResponse createProgrammingLanguageResponse = modelMapper.map(saveProgrammingLanguageResult, CreateProgrammingLanguageResponse.class);
		return 	createProgrammingLanguageResponse;
	}

	@Override
	public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		nameCannotBeDuplicated(updateProgrammingLanguageRequest.getName());
		nameCannotBeBlank(updateProgrammingLanguageRequest.getName());
		
		ProgrammingLanguage programmingLanguage = modelMapper.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		ProgrammingLanguage saveProgrammingLanguageResult = programmingLanguageRepository.save(programmingLanguage);
		
		UpdateProgrammingLanguageResponse updateProgrammingLanguageResponse = modelMapper.map(saveProgrammingLanguageResult, UpdateProgrammingLanguageResponse.class);
		return updateProgrammingLanguageResponse;
	}

	@Override
	public DeleteProgrammingLanguageResponse delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		ProgrammingLanguage getReferenceByIdProgrammingLanguageResult = programmingLanguageRepository.getReferenceById(deleteProgrammingLanguageRequest.getId());
		programmingLanguageRepository.delete(getReferenceByIdProgrammingLanguageResult);
		
		DeleteProgrammingLanguageResponse deleteProgrammingLanguageResponse = modelMapper.map(getReferenceByIdProgrammingLanguageResult, DeleteProgrammingLanguageResponse.class);
		return deleteProgrammingLanguageResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
		ProgrammingLanguage getReferenceByIdProgrammingLanguageResult = programmingLanguageRepository.getReferenceById(getByIdProgrammingLanguageRequest.getId());
		
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = modelMapper.map(getReferenceByIdProgrammingLanguageResult, GetByIdProgrammingLanguageResponse.class);
		return getByIdProgrammingLanguageResponse;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> findAllProgrammingLanguageResult = programmingLanguageRepository.findAll();
		return modelMapper.map(findAllProgrammingLanguageResult, new TypeToken<List<GetAllProgrammingLanguageResponse>>() {}.getType());
	}

	private void nameCannotBeDuplicated(String name) throws Exception {
		ProgrammingLanguage getByNameProgrammingLanguageResult = programmingLanguageRepository.getByName(name);
		if(getByNameProgrammingLanguageResult != null) throw new Exception(Messages.PROGRAMMING_LANGUAGE_NAME_ALREADY_EXISTS);
	}
	
	//Technical Debt
	private void nameCannotBeBlank(String name) throws Exception {
		if(name.isBlank()) throw new Exception("Programming language name cannot be blank");
	}
}
