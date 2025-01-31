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
  
    
