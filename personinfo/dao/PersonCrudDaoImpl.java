package pl.kurs.personinfo.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.personinfo.model.onetoone.Person;
import pl.kurs.personinfo.model.onetoone.PersonDetails;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonCrudDaoImpl implements PersonCrudDao {


    private EntityManager entityManager;

    public PersonCrudDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Person person) {
        if (person.getPersonDetails() != null && person.getPersonDetails().getId() == null)
            entityManager.persist(person.getPersonDetails());
        entityManager.persist(person);
    }

    @Override
    public Person get(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void update(Person person) {
        if (person.getPersonDetails() != null) {
            PersonDetails pd = entityManager.merge(person.getPersonDetails());
            person.setPersonDetails(pd);
        }
        entityManager.merge(person);

    }

    @Override
    public void delete(Person person) {
        Person personForRemove = entityManager.merge(person);
        entityManager.remove(personForRemove.getPersonDetails());
        entityManager.remove(personForRemove);

    }
}
