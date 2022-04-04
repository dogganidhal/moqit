package io.moqit.service.generator;

import io.moqit.service.content.ContentSource;
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
@DisplayName("MockGenarator registrant test")
class MockGeneratorRegistrantTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  @DisplayName("should register mock generators")
  void shouldRegisterContentSources() {
    Assertions.assertDoesNotThrow(() -> {
      applicationContext.getBean("csv_mock_generator", MockGenerator.class);
      applicationContext.getBean("json_mock_generator", MockGenerator.class);
      applicationContext.getBean("h2_mock_generator", MockGenerator.class);
      applicationContext.getBean("postgres_mock_generator", MockGenerator.class);
      applicationContext.getBean("mysql_mock_generator", MockGenerator.class);
    });
  }

}
