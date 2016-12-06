package serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import ro.gov.ithub.stopcozi.model.repo.Agency;

import java.io.IOException;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by NiBo on 11/13/2016.
 */
public class AgencyTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJSON() throws IOException {
        Agency agency = new Agency();
        agency.setDescription("GL");
        agency.setName("AAA");

        String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/agency.json"), Agency.class));

        assertThat(MAPPER.writeValueAsString(agency)).isEqualTo(expected);
    }

    @Test
    public void deserializesFromJSON() throws Exception {
        Agency agency = new Agency();
        agency.setDescription("GL");
        agency.setName("AAA");

        assertThat(MAPPER.readValue(fixture("fixtures/agency.json"), Agency.class))
                .isEqualTo(agency);
    }
}
