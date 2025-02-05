**웹 어플리케이션 컨텍스트**
- web applicationContext

  <img width="819" alt="스크린샷 2025-02-05 12 47 01" src="https://github.com/user-attachments/assets/fca17a0b-beeb-4a38-8cdd-ccd2f4a608c2" />



- ComponentScan Annotation
  - useDefaultFilters Attribute
    ```java
    @ComponentScan(basepackages={"com.mycompany.ordersystem"},useDefaultFilters=false)

    ```

  - includeFilters Attribute
     - 특정한 조건을 만족하는 것만 지정할 수 있음.
    ```java
    @includeFilters = {
        @ComponentScan.Filter(type = FilterType.Annotation, classes = {Service.class, repository.class}
    }
    
    ```

  - excludeFilters Attribute
    - 특정한 조건이 제시된 것만 빼고 지정하는 includeFilters의 반대 개념
    ```java
    @excludeFilters = {
        @ComponentScan.Filter(type = FilterType.Annotation, classes = {Controller.class}
    }

    ```

  - basePackagesClasses Attribute
    - 지정된 클래스의 패키지와 그 하위 패키지에서 스프링빈을 찾음
    ```java
    @basePackageClasses = {CustomerService.class, Repository.class
    }

    lazyinit = true     //

    ```


    ***Spring MVC Acktecture***

    - 핸들러 매핑이 컨트롤러 결정하는 방법.
    - 디스패처 서블릿이 컨트롤러에게 HTTP 요청 및 모델을 전송하는 방법.
    - 뷰 리졸버가 물리적인 뷰를 결정하는 방법
    - 뷰가 모델을 사용하는 방법
    
  

    

