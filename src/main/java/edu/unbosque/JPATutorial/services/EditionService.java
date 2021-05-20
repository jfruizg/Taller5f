package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class EditionService {

    EditionRepositoryImpl editionRepository;
    BookRepository bookRepository;
    private EntityManager entityManager;

    public List<EditionPOJO> listEditions (){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        List<Edition> editions = editionRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();
        List<EditionPOJO> editionPOJO = new ArrayList<>();

        for (Edition edition: editions){
            editionPOJO.add(new EditionPOJO(
                    edition.getEditionId(),
                    edition.getDescription(),
                    edition.getReleaseYear()
            ));
        }
        return  editionPOJO;
    }


    public Edition saveEdition(Integer id,String des,Integer year) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);

        Edition edition = new Edition(id,des,year);
        Edition persistedEdition = editionRepository.save(edition).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedEdition;

    }
    public void deleteEdition(Integer edition_id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);

        editionRepository.deleteEdition(edition_id);

        entityManager.close();
        entityManagerFactory.close();

        return;



    }

    public void mjodifyEdition(Integer id, String descripcion, Integer year){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.modifyEdition(id,descripcion,year);

        entityManager.close();
        entityManagerFactory.close();

    }


}
