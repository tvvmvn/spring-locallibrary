package com.example.locallibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
  // 도서 제목에 키워드를 포함한 글자가 있는 데이터를 조회합니다.
  // Containing: keyword를 포함하는 글자를 찾습니다 (LIKE 연산자)
  // IgnoreCase: 대/소문자를 구분하지 않습니다.
  List<Book> findByTitleContainingIgnoreCase(String keyword);
  
  // 같은 조건으로 행의 개수 세기
  Long countByTitleContainingIgnoreCase(String keyword);
}

