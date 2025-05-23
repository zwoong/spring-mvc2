package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.*;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

public class ConverterTest {

  @Test
  void stringToInteger() {
    StringToIntegerConverter converter = new StringToIntegerConverter();
    Integer result = converter.convert("10");

    assertThat(result).isEqualTo(10);
  }

  @Test
  void IntegerToString() {
    IntegerToStringConverter converter = new IntegerToStringConverter();
    String result = converter.convert(10);
    assertThat(result).isEqualTo("10");
  }

  @Test
  void StringToIpPort() {
    IpPortToStringConverter converter = new IpPortToStringConverter();
    IpPort source = new IpPort("127.0.0.1", 8080);
    String result = converter.convert(source);
    assertThat(result).isEqualTo("127.0.0.1:8080");
  }

  @Test
  void ipPortToString() {
    StringToIpPortConverter converter = new StringToIpPortConverter();
    String source = "127.0.0.1:8080";
    IpPort result = converter.convert(source);
    assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
  }
}
