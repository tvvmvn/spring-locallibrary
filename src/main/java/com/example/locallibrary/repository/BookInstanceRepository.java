package com.example.locallibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.BookInstance;

public interface BookInstanceRepository extends JpaRepository<BookInstance, Long> {
    
  List<BookInstance> findByBookId(Long id);

  Long countByBookId(Long id);
}

