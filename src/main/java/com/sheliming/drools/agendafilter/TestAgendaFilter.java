package com.sheliming.drools.agendafilter;

import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

/**
 * 规则过滤的使用
 */
public class TestAgendaFilter {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("firemax_ksession");

        int i = kSession.fireAllRules(new RuleNameEqualsAgendaFilter("规则3"));
        System.out.println("规则数：" + i);

        kSession.dispose();

        System.out.println("--------------------------");

        kSession = kContainer.newKieSession("firemax_ksession");

        i = kSession.fireAllRules(new AgendaFilter() {
            public boolean accept(Match match) {
                System.out.println("规则名称:" + match.getRule().getName());
                return true;
            }
        });
        System.out.println("规则数：" + i);

        kSession.dispose();
    }
}
