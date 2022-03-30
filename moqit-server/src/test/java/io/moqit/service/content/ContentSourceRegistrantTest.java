package io.moqit.service.content;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


/**
 * @author Nidhal Dogga
 * @created 4/1/2022 7:01 PM
 */


@SpringBootTest
@DisplayName("ContentSource registrant test")
class ContentSourceRegistrantTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  @DisplayName("should register content sources")
  void shouldRegisterContentSources() {
    Assertions.assertDoesNotThrow(() -> {
      applicationContext.getBean("first_name_content_source", ContentSource.class);
      applicationContext.getBean("last_name_content_source", ContentSource.class);
      applicationContext.getBean("phone_number_content_source", ContentSource.class);
      applicationContext.getBean("address_content_source", ContentSource.class);
      applicationContext.getBean("email_content_source", ContentSource.class);
      applicationContext.getBean("ip_address_content_source", ContentSource.class);
      applicationContext.getBean("any_date_content_source", ContentSource.class);
      applicationContext.getBean("future_date_content_source", ContentSource.class);
      applicationContext.getBean("past_date_content_source", ContentSource.class);
    });
  }

}
