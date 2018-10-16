package mx.ariel.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.ariel.cineapp.model.Banner;

public interface IBannerRepository extends JpaRepository<Banner, Integer> {

}
