package com.sheliming.drools.dynamic;

import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.builder.model.KieSessionModel;
import org.kie.api.conf.EqualityBehaviorOption;
import org.kie.api.conf.EventProcessingOption;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class KmoduleTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        KieServices kieServices = KieServices.Factory.get();
        KieModuleModel kieModuleModel = kieServices.newKieModuleModel();

        KieBaseModel kieBaseModel = kieModuleModel.newKieBaseModel("kbase_name")
                .addPackage("rules.dynamic")
                .setDefault(true)
                .setEqualsBehavior(EqualityBehaviorOption.EQUALITY)
                .setEventProcessingMode(EventProcessingOption.STREAM);

        KieSessionModel kieSessionModel = kieBaseModel.newKieSessionModel("ksession_name")
                .setDefault(true)
                .setType(KieSessionModel.KieSessionType.STATEFUL);

        String kieModuleModelString = kieModuleModel.toXML();
        System.out.println(kieModuleModelString);

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.writeKModuleXML(kieModuleModelString);

        ReleaseId releaseId = kieServices.newReleaseId("com.shleiming", "drools-rules", "1.0.0");
        kieFileSystem.generateAndWritePomXML(releaseId);


        getRuleFiles();
    }

    public static List<File> getRuleFiles() throws UnsupportedEncodingException {
        String rulesPath = "rules";

        List<File> RuleFileList = new ArrayList<File>();

        URL url = Thread.currentThread().getContextClassLoader().getResource(rulesPath);
        if (url == null) {
            return RuleFileList;
        }
        System.out.println(url);

        String path = url.getPath();
        path = URLDecoder.decode(path, "UTF-8");

        File rootDir = new File(path);
        File[] files = rootDir.listFiles();
        System.out.println(files);


        return RuleFileList;
    }

}
