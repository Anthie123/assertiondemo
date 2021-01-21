package de.conciso.hamcrestdemo.util;

import de.conciso.hamcrestdemo.TestClass;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatcher extends TypeSafeMatcher<TestClass> {

  private final String value;

  public CustomMatcher(String value) {
    this.value = value;
  }
  @Override
  protected boolean matchesSafely(TestClass item) {
    return item.getStringValue().equals(value);
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("StringValue is not equal to " + value);
  }

  public static Matcher<TestClass> containsStringValue(String value) {
    return new CustomMatcher(value);
  }
}
