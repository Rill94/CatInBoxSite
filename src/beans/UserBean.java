package beans;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
