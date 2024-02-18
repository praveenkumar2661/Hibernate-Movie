package ADMIN;


import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import DAO.AdminDAO;
import DAO.MovieDAO;
import DTO.AdminDTO;
import DTO.MovieDTO;
@WebServlet("/addmovie")
@MultipartConfig(maxFileSize = 1024*1024*100)
public class saveMovie extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		HttpSession session = req.getSession();
		
		Part image = req.getPart("image");
		byte[] imageData = image.getInputStream().readAllBytes();
		
		
		String mail = (String)session.getAttribute("mail");
		
		MovieDTO mdto = new MovieDTO();
		mdto.setMovie_name(req.getParameter("name"));
		mdto.setMovie_genre(req.getParameter("genre"));
		mdto.setMovie_language(req.getParameter("lang"));
		mdto.setMovie_rating(Double.parseDouble(req.getParameter("rating")));
		mdto.setMovie_price(Double.parseDouble(req.getParameter("price")));
		mdto.setMovie_image(imageData);
		
		MovieDAO mdao = new MovieDAO();
		MovieDTO save = mdao.saveMovie(mdto);
		
		AdminDAO af = new AdminDAO();
		AdminDTO admin = af.findByMail(mail);
		
		List<MovieDTO> movie = admin.getMovie();
		movie.add(save);
		af.editAdmin(admin, mail);
		RequestDispatcher dispatcher = req.getRequestDispatcher("awelcome.jsp");
		dispatcher.include(req, resp);
		
	}
}
