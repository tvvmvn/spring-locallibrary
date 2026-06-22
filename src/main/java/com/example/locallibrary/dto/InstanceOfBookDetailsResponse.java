package com.example.locallibrary.dto;

import java.time.LocalDate;

import com.example.locallibrary.enums.Status;

public class InstanceOfBookDetailsResponse {

  private String title;
  private String imprint;
  private Status status;
  private String dueBack;

  //
  public InstanceOfBookDetailsResponse() {}

  // Getters/Setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getImprint() {
    return imprint;
  }

  public void setImprint(String imprint) {
    this.imprint = imprint;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getDueBack() {
    return dueBack;
  }

  public void setDueBack(LocalDate dueBack) {
    this.dueBack = dueBack != null ? dueBack.toString() : null;
  }
}
