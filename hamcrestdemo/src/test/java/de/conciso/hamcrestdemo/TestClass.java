package de.conciso.hamcrestdemo;

import java.util.Arrays;
import java.util.List;

public class TestClass {
  private List<String> stringList = Arrays.asList("1", "2", "3");

  public List<String> getStringList() {
    return stringList;
  }

  public void setStringList(List<String> stringList) {
    this.stringList = stringList;
  }

  public Long getLongValue() {
    return longValue;
  }

  public void setLongValue(Long longValue) {
    this.longValue = longValue;
  }

  public int getIntValue() {
    return intValue;
  }

  public void setIntValue(int intValue) {
    this.intValue = intValue;
  }

  public String getStringValue() {
    return stringValue;
  }

  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
  }

  private Long longValue = 1L;
  private int intValue = 2;
  private String stringValue = "Test";

}
