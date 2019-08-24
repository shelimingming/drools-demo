package com.sheliming.drools.stateless;

import com.sheliming.drools.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

/**
 * 测试无状态session
 */
public class TestStatelessSession {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        StatelessKieSession stateless_ksession = kContainer.newStatelessKieSession("stateless_ksession");

        stateless_ksession.execute(new Person("小明", 12));

    }
}
