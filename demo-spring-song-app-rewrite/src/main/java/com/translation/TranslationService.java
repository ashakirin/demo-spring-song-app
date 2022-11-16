/*~~(Recipe applicable test failed with an exception.
java.lang.IllegalAccessError: class org.openrewrite.java.testing.junit5.UpdateTestAnnotation tried to access protected method 'org.openrewrite.java.JavaIsoVisitor org.openrewrite.java.search.FindImports.getVisitor()' (org.openrewrite.java.testing.junit5.UpdateTestAnnotation and org.openrewrite.java.search.FindImports are in unnamed module of loader org.codehaus.plexus.classworlds.realm.ClassRealm @5f726750)
  org.openrewrite.java.testing.junit5.UpdateTestAnnotation.getSingleSourceApplicableTest(UpdateTestAnnotation.java:49))~~>*/package com.translation;

import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    public String translate(String text) {
        return text.equals("Top 10 songs") ? "10 ಅತ್ಯಂತ ಖ್ಯಾತಿ ಹಾಡುಗಳು" : text;
    }
}
