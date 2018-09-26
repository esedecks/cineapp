package mx.ariel.cineapp.model;

import java.util.Arrays;
import java.util.List;

public class Contacto {
	private int id; 
	private String nombre; 
	private String email; 
	private int rating; 
	private String[] generos; 
	private List<String> notificaciones; 
	private String comentarios;
	
	
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Contacto(int id, String nombre, String email, int rating, String[] generos, List<String> notificaciones,
			String comentarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.rating = rating;
		this.generos = generos;
		this.notificaciones = notificaciones;
		this.comentarios = comentarios;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getrating() {
		return rating;
	}


	public void setrating(int rating) {
		this.rating = rating;
	}


	public String[] getGeneros() {
		return generos;
	}


	public void setGeneros(String[] generos) {
		this.generos = generos;
	}


	public List<String> getNotificaciones() {
		return notificaciones;
	}


	public void setNotificaciones(List<String> notificaciones) {
		this.notificaciones = notificaciones;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", email=" + email + ", rating=" + rating + ", generos="
				+ Arrays.toString(generos) + ", notificaciones=" + notificaciones + ", comentarios=" + comentarios
				+ "]";
	}


	



	
	
	
	
	
}
