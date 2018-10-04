package mx.ariel.cineapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticias")
public class Noticia {
	//generated value cómo se incrementa la llave primati
	//identity es para mysql, secuence es para oracle
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id; 
	@Column(name="titulo",length=250, nullable=false)
	String titulo;
	@Column(name="fecha")
	Date fecha; 
	@Column(name="detalle")
	String detalle; 
	@Column(name="estatus")
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
		System.out.println("set status");
		this.status = status;
	}
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", status="
				+ status + "]";
	}
	
	
	
	
}

