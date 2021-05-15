package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer") // Optional
@NamedQueries({
        @NamedQuery(name = "Author.findByName",
                query = "SELECT a FROM Customer a WHERE a.name = :name")
})

public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "email")
    private String  email;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String age;


    @OneToMany(mappedBy = "Customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();


    public Customer() {}

    public Customer(String firs_name, String last_name, String gender , String age) {
        this.first_name= firs_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;

    }


    public String getAuthorId() {
        return first_name;
    }

    public void setCustomer(String firs_name, String last_name, String gender , String age) {
        this.first_name= firs_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;

    }

    public String getName() {
        return first_name;
    }

    public void setName(String name) {
        this.first_name = name;
    }

    public List<Rent> getBooks() {
        return rents;
    }


}
