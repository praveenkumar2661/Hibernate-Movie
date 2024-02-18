package USER;

import java.io.IOException;
import java.util.Base64;
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
import DAO.UserDAO;
import DAO.UserMovieDAO;
import DTO.AdminDTO;
import DTO.MovieDTO;
import DTO.UserDTO;
import DTO.UserMovieDTO;

@WebServlet("/buyMovie")
@MultipartConfig(maxFileSize = 1024*1024*100)
public class buyMovie extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession();
		UserDAO udao = new UserDAO();
		UserDTO udto = udao.findByMail((String)session.getAttribute("umail"));
		UserMovieDAO mdao = new UserMovieDAO();
		UserMovieDTO mdto = new UserMovieDTO();
		if(req.getParameter("price").equals(req.getParameter("useramount")))
		{	
			String base64Image = req.getParameter("image");
			byte[] imageData = Base64.getDecoder().decode(base64Image);
			mdto.setUmovie_name(req.getParameter("name"));
			mdto.setUmovie_genre(req.getParameter("genre"));
			mdto.setUmovie_language(req.getParameter("lang"));
			mdto.setUmovie_rating(Double.parseDouble(req.getParameter("rating")));
			mdto.setUmovie_price(Double.parseDouble(req.getParameter("price")));
			mdto.setUmovie_image(imageData);
			UserMovieDTO save = mdao.userSaveMovie(mdto);
			List<UserMovieDTO> movie = udto.getUser_movie();
			movie.add(save);
			udao.editUser(udto, (String)session.getAttribute("umail"));
			RequestDispatcher dispatcher = req.getRequestDispatcher("mymovie.jsp");
			dispatcher.include(req, resp);
		}
		else
		{
			req.setAttribute("dummy", "Enter the sufficient amount!!!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("buyMovie.jsp");
			dispatcher.include(req, resp);
		}
		
		
	}
}
