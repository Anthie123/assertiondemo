package de.conciso.assertjdemo;

import static org.assertj.core.api.Assertions.allOf;
import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.not;
import static org.assertj.core.api.Assumptions.assumeThat;

import de.conciso.assertjdemo.util.CustomAssertion;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Condition;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

public class AssertionTest {

  public static final String STRING_VALUE = "Test";
  public static final List<String> STRING_LIST = Arrays.asList("1", "2", "3", "4");

  @Test
  public void testAssertions() {
    assertThat(STRING_VALUE).isEqualTo(STRING_VALUE);
    assertThat(STRING_VALUE).containsPattern("T??t");
    assertThat(STRING_VALUE).isLessThanOrEqualTo("Tesy");

    assertThat(10).isCloseTo(9, Percentage.withPercentage(20));

    assertThat(STRING_LIST)
        .hasSize(4)
        .doesNotContain("10")
        .contains("2", "3");

    // assertThat(STRING_VALUE).as("Einfacher String Wert").isEqualTo(10);

    assertThatExceptionOfType(RuntimeException.class).isThrownBy(
        () -> {throw new RuntimeException("");})
        .withMessage("");

    assertThatThrownBy(() -> {throw new RuntimeException(STRING_VALUE);})
        .hasNoCause()
        .hasMessage(STRING_VALUE);

    assertThat(LocalDateTime.now())
        .isAfter(LocalDateTime.now().minusMinutes(1))
        .isBefore(LocalDateTime.now().plusMinutes(1));

    assertThat(Stream.of(1,2,3,4,5)).hasSize(5).doesNotContain(12);

    assertThat(new TestClass())
        .extracting(TestClass::getIntValue, TestClass::getLongValue)
        .contains(2, 1L);
  }

  @Test
  public void softAssertions() {
    SoftAssertions soft = new SoftAssertions();
    soft.assertThat(STRING_VALUE).isEqualTo(STRING_VALUE);
    soft.assertThat(STRING_VALUE).containsPattern("T??t");
    soft.assertThat(STRING_VALUE).isLessThanOrEqualTo("Tesy");

    soft.assertThat(10).isCloseTo(9, Percentage.withPercentage(20));

    soft.assertThat(STRING_LIST)
        .hasSize(4)
        .doesNotContain("10")
        .contains("2", "3");

    soft.assertThat(STRING_VALUE).as("Einfacher String Wert").isEqualTo(10);

    soft.assertThatThrownBy(() -> {throw new RuntimeException(STRING_VALUE);})
        .hasNoCause()
        .hasMessage(STRING_VALUE);

    soft.assertThat(LocalDateTime.now())
        .isAfter(LocalDateTime.now().minusMinutes(1))
        .isBefore(LocalDateTime.now().plusMinutes(1));

    soft.assertThat(Stream.of(1,2,3,4,5)).hasSize(5).doesNotContain(12);

    soft.assertThat(new TestClass())
        .extracting(TestClass::getIntValue, TestClass::getLongValue)
        .contains(2, 1L);

    soft.assertAll();
  }

  @Test
  public void assumptionTest() {
    assumeThat(STRING_VALUE).isEqualTo("");
    //assumeThat(STRING_VALUE).isEqualTo(STRING_VALUE);

    assertThat(STRING_VALUE).isEqualTo(STRING_VALUE);
  }

  @Test
  public void conditionTest() {
    Condition<String> trueCondition = new Condition<>(STRING_LIST::contains, "4");
    Condition<String> falseCondition = new Condition<>(STRING_LIST::contains, "10");

    assertThat(STRING_VALUE).is(allOf(trueCondition, not(falseCondition)));
  }

  @Test
  public void customAssertionTest() {
    CustomAssertion.assertThat(new TestClass())
        .hasLongValue(2L)
        .hasStringValue("bla");
  }


}
