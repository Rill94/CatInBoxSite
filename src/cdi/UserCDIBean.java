package cdi;

import beans.AuthBeanLocal;
import model.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Valerie on 23.08.2014.
 */
@Named
@SessionScoped
public class UserCDIBean implements Serializable
{
    @EJB
    private AuthBeanLocal authBeanLocal;

    private Boolean isLogged;
    private String username;
    private String password;
    private User user;


    public String login()
    {
        user = authBeanLocal.login(username, password);
        return "index?faces-redirect=true";
    }

    public String logout()
    {
        String result = authBeanLocal.logout();
        user = null;
        return result;
    }

    public Boolean getIsLogged() {
        if (user != null)
            return true;
        else return false;
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

}
