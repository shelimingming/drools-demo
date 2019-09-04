package com.sheliming.drools.listener;

import org.kie.api.event.kiebase.*;

public class MyKieBaseEventListener implements KieBaseEventListener {

    public void beforeKiePackageAdded(BeforeKiePackageAddedEvent event) {
        System.out.println("beforeKiePackageAdded:" + event);
    }

    public void afterKiePackageAdded(AfterKiePackageAddedEvent event) {
        System.out.println("afterKiePackageAdded:" + event);
    }

    public void beforeKiePackageRemoved(BeforeKiePackageRemovedEvent event) {
        System.out.println("beforeKiePackageRemoved:" + event);
    }

    public void afterKiePackageRemoved(AfterKiePackageRemovedEvent event) {
        System.out.println("afterKiePackageRemoved:" + event);
    }

    public void beforeKieBaseLocked(BeforeKieBaseLockedEvent event) {
        System.out.println("beforeKieBaseLocked:" + event);
    }

    public void afterKieBaseLocked(AfterKieBaseLockedEvent event) {
        System.out.println("afterKieBaseLocked:" + event);
    }

    public void beforeKieBaseUnlocked(BeforeKieBaseUnlockedEvent event) {
        System.out.println("beforeKieBaseUnlocked:" + event);
    }

    public void afterKieBaseUnlocked(AfterKieBaseUnlockedEvent event) {
        System.out.println("afterKieBaseUnlocked:" + event);
    }

    public void beforeRuleAdded(BeforeRuleAddedEvent event) {
        System.out.println("beforeRuleAdded:" + event);
    }

    public void afterRuleAdded(AfterRuleAddedEvent event) {
        System.out.println("afterRuleAdded:" + event);
    }

    public void beforeRuleRemoved(BeforeRuleRemovedEvent event) {
        System.out.println("beforeRuleRemoved:" + event);
    }

    public void afterRuleRemoved(AfterRuleRemovedEvent event) {
        System.out.println("afterRuleRemoved:" + event);
    }

    public void beforeFunctionRemoved(BeforeFunctionRemovedEvent event) {
        System.out.println("beforeFunctionRemoved:" + event);
    }

    public void afterFunctionRemoved(AfterFunctionRemovedEvent event) {
        System.out.println("afterFunctionRemoved:" + event);
    }

    public void beforeProcessAdded(BeforeProcessAddedEvent event) {
        System.out.println("beforeProcessAdded:" + event);
    }

    public void afterProcessAdded(AfterProcessAddedEvent event) {
        System.out.println("afterProcessAdded:" + event);
    }

    public void beforeProcessRemoved(BeforeProcessRemovedEvent event) {
        System.out.println("beforeProcessRemoved:" + event);
    }

    public void afterProcessRemoved(AfterProcessRemovedEvent event) {
        System.out.println("afterProcessRemoved:" + event);
    }
}
