package com.sheliming.drools.list;

import com.sheliming.drools.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestList {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("list_ksession");

        List list = new ArrayList();

        Person person = new Person("小明", 12);
        list.add(person);

        Person person2 = new Person("小红", 20);
        list.add(person2);

        list.add(1);
        list.add(2);

        kSession.insert(list);


        Map map = new HashMap();
        map.put("key1", "value1");
        map.put("key2", 1);
        kSession.insert(map);

        int i = kSession.fireAllRules();
        System.out.println("规则数：" + i);

        kSession.dispose();
    }
}
