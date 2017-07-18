package net.willxlwei.utilities.launch;

import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Created by will on 2017/7/13.
 */
public class LaunchProvider {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        context.start();
        System.out.println("Provider already started!");

        /*----------------------------------------------------------*/
        System.in.read();
    }
}
