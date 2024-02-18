package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.MovieDTO;

public class MovieDAO 
{
	public EntityManagerFactory emf = Persistence.createEntityManagerFactory("praveen");
	public EntityManager em = emf.createEntityManager();
	public EntityTransaction et = em.getTransaction();
	
	public MovieDTO saveMovie(MovieDTO movie)
	{
		et.begin();
		em.persist(movie);
		et.commit();
		return movie;
	}
	
	public MovieDTO deleteMovie(int id)
	{
		MovieDTO mdto = em.find(MovieDTO.class, id);
		et.begin();
		em.remove(mdto);
		et.commit();
		return null;
	}

	public MovieDTO findByID(int id)
	{
		et.begin();
		MovieDTO mdto = em.find(MovieDTO.class, id);
		et.commit();
		return mdto; 
	}
	
	public List<MovieDTO> findAll()
	{
		String queryString = "SELECT e FROM MovieDTO e";
		List<MovieDTO> resultList = em.createQuery(queryString, MovieDTO.class).getResultList();
		return resultList;
	}
}
