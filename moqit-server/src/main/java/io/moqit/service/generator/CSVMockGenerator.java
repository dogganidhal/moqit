package io.moqit.service.generator;

import io.moqit.domain.Schema;
import io.moqit.domain.Table;
import io.moqit.service.content.ContentSource;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CSVMockGenerator implements MockGenerator {

  private final ContentSource.Registry contentSourceRegistry;

  @Override
  public String generate(Schema schema) {
    return "";
  }

  @Override
  public String generate(Table table) {
    return "";
  }

}
