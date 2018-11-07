package mx.ariel.cineapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ariel.cineapp.model.Pelicula;

@Repository(value="iPeliculasRepository")
public interface IPeliculasRepository extends JpaRepository<Pelicula, Integer> {

}
