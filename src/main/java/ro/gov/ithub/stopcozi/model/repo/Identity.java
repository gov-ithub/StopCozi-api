package ro.gov.ithub.stopcozi.model.repo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
abstract class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    Long internalId;
}
