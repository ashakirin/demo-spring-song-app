/*~~(Recipe applicable test failed with an exception.
java.lang.IllegalAccessError: class org.openrewrite.java.testing.junit5.UpdateTestAnnotation tried to access protected method 'org.openrewrite.java.JavaIsoVisitor org.openrewrite.java.search.FindImports.getVisitor()' (org.openrewrite.java.testing.junit5.UpdateTestAnnotation and org.openrewrite.java.search.FindImports are in unnamed module of loader org.codehaus.plexus.classworlds.realm.ClassRealm @5f726750)
  org.openrewrite.java.testing.junit5.UpdateTestAnnotation.getSingleSourceApplicableTest(UpdateTestAnnotation.java:49))~~>*/package org.springboot.example.songs.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fabian Krüger
 */
public interface SongRepository extends JpaRepository<Song, Long> {
}
