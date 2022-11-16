package org.openrewrite.java.test;

import org.openrewrite.ExecutionContext;
import org.openrewrite.InMemoryExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.Result;
import org.openrewrite.config.Environment;
import org.openrewrite.java.JavaParser;
import org.openrewrite.java.tree.J;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class RunRewriteManually {
    public static void main(String[] args) throws IOException {
        // determine your project directory and provide a list of
        // paths to jars that represent the project's classpath
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + s);

        Path projectDir = Paths.get("demo-spring-song-app-rewrite");
        List<Path> classpath = emptyList();


        // put any rewrite recipe jars on this main method's runtime classpath
        // and either construct the recipe directly or via an Environment
        Environment environment = Environment.builder().scanRuntimeClasspath().build();
        Recipe recipe = environment.activateRecipes("org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_0");

        // create a JavaParser instance with your classpath
        JavaParser javaParser = JavaParser.fromJavaVersion()
                .classpath(classpath)
                .build();

        // walk the directory structure where your Java sources are located
        // and create a list of them
        List<Path> sourcePaths = Files.find(projectDir, 999, (p, bfa) ->
                        bfa.isRegularFile() && (p.getFileName().toString().endsWith(".java")
                                || p.getFileName().toString().equals("pom.xml")
                                || p.getFileName().toString().equals("application.properties")
                        )).collect(Collectors.toList());

        ExecutionContext ctx = new InMemoryExecutionContext(Throwable::printStackTrace);

        // parser the source files into ASTs
        List<J.CompilationUnit> cus = javaParser.parse(sourcePaths, projectDir, ctx);

        // collect results
        List<Result> results = recipe.run(cus, ctx).getResults();
        if (results.isEmpty()) {
            System.out.println("No changes");
        }

        for (Result result : results) {
            // print diffs to the console
            System.out.println(result.diff(projectDir));

            // or overwrite the file on disk with changes.
//             Files.writeString(result.getAfter().getSourcePath(),
//                    result.getAfter().printAll());
        }

    }
}