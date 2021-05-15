package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rent")
@NamedQueries({
        @NamedQuery(name = "Edition.findAll",
                query = "SELECT b FROM Edition b")
})
public class Rent {


    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private Integer rent_id;

    @ManyToOne
    @JoinColumn(name = "email")
    private Customer email;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition_id;

    @Column(name = "renting_date")
    private Date renting_date;

    public Rent() {}

    public Rent(Integer rent_id, Date renting_date) {
        this.rent_id = rent_id;
        this.renting_date = renting_date;
    }

    public Integer getRent_id() {
        return rent_id;
    }

    public void setRent_id(Integer rent_id) {
        this.rent_id = rent_id;
    }

    public Customer getEmail() {
        return email;
    }

    public void setEmail(Customer email) {
        this.email = email;
    }

    public Edition getEdition_id() {
        return edition_id;
    }

    public void setEdition_id(Edition edition_id) {
        this.edition_id = edition_id;
    }

    public Date getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(Date renting_date) {
        this.renting_date = renting_date;
    }


    public void removeEdition(Edition edition){
    }


}
