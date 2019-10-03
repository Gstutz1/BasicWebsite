package springxml;

import springxml.beans.Figure;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext");

        Figure figure = context.getBean("odin", Figure.class);

        System.out.println(figure.getName());
        System.out.println(figure.getInfo());
        System.out.println(figure.getSections().get(0).getHeader());
        System.out.println(figure.getSections().get(0).getBody());

        System.out.println(figure.getDataVerification().sendNotification());

        context.close();
    }
}
