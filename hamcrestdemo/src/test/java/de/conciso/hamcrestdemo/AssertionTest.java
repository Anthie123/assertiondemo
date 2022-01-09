package de.conciso.hamcrestdemo;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.conciso.hamcrestdemo.util.CustomMatcher;

public class AssertionTest {

  public static final String STRING_VALUE = "Test";
  public static final List<String> STRING_LIST = Arrays.asList("1", "2", "3", "4");

  @Test
  public void testAssertions() {
    assertThat(STRING_VALUE, equalTo(STRING_VALUE));
    assertThat(STRING_VALUE, matchesPattern("T..t"));

    assertThat(STRING_VALUE, lessThanOrEqualTo("Tesy"));

    assertThat(10d, closeTo(9d, 2));

    assertThat(STRING_LIST, allOf(contains("2", "3"), not(contains("10"))));

    assertThat("Einfacher String Wert", STRING_VALUE, equalTo(10));
  }

  @Test
  public void customAssertionTest() {
    assertThat(new TestClass(), CustomMatcher.containsStringValue("Test"));
  }


}
