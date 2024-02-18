package ADMIN;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import DTO.AdminDTO;
@WebServlet("/editAdmin")
public class editAdminDetails extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		String mail = (String)session.getAttribute("mail");
		AdminDAO adao = new AdminDAO();
		AdminDTO adto = adao.findByMail(mail);
		
		
		if(req.getParameter("password").equals(req.getParameter("cpassword")))
		{
			adto.setAdmin_name(req.getParameter("name"));
			adto.setAdmin_contact(Long.parseLong(req.getParameter("contact")));
			adto.setAdmin_mail(mail);
			adto.setAdmin_password(req.getParameter("password"));
			adto.setAdmin_confirm_password(req.getParameter("cpassword"));
			adao.editAdmin(adto, mail);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("awelcome.jsp");
			dispatcher.include(req, resp);
		}
		else
		{
			req.setAttribute("pass", "Both Password and Confirm Password must be same!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("editadmin.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
		
	}
}
