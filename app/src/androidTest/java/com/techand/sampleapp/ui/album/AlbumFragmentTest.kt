package com.techand.sampleapp.ui.album

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.techand.sampleapp.R
import com.techand.sampleapp.ui.MainActivity
import com.techand.sampleapp.ui.userInfo.UserInfoAdapter
import org.junit.Rule
import org.junit.Test

class AlbumFragmentTest{
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onclickFirstItemReturnTrue() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerlist))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<UserInfoAdapter.DataViewHolder>(
                    0,
                    ViewActions.click()
                )
            )

        Espresso.onView(ViewMatchers.withText(R.string.album))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.recyclr_album))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.recyclr_album))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(5)))
    }


}