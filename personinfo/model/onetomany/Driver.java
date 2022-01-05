package pl.kurs.personinfo.model.onetomany;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_driver")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
    //@JoinColumn(name = "driver_id", referencedColumnName = "id_driver") //to wypierdalamy z powodu dwukierunkowości relacji
    private Set<Car> cars = new HashSet<>();

    public void addCar(Car car) {
        car.setDriver(this);
        cars.add(car);
    }


    public Driver() {
    }


    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Car> getCars() {
        return cars;
    }
}
