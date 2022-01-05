package pl.kurs.personinfo.model.onetoone;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_details")
public class PersonDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person_details")
    private Long id;

    @Column(unique = true)
    private String pesel;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne(mappedBy = "personDetails") //jak dodamy pole person w PersonDetails to mamy relacje dwukierunkową
    private Person person;

    public PersonDetails() {
    }

    public PersonDetails(String pesel, String email, String phoneNumber) {
        this.pesel = pesel;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }


    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
