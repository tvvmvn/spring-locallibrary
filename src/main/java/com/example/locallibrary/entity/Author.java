package com.example.locallibrary.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// 데이터베이스의 각 테이블과 대응되는 객체 (도메인)
@Entity
public class Author {

  @Id // 기본키로 지정합니다
  // 기본키 생성 방식(Generation Type)을 AUTO_INCREMENT로 설정합니다.
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;

  private String firstName;

  private String familyName;

  // LocalDate: 날짜 객체. 연-월-일 순으로 데이터를 저장합니다.
  // 데이터베이스의 DATE 자료형에 대응합니다.
  private LocalDate birthDate;

  private LocalDate deathDate;

  // 
  public Author() {};

  public Author(String firstName, String familyName, LocalDate birthDate, LocalDate deathDate) {
    this.firstName = firstName;
    this.familyName = familyName;
    this.birthDate = birthDate;
    this.deathDate = deathDate;
  };

  // Getters
  public long getId() {
    return id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getFamilyName() {
    return this.familyName;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  public LocalDate getDeathDate() {
    return this.deathDate;
  }

  public String getName() {
    return this.firstName + " " +  this.familyName;
  }
}