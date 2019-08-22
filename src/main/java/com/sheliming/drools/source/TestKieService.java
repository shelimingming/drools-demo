package com.sheliming.drools.source;

import com.sheliming.drools.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestKieService {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();

        //两种获取方法,newKieClasspathContainer("a")可以设置容器的ID；getKieClasspathContainer容器ID随机的
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieContainer kContainer2 = ks.newKieClasspathContainer();
        KieContainer kContainer3 = ks.newKieClasspathContainer("containerId");


        KieSession kSession = kContainer.newKieSession("source_ksession");

        kSession.insert(new Person("小明", 12));
        int i = kSession.fireAllRules();
        System.out.println("规则数：" + i);

        kSession.dispose();
    }
}
