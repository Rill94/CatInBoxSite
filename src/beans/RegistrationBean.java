package beans;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Valerie on 26.08.2014.
 */
@Stateless
public class RegistrationBean implements RegistrationBeanLocal {
    public RegistrationBean (){}



    @PersistenceContext(name = "persistence/catinbox", unitName = "CatinboxPU")
    private EntityManager entityManager;

    public void createUser(User user)
    {

    }
}
