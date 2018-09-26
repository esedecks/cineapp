package mx.ariel.cineapp.model;

import java.util.Date;

public class Horario {
	private int id; 
	private Date fecha; 
	private String hora; //HH:mm
	private String sala; 
	private double precio; 
	private Pelicula pelicula;
	
	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horario(int id, Date fecha, String hora, String sala, double precio, Pelicula pelicula) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.sala = sala;
		this.precio = precio;
		this.pelicula = pelicula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala + ", precio=" + precio
				+ ", pelicula=" + pelicula + "]";
	} 
	
	
	
	
}
