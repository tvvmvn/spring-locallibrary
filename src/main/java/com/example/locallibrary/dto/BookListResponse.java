package com.example.locallibrary.dto;

public class BookListResponse {
  
  private String title;
  private String authorName;
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

  public void setUrl(Long id) {
    this.url = "/book/" + id;
  }
}
