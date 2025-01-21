

**스프링 라이브러리 설치실패시**

#m2파일 삭제 하면 새로 리다운로드 함.
 -스프링이 필요한 라이브러리를 다운로드 하다가 실패 할 가능성이 있음.


# 💎 스프링에서 객체를 주입하는 방법
      -객체 주입 생성자 통해 주입
```java
public SamsungTV(SonySpeaker speaker) {
		System.out.println("==> SamsungTV(2) 생성");
		this.speaker = speaker;
	}
```

***SamsungTV와 AplleTV를 인터페이스로 동시에 사용하는 방법.
#인터페이스로 만들 시 xml 파일로 쉽게 통제가 가능.
```java
package com.spring.injection;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker() {
		System.out.println("==> AppleSpeaker 생성");
	}
	public void volumeUp() {
		System.out.println("AppleSpeaker --> 소리 올리기");
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker --> 소리 내리기");
	}
}
```


***생성자3***
#1-1
```java
public SamsungTV(Speaker speaker) {
		System.out.println("==> SamsungTV(2) 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("==> SamsungTV(3) 생성");
		this.speaker = speaker;
		this.price = price;
	}
```


#1-2
```java
<bean id="speaker" class="com.spring.injection.SonySpeaker" />
	
	<bean id="tv" class="com.spring.injection.SamsungTV">
		<constructor-arg value="1500000" />
		<constructor-arg ref="speaker" />	
	</bean>
</beans>
```





-setter 메서드를 이용해서 주입

