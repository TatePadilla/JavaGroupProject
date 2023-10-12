/**
 * @author Tate - tlpadilla & Chris Tutje
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package helpers;

import java.util.List;

/**
 * @author Tate
 *
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Album;

public class AlbumHelper {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JavaGroupProject");
		
	public void add(Album type) {
		EntityManager manager = emFactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(type);
		manager.getTransaction().commit();
		manager.close();
	}
	public void delete(Album type) {
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		eManager.remove(eManager.find(Album.class, type.getAlbumId()));
		eManager.getTransaction().commit();
		eManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Album> show() {
		EntityManager eManager = emFactory.createEntityManager();
		eManager.clear();
		Query q = eManager.createQuery("SELECT i FROM album i");
		List<Album> allAlbums = q.getResultList();
		eManager.close();
		return allAlbums;

	}

	public void update(Album albumName) {
		EntityManager eManager = emFactory.createEntityManager();
		Album dbEntity = eManager.find(Album.class, albumName.getAlbumId());
		eManager.getTransaction().begin();
		dbEntity.setAlbumName(albumName.getAlbumName());
		dbEntity.setBandName(albumName.getBandName());
		eManager.getTransaction().commit();
		eManager.close();

	}

	public Album searchAlbumByName(String type) {
		EntityManager eManager = emFactory.createEntityManager();
		TypedQuery<Album> query = eManager.createQuery("SELECT i FROM album AS i WHERE i.type = :type", Album.class);
		query.setParameter("type", type);
		Album dbEntity = query.getSingleResult();
		eManager.close();
		return dbEntity;
	}

}
