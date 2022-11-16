/*~~(Recipe applicable test failed with an exception.
java.lang.IllegalAccessError: class org.openrewrite.java.testing.junit5.UpdateTestAnnotation tried to access protected method 'org.openrewrite.java.JavaIsoVisitor org.openrewrite.java.search.FindImports.getVisitor()' (org.openrewrite.java.testing.junit5.UpdateTestAnnotation and org.openrewrite.java.search.FindImports are in unnamed module of loader org.codehaus.plexus.classworlds.realm.ClassRealm @5f726750)
  org.openrewrite.java.testing.junit5.UpdateTestAnnotation.getSingleSourceApplicableTest(UpdateTestAnnotation.java:49))~~>*/package org.springboot.example.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Value
@ConfigurationProperties(prefix = "region")
public class RegionConfig {
    private Locale regionCode;

    public RegionConfig(Locale regionCode) {
        this.regionCode = regionCode;
    }
}
