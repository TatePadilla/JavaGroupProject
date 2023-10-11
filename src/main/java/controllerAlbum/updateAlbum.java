/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package controllerAlbum;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.persistence.*;
import java.io.IOException;
import model.Album;

@WebServlet("/updateAlbum")
public class updateAlbum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String albumIdStr = request.getParameter("id");
        String newAlbumName = request.getParameter("albumName");
        String newBandName = request.getParameter("bandName");

        try {
            int albumId = Integer.parseInt(albumIdStr);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaGroupProject");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Album album = em.find(Album.class, albumId);
            if (album != null) {
                album.setAlbumName(newAlbumName);
                album.setBandName(newBandName);

                em.getTransaction().commit();
                em.close();

                response.sendRedirect("updateAlbumSuccess.jsp");
                return;
            } else {
                em.getTransaction().rollback();
                em.close();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        response.sendRedirect("updateAlbumSuccess.jsp");
    }
}
