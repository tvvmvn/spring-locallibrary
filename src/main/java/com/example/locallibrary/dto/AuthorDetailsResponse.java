package com.example.locallibrary.dto;

import java.time.LocalDate;

public class AuthorDetailsResponse {
  
  private String name;
  private String birthDate;
  private String deathDate;

  //
  public AuthorDetailsResponse() {}

  // Getters/Setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate != null ? birthDate.toString() : "";
  }

  public String getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(LocalDate deathDate) {
    this.deathDate = deathDate != null ? deathDate.toString() : "";
  }
}