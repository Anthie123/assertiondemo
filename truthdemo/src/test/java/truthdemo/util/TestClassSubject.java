package truthdemo.util;

import static com.google.common.truth.Truth.assertAbout;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;
import org.checkerframework.checker.nullness.qual.Nullable;
import truthdemo.TestClass;

public class TestClassSubject extends Subject {

  private final TestClass actual;

  protected TestClassSubject(FailureMetadata metadata,
      @Nullable TestClass actual) {
    super(metadata, actual);
    this.actual = actual;
  }

  public void hasStringValue(String value) {
    check("stringValue()").that(actual.getStringValue()).isEqualTo(value);
  }

  public void hasLongValue(Long value) {
    check("longValue()").that(actual.getLongValue()).isEqualTo(value);
  }

  public static Factory<TestClassSubject, TestClass> testclasses() {
    return TestClassSubject::new;
  }

  public static TestClassSubject assertThat(@Nullable TestClass actual) {
    return assertAbout(testclasses()).that(actual);
  }
}
