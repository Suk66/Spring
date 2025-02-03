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
      
   - Annotation
 
   ```java
   public class InjectedBean {
    public InjectedBean(){
        System.out.println("InjectedBean이 생성됩니다...");
    }
   }  
  ```

  ```java
  public class DependentBean {
    private InjectedBean injectedBean;
    public DependentBean(InjectedBean injectedBean) {
        System.out.println("DependentBean이 생성됩니다...인자생성..");
        System.out.println("인자 생성자에서 InjectedBean이 주입됩니다...");
        this.injectedBean = injectedBean;
    }
    public DependentBean() {
        // 매개변수가 없는 생성자... 후순위 생성이라 처음 겪는 개념.;;
        System.out.println("DependentBean이 생성됩니다... 나는 기본생성자!");
    }
    public void setInjectedBean(InjectedBean injectedBean) {
        System.out.println("세터 메서드에서 InjectedBean이 주입됩니다...");
        this.injectedBean = injectedBean;
    }
  }
  ```

  ```java
  <bean id="injectedBean" class="di.InjectedBean" />
    <bean id="dependentBean" class="di.DependentBean">
        <constructor-arg ref="injectedBean" />
        <!-- 필드를 사용하는 주입(?)방식 -->
  <!--        <property name="injectedBean" ref="injectedBean" />-->
      </bean>
  ```

  ```java
  public class MainAnnotation {
     public static void main(String[] args) {
         ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
         DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
 
     }
  }
  ```
