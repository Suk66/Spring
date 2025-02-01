**스프링빈 **
#POJO
- plaim
- old
- java
- object

```java
#@Configuration
public class AppConfig {
}
```

#스프링 빈 생성
- 스프링 빈 설정
  ```java
  beans{
      빈_이름(빈_타입){
      }
  }
  ```

  - 스프링 빈 가져오기
    ```java
    CustomerService customerService = context.getBean("⭐️스프링빈 이름⭐️", CustomerService.class(⭐️반환할 데이터타입⭐️);

    CustomerService customerService = 😘형변환(CustomerService)context.getBean("⭐️스프링빈 이름⭐️");


  - 스프링 빈 서비스
    ```java
    @Service("customerService")
    public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;

    ```
    ⭐️⭐️⭐️CustomerServiceImpl을 서비스(스프링빈)으로 등록이 우선임.

  - 스프링 빈
    ```java
    public class MainAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
       // CustomerService customerService = (CustomerService) context.getBean("customerService");
        List<Customer> customers = customerService.getCustomers();
        for(Customer customer :customers )
            System.out.println(customer);
    }
    }
    ```

    ||
     L 위 MainAnnotation에서 ApplicationContext context 인스턴스를 AppConfig.class로 우회해서 거기에서 받아온
    ```java
    @Configuration
    @ComponentScan(basePackages = "com.mycompany.ordersystem")
    public class AppConfig {
    }

    ```
    으로 패키지를 정확히 지정해서 스캔함
    - 해당 패키지를 스캔하여 스프링빈을 가져옴. 위에서 해당 패키지에 Service Annotation을를 CustomerServiceImpl에 추가 했음.



  - 스프링 빈 영역
     #Scope
     - singleton : 애플리케이션 컨텐스트당 단 하나의 인스턴스를 생성.
     - prototype : getBean() 메서드가 호출될 떄 마다 하나의 인스턴스를 생성.
     ```java
     @Scope(value = "prototype")
     public PrototypeBean() {

     <bean id="PrototypeBean" class="PrototypeBean" scope="prototype"/>
     ```
       
     - request   : HTTP request 영역 안에서 인스턴스 생성.
     - session   : HTTP session 영역 안에서 인스턴스 생성.
     - application : 서블릿 컨텍스트 영역 안에서 인스턴스 생성.
   

**ClassPathXmlApplicationContext**
  - FileSystemXmlApplicationContext
  - GenericXmlApplicationContext
    #전통적인 스프링 설정방식
    - beans.xml에 <bean>태그로 Bean 등록
    - <context:component-scan> 등으로 자동 스캔가능.
      #가독성 설정이 분리되어 있어 구조파악이 용이.
      #표준화 xml로 표준화된 설정 가능.
      #오래된 레거시와 호환성 높음.
      ⭐️ 코드가 길어질 수 있음 - 컴파일 시점 오류확인X


**AnnotationConfigApplicationContext**
  - @ComponentScan
  - @Component, @Service, @Repository
    #XML 없이 클래스를 스캔하여 자동으로 Bean등록 - Configuration 파일과 함께 사용 하기도 함.
    #컴파일 시점 오류확인 가능. 간결한 코드.
    ⭐️ 어노테이션이 분산되어 있으면 구조파악이 어려울 수 있음 - 기존 레거시(XML)와 혼용시 복잡.

**@Configuration + @Bean**
  - AnnotationConfigApplicationContext
    #자바클래스 내부에서 @Bean 등록. - XML 완전 대체가능.


  
     
  
    
