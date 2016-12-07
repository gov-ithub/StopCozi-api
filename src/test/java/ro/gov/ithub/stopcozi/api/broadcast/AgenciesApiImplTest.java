package ro.gov.ithub.stopcozi.api.broadcast;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;
import ro.gov.ithub.stopcozi.dao.AgencyDao;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import javax.ws.rs.core.MediaType;
/**
 * Created by NiBo on 12/5/2016.
 */
public class AgenciesApiImplTest {

    private static final AgencyDao dao = mock(AgencyDao.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new AgenciesApiImpl(dao))
            .build();

    @Test
    public void testCreateTicket() throws Exception {
        Response response = resources.client().target("/agencies/1/services/1/tickets").request().post(Entity.entity("",MediaType.APPLICATION_JSON_TYPE));
        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.SERVICE_UNAVAILABLE);

    }

    @Test
    public void testUpdateAgency() throws Exception {
        //TODO
    }

    @Test
    public void testUpdateTicket() throws Exception {
        Response response = resources.client().target("/agencies/1/services/1/tickets/1").request().method("PATCH",Entity.entity("",MediaType.APPLICATION_JSON_TYPE));
        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.SERVICE_UNAVAILABLE);
    }
}