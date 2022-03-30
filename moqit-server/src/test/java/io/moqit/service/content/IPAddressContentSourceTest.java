package io.moqit.service.content;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("IP address content source test")
public class IPAddressContentSourceTest {

  private final static Pattern IP_ADDRESS_PATTERN = Pattern
    .compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$");
  private final IPAddressContentSource contentSource = new IPAddressContentSource();

  @Test
  @DisplayName("should generate valid IP addresses")
  public void shouldGenerateValidIPAddresses() {
    for (int i = 0; i < 100; i++) {
      String ipAddress = contentSource.getOne();
      assertTrue(IP_ADDRESS_PATTERN.matcher(ipAddress).matches());
    }
  }

  @Test
  @DisplayName("should generate different IP addresses")
  public void shouldGenerateDifferentIPAddresses() {
    var ips = contentSource.getMultiple(100);
    var filteredDoubles = ips.stream()
      .filter(ip -> Collections.frequency(ips, ip) == 1)
      .toList();
    assertEquals(100, filteredDoubles.size());
  }

}
