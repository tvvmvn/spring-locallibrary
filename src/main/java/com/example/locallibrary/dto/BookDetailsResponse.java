package com.example.locallibrary.dto;

import java.util.List;

public class BookDetailsResponse {

  private String title;
  private String summary;
  private String authorName;
  private String authorUrl;
  private String isbn;
  private List<String> genres;
  private Long bookInstanceCount;
  private List<InstanceOfBookListResponse> bookInstances;

  //
  public BookDetailsResponse() {
  }

  // Getters/Setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getAuthorUrl() {
    return authorUrl;
  }

  public void setAuthorUrl(Long id) {
    this.authorUrl = "/author/" + id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setBookGenres(List<String> genres) {
    this.genres = genres;
  }

  public Long getBookInstanceCount() {
    return bookInstanceCount;
  }

  public void setBookInstanceCount(Long bookInstanceCount) {
    this.bookInstanceCount = bookInstanceCount;
  }

  public List<InstanceOfBookListResponse> getBookInstances() {
    return bookInstances;
  }

  public void setBookInstances(List<InstanceOfBookListResponse> bookInstances) {
    this.bookInstances = bookInstances;
  }

  public static class InstanceOfBookListResponse {

    private String title;
    private String status;
    private String url;

    //
    public InstanceOfBookListResponse() {
    }

    // Getters/Setters
    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(Long id) {
      this.url = "/bookinstance/" + id;
    }
  }
}
