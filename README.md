# 택시배차 프로그램
![default](https://user-images.githubusercontent.com/26863285/47618493-12be6b00-db17-11e8-9d46-71dd8ccd92b8.png)



## 목차
  - ### 개발 환경
  - ### 실행 가이드
  - ### 주요 기능 및 API 코드 설명
  
  
  
### 개발 환경
  - Language : java 1.8.0_111 버전
  - Framework : Spring Boot 2.0.6
  - DB : H2(인메모리 데이터베이스)
  - ORM : JPA
  - Template engine : Mustache
  - WAS : Tomcat
  - Dependency tool : maven
  - IDE : intellij
 
 
 ### 실행 가이드
      - 프로젝트 복제 : $ git clone https://github.com/wwwkang8/TaxiAPI.git
      - IDE로 프로젝트 import
        - intellij 기준 : 좌측 상단 File > New > Project from Existing sources > 프로젝트 경로 선택 > import방식 maven 선택
        - Eclipse 기준 : 좌측 상단 File > import > Maven > Existing Maven Projects > 프로젝트 경로 선택 > finish
        - 프로젝트 실행 : src\main\java\com\drama\taxi\TaxiApplication.java 에서 Run 'TaxiApplication' 클릭.
        - URL 접속 : localhost:9090 으로 브라우저에서 접속.
 
 
 ### 아키텍쳐 : Model 2 기반의 MVC 패턴
 ![archi](https://user-images.githubusercontent.com/26863285/47635494-88b6e680-db98-11e8-8e38-90b11233a843.png)
 
 
 ### 데이터베이스
 ![db](https://user-images.githubusercontent.com/26863285/47635904-e13ab380-db99-11e8-90f2-85dec40c39ff.png)

 
 ### 주요 기능
     - 회원 가입
     - 로그인
     - 승객별 배차 내역 확인 : 로그인한 승객 계정의 배차 내역 확인.
     - 승객 배차 신청 기능
     - 최신순으로 모든 배차 내역 확인
     - 택시기사 배차 수락 기능
