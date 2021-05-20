package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(String email);

    List<Customer> findAll();

    Optional<Customer> save(Customer author);

    void deletbyemail(String email);

    void modifyByEmail(String email, String name , String apellido,String genero, String age);
}
