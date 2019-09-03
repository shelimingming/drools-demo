package com.sheliming.drools.dynamic;

import com.sheliming.drools.Person;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

public class KieHelperTest {
    public static void main(String[] args) {
        String drl = "package rules.hello\n" +
                "import com.sheliming.drools.Person\n" +
                "\n" +
                "rule \"ageLower18\"\n" +
                "    when\n" +
                "        $person: Person(age < 18)\n" +
                "    then\n" +
                "        System.out.println($person.getName()+\"未成年\");\n" +
                "    end\n" +
                "\n" +
                "rule \"ageUper18\"\n" +
                "    when\n" +
                "        $person: Person(age >= 18)\n" +
                "    then\n" +
                "        System.out.println($person.getName()+\"已成年\");\n" +
                "    end";
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();


        kieSession.insert(new Person("小明", 12));
        int i = kieSession.fireAllRules();
        System.out.println("规则数：" + i);
    }
}
