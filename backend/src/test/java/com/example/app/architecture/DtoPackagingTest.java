package com.example.app.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.example.app")
class DtoPackagingTest {
    @ArchTest
    static final ArchRule request_dtos_in_request_package = classes().that().haveSimpleNameEndingWith("Request")
            .should().resideInAnyPackage("..dto.request..");

    @ArchTest
    static final ArchRule response_dtos_in_response_package = classes().that().haveSimpleNameEndingWith("Response")
            .should().resideInAnyPackage("..dto.response..");
}
