/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package controllerAlbum;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helpers.AlbumHelper;

import model.Album;


/**
 * @author Tate
 *
 */
@WebServlet("/showAlbum")
public class showAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showAlbum() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		AlbumHelper helper = new AlbumHelper();

		List<Album> albumList = helper.show();

		request.setAttribute("allAlbums", albumList);

		String path = "/showAlbums.jsp";

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
