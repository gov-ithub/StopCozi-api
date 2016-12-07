package ro.gov.ithub.stopcozi.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.Query;
import org.junit.Before;
import org.junit.Test;
import ro.gov.ithub.stopcozi.model.repo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by NiBo on 12/1/2016.
 */
public class AgencyDaoTest extends DAOTests {

    AgencyDao agencyDao;

    @Before
    public void initialize() {
        agencyDao = new AgencyDao(sessionFactory);

        // Delete all the old junk...
        getSession().beginTransaction();
        Query q = getSession().createQuery("delete from Agency");
        q.executeUpdate();
        getSession().getTransaction().commit();
    }

    @Test
    public void testAgencies() throws Exception {
        getSession().beginTransaction();

        Category category = new Category();
        category.setName("AAA");
        List<Category> categories = new ArrayList<>();
        categories.add(category);

        Desk desk = new Desk();
        desk.setName("Ghiseul 1");
        Service service = new Service();

        List<Ticket> ticketsInProgress = new ArrayList<>();
        Ticket ticket = new Ticket();
        ticket.setDesk(desk);
        ticket.setIssueDateTime(new Date());
        ticket.setService(service);
        ticket.setStatus(TicketStatus.IN_PROGRESS);
        ticket.setTicketNo("A108");
        ticketsInProgress.add(ticket);


        desk.setTicketsInProgress(ticketsInProgress);
        List<Desk> desks = new ArrayList<>();
        desks.add(desk);

        ServiceSchedule serviceSchedule = new ServiceSchedule();
        serviceSchedule.setDayOfWeek(DayOfWeek.WEDNESDAY);
        serviceSchedule.setStart(new Date());
        serviceSchedule.setEnd(new Date());
        serviceSchedule.setDesks(desks);
        List<ServiceSchedule> workingHours = new ArrayList<>();
        workingHours.add(serviceSchedule);

        service.setCategories(categories);
        service.setName("Service");
        service.setWorkingHours(workingHours);
        service.setLastIssuedTicket("A107");
        service.setTicketLimit("30");
        List<Service> services = new ArrayList<>();
        services.add(service);

        Agency agency = new Agency();
        agency.setDescription("GL");
        agency.setName(RandomStringUtils.randomAlphanumeric(10));
        agency.setAddress("Address");
        agency.setCategories(categories);
        agency.setServices(services);
        agency.setDesks(desks);
        Long id = agencyDao.save(agency);

        Agency savedAgency = agencyDao.findById(id);
        assertNotNull(savedAgency);
        assertEquals(savedAgency.getDescription(), "GL");
        assertNotNull(savedAgency.getCategories());
        assertEquals(savedAgency.getCategories().size(), 1);
        assertNotNull(savedAgency.getServices());
        assertEquals(savedAgency.getServices().size(), 1);
        assertNotNull(savedAgency.getDesks());
        assertEquals(savedAgency.getDesks().size(), 1);

        getSession().getTransaction().commit();
    }

}