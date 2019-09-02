package com.sheliming.drools.dynamic;

import org.kie.api.KieServices;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;

public class ReleaseIdTest {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieRepository kieRepository = kieServices.getRepository();
        ReleaseId defaultReleaseId = kieRepository.getDefaultReleaseId();


        System.out.println(defaultReleaseId);
    }
}
