package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.constants.Messages;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public ProgrammingLanguage create(ProgrammingLanguage programmingLanguage) throws Exception {
		nameCannotBeDuplicated(programmingLanguage.getName());
		nameCannotBeBlank(programmingLanguage.getName());
		
		return programmingLanguageRepository.create(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage) throws Exception {
		nameCannotBeDuplicated(programmingLanguage.getName());
		nameCannotBeBlank(programmingLanguage.getName());
		
		return programmingLanguageRepository.update(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage) {
		return programmingLanguageRepository.delete(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
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
