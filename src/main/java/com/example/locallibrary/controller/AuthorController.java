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
  // @PathVariable: 경로 변수를 지정하는 어노테이션
  // URL(요청 주소)로 서버에 간단한 데이터를 전송하는 방식입니다. (요청 매개변수처럼)
  // 요청주소에서 이 자리({})에 있는 값을 경로변수 id로 인식하겠다
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
