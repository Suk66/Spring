**매우 중요 인텔리제이 커뮤니티에디션에서 셋팅.**
- Project Structure
  <img width="1046" alt="스크린샷 2025-02-06 17 26 44" src="https://github.com/user-attachments/assets/0ad597ce-9eed-4c99-95d7-a696dfe99f20" />


  <img width="1028" alt="스크린샷 2025-02-06 17 28 42" src="https://github.com/user-attachments/assets/7a07944e-b95f-458d-b345-38df3a645579" />


  <img width="1028" alt="스크린샷 2025-02-06 17 29 44" src="https://github.com/user-attachments/assets/faead325-06ea-498f-82c8-667b2d1941f7" />


  <img width="1028" alt="스크린샷 2025-02-06 17 31 58" src="https://github.com/user-attachments/assets/646cc91f-2302-4bdd-a05b-7f2a6f4b2033" />


  <img width="1028" alt="스크린샷 2025-02-06 17 32 56" src="https://github.com/user-attachments/assets/5d4ca5ed-1afa-47a9-b689-6bab928578dd" />


  <img width="1028" alt="스크린샷 2025-02-06 17 34 07" src="https://github.com/user-attachments/assets/64fdd943-00fa-4aa7-b001-2902fe25d680" />


  <img width="802" alt="스크린샷 2025-02-06 17 35 05" src="https://github.com/user-attachments/assets/935dc08b-46ab-405a-80db-c1089b0e8790" />


  <img width="1093" alt="스크린샷 2025-02-06 17 36 24" src="https://github.com/user-attachments/assets/37c465cc-e349-452f-ab62-a0d0438dd680" />



**오늘의 똥고쇼 퍼레이드**
- 배포가 잘 이루어졌는지 확인해야 함.
```java  
ls /Users/hsuk/springweb/ch09/orderTest/target/

// 여기에서 war 가 있어야 함.
// clean → 이전 빌드 결과를 삭제 (기존 target/ 폴더 삭제)
// install → 프로젝트를 빌드하고 .war 파일 생성

cd /Users/hsuk/springweb/ch09/orderTest  // 프로젝트 폴더로 이동을 해서
mvn clean package

cp /Users/hsuk/springweb/ch09/orderTest/target/orderTest.war /Users/hsuk/.SmartTomcat/orderTest/orderTest/webapps/
// 이후 해당 war 타겟에 있는 배포파일을 톰켓 배포 하는 곳으로 터미널을 통해 이동시킴.

```
**심플한 JSP뛰우기.**

webapp
    - WEB-INF - web.xml
    ```java
    <!DOCTYPE web-app PUBLIC
     "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
     "http://java.sun.com/dtd/web-app_2_3.dtd" >
    
    <web-app>
      <display-name>Archetype Created Web Application</display-name>
    
      <servlet>
        <servlet-name>default</servlet-name>
        <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
      </servlet>
    
      <servlet-mapping>
        <servlet-name>default</servlet-name>
        <url-pattern>/</url-pattern>
      </servlet-mapping>
    
      <!-- 인덱스 페이지 설정 -->
      <display-name>Test JSP App</display-name>
      <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
      </welcome-file-list>
      </web-app>
      ```



      - pom.xml
      ```java
      <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>com.mycompany</groupId>
      <artifactId>orderTest</artifactId>
      <packaging>war</packaging>
      <version>1.0-SNAPSHOT</version>
      <name>orderTest Maven Webapp</name>
      <url>http://maven.apache.org</url>
      <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      </properties>


      <dependencies>
        <dependency>
          <groupId>javax.servlet</groupId>
          <artifactId>javax.servlet-api</artifactId>
          <version>4.0.1</version>
          <scope>provided</scope>
        </dependency>

    <!-- Spring MVC -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.22</version>
    </dependency>

    <!-- JSP Support -->
    <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
      <version>9.0.98</version>
    </dependency>

    <!-- JSTL -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>

    <!-- Logging -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.2.10</version>
    </dependency>



    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
      </dependencies>
          <build>
            <plugins>
              <!-- WAR 플러그인 -->
              <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.1</version>
                <configuration>
                  <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
              </plugin>
            </plugins>
          </build>
        </project>
        ```
    

    





