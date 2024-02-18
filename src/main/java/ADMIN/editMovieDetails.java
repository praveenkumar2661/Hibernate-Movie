package ADMIN;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.MovieDAO;
import DTO.MovieDTO;
@WebServlet("/editMovieDetails")
@MultipartConfig(maxFileSize = 1024*1024*100)
public class editMovieDetails extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		MovieDAO mdao = new MovieDAO();
		MovieDTO mdto = mdao.findByID(Integer.parseInt((String) session.getAttribute("movieID")));
		mdto.setMovie_name(req.getParameter("name"));
		mdto.setMovie_genre(req.getParameter("genre"));
		mdto.setMovie_language(req.getParameter("lang"));
		mdto.setMovie_price(Double.parseDouble(req.getParameter("price")));
		mdto.setMovie_rating(Double.parseDouble(req.getParameter("rating")));
		
		Part image = req.getPart("img");
		
		if(image.getSize()>0)
		{
			byte[] img = image.getInputStream().readAllBytes();
			mdto.setMovie_image(img);
		}
		
		mdao.saveMovie(mdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("awelcome.jsp");
		dispatcher.include(req, resp);
	}
}
