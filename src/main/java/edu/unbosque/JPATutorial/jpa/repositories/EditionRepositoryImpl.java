package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.*;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EditionRepositoryImpl implements EditionRepository {

    private EntityManager entityManager;

    public EditionRepositoryImpl(EntityManager entityManager){this.entityManager = entityManager;}

    public Optional<Edition> findById(Integer library_id){
        Edition library = entityManager.find(Edition.class, library_id);
        return library != null ? Optional.of(library) : Optional.empty();
    }

    @Override
    public Optional<Edition> findbyEmail(Integer name) {
        Edition library = entityManager.find(Edition.class, name);
        return library != null ? Optional.of(library) : Optional.empty();
    }

    @Override
    public List<Edition> findAll() {
        return entityManager.createQuery("from Edition ").getResultList();
    }


    public Optional<Edition> save(Edition edition) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(edition);
            entityManager.getTransaction().commit();
            return Optional.of(edition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    @Override
    public void deleteEdition(Integer id) {
        Edition edition = entityManager.find(Edition.class, id);

        if (edition != null) {
            try {

                entityManager.getTransaction().begin();

                edition.getRents().forEach(book -> {
                    entityManager.remove(book);
                });

                entityManager.remove(edition);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void modifyEdition(Integer id, String descripcion, Integer year) {
        Edition edition = entityManager.find(Edition.class, id);
        if (edition != null) {
            try {
                entityManager.getTransaction().begin();
                edition.setReleaseYear(year);
                edition.setDescription(descripcion);


                entityManager.merge(edition);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
