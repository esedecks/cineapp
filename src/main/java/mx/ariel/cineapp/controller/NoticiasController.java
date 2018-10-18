package mx.ariel.cineapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.ariel.cineapp.model.Noticia;
import mx.ariel.cineapp.service.INoticiasService;

@Controller
@RequestMapping(value="/noticias")
public class NoticiasController {
	
	@Autowired
	INoticiasService noticiasService; 
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute("noticia") Noticia noticia) {
		return "noticias/formNoticia"; 
	}
	
	
	@GetMapping(value="/index")
	public String mostrarIndex(Model model ) {
		model.addAttribute("noticias", noticiasService.buscarTodas()); 
		return "noticias/listNoticias"; 
	}
	
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute("noticia") Noticia noticia,
						 Model model, RedirectAttributes attributes, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Han sucedido algunos errores");
			return "noticias/formNoticia"; 
		}
		noticiasService.guardar(noticia);
		attributes.addFlashAttribute("mensaje", "La noticia se guardó con éxito"); 
		return "redirect:/noticias/index";
	}
	
	@GetMapping("/edit/{id}")
	public String modificar(@PathVariable("id") int idNoticia, Model model) {
		model.addAttribute("noticia", noticiasService.buscarPorId(idNoticia)); 
		return "noticias/formNoticia"; 
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attributes ) {
		noticiasService.eliminar(idNoticia);
		attributes.addFlashAttribute("mensaje", "La noticia se eliminó correctamente"); 
		return "redirect:/noticias/index"; 
	}
}

