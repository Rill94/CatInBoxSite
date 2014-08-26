package beans;

import model.User;

import javax.ejb.Local;

/**
 * Created by Valerie on 23.08.2014.
 */
@Local
public interface AuthBeanLocal
{
    public String logout();
    public User login(String username, String password);
    public String getMD5(String input);
}
