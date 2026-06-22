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
  // 클라이언트가 요청한 책의 id
  public String getOne(@PathVariable("id") Long id, Model model) {

    Book book = bookRepository.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("도서가 존재하지 않습니다: " + id));
    
    // Book instances
    List<InstanceOfBookListResponse> bookInstances = bookInstanceRepository.findByBookId(id)
      .stream()
      .map((bookInstance) -> {
        InstanceOfBookListResponse dto = new InstanceOfBookListResponse();
        dto.setTitle(bookInstance.getBook().getTitle());
        dto.setUrl(bookInstance.getId());
        dto.setStatus(bookInstance.getStatus().getLabel());
        return dto;
      }).collect(Collectors.toList());

    // Genres
    List<String> genres = bookGenreRepository.findByBookId(id).stream()
      .map((bookGenre) -> {
        Genre genre = bookGenre.getGenre();
        return genre.getName();
      }).collect(Collectors.toList());

    // Book DTO
    BookDetailsResponse dto = new BookDetailsResponse();
    dto.setTitle(book.getTitle());
    dto.setSummary(book.getSummary());
    dto.setAuthorName(book.getAuthor().getName());
    dto.setAuthorUrl(book.getAuthor().getId());
    dto.setIsbn(book.getIsbn());
    dto.setBookGenres(genres);
    dto.setBookInstanceCount(bookInstanceRepository.countByBookId(id));
    dto.setBookInstances(bookInstances);
    
    model.addAttribute("book", dto);

    return "book_detail";
  }
}
