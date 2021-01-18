package com.techand.sampleapp.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.techand.sampleapp.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun launchActivity() {

        onView(withId(R.id.nav_host_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun launchUserInfoFragment() {

        //check frag name displayed
        onView(withText(R.string.user_info))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        //recyclerlist
        onView(withId(R.id.recyclerlist))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}