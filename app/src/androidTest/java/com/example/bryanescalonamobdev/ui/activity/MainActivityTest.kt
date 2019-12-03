package com.example.bryanescalonamobdev.ui.activity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.bryanescalonamobdev.R
import com.example.bryanescalonamobdev.base.RecyclerMatcher.Companion.withItemCount
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkRecycler(){
        if (getRvCount() > 0){
            var item = getRvCount()
            Espresso.onView(ViewMatchers.withId(R.id.rv_animal_list))
                .check(ViewAssertions.matches(withItemCount(item)))
        }
    }

    private fun getRvCount(): Int {
        val recyclerView =
            mActivityTestRule.activity.findViewById(R.id.rv_animal_list) as RecyclerView
        return recyclerView.adapter!!.itemCount
    }

    private fun DrawableMatcher(icon:Int): Matcher<View> {
        return DrawableMatcher(icon)
    }

}