# hexagonal-architecture-with-spring-boot-practice
레이어드 아키텍쳐로 구성한 기존의 MVC 게시판을 헥사고날 아키텍쳐를 적용해 변경해본 프로젝트

<br><br>

## 실행
<strong>Front</strong><br>
<code>npm install</code><br>
<code>npm run serve</code>
<br><br>

<strong>Swagger</strong> : [Swagger링크](http://localhost:8080/swagger-ui/index.html)
<br><br>


## 실행화면
### 로그인
![1_Login](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/cb71c528-0327-40cf-b11f-bd502809cff2)
<br>

### 등록
![2_Insert](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/bd6cf7c9-591e-41e2-b79e-78d49d57fe9b)

<br>

### 수정
![3_Update](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/dc264922-8c13-429d-9943-234e4d22a7bb)

<br>

### 삭제
![4_Delete](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/27d74d2e-0d28-4c3a-b90f-07178556e222)


<br>

### Redis 적용 전
=> 4571ms<br>
![Redis_No](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/47d8b98f-7847-4817-aa81-53a1b6704cb0)
![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/c9198f43-0a8a-4c62-b76a-f770f4cdebdb)

<br>

### Redis 적용 후
=> 1ms<br>
![Redis_Yes](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/b19d4c53-73ea-487b-aece-e83f6fd81d9f)
![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/4ba55748-41cc-4443-a404-ece69415b214)
<br>
![image](https://github.com/acrnm148/hexagonal-architecture-with-spring-boot-practice/assets/67724306/2fd463dc-0056-4b49-8d7f-99c5329d0415)

<br>
