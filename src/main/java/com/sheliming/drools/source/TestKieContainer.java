package com.sheliming.drools.source;

import org.drools.compiler.kie.builder.impl.KieContainerImpl;
import org.drools.compiler.kie.builder.impl.KieProject;
import org.drools.compiler.kie.builder.impl.KieRepositoryImpl;
import org.drools.compiler.kie.builder.impl.KieServicesImpl;
import org.drools.compiler.kie.builder.impl.event.KieModuleDiscovered;
import org.drools.compiler.kie.builder.impl.event.KieServicesEventListerner;
import org.kie.api.KieServices;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;

import java.util.Collection;

public class TestKieContainer {
    public static void main(String[] args) {
    KieServicesImpl ks = (KieServicesImpl)KieServices.Factory.get();
        ks.registerListener(new KieServicesEventListerner() {
@Override
public void onKieModuleDiscovered(KieModuleDiscovered event) {
        System.out.println("listener:"+event.getKieModuleUrl());
        }
        });

        KieContainerImpl kContainer = (KieContainerImpl)ks.getKieClasspathContainer();

        KieProject kieProject = kContainer.getKieProject();
        System.out.println(kieProject);

        Collection<String> kieBaseNames = kieProject.getKieBaseNames();
        System.out.println(kieBaseNames);

        KieRepositoryImpl repository = (KieRepositoryImpl) ks.getRepository();
        ReleaseId defaultReleaseId = repository.getDefaultReleaseId();
        System.out.println(defaultReleaseId);
        }
        }
