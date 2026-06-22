package com.example.locallibrary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;

  private String name;

  //
  public Genre() {};

  public Genre(String name) {
    this.name = name;
  };

  // Getters
  public long getId() {
    return id;
  }

  public String getName() {
    return this.name;
  }
}