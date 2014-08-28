package cdi;

import beans.AuthBeanLocal;
import beans.UserBeanLocal;
import model.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Valerie on 26.08.2014.
 */
@Named
@SessionScoped
public class RegistrationCDIBean implements Serializable
{
    @EJB
    private AuthBeanLocal authBeanLocal;

    @EJB
    private UserBeanLocal userBeanLocal;

    private String username;

    private String password;
    private String first_name;
    private String last_name;
    private String email;

    public String createUser() {
        User user = new User(username, authBeanLocal.getMD5(password), email, first_name, last_name);
        userBeanLocal.createUser(user);
        return "successreg?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
