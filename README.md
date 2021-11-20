# 도메인 주도 설계 철저 입문 By Kotlin

## 지식을 표현하는 패턴
* 💁 __값 객체 (Value Object)__
  * Equality 로 비교된다. (내부적인 값의 속성을 비교한다.)
  * 불변 특성이 있다.
  * 값의 변경은 새로운 값 객체의 생성이 된다.
* 💁 __엔티티 (Entity)__
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

* 💁 __도메인 서비스__
  * 값 객체로 모든 행동을 구현하지 않고, 별도의 객체로 분리해서 정의할 수 있도록 한다. (별도의 객채 = 도메인 서비스)
    * 도메인 서비스는 값 객체와 엔티티에서 구현되는 `부자연스러움` 을 해결해준다.
  * 도메인 서비스는 별도의 상태값은 가지지 않는다.
  * DDD 에서는 서비스는 두가지 맥락으로 구분된다.
    * 도메인을 위한 서비스
    * 애플리케이션을 위한 서비스
  * 도메인 서비스에서 구현할 지 망설여진다면 우선 `엔티티나 값 객체에 정의해본다.`

## 애플리케이션을 구성하는 패턴
* 💁 __레파지토리__
  * 레파지토리 책임은 객체의 퍼시스턴시까지다.
    * 레파지토리의 책임이 도메인 규칙에 가깝게 책임을 가지고 있는지 살펴야 한다.
    * 레파지토리와 도메인 서비스 책임 둘 중에 `행위` 가 어디에 더 가까운지 알아야 한다.

* 💁 __애플리케이션 서비스__   
<img src="./images/DDD_application_service.png" />   
  
  * `api` -> `application-service` -> `domain-service` -> `repository` -> `data-store`
    * application-service 에서 여러 domain-service 의 내용들을 머지해서 내려주도록 해야한다.
    * 애플리케이션 서비스에 대한 응집도를 낮출수도 혹은 높일수도 있다.
      * 응집도를 낮춘다면,
        * UserApplicationService (유저 등록/탈퇴/수정 을 모두 다 한다.)
      * 응집도를 높인다면, (패키지로 응집도 높인 클래스를 구분한다. application.users.*)
        * UserApplicationRegisterService
        * UserApplicationDeleteService
        * UserApplicationUpdateService
    
#### 스프링의 `@Service` 애노테이션을 보면 아래와 같은 내용이 있다.
> Indicates that an annotated class is a "Service",    
> originally defined by Domain-Driven Design (Evans, 2003) as "an operation offered as an interface that stands alone in the model,    
> with no encapsulated state."   
> 
> May also indicate that a class is a "Business Service Facade" (in the Core J2EE patterns sense), or something similar.    
> This annotation is a general-purpose stereotype and individual teams may narrow their semantics and use as appropriate.   
* 도메인 모델에서 별도의 캡슐화된 상태값 없이 독립적인 형태로 작업을 제공한다.
* 또 비즈니스 서비스 의 facade 형태로 혹은 이와 유사하게 나타낼 수 있다. 블라블라블라
* 개인적으로 `Service` 애노테이션을 결과적으로 사용하기에 따라 애플리케이션 서비스 혹은 도메인 서비스로 사용할 수 있지 않을까?? 싶다.
  * 따라서, 나는 구분해서 사용하기위해 별도의 메타애노테이션을 정의했다.
```kotlin
/**
 * 도메인과 레파지토리에 밀접한 도메인 서비스 애노테이션이다.
 * 도메인 서비스끼리는 서로 호출하지 않는게 핵심이다.
 */
@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DomainService(
    @get:AliasFor(annotation = Service::class, attribute = "value")
    val value: String = ""
)

/**
 * 사용자 유스케이스에 대한 전용 애플리케이션 서비스 애노테이션이다.
 */
@Service
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationService(
    @get:AliasFor(annotation = Service::class, attribute = "value")
    val value: String = ""
)
```

* 💁 __소프트웨어 유연성을 위한 의존관계__
  * DIP 를 이용해 해결한다. (의존관계 역전 원칙)
  * 스프링 프레임워크에서는 IoC 컨테이너를 구현하여, DI (의존관계 역전) 을 구행하고 있다.
    * https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-introduction
  * 기타 다른 책들 (오브젝트와 클린코드) 에서도 관련 내용을 언급하고 있다.
    * https://github.com/coding-buddha/object-by-kotlin/blob/main/README-object.md
    * https://github.com/pasudo123/mango-banana-clean-code/blob/master/README.md


