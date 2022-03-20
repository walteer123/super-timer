package dependencies

import dependencies.Version.compose_version
import dependencies.Version.espresso_core_version
import dependencies.Version.junit_ext_version
import dependencies.Version.junit_version

object TestDependencies {
    const val jUnit = "junit:junit:$junit_version"
    const val jUnitTestExt = "androidx.test.ext:junit:$junit_ext_version"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espresso_core_version"
    const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4:$compose_version"
}
