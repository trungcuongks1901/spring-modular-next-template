package com.example.app.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.example.app.modules")
class ModuleDependencyTest {
    @ArchTest
    static final ArchRule masterdata_not_depend_on_business = noClasses().that().resideInAnyPackage("..modules.masterdata..")
            .should().dependOnClassesThat().resideInAnyPackage("..modules.business..");
    @ArchTest
    static final ArchRule identity_not_depend_on_business = noClasses().that().resideInAnyPackage("..modules.identity..")
            .should().dependOnClassesThat().resideInAnyPackage("..modules.business..");
    @ArchTest
    static final ArchRule shared_not_depend_on_modules = noClasses().that().resideInAnyPackage("..modules.shared..")
            .should().dependOnClassesThat().resideInAnyPackage("..modules.masterdata..", "..modules.identity..", "..modules.business..");
}
