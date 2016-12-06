package ro.gov.ithub.stopcozi.api.broadcast;
import io.dropwizard.hibernate.UnitOfWork;
import ro.gov.ithub.stopcozi.api.broadcast.model.Agency;
import ro.gov.ithub.stopcozi.api.broadcast.model.Ticket;
import ro.gov.ithub.stopcozi.api.broadcast.model.Location;
import ro.gov.ithub.stopcozi.api.broadcast.resource.TicketTrackingApi;
import ro.gov.ithub.stopcozi.dao.AgencyDao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;

@Singleton
public class TicketTrackingApiImpl implements TicketTrackingApi{
    @Inject
    private AgencyDao agencyDao;
    
    
    @Override
    @UnitOfWork
    public Response getServiceSuggestions(String searchText, Long  limit) {

        return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
    }
    
    @Override
    @UnitOfWork
    public Response getServices(String searchText, Long  limit) {

        return Response.status(200).build();
    }
    
    @Override
    @UnitOfWork
    public Response getAgencySuggestions(Long serviceId, String searchText, Long  limit) {

        return Response.status(200).build();
    }
        
    @Override
    @UnitOfWork
    public Response getServiceAgencies(Long serviceId, String  searchText, List<Float> deviceLocation, Long radius, Long limit ) {

        return Response.status(200).build();
    }
    
    @Override
    @UnitOfWork
    public Response getServiceAgencyDetails(Long serviceId, Long agencyId, String ticketId ) {

        return Response.status(200).build();
    }
    	

}
