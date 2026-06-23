package com.example.locallibrary.dto;

// 책 목록 조회용 DTO
public class BookListResponse {
  
  private String title;
  private String authorName;
  // 책 상세보기 페이지로 이동하는 링크 주소를 만들어 보냅니다. (재사용 가능)
  private String url;

  //
  public BookListResponse() {}

  // Getters/Setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getUrl() {
    return url;
  }

  // 유틸리티. 책 상세 페이지로 연결되는 링크 주소를 제공합니다.
  public void setUrl(Long id) {
    this.url = "/book/" + id;
  }
}
