package mx.ariel.cineapp.serviceImpl;

import org.springframework.stereotype.Service;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.service.INoticiasService;

@Service
public class NoticiasService implements INoticiasService {

	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);
	}
	
	

}
