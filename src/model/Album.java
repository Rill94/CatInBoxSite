package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the album database table.
 * 
 */
@Entity
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Lob
	private String genre;

	@Lob
	private String title;

	//bi-directional many-to-one association to Band
	@ManyToOne
	@JoinColumn(name="band_id")
	private Band band;

	//bi-directional many-to-one association to Song
	@OneToMany(mappedBy="album")
	private List<Song> songs;

	public Album() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Band getBand() {
		return this.band;
	}

	public void setBand(Band band) {
		this.band = band;
	}

	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Song addSong(Song song) {
		getSongs().add(song);
		song.setAlbum(this);

		return song;
	}

	public Song removeSong(Song song) {
		getSongs().remove(song);
		song.setAlbum(null);

		return song;
	}

}