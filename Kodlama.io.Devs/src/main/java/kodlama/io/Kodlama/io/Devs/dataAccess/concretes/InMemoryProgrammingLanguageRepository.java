package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	private List<ProgrammingLanguage> programmingLanguages;

	public InMemoryProgrammingLanguageRepository() {
		this.programmingLanguages = new ArrayList<ProgrammingLanguage>();
	}

	@Override
	public ProgrammingLanguage create(ProgrammingLanguage programmingLanguage) {
		return programmingLanguages.add(programmingLanguage) ? programmingLanguage : null;
	}

	@Override
	public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.set(getIndexById(programmingLanguage.getId()), programmingLanguage);
		return programmingLanguage;
	}

	@Override
	public ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage) {
		return programmingLanguages.remove(getIndexById(programmingLanguage.getId()));
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguages.stream().filter(pl -> pl.getId() == id).findFirst().orElse(null);
	}

	@Override
	public ProgrammingLanguage getByName(String name) {
		return programmingLanguages.stream().filter(pl -> pl.getName().equals(name)).findFirst().orElse(null);
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	
	private int getIndexById(int id) {
		ProgrammingLanguage programmingLanguage = getById(id);
		return programmingLanguages.indexOf(programmingLanguage);
	}
}
