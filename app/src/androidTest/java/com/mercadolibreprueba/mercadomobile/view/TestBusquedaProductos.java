package com.mercadolibreprueba.mercadomobile.view;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.mercadolibreprueba.mercadomobile.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestBusquedaProductos {

    @Rule
    public ActivityTestRule<SearchActivity> mActivityTestRule = new ActivityTestRule<>(SearchActivity.class);

    @Test
    public void testBusquedaProductos() {


        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.txtSearch),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.searchContainer),
                                        1),
                                0)));
        appCompatEditText.perform(scrollTo(), replaceText("camiseta"), closeSoftKeyboard());


        ViewInteraction editText = onView(
                allOf(withId(R.id.txtSearch), withText("camiseta"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.searchContainer),
                                        1),
                                0),
                        isDisplayed()));
        editText.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.btnSearch), withContentDescription("Search Button"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.searchContainer),
                                        1),
                                1)));
        appCompatImageButton.perform(scrollTo(), click());


        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerSearchResult),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                3)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnVolver), withText("Volver"),
                        childAtPosition(
                                allOf(withId(R.id.productDetailButtons),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                6)),
                                1)));
        appCompatButton.perform(scrollTo(), click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recyclerSearchResult),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                3)));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnVolver), withText("Volver"),
                        childAtPosition(
                                allOf(withId(R.id.productDetailButtons),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                6)),
                                1)));
        appCompatButton3.perform(scrollTo(), click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recyclerSearchResult),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                3)));
        recyclerView3.perform(actionOnItemAtPosition(48, click()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnIrMercadoLibre), withText("Ver en Mercado Libre"),
                        childAtPosition(
                                allOf(withId(R.id.productDetailButtons),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                6)),
                                0)));
        appCompatButton2.perform(scrollTo(), click());
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
