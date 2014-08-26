package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    private String email;

    private String username;

    //bi-directional many-to-one association to Rating
    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    public User(String username, String password, String email, String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    //bi-directional many-to-many association to Group
    @ManyToMany
    @JoinTable(
            name = "user_groups"
            , joinColumns = {
            @JoinColumn(name = "user_id")
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "group_id")
    }
    )
    private List<Group> groups;

    //bi-directional many-to-one association to Comment
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Rating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}