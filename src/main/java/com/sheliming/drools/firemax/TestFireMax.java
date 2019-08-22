package com.sheliming.drools.firemax;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestFireMax {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("hello_ksession");

        int i = kSession.fireAllRules(3);
        System.out.println("规则数：" + i);

        kSession.dispose();
    }
}
