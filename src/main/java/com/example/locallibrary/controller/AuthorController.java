package com.example.locallibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.locallibrary.dto.AuthorDetailsResponse;
import com.example.locallibrary.entity.Author;
import com.example.locallibrary.repository.AuthorRepository;

@Controller
public class AuthorController {

  private final AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @GetMapping("/author/{id}")
  public String getOne(@PathVariable("id") Long id, Model model) {

    Author author = authorRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("저자가 존재하지 않습니다: " + id));

    AuthorDetailsResponse dto = new AuthorDetailsResponse();
    dto.setName(author.getName());
    dto.setBirthDate(author.getBirthDate());
    dto.setDeathDate(author.getDeathDate());

    model.addAttribute("author", dto);

    return "author_detail";
  }
}
