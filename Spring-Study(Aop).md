**Aop관련 <aop:Config>와 Configuration(Java 기반) 설정을 같이 사용 할 때는 반드시 **
- @EnableAspectJAutoProxy 를 설정해줘야 함.
  ```java
  import org.springframework.context.annotation.ComponentScan;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.context.annotation.EnableAspectJAutoProxy;
  
  @Configuration
  @ComponentScan(basePackages = {"com.mycompany.ordersystem"})
  @EnableAspectJAutoProxy
  public class AppConfig {
  }

  ```
