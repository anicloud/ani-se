package com.ani.se.on;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huangbin on 6/21/15.
 */
public class ServerApp {
    public static void main( String [] args ) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context/app.xml");
    }
}
