package USER;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DTO.UserDTO;
@WebServlet("/editUser")
public class editUserDetails extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		String mail = (String)session.getAttribute("umail");
		UserDAO udao = new UserDAO();
		UserDTO udto = udao.findByMail(mail);
		
		
		if(req.getParameter("password").equals(req.getParameter("cpassword")))
		{
			udto.setUser_name(req.getParameter("name"));
			udto.setUser_contact(Long.parseLong(req.getParameter("contact")));
			udto.setUser_mail(mail);
			udto.setUser_password(req.getParameter("password"));
			udto.setUser_confirm_password(req.getParameter("cpassword"));
			udao.editUser(udto, mail);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("uwelcome.jsp");
			dispatcher.include(req, resp);
		}
		else
		{
			req.setAttribute("pass", "Both Password and Confirm Password must be same!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("edituser.jsp");
			dispatcher.include(req, resp);
		}
		
		
		
		
	}
}
