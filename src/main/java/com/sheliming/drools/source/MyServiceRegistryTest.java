package com.sheliming.drools.source;

import org.kie.api.KieServices;
import org.kie.api.internal.utils.ServiceRegistry;

/**
 * 自定义的kie.conf文件
 */
public class MyServiceRegistryTest {
    public static void main(String[] args) {
        MyInterface myInterface = ServiceRegistry.getInstance().get(MyInterface.class);
        System.out.println(myInterface);
        myInterface.hello();

    }
}
