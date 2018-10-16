package mx.ariel.cineapp.service;

import java.util.Date;
import java.util.List;

import mx.ariel.cineapp.model.Horario;

public interface IHorariosService {
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha); 
}
