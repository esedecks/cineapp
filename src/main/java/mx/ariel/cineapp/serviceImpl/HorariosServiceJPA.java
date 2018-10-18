package mx.ariel.cineapp.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ariel.cineapp.model.Horario;
import mx.ariel.cineapp.repository.IHorariosRepository;
import mx.ariel.cineapp.service.IHorariosService;

@Service
public class HorariosServiceJPA implements IHorariosService {
	
	@Autowired
	private IHorariosRepository horariosRepo ; 

	@Override
	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
		return horariosRepo.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
	}
	
	@Override
	public List<Horario> buscarTodos() {
		return horariosRepo.findAll();
	}

	@Override
	public void insertar(Horario horario) {
		horariosRepo.save(horario); 
	}

	@Override
	public Horario buscarPorId(int id) {
		Optional<Horario> horarioOptional = horariosRepo.findById(id); 
		if(horarioOptional.isPresent())
			return horarioOptional.get(); 
		return null;
	}

	
	@Override
	public void eliminar(int id) {
		horariosRepo.deleteById(id);
	}
}
