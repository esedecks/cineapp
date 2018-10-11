package mx.ariel.cineapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ariel.cineapp.model.Detalle;
import mx.ariel.cineapp.repository.IDetalleRepository;
import mx.ariel.cineapp.service.IDetalleService;
@Service
public class DetalleServiceJPA implements IDetalleService{
	
	@Autowired
	private IDetalleRepository detalleRepo; 
	
	@Override
	public void insertart(Detalle detalle) {
		detalleRepo.save(detalle); 
	}

}
