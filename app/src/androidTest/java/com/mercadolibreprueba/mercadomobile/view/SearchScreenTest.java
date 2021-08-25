package com.mercadolibreprueba.mercadomobile.view;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.mercadolibreprueba.mercadomobile.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchScreenTest {

    @Rule
    public ActivityTestRule<SearchActivity> mActivityTestRule = new ActivityTestRule<>(SearchActivity.class);

    @Test
    public void searchScreenTest() {


        View recyclerViewCelulares = mActivityTestRule.getActivity().findViewById(R.id.recyclerCategoryCelulares);
        View recyclerViewDeportes = mActivityTestRule.getActivity().findViewById(R.id.recyclerCategoryDeportes);
        View recyclerViewComputacion = mActivityTestRule.getActivity().findViewById(R.id.recyclerCategoryComputacion);

        recyclerViewCelulares
                .getViewTreeObserver()
                .addOnGlobalLayoutListener(() -> {
                    ViewInteraction recyclerView = onView(
                            allOf(withId(R.id.recyclerCategoryCelulares),
                                    childAtPosition(
                                            childAtPosition(
                                                    withId(R.id.promotionsContainer),
                                                    1),
                                            1),
                                    isDisplayed()));
                    recyclerView.check(matches(isDisplayed()));
                });



        recyclerViewComputacion
                .getViewTreeObserver()
                .addOnGlobalLayoutListener(() -> {
                    ViewInteraction recyclerView3 = onView(
                            allOf(withId(R.id.recyclerCategoryComputacion),
                                    childAtPosition(
                                            childAtPosition(
                                                    withId(R.id.promotionsContainer),
                                                    2),
                                            1),
                                    isDisplayed()));
                    recyclerView3.check(matches(isDisplayed()));

                    ViewInteraction recyclerView4 = onView(
                            allOf(withId(R.id.recyclerCategoryComputacion),
                                    childAtPosition(
                                            childAtPosition(
                                                    withId(R.id.promotionsContainer),
                                                    2),
                                            1),
                                    isDisplayed()));
                    recyclerView4.check(matches(isDisplayed()));
                });


        recyclerViewDeportes
                .getViewTreeObserver()
                .addOnGlobalLayoutListener(() -> {

                    onView(withId(R.id.recyclerCategoryDeportes))
                            .perform(scrollTo());

                    ViewInteraction recyclerView2 = onView(
                            allOf(withId(R.id.recyclerCategoryDeportes),
                                    childAtPosition(
                                            childAtPosition(
                                                    withId(R.id.promotionsContainer),
                                                    3),
                                            1),
                                    isDisplayed()));
                    recyclerView2.check(matches(isDisplayed()));

                });

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
