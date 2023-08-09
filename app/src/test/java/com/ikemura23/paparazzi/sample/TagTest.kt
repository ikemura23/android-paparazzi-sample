package com.ikemura23.paparazzi.sample

import androidx.compose.material3.MaterialTheme
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.ikemura23.paparazzi.sample.ui.component.Tag
import org.junit.Rule
import org.junit.Test

class TagTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.NEXUS_5.copy(softButtons = false),
        renderingMode = SessionParams.RenderingMode.SHRINK,
    )

    @Test
    fun testTag() {
        paparazzi.snapshot("Tag") {
            MaterialTheme {
                Tag(name = "Snapshot-Test")
            }
        }
    }
}
