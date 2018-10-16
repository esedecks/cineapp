package mx.ariel.cineapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ariel.cineapp.model.Horario;

@Repository(value="iHorariosRepository")
public interface IHorariosRepository extends JpaRepository<Horario, Integer> {
	
	public List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha); 
}
