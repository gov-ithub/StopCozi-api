package ro.gov.ithub.stopcozi.model.repo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "SERVICE_SCHEDULES")
public class ServiceSchedule extends Identity{

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @Temporal(TemporalType.TIME)
    private Date start;

    @Temporal(TemporalType.TIME)
    private Date end;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceId")
    private List<Desk> desks;

}
