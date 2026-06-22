package com.example.locallibrary.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.locallibrary.dto.BookListResponse;
import com.example.locallibrary.dto.BookSearchResponse;
import com.example.locallibrary.dto.BookSearchResponse.ResultBook;
import com.example.locallibrary.repository.BookInstanceRepository;
import com.example.locallibrary.repository.BookRepository;

@Controller
public class HomeController {

  private final BookRepository bookRepository;
  private final BookInstanceRepository bookInstanceRepository;

  public HomeController(BookRepository bookRepository, BookInstanceRepository bookInstanceRepository) {
    this.bookRepository = bookRepository;
    this.bookInstanceRepository = bookInstanceRepository;
  }

  @GetMapping("/")
  public String home(Model model) {

    List<BookListResponse> books = bookRepository.findAll().stream()
      .map((book) -> {
        BookListResponse dto = new BookListResponse();
        dto.setTitle(book.getTitle());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setUrl(book.getId());
        return dto;
      }).collect(Collectors.toList());

    model.addAttribute("books", books);

    return "home";
  }

  @GetMapping("/search")
  public String search(
    // @RequestParam: 요청 매개변수. 
    // keyword는 사용자가 입력한 검색어입니다.
    // 형태: 주소?keyword=값
    @RequestParam(name = "keyword") String keyword, Model model) {
      
    List<ResultBook> resultBooks = bookRepository.findByTitleContainingIgnoreCase(keyword).stream()
      .map(book -> {
        ResultBook dto = new ResultBook();
        dto.setTitle(book.getTitle());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setInstanceCount(bookInstanceRepository.countByBookId(book.getId()));
        dto.setUrl(book.getId());
        return dto;
      }).collect(Collectors.toList());

    BookSearchResponse dto = new BookSearchResponse();

    dto.setResultBooks(resultBooks);
    dto.setResultCount(bookRepository.countByTitleContainingIgnoreCase(keyword));
    
    model.addAttribute("keyword", keyword);
    model.addAttribute("result", dto);

    return "search_result"; 
  }
}
