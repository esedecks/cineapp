package mx.ariel.cineapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.repository.INoticiasRepository;
import mx.ariel.cineapp.service.INoticiasService;

@Service
public class NoticiasServiceJPA implements INoticiasService{

	@Autowired
	INoticiasRepository noticiasRepository; 
	@Override
	public void guardar(Noticia noticia) {
		noticiasRepository.save(noticia); 
	}

	@Override
	public List<Noticia> buscarTodas() {
		return noticiasRepository.findAll();
	}

	@Override
	public Noticia buscarPorId(int id) {
		Optional<Noticia> optionalNoticia = noticiasRepository.findById(id);
		if(optionalNoticia.isPresent())
			return optionalNoticia.get(); 
		else 
			return null; 
	}

	@Override
	public void eliminar(int id) {
		noticiasRepository.deleteById(id);
	}

	@Override
	public List<Noticia> obtenerUltimasNoticias() {
		return noticiasRepository.findTop3ByEstatusOrderByIdDesc("Activa"); 
	}

}
