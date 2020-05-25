package pl.kazlas.frankfurter;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

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

    public List<RateSearchEntity> getAll(){
    	Query query = entityManager.createQuery("SELECT r from RateSearchEntity as r ORDER BY r.date");
        return query.getResultList();
    }
 }
