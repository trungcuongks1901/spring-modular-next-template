package com.example.app.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.example.app")
class LayeredArchitectureTest {
    @ArchTest
    static final ArchRule controllers_should_not_access_repositories = noClasses()
            .that().resideInAnyPackage("..controller..")
            .should().dependOnClassesThat().resideInAnyPackage("..repository..");

    @ArchTest
    static final ArchRule repositories_should_not_depend_on_services = noClasses()
            .that().resideInAnyPackage("..repository..")
            .should().dependOnClassesThat().resideInAnyPackage("..service..");
}
