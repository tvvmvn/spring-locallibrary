package com.example.locallibrary.dto;

import java.time.LocalDate;

// 저자 상세보기 DTO
public class AuthorDetailsResponse {
  
  private String name;
  // 뷰에서 바로 사용가능하도록 문자열로 변환합니다.
  private String birthDate;
  private String deathDate;
  // REST API 방식에서는 JSON으로 주고받습니다(getter 불가)

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