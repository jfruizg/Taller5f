package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.entities.Rent;

import java.util.List;
import java.util.Optional;

public interface RentRepository{

    Optional<Rent> findByName(String name);

    Optional<Rent> findById(Integer library_id);

    List<Rent> findAll();

    Optional<Rent> save(Rent library);
}
