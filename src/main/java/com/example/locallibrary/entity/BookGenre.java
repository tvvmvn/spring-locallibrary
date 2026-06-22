package com.example.locallibrary.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// 책-장르의 다대다(N:M) 관계를 구현하기 위해 필요한 엔티티
// 책ID, 장르ID 두개의 컬럼으로 구성됩니다.
@Entity
public class BookGenre {
  
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 다대일(N:1) - 여러 개의 책이 같은 장르를 공유할 수 있다
  // DB에서의 구조: 책의 기본키(book_id)를 외래키로 지정합니다.
  @ManyToOne(fetch = FetchType.LAZY) 
  @JoinColumn(name = "book_id")
  private Book book;

  // 다대일(N:1) - 여러 개의 장르가 하나의 책에 속할 수 있다
  // DB에서의 구조: 장르의 기본키(genre_id)를 외래키로 지정합니다.
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "genre_id")
  private Genre genre;

  //
  public BookGenre() {}

  public BookGenre(Book book, Genre genre) {
    this.book = book;
    this.genre = genre;
  }

  // Getters
  public Long getId() {
    return id;
  }

  public Book getBook() {
    return book;
  }

  public Genre getGenre() {
    return genre;
  }
}