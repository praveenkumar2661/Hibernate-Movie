package DTO;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class MovieDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String movie_name;
	private String movie_genre;
	private String movie_language;
	private double movie_rating;
	private double movie_price;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] movie_image;
	@ManyToOne(cascade = CascadeType.ALL)
	private AdminDTO admin;
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
	public String getMovie_language() {
		return movie_language;
	}
	public void setMovie_language(String movie_language) {
		this.movie_language = movie_language;
	}
	public double getMovie_rating() {
		return movie_rating;
	}
	public void setMovie_rating(double movie_rating) {
		this.movie_rating = movie_rating;
	}
	public double getMovie_price() {
		return movie_price;
	}
	public void setMovie_price(double movie_price) {
		this.movie_price = movie_price;
	}
	public byte[] getMovie_image() {
		return movie_image;
	}
	public void setMovie_image(byte[] movie_image) {
		this.movie_image = movie_image;
	}
	public AdminDTO getAdmin() {
		return admin;
	}
	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
