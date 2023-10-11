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
import model.Album;
import model.Song;

@WebServlet("/addSong")
public class addSong extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String songName = request.getParameter("songName");
        String albumName = request.getParameter("albumName");
        String bandName = request.getParameter("bandName");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaGroupProject");
        EntityManager em = emf.createEntityManager();

        try {
            Album album = em.createQuery("SELECT a FROM album a WHERE a.albumName = :albumName AND a.bandName = :bandName", Album.class)
                .setParameter("albumName", albumName)
                .setParameter("bandName", bandName)
                .getSingleResult();

            Song song = new Song();
            song.setSongName(songName);
            song.setAlbum(album);

            em.getTransaction().begin();
            em.persist(song);
            em.getTransaction().commit();

            request.setAttribute("message", "Song added successfully!");
            request.getRequestDispatcher("addSongSuccess.jsp").forward(request, response);
        } finally {
            em.close();
            emf.close();
        }
    }
}
