package com.example.locallibrary.entity;

import java.time.LocalDate;

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
  private Long id;
  
  // 다대일(N:1) - 여러 개의 책 사본이 하나의 책에 속할 수 있다
  // DB에서의 구조: book_id(외래키)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")     
  private Book book;

  // 출판사
  private String imprint;

  // 상태: 대출중, 대출가능 등
  private Status status;

  // 반납일자. 데이터베이스의 date 자료형과 대응합니다.
  // date: yyyy-mm-dd(연-월-일)
  private LocalDate dueBack;


  public BookInstance() {};
  
  public BookInstance(Book book, String imprint, Status status, LocalDate dueBack) {
    this.book = book;
    this.imprint = imprint;
    this.status = status;
    this.dueBack = dueBack;
  };

  // Getters
  public Long getId() {
    return id;
  }

  public Book getBook() {
    return book;
  }

  public String getImprint() {
    return imprint;
  }

  public Status getStatus() {
    return status;
  }

  public LocalDate getDueBack() {
    return dueBack;
  }
}