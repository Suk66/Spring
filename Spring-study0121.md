

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

***SamsungTV와 AplleTV를 인터페이스로 동시에 사용하는 방법***

# 💎 인터페이스로 만들 시
	-xml 파일로 쉽게 통제가 가능.
```java
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





***setter 메서드를 이용해서 주입***
	

 **Danger 💎💎💎 setter 사용시 인자전달 방식이 아니라서 기본생성자와 매칭(?)**

#1-3
```java
<!--  setter() 메서드를 이용한 주입 -->
		<bean id="tv" class="com.spring.injection.SamsungTV">
			<property name="speaker" ref="speaker" />
			<property name="price" value="1500000" />
		</bean>
```



***스프링에서 안 좋아하는 방법CollectionBean***

# 1-1
```java
public class CollectionBean {

	private String[] addressList = {"공덕동", "대흥동", "합정동"};

	public String[] getAddressList() {
		return addressList;
	}

	public void setAddressList(String[] addressList) {
		this.addressList = addressList;
	}
}
```

```java
public static void main(String[] args) {
		GenericXmlApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 컨테이너로부터 사용한 객체를 lookup 하자.
		CollectionBean bean = container.getBean("collection", CollectionBean.class);
		
		String[] addressList = bean.getAddressList();
		
		for(String address : addressList) {
			
			System.out.print(address + "\t");
		}
		
		System.out.println();
		
		// 콘테이너 종료.
		container.close();
	}
```

***스프링에서 좋아하는 방법***
private String[] addressList; 
	=직접리스트를 {" value, value, value"} 하는 방식은 주소값이 지워지면 없어지고 수정도 어렵기 때문에 스프링이 좋아하지 않음.
 하여 xml을 이용하여 제어함.





