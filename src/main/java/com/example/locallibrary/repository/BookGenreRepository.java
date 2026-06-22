package com.example.locallibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.BookGenre;

public interface BookGenreRepository extends JpaRepository<BookGenre, Long> {
  
  // 장르id의 값이 전달받은 id와 일치하는 행들을 조회합니다.
  List<BookGenre> findByGenreId(Long id);
  
  // 집계함수인 COUNT(*) 를 실행합니다
  // genre_id 컬럼값이 입력받은 id와 일치하는 행의 개수를 셉니다
  Long countByGenreId(Long id);

  // book_id의 값이 전달받은 id와 일치하는 행들을 조회합니다
  List<BookGenre> findByBookId(Long id);
}

