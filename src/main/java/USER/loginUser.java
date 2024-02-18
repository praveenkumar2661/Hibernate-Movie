package USER;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Session;

import DAO.UserDAO;
import DTO.UserDTO;
@WebServlet("/ulogin")
public class loginUser extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");
		HttpSession session = req.getSession();
		session.setAttribute("umail", mail);
		UserDAO uf = new UserDAO();
		PrintWriter pw = resp.getWriter();
		UserDTO user = uf.findByMail(mail);
		
		if(user != null)
		{
			String password = user.getUser_password();
			if(pass.equals(password))
			{
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("uwelcome.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "Invalid Password");
				RequestDispatcher dispatcher = req.getRequestDispatcher("ulogin.jsp");
				dispatcher.include(req, resp);
			}
		}
		else
		{
			req.setAttribute("message", "Invalid MailID");
			RequestDispatcher dispatcher = req.getRequestDispatcher("ulogin.jsp");
			dispatcher.include(req, resp);
		}
	}
}
