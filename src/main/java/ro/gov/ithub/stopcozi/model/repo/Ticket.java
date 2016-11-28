package ro.gov.ithub.stopcozi.model.repo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TICKETS")
public class Ticket extends Identity {

    private String ticketNo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDateTime;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "deskId")
    private Desk desk;
}
