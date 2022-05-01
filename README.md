# socket_study_01

# 웹소켓 통신을 위한 저장소
## STOMP활용

# 오류가 발생했던 점

- spring freemarker 사용하려면 application에 설정해줘야 할 값들이 있다.
``` yaml
spring:
  devtools:
    livereload:
      enabled: true
    restart:
      enabled: false
  freemarker:
    cache: false
    template-loader-path: classpath:/templates
    suffix: .ftl
```
예시는 devtools와 섞여있는 값들..
-> 이걸 해줘야지 ftl파일을 잡을 수 있다.
-> 오류 내용은 다시 정리 



- CORS 문제로 접속이 안되는 경우가 있는데
registry에 추가할 때 setAllowedOrigin("*") 부분을
setAllowedOriginPatterns로 바꿔주면 된다.


- 입장시에 입장이름이 안적히는 문제가 있었는데
Controller에서 Message.Type을 JOIN으로 했기 때문이다.
ENTER로 바꿔주면 그대로 전달 가능

- Redis설정을 할때 의존성 추가부분이
``` gradle
    implementation 'org.springframework.boot:spring-boot-starter-data-redis'
    //embedded-redis
    compile group: 'it.ozimov', name: 'embedded-redis', version: '0.7.2'
```
이라고 적힌 부분이 있지만

``` gradle
    implementation 'org.springframework.boot:spring-boot-starter-data-redis:2.6.3'
    implementation group: 'it.ozimov', name: 'embedded-redis', version: '0.7.2'
```
다음과 같이 수정해서 사용해야한다.

- Redis Subscribe부분에서 문제가 있다. 
-> 저장소와의 연결 문제를 해결 ✔ -> 경로 설정을 잘 해줘야 함.

- JDK 11 버전 이후부터는 JAXB(java.xml.bind module) 에 대한 의존성을 JDK에서 제공하고 있지 않기 때문에  
jaxb 의존성을 추가해주면 된다.  
java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException 에러발생


- Profile 설정에서 문제
application 파일을 나누어서 관리할 때 profile이 잘 변경되었는지 확인.
