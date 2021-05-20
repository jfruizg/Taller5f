package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Edition;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpI implements CustomerRepository{

    private EntityManager entityManager;

    public CustomerRepositoryImpI(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Customer> findById(String id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer != null ? Optional.of(customer) : Optional.empty();
    }

    public List<Customer> findAll() {
        return entityManager.createQuery("from Author").getResultList();
    }

    public Optional<Author> findByName(String name) {
        Author author = entityManager.createNamedQuery("Customer.findByName", Author.class)
                .setParameter("name", name)
                .getSingleResult();
        return author != null ? Optional.of(author) : Optional.empty();
    }

    public Optional<Customer> save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deletbyemail(String email) {
        Customer customer = entityManager.find(Customer.class, email);
        if (customer != null) {
            try {

                entityManager.getTransaction().begin();

                customer.getRents().forEach(book -> {
                    entityManager.remove(book);
                });

                entityManager.remove(customer);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void modifyByEmail(String email, String name , String apellido,String genero, String age){
        Customer customer = entityManager.find(Customer.class, email);
        if (customer != null) {
            try {

                entityManager.getTransaction().begin();
                customer.setFirst_name(name);
                customer.setLast_name(apellido);
                customer.setGender(genero);
                customer.setAge(age);
                entityManager.merge(customer);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}
