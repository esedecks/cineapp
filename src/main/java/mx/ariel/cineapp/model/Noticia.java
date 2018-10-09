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
	String estatus;
	
	public Noticia() {
		System.out.println("Contructor noticia");
		estatus="Activa"; 
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
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}
	
	
	
	
}

