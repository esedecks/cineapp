package mx.ariel.cineapp.model;

public class Detalle {
	private int id ; 
	private String directores; 
	private String actores; 
	private String sinopsis; 
	private String trailer;
	
	public Detalle() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Constuctor detalle");
	}

	public Detalle(int id, String directores, String actores, String sinopsis, String trailer) {
		super();
		this.id = id;
		this.directores = directores;
		this.actores = actores;
		this.sinopsis = sinopsis;
		this.trailer = trailer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirectores() {
		return directores;
	}

	public void setDirectores(String directores) {
		this.directores = directores;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", directores=" + directores + ", actores=" + actores + ", sinopsis=" + sinopsis
				+ ", trailer=" + trailer + "]";
	} 
	
	
	
}
