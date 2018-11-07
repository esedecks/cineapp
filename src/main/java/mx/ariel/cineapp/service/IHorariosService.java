package mx.ariel.cineapp.service;

import java.util.Date;
import java.util.List;

import mx.ariel.cineapp.model.Horario;

public interface IHorariosService {
	public void insertar(Horario horario); 
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha); 
	List<Horario> buscarTodos(); 
	Horario buscarPorId(int id); 
	public void eliminar(int id); 
	List<Horario> buscarPorFechaAndPeliculaEstatus(Date fecha,String estatus); 
}
