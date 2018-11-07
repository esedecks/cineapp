package mx.ariel.cineapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ariel.cineapp.model.Banner;
import mx.ariel.cineapp.repository.IBannerRepository;
import mx.ariel.cineapp.service.IBannersService;
@Service
public class BannerServiceJPA implements IBannersService{

	@Autowired
	IBannerRepository bannerRepo; 
	@Override
	public void insertar(Banner banner) {
		bannerRepo.save(banner); 
	}

	@Override
	public List<Banner> buscarTodos() {
		return bannerRepo.findAll();
	}

	@Override
	public void eliminar(int idBanner) {
		bannerRepo.deleteById(idBanner);
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		Optional<Banner> bannerOption = bannerRepo.findById(idBanner); 
		if(bannerOption.isPresent())
			return bannerOption.get(); 
		return null;
	}

	@Override
	public List<Banner> buscarActivos() {
		return bannerRepo.buscarActivos();
	}
	
	

}
