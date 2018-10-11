package mx.ariel.cineapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.ariel.cineapp.model.Noticia;

@Repository("noticiasRepository")
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface INoticiasRepository extends JpaRepository<Noticia, Integer> {
	/*Busca todos 
	 * select * from Noticias; 
	 * */
	List<Noticia> findBy(); 
	/*Busca por estatus 
	 * select * from Noticias where estatus = ? ; 
	 * */
	List<Noticia> findByEstatus(String estatus);
	/*Busca todos 
	 * select * from Noticias where fecha = ? ; 
	 * */
	List<Noticia> findByFecha(Date fecha); 
	
	/*Busca todos 
	 * select * from Noticias where estatys  = ? and fecha = ? ; 
	 * */
	List<Noticia> findByEstatusAndFecha(String estatus,Date fecha); 
	
	/*Busca todos 
	 * select * from Noticias where estatys  = ? and fecha = ?; 
	 * */
	List<Noticia> findByEstatusOrFecha(String estatus,Date fecha); 
	
	/*Busca todos 
	 * SELECT * FROM cineapp.noticias
		where fecha between ? and ? ;
	 * */
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2); 
	List<Noticia> findByIdBetween(Integer i, Integer f); 
}
