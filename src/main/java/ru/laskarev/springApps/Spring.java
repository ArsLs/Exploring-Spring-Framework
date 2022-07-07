package ru.laskarev.springApps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MyFirstBean myFirstBean = context.getBean("myFirstBean", MyFirstBean.class);

        System.out.println("Condition: " + myFirstBean.getCondition());

        context.close();
    }
}
