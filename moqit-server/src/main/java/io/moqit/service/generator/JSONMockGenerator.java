package io.moqit.service.generator;

import io.moqit.domain.Schema;
import org.springframework.stereotype.Service;

import static io.moqit.service.generator.MockGenerator.JSON;

@Service(JSON)
public class JSONMockGenerator implements MockGenerator {
  @Override
  public String generate(Schema schema) {
    return "";
  }
}
