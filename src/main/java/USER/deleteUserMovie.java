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
import DAO.UserMovieDAO;
import DTO.UserDTO;
import DTO.UserMovieDTO;

@WebServlet("/deleteum")
public class deleteUserMovie extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		int id =Integer.parseInt( req.getParameter("movieID"));
		UserDAO udao = new UserDAO();
		UserDTO udto = udao.findByMail((String) session.getAttribute("umail"));
		UserMovieDAO mdao = new UserMovieDAO();
		List<UserMovieDTO> movie = udto.getUser_movie();
		int count = 0;
		for(UserMovieDTO movies: movie)
		{
			if(movies.getId()==id)
			{
				movie.remove(count);
				break;
			}
			count++;
		}
		System.out.println(movie);
		udao.editUser(udto, (String)session.getAttribute("umail"));
		mdao.deleteMovie(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("mymovie.jsp");
		dispatcher.include(req, resp);
	}
}
