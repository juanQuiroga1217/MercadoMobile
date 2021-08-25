package com.mercadolibreprueba.mercadomobile.view;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;

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
public class TestProductDetailsScreen {

    @Rule
    public ActivityTestRule<SearchActivity> mActivityTestRule = new ActivityTestRule<>(SearchActivity.class);


    @Test
    public void testProductDetailsScreen() {

        View recyclerViewCelulares = mActivityTestRule.getActivity().findViewById(R.id.recyclerCategoryCelulares);

        recyclerViewCelulares
                .getViewTreeObserver()
                .addOnGlobalLayoutListener(() -> {
                    ViewInteraction recyclerView = onView(
                            allOf(withId(R.id.recyclerCategoryCelulares),
                                    childAtPosition(
                                            withClassName(is("android.widget.LinearLayout")),
                                            1)));
                    recyclerView.perform(actionOnItemAtPosition(0, click()));


                    ViewInteraction button = onView(
                            allOf(withId(R.id.btnVolver),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                            5)),
                                            1),
                                    isDisplayed()));
                    button.check(matches(isDisplayed()));

                    ViewInteraction recyclerView2 = onView(
                            allOf(withId(R.id.recyclerProductAttributes),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            6),
                                    isDisplayed()));
                    recyclerView2.check(matches(isDisplayed()));


                    ViewInteraction textView = onView(
                            allOf(withId(R.id.lblProductDetailsTitle), withText("Realme 6 Dual Sim 128 Gb Blanco Cometa 4 Gb Ram"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            1),
                                    isDisplayed()));
                    textView.check(matches(isDisplayed()));

                    ViewInteraction imageView = onView(
                            allOf(withId(R.id.ProductDetailsPicture), withContentDescription("Product Photo"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            2),
                                    isDisplayed()));
                    imageView.check(matches(isDisplayed()));

                    ViewInteraction imageView2 = onView(
                            allOf(withId(R.id.ProductDetailsPicture), withContentDescription("Product Photo"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            2),
                                    isDisplayed()));
                    imageView2.check(matches(isDisplayed()));

                    ViewInteraction appCompatButton = onView(
                            allOf(withId(R.id.btnVolver), withText("Volver"),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            withClassName(is("android.widget.RelativeLayout")),
                                                            6)),
                                            1)));
                    appCompatButton.perform(scrollTo(), click());

                    ViewInteraction recyclerView3 = onView(
                            allOf(withId(R.id.recyclerCategoryComputacion),
                                    childAtPosition(
                                            withClassName(is("android.widget.LinearLayout")),
                                            1)));
                    recyclerView3.perform(actionOnItemAtPosition(0, click()));

                    ViewInteraction textView2 = onView(
                            allOf(withId(R.id.lblProductDetailsTitle), withText("Portátil Dell V3 3400 I5-1135g7 Ram 16gb Ssd 128gb + 1tb Win"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            1),
                                    isDisplayed()));
                    textView2.check(matches(isDisplayed()));

                    ViewInteraction imageView3 = onView(
                            allOf(withId(R.id.ProductDetailsPicture), withContentDescription("Product Photo"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            2),
                                    isDisplayed()));
                    imageView3.check(matches(isDisplayed()));

                    ViewInteraction textView3 = onView(
                            allOf(withId(R.id.lblProductDetailsPrice), withText("$2,670,000.00"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            3),
                                    isDisplayed()));
                    textView3.check(matches(isDisplayed()));

                    ViewInteraction button3 = onView(
                            allOf(withId(R.id.btnIrMercadoLibre),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                            5)),
                                            0),
                                    isDisplayed()));
                    button3.check(matches(isDisplayed()));

                    ViewInteraction button4 = onView(
                            allOf(withId(R.id.btnVolver),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                            5)),
                                            1),
                                    isDisplayed()));
                    button4.check(matches(isDisplayed()));

                    ViewInteraction recyclerView4 = onView(
                            allOf(withId(R.id.recyclerProductAttributes),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            6),
                                    isDisplayed()));
                    recyclerView4.check(matches(isDisplayed()));

                    ViewInteraction recyclerView5 = onView(
                            allOf(withId(R.id.recyclerProductAttributes),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            6),
                                    isDisplayed()));
                    recyclerView5.check(matches(isDisplayed()));

                    ViewInteraction appCompatButton2 = onView(
                            allOf(withId(R.id.btnVolver), withText("Volver"),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            withClassName(is("android.widget.RelativeLayout")),
                                                            6)),
                                            1)));
                    appCompatButton2.perform(scrollTo(), click());

                    ViewInteraction recyclerView6 = onView(
                            allOf(withId(R.id.recyclerCategoryDeportes),
                                    childAtPosition(
                                            withClassName(is("android.widget.LinearLayout")),
                                            1)));
                    recyclerView6.perform(actionOnItemAtPosition(0, click()));

                    ViewInteraction textView4 = onView(
                            allOf(withId(R.id.lblProductDetailsTitle), withText("Bandas De Resistencia Para Hacer Ejercicios Kit De 5 Bandas "),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            1),
                                    isDisplayed()));
                    textView4.check(matches(isDisplayed()));

                    ViewInteraction imageView4 = onView(
                            allOf(withId(R.id.ProductDetailsPicture), withContentDescription("Product Photo"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            2),
                                    isDisplayed()));
                    imageView4.check(matches(isDisplayed()));

                    ViewInteraction textView5 = onView(
                            allOf(withId(R.id.lblProductDetailsPrice), withText("$17,000.00"),
                                    childAtPosition(
                                            childAtPosition(
                                                    IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                                    0),
                                            3),
                                    isDisplayed()));
                    textView5.check(matches(isDisplayed()));

                    ViewInteraction button5 = onView(
                            allOf(withId(R.id.btnIrMercadoLibre),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                            5)),
                                            0),
                                    isDisplayed()));
                    button5.check(matches(isDisplayed()));

                    ViewInteraction button6 = onView(
                            allOf(withId(R.id.btnVolver),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                            5)),
                                            1),
                                    isDisplayed()));
                    button6.check(matches(isDisplayed()));

                    ViewInteraction appCompatButton3 = onView(
                            allOf(withId(R.id.btnVolver), withText("Volver"),
                                    childAtPosition(
                                            allOf(withId(R.id.productDetailButtons),
                                                    childAtPosition(
                                                            withClassName(is("android.widget.RelativeLayout")),
                                                            6)),
                                            1)));
                    appCompatButton3.perform(scrollTo(), click());
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
