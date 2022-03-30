package io.moqit.service.generator;

import io.moqit.domain.Schema;
import org.springframework.stereotype.Service;

import static io.moqit.service.generator.MockGenerator.CSV;

@Service(CSV)
public class CSVMockGenerator implements MockGenerator {
  @Override
  public String generate(Schema schema) {
    return "";
  }
}
