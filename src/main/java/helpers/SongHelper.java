/**
 * @author Tate - tlpadilla & Chris Tutje
 * CIS175 - Fall 2023
 * Oct 9, 2023
 */
package helpers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Song;

public class SongHelper {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Albums");
	AlbumHelper albumHelper = new AlbumHelper();
	
	public void add(Song model) {
		EntityManager eManager = emFactory.createEntityManager();
		model.setAlbum(albumHelper.searchAlbumByName(model.getAlbum().getAlbumName()));
		eManager.getTransaction().begin();
		eManager.persist(model);
		eManager.getTransaction().commit();
		eManager.close();
	}
	
	public void delete(Song model) {
		EntityManager eManager = emFactory.createEntityManager();
		eManager.getTransaction().begin();
		eManager.remove(eManager.find(Song.class, model.getSongId()));
	}
	@SuppressWarnings("unchecked")
	public List<Song> show() {
		EntityManager manager = emFactory.createEntityManager();
		List<Song> allItems = manager.createQuery("SELECT i FROM song i").getResultList();
		manager.close();
		return allItems;

	}

	public void update(Song model) {
		EntityManager manager = emFactory.createEntityManager();
		model.setAlbum(albumHelper.searchAlbumByName(model.getAlbum().getAlbumName()));
		Song dbEntity = manager.find(Song.class, model.getSongId());
		manager.getTransaction().begin();
		dbEntity.setSongName(model.getSongName());
		// dbEntity.setSONGATTRIBUTE(model.getSONGATTRIBUTEHERE());  // other possible song attributes
		// dbEntity.setSONGATTRIBUTE(model.getSONGATTRIBUTEHERE()); // other possible song attributes
		dbEntity.setAlbum(model.getAlbum());
		manager.getTransaction().commit();
		manager.close();

	}

	public Song searchFifthWheelByName(String oldSongName) {
		EntityManager manager = emFactory.createEntityManager();
		TypedQuery<Song> query = manager.createQuery("SELECT i FROM song AS i WHERE i.songName = :songName", Song.class);
		query.setParameter("songName", oldSongName);
		Song dbEntity = query.getSingleResult();
		return dbEntity;
	}
	
}
