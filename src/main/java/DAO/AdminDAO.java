package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import DTO.AdminDTO;

public class AdminDAO 
{
	public EntityManagerFactory emf = Persistence.createEntityManagerFactory("praveen");
	public EntityManager em = emf.createEntityManager();
	public EntityTransaction et = em.getTransaction();
	
	public AdminDTO saveAdmin(AdminDTO admin)
	{
		et.begin();
		em.persist(admin);
		et.commit();
		return admin;
	}

	public AdminDTO findByMail(String mail)
	{
		et.begin();
		AdminDTO admin = em.find(AdminDTO.class, mail);
		et.commit();
		return admin;
	}
	public AdminDTO editAdmin(AdminDTO newUser, String mail)
	{
		AdminDTO exAdmin = em.find(AdminDTO.class, mail);
		if(exAdmin != null)
		{
			et.begin();
			em.merge(newUser);
			et.commit();
			return newUser;
		}
		return null;
	}
	public AdminDTO deleteUser(String mail)
	{
		et.begin();
		AdminDTO admin = em.find(AdminDTO.class, mail);
		em.remove(admin);
		et.commit();
		return admin;
	}
}
