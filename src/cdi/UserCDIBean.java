package cdi;

import beans.AuthBeanLocal;
import model.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
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

    private User login()
    {
        return authBeanLocal.login(username, password);
    }

    public String logout()
    {
        String result = authBeanLocal.logout();
        isLogged = false;
        return result;
    }

    public Boolean getIsLogged() {
        User user = login();
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
