package com.example.locallibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.BookGenre;

public interface BookGenreRepository extends JpaRepository<BookGenre, Long> {
  
  // 장르id의 값이 전달받은 id와 일치하는 행들을 조회합니다.
  // 특정 장르에 해당하는 책들을 찾을 때 활용합니다
  List<BookGenre> findByGenreId(Long id);
  
  // 장르id 컬럼값이 입력받은 id와 일치하는 행의 개수를 셉니다
  // 특정 장르에 해당하는 책의 개수를 셉니다
  // 내부적으로 집계함수인 COUNT(*) 를 실행합니다
  Long countByGenreId(Long id);

  // 책id의 값이 전달받은 id와 일치하는 행들을 조회합니다
  // 특정 책의 장르들을 확인하기 위해 사용합니다.
  List<BookGenre> findByBookId(Long id);
}

