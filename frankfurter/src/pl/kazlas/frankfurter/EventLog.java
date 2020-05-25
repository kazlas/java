package pl.kazlas.frankfurter;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import pl.kazlas.frankfurter.entity.RateSearchEntity;

/**
 * Implementation of event log
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EventLog {

    @PersistenceContext(unitName = "eventlog-unit", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    public void addSearching(RateSearchEntity rateSearch) {
        entityManager.persist(rateSearch);
    }

 
}
