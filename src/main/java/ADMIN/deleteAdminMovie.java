package ADMIN;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import DAO.MovieDAO;
import DTO.AdminDTO;
import DTO.MovieDTO;
@WebServlet("/deleteam")
public class deleteAdminMovie extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		int id = Integer.parseInt(req.getParameter("movieID"));
		AdminDAO adao = new AdminDAO();
		AdminDTO adto = adao.findByMail((String) session.getAttribute("mail"));
		MovieDAO mdao = new MovieDAO();
		List<MovieDTO> movie = adto.getMovie();
		int count = 0;
		for(MovieDTO movies: movie)
		{
			if(id==movies.getId())
			{
				movie.remove(count);
				break;
			}
			count++;
		}
		System.out.println(movie);
		adao.editAdmin(adto, (String)session.getAttribute("mail"));
		mdao.deleteMovie(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("awelcome.jsp");
		dispatcher.include(req, resp);
	}
}
