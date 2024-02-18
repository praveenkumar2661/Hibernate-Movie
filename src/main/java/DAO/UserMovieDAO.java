package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.UserMovieDTO;

public class UserMovieDAO 
{

	public EntityManagerFactory emf = Persistence.createEntityManagerFactory("praveen");
	public EntityManager em = emf.createEntityManager();
	public EntityTransaction et = em.getTransaction();
	
	public UserMovieDTO userSaveMovie(UserMovieDTO movie)
	{
		et.begin();
		em.persist(movie);
		et.commit();
		return movie;
	}
	
	public UserMovieDTO deleteMovie(int id)
	{
		UserMovieDTO mdto = em.find(UserMovieDTO.class, id);
		et.begin();
		em.remove(mdto);
		et.commit();
		return null;
	}
	
	public UserMovieDTO findById(int id)
	{
		et.begin();
		UserMovieDTO mdto = em.find(UserMovieDTO.class, id);
		et.commit();
		return mdto; 
	}
}
