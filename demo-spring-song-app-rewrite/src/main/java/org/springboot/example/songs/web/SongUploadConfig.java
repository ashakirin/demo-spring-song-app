/*~~(Recipe applicable test failed with an exception.
java.lang.IllegalAccessError: class org.openrewrite.java.testing.junit5.UpdateTestAnnotation tried to access protected method 'org.openrewrite.java.JavaIsoVisitor org.openrewrite.java.search.FindImports.getVisitor()' (org.openrewrite.java.testing.junit5.UpdateTestAnnotation and org.openrewrite.java.search.FindImports are in unnamed module of loader org.codehaus.plexus.classworlds.realm.ClassRealm @5f726750)
  org.openrewrite.java.testing.junit5.UpdateTestAnnotation.getSingleSourceApplicableTest(UpdateTestAnnotation.java:49))~~>*/package org.springboot.example.songs.web;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class SongUploadConfig {
    @Bean
    CommonsMultipartResolver commonsMultipartResolver() {
        final CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(-1);
        return commonsMultipartResolver;
    }
}
