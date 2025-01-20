
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
```
여기까지가 첫째 문단.


```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Markdown!");
    }
}
```
여기까지가 두번째 문단.

> **📌 새 코드 시작!**
```java
System.out.println("New Code Here!");
```
새로운 코드방식.

# 📌 새 코드 시작!
```python
print("Hello, Python!")
```
파이썬 코드 종료.

# 💎 뽀인트!
그리고 자바코드 살짝 삽입 `System.out.println("== > samsungTV " );` 그리고 다시 아무일 없는대로.

###🎐💍💎 **설명과 구분하기**
| 코드 | 설명 |
|------|------|
| ```java public class Hello { System.out.println("Hello!"); }``` | Java Hello World 예제 |
| ```python print("Hello, Python!")``` | Python Hello World 예제 |




