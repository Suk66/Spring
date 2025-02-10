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


**더 심플한 aop**
- <aop:aspectj-autoproxy/>
- XML 형식에 aop에서 autoproxy를 줘서 beans.xml에 모든 요소를 주석처리 하고 사용할 수 있음.
  ```java
  <!--    <aop:config>-->
<!--        <aop:aspect ref="loggingAspect">-->
<!--            <aop:pointcut id="getLogging"-->
<!--                          expression="execution(* com.mycompany.ordersystem.*.*.*.get*(..))-->
<!--                                    || execution(* com.mycompany.ordersystem.*.*.*.find*(..))"/>-->
<!--            <aop:pointcut id="saveLogging"-->
<!--                          expression="execution(* com.mycompany.ordersystem.*.*.*.save*(..))"/>-->
<!--            <aop:before pointcut-ref="getLogging" method="logBefore"/>-->
<!--            <aop:after pointcut-ref="getLogging" method="logAfter"/>-->
<!--            <aop:after-returning pointcut-ref="getLogging" method="logAfterReturning"/>-->
<!--            <aop:after-throwing pointcut-ref="getLogging" method="logAfterThrowing"/>-->
<!--            <aop:around pointcut-ref="saveLogging" method="logAround"/>-->
<!--        </aop:aspect>-->
<!--    </aop:config>-->
```


#⭐️⭐️위대한 PointCut⭐️⭐️
- aspect - LoggingAspect
```java
@Aspect
@Component
public class LoggingAspect {
    private Logger log = LoggerFactory.getLogger(getClass());
    @Pointcut("execution(* com.mycompany.ordersystem.*.*.*.get*(..)) ||\n" +
            "execution(* com.mycompany.ordersystem.*.*.*.find*(..))")
    public void getLogging() {}

    @Before("getLogging()")
    public void logBefore(JoinPoint joinPoint) {
        String message = buildJoinPoint(joinPoint);
        message += "메서드 실행 시작";
        log.info(message);
    }

    ```

  #⭐️⭐️메인실행시 AppConfig.class요소 불러옴. ⭐️⭐️
  ```java
  public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


    // 해당 구성요소들.
    import com.mycompany.ordersystem.aspect.LoggingAspect;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.EnableAspectJAutoProxy;
    
    @Configuration    // 이요소 Java 설정 기반. 이것과 함께 aop를 사용하려면 밑에 오토프록시를 사용해야 함.
    @ComponentScan(basePackages = {"com.mycompany.ordersystem"})
    @EnableAspectJAutoProxy    // autoProxy 
    public class AppConfig {
    
        @Bean
        public LoggingAspect loggingAspect() {
            return new LoggingAspect();
        }
    } 


