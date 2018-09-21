package mx.ariel.cineapp.serviceImpl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.ariel.cineapp.model.Banner;
import mx.ariel.cineapp.service.IBannersService;

@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null; 
	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		
		// Ejercicio: Crear una nueva lista enlazada		
		lista = new ArrayList<>(); 
		// Ejercicio: Crear algunos objetos de tipo Banner (estaticos)
		Banner banner = null; 
		for(int i = 0; i<10; i++) {
			banner = new Banner(); 
			banner.setArchivo("archivo"+(i+1)+".jpeg");
			banner.setFecha(new Date());
			banner.setId(i+1);
			banner.setTitulo("titulo"+(i+1));
			lista.add(banner);
		}
		// Ejercicio: Agregar los objetos Banner a la lista
		
	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insertar(Banner banner) {
		
		// Ejercicio: Implementar metodo
		lista.add(banner);
		
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	@Override
	public List<Banner> buscarTodos() {
		// Ejercicio: Implementar metodo
		return lista;
		
	}

}
