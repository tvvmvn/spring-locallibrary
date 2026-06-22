package com.example.locallibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locallibrary.entity.Author;

// Author: 리토지토리가 관리하는 엔티티(DB테이블)
// Long: 기본키 타입(BigInt)
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

