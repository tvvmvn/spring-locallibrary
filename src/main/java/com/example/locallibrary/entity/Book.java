package com.example.locallibrary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  
  private String title;

  // 최대 1000 글자로 설정합니다. varchar(1000)
  @Column(length = 1000)
  private String summary;

  // 다대일(N:1) - 여러개의 책이 한명의 저자에게 속한다
  // 테이블에서 저자의 아이디(author_id)를 외래키로 저장합니다.
  // FetchType: EAGER, LAZY 두가지가 있습니다.
  // EAGER(즉시 가져오기): 연관된 엔티티를 항상 함께 조회합니다. (성능 이슈있음)
  // LAZY(미루기): 연관된 엔티티를 필요한 순간(Getter로 호출)등까지 조회를 미룹니다. 성능을 위해 추천되는 방식. 
  // 예) Book 리포지토리에서 Long count() 메서드가 내부적으로 저자 조회를 하지 않을 수 있음
  @ManyToOne(fetch = FetchType.LAZY) 
  @JoinColumn(name = "author_id")     
  private Author author;
  
  private String isbn;

  // 
  public Book() {};

  public Book(String title, String summary, String isbn, Author author) {
    this.title = title;
    this.summary = summary;
    this.isbn = isbn;
    this.author = author;
  };

  // Getters
  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getSummary() {
    return this.summary;
  }

  public Author getAuthor() {
    return this.author;
  }

  public String getIsbn() {
    return this.isbn;
  }
}