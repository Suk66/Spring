package context;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MainXML {
    public static void main(String[] args) {
       // ApplicationContext context = new classPathXmlApplicationContext("beans.xml");
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("beans.xml");
        context.refresh();

    }
}
