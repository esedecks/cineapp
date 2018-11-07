package mx.ariel.cineapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.ariel.cineapp.model.Banner;

public interface IBannerRepository extends JpaRepository<Banner, Integer> {
	
	@Query("select b from Banner b where estatus = 'Activo'")
	List<Banner> buscarActivos(); 
}
