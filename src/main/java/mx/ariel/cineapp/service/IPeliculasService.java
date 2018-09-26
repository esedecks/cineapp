package mx.ariel.cineapp.service;

import java.util.List;

import mx.ariel.cineapp.model.Pelicula;

public interface IPeliculasService {
	public List<Pelicula>  buscarTodas();
	
	public Pelicula buscarPorId(int idPelicula);
	
	public void insertar(Pelicula pelicula); 
	
	List<String> buscarGeneros(); 
}
