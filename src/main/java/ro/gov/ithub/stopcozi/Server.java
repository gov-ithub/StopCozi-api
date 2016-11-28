package ro.gov.ithub.stopcozi;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import ro.gov.ithub.stopcozi.model.repo.*;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class Server extends Application<ServerConfiguration> {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Server.class);

    private final HibernateBundle<ServerConfiguration> hibernateBundle = new HibernateBundle<ServerConfiguration>(
        Agency.class, Category.class, Desk.class, Service.class, ServiceSchedule.class, Ticket.class
    ) {
        @Override
        public DataSourceFactory getDataSourceFactory(ServerConfiguration configuration) {
            return configuration.getDatabase();
        }
    };

    public static void main(String[] args) throws Exception {
        new Server().run(args);
    }

    @Override
    public String getName() {
        return "StopCozi API";
    }

    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);

        bootstrap.addBundle(new AssetsBundle("/swagger-spec", "/api-spec", null));

        bootstrap.addBundle(GuiceBundle.<ServerConfiguration>newBuilder()
            .addModule(new AbstractModule(){
                @Override protected void configure() {}
                @Provides SessionFactory sessionFactoryProvider() { return hibernateBundle.getSessionFactory();}
            })
            .setConfigClass(ServerConfiguration.class)
            .enableAutoConfig(getClass().getPackage().getName())
            .build(Stage.DEVELOPMENT)
        );

        bootstrap.addBundle(new Java8Bundle());

        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
            new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                new EnvironmentVariableSubstitutor(false)
            )
        );
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) throws Exception {
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("crossOriginRequsts", CrossOriginFilter.class);
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
