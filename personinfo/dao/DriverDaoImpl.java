package pl.kurs.personinfo.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.personinfo.model.onetomany.Car;
import pl.kurs.personinfo.model.onetomany.Driver;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DriverDaoImpl implements DriverDao{


    private EntityManager entityManager;

    public DriverDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Driver driver) {
        for (Car car : driver.getCars()) {
            if(car != null && car.getId() == null)
                entityManager.persist(car);
        }
        entityManager.persist(driver);

    }

    @Override
    public Driver get(Long id) {
        return entityManager.find(Driver.class, id);
    }
}
