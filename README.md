# 택시배차 프로그램
![default](https://user-images.githubusercontent.com/26863285/47618493-12be6b00-db17-11e8-9d46-71dd8ccd92b8.png)



## 목차
  - ### 개발 환경
  - ### 실행 가이드
  - ### API 코
  
  
  
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
 ![default](https://user-images.githubusercontent.com/26863285/47618589-51085a00-db18-11e8-9250-dd2653990b53.png)
        
        - Eclipse 기준 : 좌측 상단 File > import > Maven > Existing Maven Projects > 프로젝트 경로 선택 > finish
 ![default](https://user-images.githubusercontent.com/26863285/47618710-9a0cde00-db19-11e8-8352-fef377aac083.png)
 ![2](https://user-images.githubusercontent.com/26863285/47618711-9a0cde00-db19-11e8-926e-68eea95c563c.png)
        
        - 프로젝트 실행 : src\main\java\com\drama\taxi\TaxiApplication.java 에서 Run 'TaxiApplication' 클릭.
        - URL 접속 : localhost:9090 으로 브라우저에서 접속.
