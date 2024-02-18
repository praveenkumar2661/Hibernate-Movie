package ADMIN;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminDAO;
import DTO.AdminDTO;
@WebServlet("/asignup")
public class saveAdmin extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name").toLowerCase();
		long contact = Long.parseLong(req.getParameter("num"));
		String mail = req.getParameter("mail").toLowerCase();
		String pass = req.getParameter("pass");
		String cpass = req.getParameter("cpass");
		PrintWriter pw = resp.getWriter();
		if(pass.equals(cpass))
		{
			AdminDAO adao = new AdminDAO();
			AdminDTO find = adao.findByMail(mail);
			
			if(find == null)
			{
				AdminDTO adto = new AdminDTO();
				adto.setAdmin_name(name);
				adto.setAdmin_contact(contact);
				adto.setAdmin_mail(mail);
				adto.setAdmin_password(pass);
				adto.setAdmin_confirm_password(cpass);
				
				adao.saveAdmin(adto);
				
				if(adao != null)
				{
					RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
					dispatcher.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("message", "User already exist!!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("asignup.jsp");
				dispatcher.include(req, resp);
			}
		}
		else
		{
			req.setAttribute("message", "Password and Confirm Password must be same!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("asignup.jsp");
			dispatcher.include(req, resp);
		}
	}
}
