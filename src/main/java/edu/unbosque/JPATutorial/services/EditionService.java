package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.repositories.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Stateless
public class EditionService {

    EditionRepositoryImpl editionRepository;
    BookRepository bookRepository;

    public void saveEdition(Integer edition_id, String description, LocalDate releaseYear, String genre) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);


        Optional<Book> book = bookRepository.findById(edition_id);



        book.ifPresent(a -> {
            a.addEdition(new Edition(edition_id, description,releaseYear,genre));
            bookRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }
    public void deleteEdition(Integer edition_id, Edition edition){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);

        Optional<Book> book = bookRepository.findById(edition_id);

        book.ifPresent(a -> {
            a.deletEdition(edition);
        });


        entityManager.close();
        entityManagerFactory.close();

        return;



    }

    public void mjodifyEdition(Integer id,String genre, String descripcion, LocalDate year){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.modifyEdition(id,genre,descripcion,year);

        entityManager.close();
        entityManagerFactory.close();

    }


}
