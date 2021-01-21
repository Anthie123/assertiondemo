package truthdemo;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import truthdemo.util.TestClassSubject;

public class AssertionTest {

  public static final String STRING_VALUE = "Test";
  public static final List<String> STRING_LIST = Arrays.asList("1", "2", "3", "4");

  @Test
  public void testAssertions() {
    assertThat(STRING_VALUE).isEqualTo(STRING_VALUE);
    assertThat(STRING_VALUE).containsMatch("T..t");
    assertThat(STRING_VALUE).isAtMost("Tesy");

    assertThat(10d).isWithin(2).of(9);


    assertThat(STRING_LIST).hasSize(4);

    //assertWithMessage("Einfacher String Wert").that(STRING_VALUE).isEqualTo(10);

    Throwable e = assertThrows(RuntimeException.class, () -> {throw new RuntimeException(STRING_VALUE);});
    assertThat(e).hasMessageThat().isEqualTo(STRING_VALUE);


    assertThat(Stream.of(1,2,3,4,5)).isNoneOf(12, null, null);
  }
  @Test
  public void assumptionTest() {
    assume().that(STRING_VALUE).isEqualTo("");
    //assume().that(STRING_VALUE).isEqualTo(STRING_VALUE);

    assertThat(STRING_VALUE).isEqualTo(STRING_VALUE);
  }

  @Test
  public void customAssertionTest() {
    TestClassSubject.assertThat(new TestClass())
        .hasLongValue(1L);

    TestClassSubject.assertThat(new TestClass())
        .hasStringValue("bla");
  }


}
