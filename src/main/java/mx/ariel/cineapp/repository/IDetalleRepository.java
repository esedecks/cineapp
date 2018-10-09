package mx.ariel.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ariel.cineapp.model.Detalle;

@Repository("iDetalleRepository")
public interface IDetalleRepository extends JpaRepository<Detalle, Integer> {

}
