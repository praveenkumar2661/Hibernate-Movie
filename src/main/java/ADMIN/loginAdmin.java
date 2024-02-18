package ADMIN;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import DTO.AdminDTO;
@WebServlet("/alogin")
public class loginAdmin extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");
		HttpSession session = req.getSession();
		session.setAttribute("mail", mail);
		AdminDAO af = new AdminDAO();
		PrintWriter pw = resp.getWriter();
		AdminDTO admin = af.findByMail(mail);
		
		if(admin != null)
		{
			String password = admin.getAdmin_password();
			if(pass.equals(password))
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("awelcome.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "Invalid Password");
				RequestDispatcher dispatcher = req.getRequestDispatcher("alogin.jsp");
				dispatcher.include(req, resp);
			}
		}
		else
		{
			req.setAttribute("message", "Invalid MailID");
			RequestDispatcher dispatcher = req.getRequestDispatcher("alogin.jsp");
			dispatcher.include(req, resp);
		}
	}
}
