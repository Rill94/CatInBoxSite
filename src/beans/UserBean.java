package beans;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserBean extends AbstractFacade<User> implements UserBeanLocal
{
    public UserBean()
    {}

    @PersistenceContext(name = "persistence/catinbox", unitName = "CatinboxPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public User createUser(User user)
    {
        return create(user);
    }

    public List<User> findUserByUsername(String username)
    {
        Query query = entityManager.createQuery("select u from User u where u.username=:username");
        query.setParameter("username", username);
        List<User> userList = query.getResultList();
        return userList;
    }
}
