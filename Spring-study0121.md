

**스프링 라이브러리 설치실패시**

#m2파일 삭제 하면 새로 리다운로드 함.

# 💎 스프링에서 객체를 주입하는 방법
      -객체 주입 생성자 통해 주입
```java
public SamsungTV(SonySpeaker speaker) {
		System.out.println("==> SamsungTV(2) 생성");
		
		this.speaker = speaker;
	}
```


-setter 메서드를 이용해서 주입

