package com.comensal.organizacion;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import rcg.org.comensal.SharedLayeredRules;

@AnalyzeClasses(
    packages = "com.comensal",
    importOptions = ImportOption.DoNotIncludeTests.class
)
class ArchitectureTest {

    @ArchTest
    static final ArchTests LAYER_RULES = ArchTests.in(SharedLayeredRules.class);
}
