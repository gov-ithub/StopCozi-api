package ro.gov.ithub.stopcozi.model.repo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CATEGORIES")
public class Category extends Identity{

  private String id;

  private String name;

}
