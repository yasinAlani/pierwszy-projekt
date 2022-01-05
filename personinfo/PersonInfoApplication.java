package pl.kurs.personinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.personinfo.dao.DriverDao;
import pl.kurs.personinfo.dao.PersonCrudDao;
import pl.kurs.personinfo.model.onetomany.Car;
import pl.kurs.personinfo.model.onetomany.Driver;
import pl.kurs.personinfo.model.onetoone.Person;
import pl.kurs.personinfo.model.onetoone.PersonDetails;

@SpringBootApplication
public class PersonInfoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(PersonInfoApplication.class, args);

        //relacja one to one

//        PersonDetails pd1 = new PersonDetails("53636784465", "jozek.mirga@gmail.com", "785489354");
//
//        Person person1 = new Person("Józek", "Mirga", pd1);
//
//        PersonCrudDao peronCrudDao = ctx.getBean(PersonCrudDao.class);
//
//        peronCrudDao.save(person1);
//
//        Person loadedPerson = peronCrudDao.get(1l);
//        System.out.println(loadedPerson);
//
//        person1.getPersonDetails().setEmail("xxxxxxxx");
//        person1.setLastName("Guzik");
//        peronCrudDao.update(person1);
//        System.out.println(peronCrudDao.get(1L));

//        peronCrudDao.delete(person1);


        //relacja one to many

        Driver d1 = new Driver("Adam", "Małysz");
//        d1.getCars().add(new Car("Pagani", "Zonda", "V12", d1));
//        d1.getCars().add(new Car("Mercedes", "C63", "V8 Biturbo", d1));
        d1.addCar(new Car("Pagani", "Zonda", "V12"));
        d1.addCar(new Car("Mercedes", "C63", "V8 Biturbo"));


        DriverDao driverDao = ctx.getBean(DriverDao.class);

        driverDao.save(d1);

        Driver driver = driverDao.get(1L);



        ctx.close();
    }

}
