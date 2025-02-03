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
