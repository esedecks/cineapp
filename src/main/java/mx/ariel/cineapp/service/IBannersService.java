package mx.ariel.cineapp.service;

import java.util.List;

import mx.ariel.cineapp.model.Banner;


public interface IBannersService {

	void insertar(Banner banner); 
	List<Banner> buscarTodos();
	
}
