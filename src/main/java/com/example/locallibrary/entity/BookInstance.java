package com.example.locallibrary.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.locallibrary.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookInstance {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  // 다대일(N:1) - 여러 개의 책 사본이 하나의 책에 속할 수 있다
  // DB에서의 구조: book_id(외래키)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")     
  private Book book;

  private String imprint;

  private Status status;

  // 반납일자. 예) 2026-07-01 형식으로 저장합니다.
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dueBack;


  public BookInstance() {};
  
  public BookInstance(Book book, String imprint, Status status, LocalDate dueBack) {
    this.book = book;
    this.imprint = imprint;
    this.status = status;
    this.dueBack = dueBack;
  };

  // Getters
  public long getId() {
    return id;
  }

  public Book getBook() {
    return this.book;
  }

  public String getImprint() {
    return this.imprint;
  }

  public Status getStatus() {
    return this.status;
  }

  public LocalDate getDueBack() {
    return this.dueBack;
  }
}