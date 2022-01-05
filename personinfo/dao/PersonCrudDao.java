package pl.kurs.personinfo.dao;

import pl.kurs.personinfo.model.onetoone.Person;

public interface PersonCrudDao {

    void save(Person person); //create

    Person get(Long id); //read

    void update(Person person); //update

    void delete(Person person); //delete


}
