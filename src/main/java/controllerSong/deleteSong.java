/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package controllerSong;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.persistence.*;
import java.io.IOException;
import model.Song;

@WebServlet("/deleteSong")
public class deleteSong extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String songIdStr = request.getParameter("songId");

        try {
            int songId = Integer.parseInt(songIdStr);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaGroupProject");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Song song = em.find(Song.class, songId);
            if (song != null) {
                em.remove(song);
                em.getTransaction().commit();
                em.close();

                response.sendRedirect("deleteSongSuccess.jsp");
                return;
            } else {
                em.getTransaction().rollback();
                em.close();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewSongs.jsp");
    }
}
