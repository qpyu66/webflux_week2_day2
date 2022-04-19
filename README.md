
- [2주차 과제(2) - REST API 로 내부 통신하는 MSA 구축하기]()

    - Requirement
        - 어제 만든 SayHello Server 에서 InfoService Server 로 내부 호출
        - InfoService 는 호출 파라미터로 찾은 데이터의 직업 응답
    - Spec
        - WebClient

    - Request
        ```
          GET localhost:8080/hello?name=$name
        ```
    - Response - application/json
       ```
         { “to”: “$name”, “job”: “”, “message”: “hello $name” }
       ```
