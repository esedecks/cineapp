package mx.ariel.cineapp.model;

import java.util.Date;

import org.springframework.util.SystemPropertyUtils;

public class Noticia {
	int id; 
	String titulo;
	Date fecha; 
	String detalle; 
	String status;
	public Noticia() {
		System.out.println("Contructor noticia");
		status="Activa"; 
		fecha = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		System.out.println("set titulo");
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		System.out.println("set detalle");
		this.detalle = detalle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		System.out.println("set detalle");
		this.status = status;
	}
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", status="
				+ status + "]";
	}
	
	
	
	
}

