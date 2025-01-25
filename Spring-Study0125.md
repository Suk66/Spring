**깃허브에서 원격 저장소 체인지 간단한 방법.**
#간단한 부분에서 개고생 하지말자..



**원격 저장소 연결을 새로 설정**
# (기존에 origin이 Spring 레포지토리였으니까 없애고 새 레포지토리에 연결)
```java
# A. 기존 원격 연결 지우기 (기존 저장소는 그대로 남아 있음)
git remote remove origin

# B. 새 원격 레포지토리(IntelliJProject) 등록
git remote add origin https://github.com/Suk66/IntelliJProject.git
```



**원하는 브랜치로 푸시 (Deb)**
```java
# 로컬에서 작업한 브랜치가 Deb라면:
git push -u origin Deb
```
-u(혹은 --set-upstream)로 “로컬 Deb ↔ 원격 Deb” 연결이 설정됨.
이제부터 git push 만으로 Deb 브랜치를 업데이트할 수 있음.

그럼에도 충돌이 생기는 이유는?
원격 레포지토리에 같은 이름의 브랜치가 이미 있고, 그 브랜치에 조금이라도 다른 커밋이 있으면,
Git이 “이력이 달라요”라며 거부할 수 있음 → pull이나 rebase 또는 --force push가 필요해짐.


