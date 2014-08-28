package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the song database table.
 * 
 */
@Entity
@NamedQuery(name="Song.findAll", query="SELECT s FROM Song s")
public class Song implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private double amount;

	private Time length;

	@Lob
	private String title;

    @Temporal(TemporalType.DATE)
    private Date year;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="song")
	private List<Rating> ratings;

	//bi-directional many-to-one association to Album
	@ManyToOne
	@JoinColumn(name="album_id")
	private Album album;

	public Song() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Time getLength() {
		return this.length;
	}

	public void setLength(Time length) {
		this.length = length;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setSong(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setSong(null);

		return rating;
	}

	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

}