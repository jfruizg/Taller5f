package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class LibraryRepositoryImpl implements LibraryRepository {

    private EntityManager entityManager;

    public LibraryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Library> findById(Integer library_id){
        Library library = entityManager.find(Library.class, library_id);
        return library != null ? Optional.of(library) : Optional.empty();
    }

    @Override
    public Optional<Library> findByName(String name) {
        Library library = entityManager.find(Library.class, name);
        return library != null ? Optional.of(library) : Optional.empty();
    }

    @Override
    public List<Library> findAll() {
        return entityManager.createQuery("from Library").getResultList();
    }

    @Override
    public Optional<Library> save(Library library) {
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
    public void deleteById(Integer library_id) {
        Library library = entityManager.find(Library.class, library_id);
        if (library != null) {
            try {

                entityManager.getTransaction().begin();

                library.getEditions().forEach(edition -> {
                    entityManager.remove(edition);
                });

                entityManager.remove(library);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void modifyById(Integer id,String name){
        Library library = entityManager.find(Library.class, id);
        if (library != null) {
            try {

                entityManager.getTransaction().begin();
                library.setName(name);
                library.getEditions().forEach(edition -> {
                    entityManager.refresh(edition);
                });

                entityManager.merge(library);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
