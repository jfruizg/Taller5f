package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepository;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepository;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepositoryImpI;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerServices {

    CustomerRepository customerRepository;

    public List<CustomerPOJO> listCustomer() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpI(entityManager);
        List<Customer> customers = customerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<CustomerPOJO> customerPOJOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerPOJOS.add(new CustomerPOJO(
                    customer.getEmail(),
                    customer.getFirst_name(),
                    customer.getLast_name(),
                    customer.getGender(),
                    customer.getAge()
            ));
        }



        return customerPOJOS;

    }

    public Customer saveCustomer(String email, String first_name,String last_name,String gender,String age) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpI(entityManager);

        Customer customer = new Customer(email,first_name,last_name,gender,age);
        Customer persidedCustomer = customerRepository.save(customer).get();

        entityManager.close();
        entityManagerFactory.close();

        return persidedCustomer;

    }

    public void deleteCustomer(String authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpI(entityManager);

        customerRepository.deletbyemail(authorId);

        entityManager.close();
        entityManagerFactory.close();

    }
    public void modifyCustomer(String email, String first_name,String last_name,String gender,String age){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpI(entityManager);

        customerRepository.modifyByEmail(email,first_name,last_name,gender,age);

        entityManager.close();
        entityManagerFactory.close();

    }
}


