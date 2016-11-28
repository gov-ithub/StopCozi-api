package ro.gov.ithub.stopcozi.model.repo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "SERVICES")
public class Service extends Identity {

  private String id;

  private String name;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "serviceId")
  private List<Category> categories;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "serviceId")
  private List<ServiceSchedule> workingHours;

  private String ticketLimit;

  private String lastIssuedTicket;

}

