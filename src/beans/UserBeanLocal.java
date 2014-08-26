package beans;

import model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserBeanLocal {
    public User createUser(User user);
    public List<User> findUserByUsername(String username);
}
