package com.matteo.springpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Builder
  public PetType(Long id, String name) {
    super(id);
    this.name = name;
  }

  public PetType() {
  }

  @Override
  public String toString() {
    return name;
  }
}
