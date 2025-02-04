**Annotation Setting**
⭐️자동 와이어링
- Byname
- Bytype
- constructor

```java
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context.xsd">

⭐️<context:annotation-config/>⭐️ // annotation wiring Use .
</beans>


  - @Autowired
  - UnsatisfiedDependencyException
    @Autowired(required = false)

  - @Qualifier

    - @Autowired
      @Qualifier("bean11")


  ```java  
  public class Bean2 {
   //  @Autowired

    private Bean1 bean1;
    @Autowired
    @Qualifier("bean11")
    public void setBean1(Bean1 bean1) {
        this.bean1 = bean1;
    }

    public Bean1 getBean1() {
        return this.bean1;
    }
  }

      <bean id="bean1" class="wiring.Bean1" />
      <bean id="bean11" class="wiring.Bean1" primary="true"/>
      <bean id="bean2" class="wiring.Bean2"/>
      <bean id="bean3" class="wiring.Bean3"/>

      
  ```

  ****
- 샤부레
- 마부레
```java
<dependency>
      <groupId>jakarta.inject</groupId>
      <artifactId>jakarta.inject-api</artifactId>
      <version>2.0.1</version>
</dependency>











