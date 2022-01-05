package pl.kurs.personinfo.dao;

import pl.kurs.personinfo.model.onetomany.Driver;

public interface DriverDao {

    void save(Driver driver);
    Driver get(Long id);

}
