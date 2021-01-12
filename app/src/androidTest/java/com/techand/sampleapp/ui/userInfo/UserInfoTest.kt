package com.techand.sampleapp.ui.userInfo

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.techand.sampleapp.launchFragmentInHiltContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
}
