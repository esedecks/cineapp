package mx.ariel.cineapp.service;

import java.util.List;

import mx.ariel.cineapp.model.Banner;


public interface IBannersService {

	public void insertar(Banner banner); 
	List<Banner> buscarTodos();
	public void eliminar(int idBanner); 
	public Banner buscarPorId(int idBanner); 
}
