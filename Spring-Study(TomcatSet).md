**IntelliJ ComunityEdition**
- 톰캣설정 방법.
- file -> project Structure - module - dependencies - +catalina.jar  compile checkbox - apply Ok
- Run Edit Config
  Tomcat 9.0.98
  Java17 - org.apache.catalina.startup.Bootstrap - start - /Users/hsuk/apache-tomcat-9.0.98 - JAVA_HOME=/Users/hsuk/apache-tomcat-9.0.98
  맥 확장 속성 제거. hsuk@hyunsukkimui-MacBookPro bin % sudo xattr -d com.apple.quarantine catalina.sh

  -- 그냥 다 필요없고 메이븐 의존성 추가하면 끝남.... 개고생함;
  <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-catalina</artifactId>
      <version>9.0.98</version>
    </dependency>

    <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-bootstrap</artifactId>
      <version>9.0.98</version>
    </dependency>

    <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-util</artifactId>
      <version>9.0.98</version>
    </dependency>

    <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-juli</artifactId>
      <version>9.0.98</version>
    </dependency>


    <!-- JSP 새로 추가 -->
    <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-jasper</artifactId>
      <version>9.0.98</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>




  **이게 제일 중요!!! 톰캣설정**
  ```java
  <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-catalina</artifactId>
      <version>9.0.98</version>
    </dependency>

    <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-core</artifactId>
      <version>9.0.98</version>
    </dependency>

    <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-util</artifactId>
      <version>9.0.98</version>
    </dependency>

    <dependency>
      <groupId>org.apache.tomcat</groupId>
      <artifactId>tomcat-juli</artifactId>
      <version>9.0.98</version>
    </dependency>

    ```
    메이븐 의존성 추가.



    
