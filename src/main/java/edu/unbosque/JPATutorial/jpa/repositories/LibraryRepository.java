package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository {

    Optional<Library> findByName(String name);

    Optional<Library> findById(Integer library_id);

    List<Library> findAll();

    Optional<Library> save(Library library);

    void modificarLibreria(String nuevoNombre, String name);

    void deleteLibrary(String name);
}
