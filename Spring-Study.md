
```java
####public class TVUser {

	###public static void main(String[] args) {
		// 현재 코드의 개념이 Ioc 개념임.
		// 컨테이너 생성
		// 스프링 컨테이너를 생성을 하자.
		##GenericXmlApplicationContext container =
				##new GenericXmlApplicationContext("applicationContext.xml");
		
		
		// 컨테이너로부터 객체를 검색(Lookup)한다.
		#Tv tv =(Tv)container.getBean(args[0]);
		
		tv.turnOn();
		tv.turnOff();
		tv.soundDown();
		tv.soundOn();
	}
}

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Markdown!");
    }
}

> **📌 새 코드 시작!**
```java
System.out.println("New Code Here!");

# 📌 새 코드 시작!

```python
print("Hello, Python!")


| 코드 | 설명 |
|------|------|
| ```java public class Hello { System.out.println("Hello!"); }``` | Java Hello World 예제 |
| ```python print("Hello, Python!")``` | Python Hello World 예제 |




