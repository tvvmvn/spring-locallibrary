package com.example.locallibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.locallibrary.dto.InstanceOfBookDetailsResponse;
import com.example.locallibrary.entity.BookInstance;
import com.example.locallibrary.repository.BookInstanceRepository;
import com.example.locallibrary.repository.BookRepository;

@Controller
public class BookInstanceController {

  private final BookInstanceRepository bookInstanceRepository;

  public BookInstanceController(BookInstanceRepository bookInstanceRepository, BookRepository bookRepository) {
    this.bookInstanceRepository = bookInstanceRepository;
  }

  @GetMapping("/bookinstance/{id}")
  public String getOne(@PathVariable("id") Long id, Model model) {
    
    BookInstance bookInstance = bookInstanceRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("책 사본이 존재하지 않습니다: " + id));
    
    InstanceOfBookDetailsResponse dto = new InstanceOfBookDetailsResponse();
    dto.setTitle(bookInstance.getBook().getTitle());
    dto.setImprint(bookInstance.getImprint());
    dto.setStatus(bookInstance.getStatus());
    dto.setDueBack(bookInstance.getDueBack());

    model.addAttribute("bookInstance", dto);

    return "bookinstance_detail";
  }
}
