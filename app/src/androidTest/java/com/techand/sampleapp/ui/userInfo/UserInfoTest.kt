package com.techand.sampleapp.ui.userInfo

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.techand.sampleapp.R
import com.techand.sampleapp.launchFragmentInHiltContainer
import com.techand.sampleapp.ui.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserInfoTest {

    //Test Fragment
    @ExperimentalCoroutinesApi
    @Test
    fun testLaunchFragmentInHiltContainer(){
        launchFragmentInHiltContainer<UserInfo> {
        }
    }

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun launchActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.nav_host_fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun launchUserInfoFragmentTitle() {
        Espresso.onView(ViewMatchers.withText(R.string.user_info))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun displayRecyclerView() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerlist))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun countTotalItemsIsSeven() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerlist))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(7)))
    }
    @Test
    fun onclickFirstItemReturnTrue() {
        Espresso.onView(ViewMatchers.withId(R.id.recyclerlist))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<UserInfoAdapter.DataViewHolder>(0,
                    ViewActions.click()
                ))
    }
}
