package USER;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MovieDAO;
import DAO.UserDAO;
import DTO.MovieDTO;
import DTO.UserDTO;
import DTO.UserMovieDTO;
@WebServlet("/checkMovie")
public class checkMovie extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session =req.getSession();
		session.setAttribute("movieID",  req.getParameter("movieID"));
		MovieDTO mdto = new MovieDAO().findByID(Integer.parseInt((String)session.getAttribute("movieID")));
		UserDTO udto = new UserDAO().findByMail((String)session.getAttribute("umail")); 
		List<UserMovieDTO> movie = udto.getUser_movie(); 
		
		for(UserMovieDTO movies:movie)
		{
			if(movies.getUmovie_name().equals(mdto.getMovie_name()))
			{
				req.setAttribute("message", "Movie alreay in My Movies!!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("uwelcome.jsp");
				dispatcher.include(req, resp);
				return;	
			}	
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("buyMovie.jsp");
		dispatcher.include(req, resp);
		
		
	}
}
