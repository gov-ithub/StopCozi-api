package ro.gov.ithub.stopcozi.api.broadcast;

import io.dropwizard.hibernate.UnitOfWork;
import ro.gov.ithub.stopcozi.api.broadcast.model.Agency;
import ro.gov.ithub.stopcozi.api.broadcast.model.Ticket;
import ro.gov.ithub.stopcozi.api.broadcast.resource.AgenciesApi;
import ro.gov.ithub.stopcozi.dao.AgencyDao;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;

@Singleton
public class AgenciesApiImpl implements AgenciesApi{

    @Inject
    private AgencyDao agencyDao;

    @Override
    @UnitOfWork
    public Response createTicket(String agencyId, String serviceId, Ticket ticket) {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }

    @Override
    @UnitOfWork
    public Response updateAgency(String agencyId, Agency agency) {
        ro.gov.ithub.stopcozi.model.repo.Agency repoAgency = Broadcast2RepoAdapter.adaptAgency(agency);
        agencyDao.save(repoAgency);

        return Response.accepted().build();
    }

    @Override
    @UnitOfWork
    public Response updateTicket(String agencyId, String serviceId, String ticketNo, Ticket ticket) {
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }
}
