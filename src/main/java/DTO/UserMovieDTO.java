package DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserMovieDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String umovie_name;
	private String umovie_genre;
	private String umovie_language;
	private double umovie_rating;
	private double umovie_price;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] umovie_image;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UserDTO> umovie_user;
	public String getUmovie_name() {
		return umovie_name;
	}
	public void setUmovie_name(String umovie_name) {
		this.umovie_name = umovie_name;
	}
	public String getUmovie_genre() {
		return umovie_genre;
	}
	public void setUmovie_genre(String umovie_genre) {
		this.umovie_genre = umovie_genre;
	}
	public String getUmovie_language() {
		return umovie_language;
	}
	public void setUmovie_language(String umovie_language) {
		this.umovie_language = umovie_language;
	}
	public double getUmovie_rating() {
		return umovie_rating;
	}
	public void setUmovie_rating(double umovie_rating) {
		this.umovie_rating = umovie_rating;
	}
	public double getUmovie_price() {
		return umovie_price;
	}
	public void setUmovie_price(double umovie_price) {
		this.umovie_price = umovie_price;
	}
	public byte[] getUmovie_image() {
		return umovie_image;
	}
	public void setUmovie_image(byte[] umovie_image) {
		this.umovie_image = umovie_image;
	}
	public List<UserDTO> getUmovie_user() {
		return umovie_user;
	}
	public void setUmovie_user(List<UserDTO> umovie_user) {
		this.umovie_user = umovie_user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
