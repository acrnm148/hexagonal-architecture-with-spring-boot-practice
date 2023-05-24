# hexagonal-architecture-with-spring-boot-practice
레이어드 아키텍쳐로 구성한 기존의 MVC 게시판을 헥사고날 아키텍쳐를 적용해 변경해본 프로젝트
- Springboot 2.6.7
- Java 1.8
- MyBatis
- Redis
- PostgreSQL
- Vue.js
- javascript
- bootstrap5<br><br>

![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/9c9af569-8cc5-407a-9d4e-33396765b69e)<br>
헥사고날 아키텍처, 포트 어댑터 아키텍처, 육각형 아키텍처

<br><br>

## 1️⃣ 실행
<strong>Front</strong><br>
<code>npm install</code><br>
<code>npm run serve</code>
<br><br>

<strong>Swagger</strong> : [Swagger링크](http://localhost:8080/swagger-ui/index.html)
![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/51e6d8ed-1f9c-4554-8d81-e584688ae8ec)

<br><br>


## 2️⃣ 실행화면


### 1. Redis 적용

💡 조건<br>
- 게시판 목록을 조회하는 selectBoardList 메소드의 실행시간 측정<br>
    - Board 테이블 조회<br>
    - 1000만 건의 더미데이터 생성<br>
- key : 검색어 + Limit + Offset 합친 String<br>
- 1000만 개의 데이터 중 1번 째 데이터에 ‘suna’를 저장하였음.<br>
검색어로 ’suna’를 한 번 검색해보았음.<br>

<br><br>

<strong>▶Redis 적용 전 => 4571ms</strong>

![Redis_No](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/47d8b98f-7847-4817-aa81-53a1b6704cb0)
![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/c9198f43-0a8a-4c62-b76a-f770f4cdebdb)

<br>

<strong>▶Redis 적용 후 => 1ms</strong>

![Redis_Yes](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/b19d4c53-73ea-487b-aece-e83f6fd81d9f)
![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/4ba55748-41cc-4443-a404-ece69415b214)
<br>
![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/2fd463dc-0056-4b49-8d7f-99c5329d0415)

<br>

### 2. CRUD 기능

<strong>▶로그인</strong><br>

![1_Login](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/cb71c528-0327-40cf-b11f-bd502809cff2)

<br><br>

<strong>▶게시글 등록</strong><br>

![2_Insert](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/bd6cf7c9-591e-41e2-b79e-78d49d57fe9b)

<br><br>

<strong>▶게시글 수정</strong><br>

![3_Update](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/dc264922-8c13-429d-9943-234e4d22a7bb)

<br><br>

<strong>▶게시글 삭제</strong><br>

![4_Delete](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/27d74d2e-0d28-4c3a-b90f-07178556e222)


<br><br><br>

## 3️⃣ 정리

**Redis** <br>
- 장점 : **속도가 빠르다. (메모리 기반)**<br>
- 단점 : 휘발성이다. 서버에 장애가 나거나 전원을 껐다 켜야할 경우 메모리가 날아가서 데이터 손실이 발생할 수 있다.<br>

**DB**<br>
- 장점 : **비휘발성이다. (디스크 기반)**<br>
- 단점 : 비용적 문제가 발생, 속도가 어느정도 낮아질 수 있다.<br>

**⇒ 두 가지 모두 다른 장점을 가지고 있으므로 조합하여 적절하게 활용**<br>

<br><br>

## 4️⃣ 후기

헥사고날을 사용하면서 코드가 많아지고 복잡성이 올라간다는 단점이 있었다.<br>
반면에 서비스가 커짐에 따라 잘게 분리함으로써 모듈을 재사용하기가 용이해져 유지보수성이 높아지는 장점이 있었다.<br>
<br>
이에 대규모의 서비스를 개발할 경우 유지보수성을 높이기 위해 헥사고날이 도움이 될 것이라고 생각하지만 기존의 MVC에서 헥사고날로 바꾸는 것이 무조건적으로 좋은가? 는 조심스럽게 아닐 수도 있다고 생각한다. 헥사고날이 효율적인 측면에서는 무조건적인 답은 아닌 것 같다. 이는 더 공부해봐야 더 많은 부분에서 깨달을 수 있을 것 같다.

