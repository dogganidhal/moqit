package io.moqit.service.content;

import io.moqit.domain.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nidhal Dogga
 * @created 4/1/2022 9:12 PM
 */


@SpringBootTest
@DisplayName("Content Source Registry Test")
class ContentSourceRegistryTest {

  @Autowired
  private ContentSource.Registry registry;

  @Test
  @DisplayName("should return correct `ContentSource` class for a given content type")
  void shouldResolveCorrectContentSourceClasses() {
    var addressContentSource = registry.resolve(ContentType.ADDRESS);
    assertNotNull(addressContentSource);
    assertEquals(ResourceContentSource.class, addressContentSource.getClass());

    var firstNameContentSource = registry.resolve(ContentType.FIRST_NAME);
    assertNotNull(firstNameContentSource);
    assertEquals(ResourceContentSource.class, firstNameContentSource.getClass());

    var lastNameContentSource = registry.resolve(ContentType.LAST_NAME);
    assertNotNull(lastNameContentSource);
    assertEquals(ResourceContentSource.class, lastNameContentSource.getClass());

    var phoneNumberContentSource = registry.resolve(ContentType.PHONE_NUMBER);
    assertNotNull(phoneNumberContentSource);
    assertEquals(ResourceContentSource.class, phoneNumberContentSource.getClass());

    var ipAddressContentSource = registry.resolve(ContentType.IP_ADDRESS);
    assertNotNull(ipAddressContentSource);
    assertEquals(IPAddressContentSource.class, ipAddressContentSource.getClass());

    var anyDateContentSource = registry.resolve(ContentType.ANY_DATE);
    assertNotNull(anyDateContentSource);
    assertEquals(DateTimeContentSource.class, anyDateContentSource.getClass());

    var futureDateContentSource = registry.resolve(ContentType.FUTURE_DATE);
    assertNotNull(futureDateContentSource);
    assertEquals(DateTimeContentSource.class, futureDateContentSource.getClass());

    var pastDateContentSource = registry.resolve(ContentType.PAST_DATE);
    assertNotNull(pastDateContentSource);
    assertEquals(DateTimeContentSource.class, pastDateContentSource.getClass());
  }

}
