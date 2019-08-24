package com.sheliming.drools.group;

import com.sheliming.drools.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

/**
 * 测试无状态session
 */
public class TestGroup {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("group_ksession");

        kSession.getAgenda().getAgendaGroup("group1").setFocus();

        int i = kSession.fireAllRules();
        System.out.println("规则数：" + i);

        kSession.dispose();

    }
}
