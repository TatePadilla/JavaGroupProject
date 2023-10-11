/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package controllerSong;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Song;

@WebServlet("/updateSong")
public class updateSong extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String songIdStr = request.getParameter("songId");
        String newSongName = request.getParameter("newSongName");

        try {
            int songId = Integer.parseInt(songIdStr);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaGroupProject");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Song song = em.find(Song.class, songId);

            if (song != null) {
                song.setSongName(newSongName);

                em.getTransaction().commit();
                em.close();

                response.sendRedirect("updateSongSuccess.jsp");
            } else {
                request.setAttribute("errorMessage", "Song not found with ID: " + songId);
                request.getRequestDispatcher("updateSongs.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid song ID format.");
            request.getRequestDispatcher("updateSongs.jsp").forward(request, response);
        }
    }
}
