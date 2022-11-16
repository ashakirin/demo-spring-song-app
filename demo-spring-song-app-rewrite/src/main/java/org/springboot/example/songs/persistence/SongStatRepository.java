/*
 * Copyright 2021 - 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*~~(Recipe applicable test failed with an exception.
java.lang.IllegalAccessError: class org.openrewrite.java.testing.junit5.UpdateTestAnnotation tried to access protected method 'org.openrewrite.java.JavaIsoVisitor org.openrewrite.java.search.FindImports.getVisitor()' (org.openrewrite.java.testing.junit5.UpdateTestAnnotation and org.openrewrite.java.search.FindImports are in unnamed module of loader org.codehaus.plexus.classworlds.realm.ClassRealm @5f726750)
  org.openrewrite.java.testing.junit5.UpdateTestAnnotation.getSingleSourceApplicableTest(UpdateTestAnnotation.java:49))~~>*/package org.springboot.example.songs.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface SongStatRepository extends JpaRepository<SongStat, Long>,  PagingAndSortingRepository<SongStat, Long> {
    List<SongStat> findTop3SongsByRegionOrderByTimesPlayedDesc(Locale region);

    Optional<SongStat> findOptionalBySongAndRegion(Song song, Locale region);
}
