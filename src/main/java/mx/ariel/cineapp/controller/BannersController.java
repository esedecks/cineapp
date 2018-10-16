package mx.ariel.cineapp.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.ariel.cineapp.model.Banner;
import mx.ariel.cineapp.service.IBannersService;
import mx.ariel.cineapp.util.Utileria;

@Controller
@RequestMapping("/banners/")
public class BannersController {

	// Ejercicio: Inyectar instancia de la clase de servicio
	@Autowired
	IBannersService bannerServices; 
	/**
	 * Metodo para mostrar el listado de banners
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		// Ejercicio: Implementar metodo
		
		// Ejercicio: Crear vista listBanners.jsp. Utilizar el archivo listBanners.html de la plantilla 
		List<Banner> listaBanners = bannerServices.buscarTodos(); 
		model.addAttribute("listaBanners", listaBanners); 
		
		return "banners/listBanners";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo Banner
	 * @return
	 */
	@GetMapping("/create")
	public String crear(@ModelAttribute("banner") Banner banner) {
		// Ejercicio: Crear vista formBanner.jsp. Utilizar el archivo formBanner.html de la plantilla 
		return "banners/formBanner";
		
	}
	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Banner banner, 
						  BindingResult result, 
						  RedirectAttributes redirectAttributes, 
						  HttpServletRequest request,
						  @RequestParam("archivoImagen") MultipartFile multipart
							) {
		
		// Ejercicio: Implementar el metodo.
		if(result.hasErrors()) {
			System.out.println("Error al recibir los datos");
			for(ObjectError error :result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "banners/formBanner"; 
		}
		
		 
		
		System.out.println("El banner está llegando "+banner);
		
		if(!multipart.isEmpty()) {
			String nuevoNombreBanner = Utileria.guardarImagen(multipart, request); 
			banner.setArchivo(nuevoNombreBanner);
		}
		
		bannerServices.insertar(banner);
		banner.setId(bannerServices.buscarTodos().size());
		redirectAttributes.addFlashAttribute("mensaje", "El banner se guardó con éxito");
		System.out.println("Se guardó la pelicula correctamente");
		
		return "redirect:/banners/index";
	}	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
		bannerServices.eliminar(idBanner);	
		attributes.addFlashAttribute("mensaje", "Se eliminó el banner con éxito"); 
		return "redirect:/banners/index";
	}	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@GetMapping("/modify/{id}")
	public String modificar(@PathVariable("id") int idBanner, Model model) {
		model.addAttribute("banner", bannerServices.buscarPorId(idBanner)); 
		return "banners/formBanner";
	}	
}