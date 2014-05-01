package org.unearthed.services;

import com.google.gson.Gson;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.unearthed.cache.MapNames;

/**
 * User: grant
 */
public class Main implements MapNames {

    private static Gson gson;

    public static void main(String args[]) {
        gson = new Gson();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        CacheService hazelcastService = applicationContext.getBean(CacheService.class);

        hazelcastService.addContinuousQuery(EQUIPMENT_MAP, new CacheListener<Object, Object>() {

            @Override
            public void added(CacheEvent<Object, Object> event) {
                System.out.println("Added " + toJson(event));
            }

            @Override
            public void updated(CacheEvent<Object, Object> event) {
                System.out.println("Updated " + toJson(event));
            }

            @Override
            public void removed(CacheEvent<Object, Object> event) {
                System.out.println("Removed " + toJson(event));
            }


        }, "equipmentModel = 'CAT950'");
    }

    private static String toJson(Object object) {
        return gson.toJson(object);
    }
}
