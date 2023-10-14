/**
 * @author Tate - tlpadilla
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package controllerSong;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.*;
import model.Album;
import model.Song;

@SuppressWarnings("serial")
@WebServlet("/addSong")
public class addSong extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String songName = request.getParameter("songName");
        LocalDate songCreatedDate = LocalDate.parse(request.getParameter("songCreatedDate"));
        int albumId = Integer.parseInt(request.getParameter("albumId"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaGroupProject");
        EntityManager em = emf.createEntityManager();

        try {
            Album album = em.find(Album.class, albumId);
           
            if (album != null) {
                Song song = new Song();
                song.setSongName(songName);
                song.setSongCreatedDate(songCreatedDate);
                song.setAlbum(album);

                em.getTransaction().begin();
                em.persist(song);
                em.getTransaction().commit();

                request.setAttribute("message", "Song added successfully!");
                request.getRequestDispatcher("addSongSuccess.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Album not found, use a valid ID");
                request.getRequestDispatcher("addSongs.jsp").forward(request, response); 
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
