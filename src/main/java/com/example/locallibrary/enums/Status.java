package com.example.locallibrary.enums;

// 도서 사본의 상태를 나타내는 이넘
public enum Status {
  
  // 괄호 안에 전달된 값이 각 상수의 라벨에 할당됩니다.
  MAINTENANCE("보수중"),
  AVAILABLE("대출가능"),
  LOANED("대출중"),
  RESERVED("예약됨");

  // label: 뷰에서 출력용으로 활용할 데이터입니다.
  private final String label;
  
  // enum 생성자를 활용해 멤버에게 이 라벨을 연결할 수 있음
  // 기본값은 private입니다.
  private Status(String label) {
    this.label = label;
  }

  // Getter (접근자)
  // 각 상수의 라벨에 접근할 수 있습니다.
  public String getLabel() {
    return this.label;
  }
}
