package com.example.lab7_2

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val rule = activityScenarioRule<MainActivity>()

    private lateinit var device: UiDevice


    @Test
    fun broadcastBeforeTest() {
        Espresso.onView(ViewMatchers.withId(R.id.text))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello World!")))
    }
}

