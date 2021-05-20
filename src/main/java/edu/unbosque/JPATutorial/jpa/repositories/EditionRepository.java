package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Edition;

import java.util.List;
import java.util.Optional;

public interface EditionRepository {

    Optional<Edition> findById(Integer i);

    List<Edition> findAll();

    Optional<Edition> save(Edition edition);

    Optional<Edition>findbyEmail(Integer name);

    void deleteEdition(Integer id);

    void modifyEdition(Integer id, String descripcion, Integer year);
}
