package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the band database table.
 * 
 */
@Entity
@NamedQuery(name="Band.findAll", query="SELECT b FROM Band b")
public class Band implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private String description;

	@Lob
	private String members;

	//bi-directional many-to-one association to Album
	@OneToMany(mappedBy="band")
	private List<Album> albums;

	public Band() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMembers() {
		return this.members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public List<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Album addAlbum(Album album) {
		getAlbums().add(album);
		album.setBand(this);

		return album;
	}

	public Album removeAlbum(Album album) {
		getAlbums().remove(album);
		album.setBand(null);

		return album;
	}

}