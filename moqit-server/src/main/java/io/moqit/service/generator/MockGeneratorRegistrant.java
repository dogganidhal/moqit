package io.moqit.service.generator;

import io.moqit.domain.MockType;
import io.moqit.service.content.ContentSource;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Nidhal Dogga
 * @created 4/2/2022 10:14 AM
 */


@Component
@AllArgsConstructor
public class MockGeneratorRegistrant implements ApplicationRunner {

  private final MockGenerator.Registry mockGeneratorRegistry;
  private final ContentSource.Registry contentSourceRegistry;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    mockGeneratorRegistry.register(MockType.H2, new H2MockGenerator(contentSourceRegistry));
    mockGeneratorRegistry.register(MockType.MYSQL, new MySQLMockGenerator(contentSourceRegistry));
    mockGeneratorRegistry.register(MockType.POSTGRES, new PGMockGenerator(contentSourceRegistry));
    mockGeneratorRegistry.register(MockType.CSV, new CSVMockGenerator(contentSourceRegistry));
    mockGeneratorRegistry.register(MockType.JSON, new JSONMockGenerator(contentSourceRegistry));
  }

}
