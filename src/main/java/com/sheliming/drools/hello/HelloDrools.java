package com.sheliming.drools.hello;

import com.sheliming.drools.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class HelloDrools {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("hello_ksession");

        kSession.insert(new Person("小明", 12));
        int i = kSession.fireAllRules();
        System.out.println("规则数：" + i);

        kSession.insert(new Person("小红", 20));
        int j = kSession.fireAllRules();
        System.out.println("规则数：" + j);

        kSession.dispose();
    }
}
