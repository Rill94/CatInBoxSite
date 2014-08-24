package beans;

import model.User;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Valerie on 10.08.2014.
 */
@Stateless
public class AuthBean implements AuthBeanLocal
{
    public AuthBean(){}

    @PersistenceContext(name = "persistence/catinbox", unitName = "CatinboxPU")
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    private static Logger logger = Logger.getLogger(AuthBean.class.getName());
    private FacesContext context = FacesContext.getCurrentInstance();
    private HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();


    public String logout()
    {
        String result="/pages/index?faces-redirect=true";
        try
        {
            request.logout();

        } catch (ServletException e) {
            logger.log(Level.SEVERE,"Failed to logout user", e);
            result = "/error?faces-redirect=true";
        }
        return result;
    }

    public User login(String username, String password)
    {
        User user = null;
        try
        {
            if (username != null && password != null) {
                Query query = entityManager.createQuery("SELECT u from User u where u.username = :username and u.password = :password");
                query.setParameter("username", username);
                query.setParameter("password", getMD5(password));
                user = (User) query.getSingleResult();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Failed to login user", e);
        }
        return user;
    }

    public void checkRow()
    {
        boolean isUserAdmin = FacesContext.getCurrentInstance().getExternalContext().isUserInRole("ADMIN");
        boolean isUserUser = FacesContext.getCurrentInstance().getExternalContext().isUserInRole("USER");
        String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        Principal userPrincipal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        System.out.print("");
    }

    private String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
