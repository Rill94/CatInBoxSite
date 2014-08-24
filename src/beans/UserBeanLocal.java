package beans;

import model.User;

import javax.ejb.Local;

@Local
public interface UserBeanLocal {
    public User createUser(User user);
}
