package ro.gov.ithub.stopcozi.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import ro.gov.ithub.stopcozi.model.repo.Agency;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AgencyDao extends AbstractDAO<Agency> {
    @Inject
    public AgencyDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Long save(Agency agency){
        Agency persistedAgency = persist(agency);

        return persistedAgency.getInternalId();
    }
}
