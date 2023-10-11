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

@WebServlet("/addAlbum") 
public class addAlbum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String albumName = request.getParameter("albumName"); 
        String bandName = request.getParameter("bandName");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaGroupProject"); 
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Album album = new Album(); 
        album.setAlbumName(albumName); 
        album.setBandName(bandName);
        
        em.persist(album); 
        em.getTransaction().commit();
        em.close();
        
        response.sendRedirect("addAlbum.jsp"); 
    }
}
