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

@WebServlet("/deleteAlbum")
public class deleteAlbum extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String albumIdStr = request.getParameter("id");

        try {
            int albumId = Integer.parseInt(albumIdStr);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaGroupProject");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Album album = em.find(Album.class, albumId);
            if (album != null) {
                em.remove(album);
                em.getTransaction().commit();
                em.close();

                response.sendRedirect("deleteAlbumSuccess.jsp");
                return;
            } else {
                em.getTransaction().rollback();
                em.close();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        response.sendRedirect("showAlbum.jsp");
    }
}
