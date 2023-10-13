/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package controllerSong;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.SongHelper;
import model.Song;

/**
 * @author Tate
 *
 */
@WebServlet("/showSong")
public class showSong extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showSong() {
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
		
		SongHelper helper = new SongHelper();
		
		List<Song> songList = helper.show();
		
		request.setAttribute("allSongs", songList);

		String path = "/showSongs.jsp";
		System.out.println(songList);
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
