package com.sheliming.drools.dynamic;

import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;

public class CreateReleaseIdTest {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId("com.shleiming", "drools-rules", "1.0.0");

        System.out.println(releaseId);
    }
}
