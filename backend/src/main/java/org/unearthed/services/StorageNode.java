package org.unearthed.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: grant
 */
public class StorageNode {

    public static void main(String args[]) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:hazelcast-storage.xml");
    }
}
