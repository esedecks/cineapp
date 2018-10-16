package mx.ariel.cineapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.ariel.cineapp.model.Pelicula;
import mx.ariel.cineapp.repository.IPeliculasRepository;
import mx.ariel.cineapp.service.IPeliculasService;

@Service
public class PeliculasServiceJPA implements IPeliculasService {

	@Autowired
	private IPeliculasRepository peliculasRepo; 
	
	@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// TODO Auto-generated method stub
		Optional<Pelicula>   optional = peliculasRepo.findById(idPelicula); 
		if(optional.isPresent())
			return optional.get(); 
		return null; 
	}

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula); 
	}

	@Override
	public List<String> buscarGeneros() {
		List<String> generos = new ArrayList<String>(); 
		generos.add("Acción");
		generos.add("Aventuras");
		generos.add("Clásicas");
		generos.add("Comedia y Románticas");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Acción y aventura");
		generos.add("Romántica");
		generos.add("Ciencia Ficción");
		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);;
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	}

	
}
