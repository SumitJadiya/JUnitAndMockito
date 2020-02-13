package com.in28minutes.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Run list of test cases (grouping)
@RunWith(Suite.class)
@SuiteClasses({ StringHelperParameterizedTest.class, StringHelperTest.class })
public class AllTests {

}
