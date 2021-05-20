package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer") // Optional
@NamedQueries({
        @NamedQuery(name = "Customer.findByName",
                query = "SELECT a FROM Customer a WHERE a.first_name = :name")
})

public class Customer {

    @Id
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


    @OneToMany(mappedBy = "email", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();


    public Customer() {}

    public Customer(String firs_name, String last_name, String gender , String age) {
        this.first_name= firs_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;

    }

    public Customer(String email, String first_name, String last_name, String gender, String age) {
        this.email = email;
        this.first_name = first_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
