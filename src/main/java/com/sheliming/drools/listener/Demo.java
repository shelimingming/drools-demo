package com.sheliming.drools.listener;

import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class Demo {
    public static void main(String[] args) {

        KieHelper kieHelper = new KieHelper();
        kieHelper.addResource(ResourceFactory.newClassPathResource("rules/hello/person.drl"), ResourceType.DRL);

        KieBase kieBase = kieHelper.build();
        kieBase.addEventListener(new MyKieBaseEventListener());

        kieBase.removeKiePackage("rules.hello");

        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();

    }
}
