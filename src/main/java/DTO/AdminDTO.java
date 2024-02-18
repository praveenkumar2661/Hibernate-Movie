package DTO;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AdminDTO 
{
	private String admin_name;
	private long admin_contact;
	@Id
	private String admin_mail;
	private String admin_password;
	private String admin_confirm_password;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MovieDTO> movie;
	
	public List<MovieDTO> getMovie() {
		return movie;
	}
	public void setMovie(List<MovieDTO> movie) {
		this.movie = movie;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public long getAdmin_contact() {
		return admin_contact;
	}
	public void setAdmin_contact(long admin_contact) {
		this.admin_contact = admin_contact;
	}
	public String getAdmin_mail() {
		return admin_mail;
	}
	public void setAdmin_mail(String admin_mail) {
		this.admin_mail = admin_mail;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_confirm_password() {
		return admin_confirm_password;
	}
	public void setAdmin_confirm_password(String admin_confirm_password) {
		this.admin_confirm_password = admin_confirm_password;
	}
}
