# 택시배차 프로그램
![default](https://user-images.githubusercontent.com/26863285/47618493-12be6b00-db17-11e8-9d46-71dd8ccd92b8.png)



## 목차
  - ### 개발 환경
  - ### 실행 가이드
  - ### 아키텍쳐
  - ### 데이터베이스
  - ### API 명세
  - ### 주요 
  
  
  
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
 
      [사용자 테이블]
      - 사용자 번호 : 사용자가 회원 가입시에 발급되는 고유의 시퀀스 번호
      - 사용자 이메일 : 회원가입 시에 사용하는 유니크한 이메일 주소
      - 비밀번호 : 회원가입 시에 입력하는 비밀번호
      - 사용자 타입 : 회원 가입시에 승객 or 택시기사로 선택하는 값.
      - 배차 수락여부 : 택시기사가 배차를 수락했는지 여부를 판단하는 컬럼.

      [배차 예약 테이블]
      - 예약 번호 : 배차 예약시 생성되는 시퀀스 번호
      - 목적지 : 사용자가 입력한 목적지
      - 승객 이메일 : 예약한 승객의 이메일 주소
      - 배차 상태 : 배차 대기 or 배차 완료
      - 택시기사 이메일 : 배차를 수락한 택시기사의 이메일 주소
      - 배차 등록일시 : 승객이 배차를 신청한 시점
      - 배차 수락일시 : 택시기사가 배차를 수락한 시점
      - 사용자 번호(FK) : 사용자 테이블의 사용자 번호를 FK로 가져서 배차를 예약한 사용자를 참조한다.
  
 
 ### API 명세
![booking-controller](https://user-images.githubusercontent.com/26863285/47690376-2827b800-dc31-11e8-92d1-601cfa3c32ae.png)
![user controller](https://user-images.githubusercontent.com/26863285/47690377-2827b800-dc31-11e8-97e7-6e2d6ad0be28.png)
![web controller](https://user-images.githubusercontent.com/26863285/47690378-2827b800-dc31-11e8-8ee8-b3d15ecbd26f.png)
 
 ### 주요 기능
     - 회원 가입
     - 로그인
     - 승객별 배차 내역 확인 : 로그인한 승객 계정의 배차 내역 확인.
     - 승객 배차 신청 기능
     - 최신순으로 모든 배차 내역 확인
     - 택시기사 배차 수락 기능
     - Interceptor
     
 
#### 회원 가입 : Sign in 버튼을 클릭하면 회원가입 페이지로 이동. 이메일 중복체크를 Ajax 통신으로 수행.
 ![sign up](https://user-images.githubusercontent.com/26863285/47689222-52c34200-dc2c-11e8-8612-0c2540e87542.png)
![register fail](https://user-images.githubusercontent.com/26863285/47689230-6078c780-dc2c-11e8-882c-b9bed99bfc8f.png)
![register success](https://user-images.githubusercontent.com/26863285/47689232-61a9f480-dc2c-11e8-8564-0af1afc57af3.png)


#### 승객 페이지 : 승객 아이디로 로그인을 하면 해당 승객이 예약한 배차 내역을 확인하는 페이지로 이동.
![default](https://user-images.githubusercontent.com/26863285/47689228-5ce54080-dc2c-11e8-9358-8a34421fecad.png)


#### 배차 신청하기 : 배차 신청 버튼을 클릭하면 배차 신청 폼으로 이동.
![batch](https://user-images.githubusercontent.com/26863285/47689381-0b898100-dc2d-11e8-9de8-821b03632373.png)


#### 택시기사 페이지 : 택시기사 아이디로 로그인을 하면 모든 승객들의 배차 신청 리스트를 확인할 수 있다. 그리고 수락버튼을 클릭하면 해당 택시기사에게 배차가 완료된다.
![2](https://user-images.githubusercontent.com/26863285/47689236-6bcbf300-dc2c-11e8-92e9-d28d9e7d68da.png)


#### 배차 완료 : 택시기사가 수락 버튼을 클릭하면 배차가 해당 택시기사의 이메일 주소, 배차 수락일시가 입력이 된다.
![default](https://user-images.githubusercontent.com/26863285/47689243-725a6a80-dc2c-11e8-8946-2efcf24acc40.png)


#### Interceptor 적용 : 로그인을 하지 않은 상태에서 URL로 접근을 막기 위해 Interceptor를 적용하였습니다. 
![121212](https://user-images.githubusercontent.com/26863285/47690341-0d554380-dc31-11e8-90ca-49bb4a45d5c1.png)

