# 일정 관리 앱 Develop

## 사용 기술

- JAVA : JDK 17
- Spring Boot : 3.3.5
- IDE : IntelliJ

## 개발 목표

- 일정을 등록, 조회, 수정, 삭제 할 수 있다.
- 유저 정보를 등록, 조회, 삭제 할 수 있다.
- 유저 정보를 인증받을 수 있다.

## API 명세서

### /schedules

| 기능 | http method | endpoint | request | response | 상태 코드 |
| --- | --- | --- | --- | --- | --- |
| 일정 추가 | POST | /schedules | 요청 body | 등록 정보 | 201: 정상 등록 |
| 전체 일정 조회 | GET | /schedules | 요청 param | 다건 응답 정보 | 200: 정상 조회 |
| 단 건 일정 조회 | GET | /schedules/{id} | 요청 param | 단 건 응답 정보 | 200: 정상 조회 |
| 일정 수정 | PATCH | /schedules/{id} | 요청 body | 수정 정보 | 200: 정상 수정 |
| 일정 삭제 | DELETE | /schedules/{id} | 요청 param | X | 200: 정상 삭제 |
- 일정 추가
    - endpoint : /schedules
    - http method : POST
    - request

        ```json
        {
        	"username" : "hyunji cho",
        	"title" : "할 일 추가",
        	"contents" : "내용",
        }
        ```

    - response

        ```json
        201: create
        {
        	"id" : 1,
        	"username" : "hyunji cho",
        	"title" : "할 일 추가",
        	"contents" : "내용",
        	"createDate" : "2024-11-13 00:00:00",
        	"modifiedDate" : "2024-11-13 00:00:00"
        }
        
        400: bad request
        {
        	"message" : "request check"
        }
        ```

- 전체 일정 조회
    - endpoint : /schedules
    - http method : GET
    - request : none
    - response

        ```json
        200: OK
        [{
        	"id" : 1,
        	"username" : "hyunji cho",
        	"title" : "할 일 추가",
        	"contents" : "내용",
        	"createDate" : "2024-11-13 00:00:00",
        	"modifiedDate" : "2024-11-13 00:00:00"
        }, ...]
        ```

- 단 건 일정 조회
    - endpoint : /schedules/{id}
    - http method : POST
    - request : /{id}
    - response

        ```json
        200: OK
        {
        	"id" : 1,
        	"username" : "hyunji cho",
        	"title" : "할 일 추가",
        	"contents" : "내용",
        	"createDate" : "2024-11-13 00:00:00",
        	"modifiedDate" : "2024-11-13 00:00:00"
        }
        
        400: bad request
        {
        	"message" : "request check"
        }
        
        404: not found
        {
        	"message" : "schedule not found"
        }
        ```

- 일정 수정
    - endpoint : /schedules/{id}
    - http method : PATCH
    - request : /{id}

        ```json
        // user table 추가 전
        {
        	"username" : "hyunji cho",
        	"title" : "할 일 추가",
        	"contents" : "내용",
        }
        ```

        ```json
        // user table 추가 후
        // username은 작성자 정보에서 받아온 값으로 저장
        {
        	"title" : "할 일 추가",
        	"contents" : "내용",
        }
        ```

    - response

        ```json
        200: OK
        {
        	"id" : 1,
        	"username" : "hyunji cho",
        	"title" : "할 일 수정",
        	"contents" : "내용 수정",
        	"createDate" : "2024-11-13 00:00:00",
        	"modifiedDate" : "2024-11-14 00:00:00"
        }
        
        400: bad request
        {
        	"message" : "request check"
        }
        
        404: not found
        {
        	"message" : "schedule not found"
        }
        ```

- 일정 삭제
    - endpoint : /schedules/{id}
    - http method : DELETE
    - request : /{id}
    - response

        ```json
        200: OK
        {
        	"message" : "delete schedule"
        }
        
        404: not found
        {
        	"message" : "schedule not found"
        }
        ```


### /users

| 기능 | http method | endpoint | request  | response body | 상태코드 |
| --- | --- | --- | --- | --- | --- |
| 회원가입 | POST | /users/signup | 요청 body | 등록 정보 | 201: 정상 등록 |
| 유저 전체 조회 | GET | /users | 요청 param | 다 건 응답 정보 | 200: 정상 조회 |
| 유저 조회 | GET | /users/{id} | 요청 param | 단 건 응답 정보 | 200: 정상 조회 |
| 유저 삭제 | DELETE | /users/{id} | 요청 param | X | 200: 정상 삭제 |
| 로그인 | GET | /users/login | 요청 body | X | 200: 로그인 성공 |
- 회원가입
    - endpoint : /users/signup
    - http method : POST
    - request

        ```json
        {
        	"username" : "hyunji cho",
        	"email" : "ooo@oooo.com",
        	"password" : "1234"	
        }
        ```

    - response

        ```json
        201: create
        {
        	"id" : 1,	
        	"username" : "hyunji cho",
        	"email" : "ooo@oooo.com",
        	"createDate" : "2024-11-13 00:00:00",
        	"modifiedDate" : "2024-11-13 00:00:00"
        }
        
        400: bad request
        {
        	"message" : "request check"
        }
        ```

- 전체 유저 조회
    - endpoint : /users
    - http method : GET
    - request : none
    - response

        ```json
        200: create
        [{
        	"id" : 1,	
        	"username" : "hyunji cho",
        	"email" : "ooo@oooo.com",
        	"createDate" : "2024-11-13 00:00:00",
        	"modifiedDate" : "2024-11-13 00:00:00"
        }, ...]
        
        404: not found
        {
        	"message" : "user not found"
        }
        ```

- 유저 조회
    - endpoint : /users/{id}
    - http method : GET
    - request : /{id}
    - response

        ```json
        200: OK
        {
        	"id" : 1,	
        	"username" : "hyunji cho",
        	"email" : "ooo@oooo.com",
        	"createDate" : "2024-11-13 00:00:00",
        	"modifiedDate" : "2024-11-13 00:00:00"
        }
        
        404: not found
        {
        	"message" : "user not found"
        }
        ```

- 유저 삭제
    - endpoint : /users/{id}
    - http method : DELETE
    - request : /{id}
    - response

        ```json
        200: OK
        {
        	"message" : "delete user data"
        }
        
        404: not found
        {
        	"message" : "user not found"
        }
        ```

- 로그인
    - endpoint : /users/login
    - http method : GET
    - request

        ```json
        {
        	"email" : "ooo@oooo.com",
        	"password" : "1234"	
        }
        ```

    - response

        ```json
        200: OK
        {
        	"message" : "complite login"
        }
        
        401: Unauthorized
        {
        	"message" : "Unauthorized check"
        }
        ```

## ERD

![스크린샷 2024-11-13 오후 5 55 28](https://github.com/user-attachments/assets/715d5a1c-aa39-43a0-a9b7-14cb4608f4ab)
