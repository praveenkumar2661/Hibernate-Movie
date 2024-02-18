package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import DTO.UserDTO;

public class UserDAO
{
	public EntityManagerFactory emf = Persistence.createEntityManagerFactory("praveen");
	public EntityManager em = emf.createEntityManager();
	public EntityTransaction et = em.getTransaction();
	public UserDTO saveUser(UserDTO user)
	{
		et.begin();
		em.persist(user);
		et.commit();
		return user;
	}
	public UserDTO findByMail(String mail)
	{
		et.begin();
		UserDTO user = em.find(UserDTO.class, mail);
		et.commit();
		return user;
	}
	public UserDTO editUser(UserDTO newUser, String mail)
	{
		UserDTO exUser = em.find(UserDTO.class, mail);
		if(exUser != null)
		{
			et.begin();
			em.merge(newUser);
			et.commit();
			return newUser;
		}
		return null;
	}
	public UserDTO deleteUser(String mail)
	{
		et.begin();
		UserDTO user = em.find(UserDTO.class, mail);
		em.remove(user);
		et.commit();
		return user;
	}
}
