package com.matteo.springpetclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType petType;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

  @Column(name = "birth_date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
  private Set<Visit> visits = new HashSet<>();

  public Pet() {}

  @Builder
  public Pet(
      Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
    super(id);
    this.name = name;
    this.petType = petType;
    this.owner = owner;
    this.birthDate = birthDate;
    if (visits == null || visits.size() > 0 ) {
      this.visits = visits;
    }
  }
}
