package com.example.locallibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.Book;

// Book: 리토지토리가 관리하는 엔티티(DB테이블)
// Long: 기본키 타입. DB의 BigInt에 대응합니다
public interface BookRepository extends JpaRepository<Book, Long> {

  // 기본적인 DB 쿼리들이 여기에 내장되어있습니다. 필요한 것만 추가할 것만 됩니다.
    
  // 도서 제목에 키워드를 포함한 글자가 있는 데이터를 조회합니다.
  // Containing: keyword를 포함하는 글자를 찾습니다 (LIKE 연산자)
  // IgnoreCase: 대/소문자를 구분하지 않습니다.
  List<Book> findByTitleContainingIgnoreCase(String keyword);
  
  // 같은 조건에 해당하는 검색 결과의 개수를 셉니다
  Long countByTitleContainingIgnoreCase(String keyword);
}

