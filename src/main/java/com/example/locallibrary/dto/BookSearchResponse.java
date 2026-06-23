package com.example.locallibrary.dto;

import java.util.List;

// 책 검색결과 DTO
public class BookSearchResponse {

  // 검색 결과 개수
  private Long resultCount;
  // 검색된 책들 (내부 클래스)
  private List<ResultBook> resultBooks;

  //
  public BookSearchResponse() {};

  // Getters/Setters
  public Long getResultCount() {
    return resultCount;
  }

  public void setResultCount(Long resultCount) {
    this.resultCount = resultCount;
  }

  public List<ResultBook> getResultBooks() {
    return resultBooks;
  }

  public void setResultBooks(List<ResultBook> resultBooks) {
    this.resultBooks = resultBooks;
  }

  public static class ResultBook {

    private String title;
    private String authorName;
    // 책의 사본 수 (재고수량)
    private Long instanceCount;
    // 책 상세 페이지로 연결하는 주소
    private String url;

    //
    public ResultBook() {
    }

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

    public Long getInstanceCount() {
      return instanceCount;
    }

    public void setInstanceCount(Long instanceCount) {
      this.instanceCount = instanceCount;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(Long id) {
      this.url = "/book/" + id;
    }
  }

}
