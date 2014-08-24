package beans;

import model.Card;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Valerie on 22.08.2014.
 */
@Stateless
public class CardBean extends AbstractFacade<Card> implements CardBeanLocal
{
    public CardBean()
    {}

    @PersistenceContext(name="persistence/subscription", unitName = "SubscriptionPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
