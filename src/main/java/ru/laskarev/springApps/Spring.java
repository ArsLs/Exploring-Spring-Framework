package ru.laskarev.springApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.laskarev.springApps.ClientOfLibrary.AbstractClient;

import java.util.Map;

public class Spring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Library Library = context.getBean("Library", Library.class);

        for (Map.Entry e : Library.getTakenBooks().entrySet()){
            System.out.println(((AbstractClient)e.getKey()).getName() +' '+ ((AbstractClient)e.getKey()).getEmail() + '=' + e.getValue());
        }
        System.out.println("Name of library: " + Library.getName());

        context.close();
    }
}
