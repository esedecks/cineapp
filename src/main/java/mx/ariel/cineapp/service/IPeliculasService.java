package mx.ariel.cineapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.ariel.cineapp.model.Pelicula;

public interface IPeliculasService {
	public List<Pelicula>  buscarTodas();
	
	public Pelicula buscarPorId(int idPelicula);
	
	public void insertar(Pelicula pelicula); 
	
	List<String> buscarGeneros(); 
	
	public void eliminar(int idPelicula);
	
	public Page<Pelicula> buscarTodas(Pageable page); 
	
	public List<Pelicula>  buscarPorFechaYestatus( Date fecha, String status);
}
