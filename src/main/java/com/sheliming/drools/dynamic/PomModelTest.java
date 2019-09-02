package com.sheliming.drools.dynamic;

import org.appformer.maven.support.PomModel;
import org.drools.core.util.IoUtils;

import java.io.*;

public class PomModelTest {
    public static void main(String[] args) throws IOException {
        File resource = new File( "pom.xml");
        byte[] bytes = IoUtils.readBytesFromInputStream(new FileInputStream(resource));
        PomModel pomModel = PomModel.Parser.parse("pom.xml", new ByteArrayInputStream(bytes));

        System.out.println(pomModel.getReleaseId());
    }
}
