package DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class UserDTO
{
	private String user_name;
	private long user_contact;
	@Id
	private String user_mail;
	private String user_password;
	private String user_confirm_password;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UserMovieDTO> user_movie;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public long getUser_contact() {
		return user_contact;
	}
	public void setUser_contact(long user_contact) {
		this.user_contact = user_contact;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_confirm_password() {
		return user_confirm_password;
	}
	public void setUser_confirm_password(String user_confirm_password) {
		this.user_confirm_password = user_confirm_password;
	}
	public List<UserMovieDTO> getUser_movie() {
		return user_movie;
	}
	public void setUser_movie(List<UserMovieDTO> user_movie) {
		this.user_movie = user_movie;
	}
}
