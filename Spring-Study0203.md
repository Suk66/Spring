***의존성 주입***
#collection
- Collection/List : <list>
- Collection/Set : <set>
- Map            : <map>
- Properties      : <props>
- Null            : <null/>

```java
public class MainXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("di.xml");
        DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
        DiBean diBean = context.getBean("diBean", DiBean.class);
        List<String> list = diBean.getList();
        for(String s : list)
            System.out.println(s);
        Set<String> set = diBean.getSet();
        for(String s : set)
            System.out.println(s);


        Map<String, String> map = diBean.getMap();
        for (String key : map.keySet())
            System.out.printf("%s : %s\n", key, map.get(key));


        Properties properties = diBean.getProperties();
        String value1 = properties.getProperty("속성1");
        String value2 = properties.getProperty("속성2");
        String value3 = properties.getProperty("속성3");
        System.out.println("속성1 : " + value1);
        System.out.println("속성2 : " + value2);
        System.out.println("속성3 : " + value3);

        String strNull = diBean.getStrNull();
        if(strNull == null)
            System.out.println("널 값이 주입되었습니다.");

        

    }
}
```

**SpEL표현식**

- 다른빈 속성 값 출력
```java
public class OtherBean {
    @Value("다른 빈 속성")
    private String value;
    public String getValue() {
        return value;
    }
}


@Value("#{otherBean.value}")
    private String otherValue;
    public String getOtherValue() {
        return otherValue;
    }

<main
String otherValue = diAnnotation.getOtherValue();
        System.out.println(otherValue);
```

**application.properties**
- priority = high
- values=value1,value2,value3
- maps={key1:'1',key2:'2',key3:'3'}

  #값을 이곳에 설정해 놓고 가져다 씀.

```java
@Value("${priority:normal}")    // 프로퍼티 설정 안해놓고 이곳에서 노말주면 기본값 노말 출력.
    private String priority;
    public String getPriority() {
        return priority;
    }
<main
    String priority = diAnnotation.getPriority();
        System.out.println(priority);


@Value("${values}")
    private String[] array;
    public String[] getArray() {
        return array;
    }
<main
    String[] array = diAnnotation.getArray();
        for(String s : array)
            System.out.println(s);

@Value("#{${maps}}")
    private Map<String, Integer> map;
    public  Map<String, Integer> getMap() {
        return map;
    }
<main
    Map<String, Integer> map = diAnnotation.getMap();
        for(String key : map.keySet())
            System.out.printf("%s : %d\n", key, map.get(key));

```


#조금 더 심화(?)
```java
@Value("#{'${values}'.split(',')}")
    private List<String> list;

    public List<String> getList() {
        return list;
    }
<main
    List<String> list = diAnnotation.getList();
        for (String s : list)
            System.out.println(s);


@Value("#{'${values}'.split(',')}")
    private Set<String> set;

    public Set<String> getSet() {
        return set;
    }
<main
    Set<String> set = diAnnotation.getSet();
        for(String s : set)
            System.out.println(s);
```






