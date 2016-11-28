package ro.gov.ithub.stopcozi.model.repo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "DESKS")
public class Desk extends Identity {

    private String id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "desk")
    private List<Ticket> ticketsInProgress;

}
