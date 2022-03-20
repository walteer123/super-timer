package dependencies

import dependencies.Version.app_compat_version
import dependencies.Version.compose_activity_version
import dependencies.Version.compose_version
import dependencies.Version.core_ktx_version
import dependencies.Version.lifecycle_runtime_ktx_version
import dependencies.Version.material_version

object Dependencies {
    const val coreKtx = "androidx.core:core-ktx:$core_ktx_version"
    const val appCompat = "androidx.appcompat:appcompat:$app_compat_version"
    const val material = "com.google.android.material:material:$material_version"

    object Compose {
        const val composeUi = "androidx.compose.ui:ui:$compose_version"
        const val composeMaterial = "androidx.compose.material:material:$compose_version"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview:$compose_version"
        const val composeActivity = "androidx.activity:activity-compose:$compose_activity_version"
    }

    const val lifecycleRuntimeKtx =  "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_runtime_ktx_version"
}
