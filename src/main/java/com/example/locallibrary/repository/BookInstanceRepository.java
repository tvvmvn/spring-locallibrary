package com.example.locallibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.BookInstance;

public interface BookInstanceRepository extends JpaRepository<BookInstance, Long> {
    
  // 책 ID로 사본찾기
  List<BookInstance> findByBookId(Long id);

  // 책ID로 사본 개수 구하기
  Long countByBookId(Long id);
}

