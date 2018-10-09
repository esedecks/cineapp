package mx.ariel.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ariel.cineapp.model.Horario;

@Repository(value="iHorariosRepository")
public interface IHorariosRepository extends JpaRepository<Horario, Integer> {

}
