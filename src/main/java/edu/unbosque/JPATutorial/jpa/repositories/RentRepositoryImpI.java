package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.entities.Rent;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RentRepositoryImpI implements RentRepository{

    private EntityManager entityManager;

    public RentRepositoryImpI(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Rent> findById(Integer library_id){
        Rent rent = entityManager.find(Rent.class, library_id);
        return rent != null ? Optional.of(rent) : Optional.empty();
    }

    @Override
    public Optional<Rent> findByName(String name) {
        Rent rent = entityManager.find(Rent.class, name);
        return rent != null ? Optional.of(rent) : Optional.empty();
    }

    @Override
    public List<Rent> findAll() {
        return entityManager.createQuery("from Rent").getResultList();
    }

    @Override
    public Optional<Rent> save(Rent library) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(library);
            entityManager.getTransaction().commit();
            return Optional.of(library);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void deleteRent(Integer rent_id) {
        Rent rent = entityManager.find(Rent.class, rent_id);
        if (rent != null) {
            try {

                entityManager.getTransaction().begin();

                entityManager.remove(rent);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
