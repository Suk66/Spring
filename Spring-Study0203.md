***의존성 주입***
#collection
- Collection/List : <list>
- Collection/Set : <set>
- Map            : <map>
-Properties      : <props>

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

    }
}
```
