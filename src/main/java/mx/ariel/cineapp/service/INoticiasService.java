package mx.ariel.cineapp.service;

import java.util.List;

import mx.ariel.cineapp.model.Noticia;

public interface INoticiasService {
	
	public void guardar(Noticia noticia); 
	
	public List<Noticia> buscarTodas(); 
	
	public Noticia buscarPorId(int id); 
	
	public void eliminar(int id); 
	
	public List<Noticia> obtenerUltimasNoticias(); 
	
}
