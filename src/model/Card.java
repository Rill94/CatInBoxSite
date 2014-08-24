package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the card database table.
 * 
 */
@Entity
@NamedQuery(name="Card.findAll", query="SELECT c FROM Card c")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	private double amount;

	private int cvc;

	@Temporal(TemporalType.DATE)
	private Date expiration;

	@Lob
	private String password;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="card")
	private List<Subscription> subscriptions;

	//bi-directional many-to-one association to History
	@ManyToOne
	@JoinColumn(name="history_id")
	private History history;

	public Card() {
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

	public int getCvc() {
		return this.cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setCard(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setCard(null);

		return subscription;
	}

	public History getHistory() {
		return this.history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

}