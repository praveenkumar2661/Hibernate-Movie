package USER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DTO.UserDTO;
@WebServlet("/usignup")
public class saveUser extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		long contact = Long.parseLong(req.getParameter("num"));
		String mail = req.getParameter("mail").toLowerCase();
		String pass = req.getParameter("pass");
		String cpass = req.getParameter("cpass");
		PrintWriter pw = resp.getWriter();
		if(pass.equals(cpass))
		{
			UserDAO udao = new UserDAO();
			UserDTO find = udao.findByMail(mail);
			
			if(find == null)
			{
				UserDTO udto = new UserDTO();
				udto.setUser_name(name);
				udto.setUser_contact(contact);
				udto.setUser_mail(mail);
				udto.setUser_password(pass);
				udto.setUser_confirm_password(cpass);
				
				udao.saveUser(udto);
				
				if(udao != null)
				{
					RequestDispatcher dispatcher = req.getRequestDispatcher("user.jsp");
					dispatcher.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("message", "User already exist!!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("usignup.jsp");
				dispatcher.include(req, resp);
			}
		}
		else
		{
			req.setAttribute("message", "Password and Confirm Password must be same!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("usignup.jsp");
			dispatcher.include(req, resp);
		}
	}
}
