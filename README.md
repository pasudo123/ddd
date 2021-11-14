# 도메인 주도 설계 철저 입문 By Kotlin

### 지식을 표현하는 패턴
* __값 객체 (Value Object)__
  * Equality 로 비교된다. (내부적인 값의 속성을 비교한다.)
  * 불변 특성이 있다.
  * 값의 변경은 새로운 값 객체의 생성이 된다.
* __엔티티 (Entity)__
  * Identity 로 비교된다. (별도의 식별자가 있다.)
  * 가변 특성이 있다.
    
> 값 객체와 엔티티 간의 구분을 어떻게 하는 것이 좋은가?   
> 생애주기의 존재여부 및 생애주기의 연속성이 있다면 엔티티로 처리하는게 좋다.
> 그 외에는 값 객체로 남겨두는 것이 좋다.

* 생애주기의 존재여부
  * 객체가 태어나서 죽는 경우가 있음을 의미, 시스템 내의 도메인의 정보가 사용되었다가 이후에 사라짐 CREATE/DELETE
* 생애주기의 연속성
  * 생애주기가 계속 반복되는가를 의미, 태어나고 죽고 태어나고 죽고를 반복

> 값 객체도 될 수 있고 엔티티가 될 수있는 모델이 있는 경우
> 환경에 따라 달라질 수 있으니 충분히 고민을 해봐야 함 (경험적으로 많이 겪어봐야 알 듯)


