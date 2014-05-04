package org.unearthed.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: grant
 */
public class ClientNode {

    public static void main(String args[]) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:hazelcast-client.xml");
    }
}
