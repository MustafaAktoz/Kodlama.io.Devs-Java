package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public CreateProgrammingLanguageResponse create(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
		nameCannotBeDuplicated(createProgrammingLanguageRequest.getName());
		nameCannotBeBlank(createProgrammingLanguageRequest.getName());
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		ProgrammingLanguage saveProgrammingLanguageResult = programmingLanguageRepository.save(programmingLanguage);
		
		CreateProgrammingLanguageResponse createProgrammingLanguageResponse = new CreateProgrammingLanguageResponse();
		createProgrammingLanguageResponse.setId(saveProgrammingLanguageResult.getId());
		createProgrammingLanguageResponse.setName(saveProgrammingLanguageResult.getName());
		return createProgrammingLanguageResponse;
	}

	@Override
	public UpdateProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		nameCannotBeDuplicated(updateProgrammingLanguageRequest.getName());
		nameCannotBeBlank(updateProgrammingLanguageRequest.getName());
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(updateProgrammingLanguageRequest.getId());
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		ProgrammingLanguage saveProgrammingLanguageResult = programmingLanguageRepository.save(programmingLanguage);
		
		UpdateProgrammingLanguageResponse updateProgrammingLanguageResponse = new UpdateProgrammingLanguageResponse();
		updateProgrammingLanguageResponse.setId(saveProgrammingLanguageResult.getId());
		updateProgrammingLanguageResponse.setName(saveProgrammingLanguageResult.getName());
		return updateProgrammingLanguageResponse;
	}

	@Override
	public DeleteProgrammingLanguageResponse delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(deleteProgrammingLanguageRequest.getId());
		programmingLanguageRepository.delete(programmingLanguage);
		
		DeleteProgrammingLanguageResponse deleteProgrammingLanguageResponse = new DeleteProgrammingLanguageResponse();
		deleteProgrammingLanguageResponse.setId(programmingLanguage.getId());
		deleteProgrammingLanguageResponse.setName(programmingLanguage.getName());
		return deleteProgrammingLanguageResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(GetByIdProgrammingLanguageRequest getByIdProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getReferenceById(getByIdProgrammingLanguageRequest.getId());
		
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = new GetByIdProgrammingLanguageResponse();
		getByIdProgrammingLanguageResponse.setId(programmingLanguage.getId());
		getByIdProgrammingLanguageResponse.setName(programmingLanguage.getName());
		return getByIdProgrammingLanguageResponse;
	}

	@Override
	public List<GetAllProgrammingLanguageResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		return programmingLanguages.stream().map(pl-> new GetAllProgrammingLanguageResponse(pl.getId(),pl.getName())).collect(Collectors.toList());
	}

	private void nameCannotBeDuplicated(String name) throws Exception {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.getByName(name);
		if(programmingLanguage != null) throw new Exception(Messages.PROGRAMMING_LANGUAGE_NAME_ALREADY_EXISTS);
	}
	
	//Technical Debt
	private void nameCannotBeBlank(String name) throws Exception {
		if(name.isBlank()) throw new Exception("Programming language name cannot be blank");
	}
}
