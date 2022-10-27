package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	ProgrammingLanguage create(ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage update(ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage);
	ProgrammingLanguage getById(int id);
	ProgrammingLanguage getByName(String name);
	List<ProgrammingLanguage> getAll();
}
