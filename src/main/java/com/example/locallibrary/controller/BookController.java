package com.example.locallibrary.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.locallibrary.dto.BookDetailsResponse;
import com.example.locallibrary.dto.BookDetailsResponse.InstanceOfBookListResponse;
import com.example.locallibrary.entity.Book;
import com.example.locallibrary.entity.Genre;
import com.example.locallibrary.repository.BookGenreRepository;
import com.example.locallibrary.repository.BookInstanceRepository;
import com.example.locallibrary.repository.BookRepository;

@Controller
public class BookController {

  private final BookRepository bookRepository;
  private final BookInstanceRepository bookInstanceRepository;
  private final BookGenreRepository bookGenreRepository;

  public BookController(
    BookRepository bookRepository, 
    BookInstanceRepository bookInstanceRepository,
    BookGenreRepository bookGenreRepository
  ) {
    this.bookRepository = bookRepository;
    this.bookInstanceRepository = bookInstanceRepository;
    this.bookGenreRepository = bookGenreRepository;
  }
  
  @GetMapping("/book/{id}")
  // id: 클라이언트가 요청한 책의ID
  // @PathVariable: 경로 변수를 지정하는 어노테이션. 
  // URL 경로에서 지정한 자리에 있는 데이터를 변수로 인식하도록 합니다.
  // 예) /book/99
  // 경로 변수도 요청 매개 변수처럼 요청 주소(URL)에 서버에 전송할 데이터를 담는 방식입니다. 
  public String getOne(@PathVariable("id") Long id, Model model) {

    // DB에서 책 검색
    Book book = bookRepository.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("도서가 존재하지 않습니다: " + id));
    
    // 이 책의 사본 목록 DTO를 만듭니다.
    List<InstanceOfBookListResponse> bookInstances = bookInstanceRepository.findByBookId(id)
      .stream()
      .map((bookInstance) -> {
        InstanceOfBookListResponse dto = new InstanceOfBookListResponse();
        dto.setTitle(bookInstance.getBook().getTitle());
        dto.setUrl(bookInstance.getId());
        dto.setStatus(bookInstance.getStatus().getLabel());
        return dto;
      }).collect(Collectors.toList());

    // 이 책의 장르목록 DTO를 만듭니다.
    List<String> genres = bookGenreRepository.findByBookId(id).stream()
      .map((bookGenre) -> {
        Genre genre = bookGenre.getGenre();
        return genre.getName();
      }).collect(Collectors.toList());

    // [최종DTO] 책 상세보기 DTO
    BookDetailsResponse dto = new BookDetailsResponse();
    dto.setTitle(book.getTitle());
    dto.setSummary(book.getSummary());
    dto.setAuthorName(book.getAuthor().getName());
    dto.setAuthorUrl(book.getAuthor().getId());
    dto.setIsbn(book.getIsbn());
    dto.setBookGenres(genres);
    dto.setBookInstanceCount(bookInstanceRepository.countByBookId(id));
    dto.setBookInstances(bookInstances);
    
    // 뷰에게 전달합니다
    model.addAttribute("book", dto);

    // 서버의 응답
    return "book_detail";
  }
}
