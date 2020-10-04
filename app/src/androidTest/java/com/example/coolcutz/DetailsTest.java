package com.example.coolcutz;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class DetailsTest {

    @Rule
    public ActivityTestRule<Details>mActivityTestRule = new ActivityTestRule<Details>(Details.class);

    private Details mActivity = null;
    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity;
    }
    @Test
    public void testLunch() {
        View view =mActivity.findViewById(R.id.edittxtphone);
        assertNotNull(view);
    }
    @After
    public void tearDown() throws Exception {
        mActivity =  null;
    }


    private class ActivityTestRule<T> {
        public T getActivity;

        public ActivityTestRule(Class<T> detailsClass) {
        }
    }
}