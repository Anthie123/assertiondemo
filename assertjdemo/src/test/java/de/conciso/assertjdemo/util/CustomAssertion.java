package de.conciso.assertjdemo.util;

import de.conciso.assertjdemo.TestClass;
import java.util.Objects;
import org.assertj.core.api.AbstractAssert;

public class CustomAssertion extends AbstractAssert<CustomAssertion, TestClass> {

  public CustomAssertion(TestClass actual) {
    super(actual, CustomAssertion.class);
  }

  public static CustomAssertion assertThat(TestClass actual) {
    return new CustomAssertion(actual);
  }

  public CustomAssertion hasStringValue(String value) {
    isNotNull();
    if (!Objects.equals(actual.getStringValue(), value)) {
      failWithMessage("Wrong string value honk: <%s> <> <%s>", value, actual.getStringValue());
    }
    return this;
  }

  public CustomAssertion hasLongValue(long value) {
    isNotNull();
    if (!Objects.equals(actual.getLongValue(), value)) {
      failWithMessage("Wrong long value honk: <%d> <> <%d>", value, actual.getLongValue());
    }
    return this;
  }

}
