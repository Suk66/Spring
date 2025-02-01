**Di의존성 주입**
- 방식
 - XML

  ```java
  public class MainXML {
      public static void main(String[] args) {
          ApplicationContext context = new ClassPathXmlApplicationContext("di.xml");
          DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
          DiBean diBean = context.getBean("diBean", DiBean.class);
      }
  }
  ```

  ```java
    <bean id="diBean" class="di.DiBean">
  <!--        <constructor-arg value="주입된 값" />-->
          <property name="value" value="주입된 값" />
      </bean>
  ```

